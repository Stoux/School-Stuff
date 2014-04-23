/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ectltool.reader;

import ectltool.opdrachtinterface.OpdrachtCollection;
import ectltool.presentation.MainFrame;
import ectltool.presentation._;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Leon
 */
public class SpaceSeperatedTextFileReader extends FileReader {

    private HashSet<Integer> skipLines;
    
    public SpaceSeperatedTextFileReader(File file, OpdrachtCollection collection, HashSet<Integer> skipLines) {
        super(file, collection);
        this.skipLines = skipLines;
    }

    @Override
    public void extract() {
        _.getMF().setStep(MainFrame.Step.Extract);
        _.getMF().setProgress(0);
        _.log("Extracting file: " + file.getName());
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
            _.getMF().setProgress(5);
            
            long lastBroadcast = System.currentTimeMillis();
            long timeBetween = 1000L;
            
            
            String line;
            int lineNr = 0; int listSize = 0;
            while ((line = reader.readLine()) != null) { //Loop thru lines
               if (skipLines.contains(++lineNr)) continue; //Skip line if needed
               
               String[] splittedSpace = line.split("  ");
               ArrayList<String> splittedLines = new ArrayList<>();
               for (String s : splittedSpace) {
                   if (!s.isEmpty() && !s.equals(" ")) {
                       splittedLines.add(s);
                   }
               }
               
               String[] splitted = splittedLines.toArray(new String[splittedLines.size()]);
               lines.add(splitted);
               
               listSize++;
               long current = System.currentTimeMillis();
               if (current - lastBroadcast > timeBetween) {
                   lastBroadcast = current;
                   _.log("Extracted " + listSize + " entries. Read " + lineNr + " lines.");
               }
            }
            _.getMF().setProgress(15);
            _.log("Extracted contents from file.");
        } catch (FileNotFoundException e) {
            _.log("Error in extracting space seperated text file: " + e.getMessage());
        } catch (IOException ex) {
            _.log("Error in extracting space seperated text file: " + ex.getMessage());
        }
    }
    
    
    
}
