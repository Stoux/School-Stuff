/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ectltool.reader;

import ectltool.database.DBConnection;
import ectltool.opdrachtinterface.FileModel;
import java.io.File;
import java.util.ArrayList;
import ectltool.opdrachtinterface.Loadable;
import ectltool.opdrachtinterface.OpdrachtCollection;
import ectltool.presentation.MainFrame;
import ectltool.presentation._;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Leon
 */
public abstract class FileReader {
    
    protected File file;
    protected FileModel model;
    protected OpdrachtCollection collection;
    protected ArrayList<String[]> lines;
    protected ArrayList<Loadable> loadables;

    public FileReader(File file, OpdrachtCollection collection) {
        this.file = file;
        this.model = collection.getFileModel();
        this.collection = collection;
        lines = new ArrayList<>();
        loadables = new ArrayList<>();
    }   
    
    public abstract void extract();
    
    public void clean() {
        MainFrame mf = _.getMF();
        mf.setStep(MainFrame.Step.Clean);
        int size = lines.size();
        _.log("Cleaning " + size + " entries.");
        int currentProgress = 0;
        double addedProgress = 0.0;
        double per = 25.0 / size;
        
        HashMap<Integer, String[]> replaces = new HashMap<>();
        ArrayList<Integer> removes = new ArrayList<>();
        
        int lineNr = 0;
        for (String[] line : lines) {
            String[] array = new String[line.length];
            boolean trimmed = false;
            for (int x = 0; x < line.length; x++) {
                array[x] = line[x].trim();
                if (!array[x].equals(line[x])) {
                    trimmed = true;
                }
            }
            
            String[] returnArray = model.cleanLine(array);
            if (returnArray == null) { //Invalid data, needs to be removed
                removes.add(lineNr);
            } else if (returnArray != array || trimmed) { //
                replaces.put(lineNr, returnArray);
            }
            
            addedProgress += per;
            int bot = (int) Math.floor(addedProgress);
            if (bot > currentProgress) {
                currentProgress = bot;
                mf.setProgress(15 + currentProgress);
            }       
            lineNr++;
        }
        
        int replacesSize = replaces.size();
        if (replacesSize > 0) { //Check if any entries need to be replaced
            per = 5 / replacesSize;
            _.log("Replacing " + replacesSize + " entries with cleaned ones.");
            for (Map.Entry<Integer, String[]> entry : replaces.entrySet()) { //Replace entries
                lines.set(entry.getKey(), entry.getValue());
                
                addedProgress += per;
                int bot = (int) Math.floor(addedProgress);
                if (bot > currentProgress) {
                    currentProgress = bot;
                    mf.setProgress(15 + currentProgress);
                }    
            }
        } else {
            currentProgress = 45;
            addedProgress = 45.0;
            mf.setProgress(currentProgress);
        }
        
        int removesSize = removes.size();
        if (removesSize > 0) {
            _.log("Removing " + removesSize + " entries due to invalid data.");
            Collections.sort(removes, Collections.reverseOrder()); //Sort list from High -> Low
                        
            per = 5 / removesSize;
            for (int removeID : removes) {
                lines.remove(removeID);
                
                addedProgress += per;
                int bot = (int) Math.floor(addedProgress);
                if (bot > currentProgress) {
                    currentProgress = bot;
                    mf.setProgress(15 + currentProgress);
                }   
            }            
        } else {
            mf.setProgress(50);
        }
        _.log("Cleaned entries.");
    }
    
    public void transform() {
        MainFrame mf = _.getMF();
        mf.setStep(MainFrame.Step.Transform);
        _.log("Transforming entries to entities.");
        int size = lines.size();
        int currentProgress = 0;
        double addedProgress = 0.0;
        double per = 25.0 / size;
        
        for (String[] line : lines) {
            Loadable l = model.transformLine(line);
            if (l == null) continue;
            loadables.add(l);
            
            addedProgress += per;
            int bot = (int) Math.floor(addedProgress);
            if (bot > currentProgress) {
                currentProgress = bot;
                mf.setProgress(50 + currentProgress);
            }            
        }
        _.log("Transformed entires.");
    }
    
    public void load() {
        MainFrame mf = _.getMF();
        mf.setStep(MainFrame.Step.Load);
        _.log("Loading into database.");
        int size = lines.size();
        int currentProgress = 0;
        double addedProgress = 0.0;
        double per = 25.0 / size;
        
        try {
            _.log("Connecting to SQL Database.");
            DBConnection dbCon = new DBConnection(collection.getDatabaseTable());
            Connection con = dbCon.getConnection();
            
            PreparedStatement prepStat = null;
            int batchSize = 0;
            
            Loadable previousLoadable = null;
            for (Loadable loadable : loadables) { //Loop thru loadables
                if (prepStat == null) { //First go -> no PrepStat yet
                    prepStat = con.prepareStatement(loadable.getPreparedStatementString());
                } else {
                    if (!loadable.getTypeName().equals(previousLoadable.getTypeName()) || batchSize >= 100) { //Not equal -> Run Statement || Batchsize is bigger than 50
                        _.log("Loading " + batchSize + " entries into Database (Type: " + previousLoadable.getTypeName() + ")");
                        prepStat.executeBatch();
                        batchSize = 0;
                        prepStat = con.prepareStatement(loadable.getPreparedStatementString());
                    }
                }
                
                //Load data
                loadable.prepareStatement(prepStat);
                prepStat.addBatch();
                batchSize++;

                //Set Previous one
                previousLoadable = loadable;
                
                //Update GUI
                addedProgress += per;
                int bot = (int) Math.floor(addedProgress);
                if (bot > currentProgress) {
                    currentProgress = bot;
                    mf.setProgress(75 + currentProgress);
                }   
            }
            if (batchSize > 0) { //If Batch not empty -> Run Batch
                _.log("Final Batch. Loading " + batchSize + " entries into Database (Type: " + previousLoadable.getTypeName() + ")");
                prepStat.executeBatch();
            }
            _.log("Loaded all entries into database.");
            _.log("Finished file: " + file.getName());
            _.getMF().setStep(MainFrame.Step.Inactief);
            _.getMF().setProgress(100);
        } catch (SQLException e) {
            _.log("An Exception has been thrown! Exception: " + e.getMessage());
            mf.setProgress(0);
            mf.setStep(MainFrame.Step.Gefaald);
        }
    } 
    
}
