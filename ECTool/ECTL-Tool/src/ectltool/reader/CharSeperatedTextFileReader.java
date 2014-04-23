/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ectltool.reader;

import ectltool.presentation.MainFrame;
import ectltool.presentation._;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import ectltool.opdrachtinterface.OpdrachtCollection;

/**
 *
 * @author Leon
 */
public class CharSeperatedTextFileReader extends FileReader {

    private String splitOn;
    private HashSet<Integer> skipLines;
    
    public CharSeperatedTextFileReader(File file, OpdrachtCollection collection, String splitOn) {
        super(file, collection);
        this.splitOn = splitOn;
        skipLines = new HashSet<>();
    }
    
    public CharSeperatedTextFileReader(File file, OpdrachtCollection collection, String splitOn, HashSet<Integer> skipLines) {
        super(file, collection);
        this.splitOn = splitOn;
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
               
               String[] splitted = line.split(splitOn);
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
            Logger.getLogger(CharSeperatedTextFileReader.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(CharSeperatedTextFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
