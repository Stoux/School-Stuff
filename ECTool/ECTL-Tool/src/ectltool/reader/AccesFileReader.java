/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ectltool.reader;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import ectltool.opdrachtinterface.OpdrachtCollection;
import ectltool.presentation.MainFrame;
import ectltool.presentation._;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Leon
 */
public class AccesFileReader extends FileReader {

    private ArrayList<String> colomOrder;
    
    public AccesFileReader(File file, OpdrachtCollection collection, ArrayList<String> colomOrder) {
        super(file, collection);
        this.colomOrder = colomOrder;
    }
    
    @Override
    public void extract() {
        _.getMF().setStep(MainFrame.Step.Extract);
        _.getMF().setProgress(0);
        _.log("Extracting file: " + file.getName());
        
        int currentProgress = 0;
        double addedProgress = 0.0;
        
        
        try {
            Database db = DatabaseBuilder.open(file);
            double groupper = 15.0 / db.getTableNames().size();
            for (String tableName : db.getTableNames()) {
                _.log("Opening table: "+ tableName);
                Table t = db.getTable(tableName);
                
                if (t.getColumnCount() != colomOrder.size()) continue;
                
                double per = groupper / t.getRowCount();
                
                int colomCount = t.getColumnCount();
                
                for (Row row : t) {
                    String[] line = new String[colomCount];
                    
                    int colom = 0;
                    for (String colomNaam : colomOrder) {
                        String s = String.valueOf(row.get(colomNaam));
                        line[colom] = s;
                        colom++;
                    }
                    
                    lines.add(line);
                                        
                    addedProgress += per;
                    int bot = (int) Math.floor(addedProgress);
                    if (bot > currentProgress) {
                        currentProgress = bot;
                        _.getMF().setProgress(0 + currentProgress);
                    }  
                }
            }
        } catch (IOException e) {
            System.out.println("Exception Acces Extraction: "+ e.getMessage());
        }
    }
    
    
    
}
