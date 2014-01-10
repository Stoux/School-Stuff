/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ectltool.reader;

import ectltool.opdrachtinterface.OpdrachtCollection;
import ectltool.presentation.MainFrame;
import ectltool.presentation._;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author Leon
 */
public class ExcelFileReader extends FileReader {

    private HashSet<Integer> skippedLines;
    private int coloms;
    private int lastRow;
    
    public ExcelFileReader(File file, OpdrachtCollection collection, HashSet<Integer> skippedLines, int coloms, int lastRow) {
        super(file, collection);
        this.skippedLines = skippedLines;
        this.coloms = coloms;
        this.lastRow = lastRow;
    }
    
    @Override
    public void extract() {
        _.getMF().setStep(MainFrame.Step.Extract);
        _.getMF().setProgress(0);
        _.log("Extracting file: " + file.getName());
        
        int currentProgress = 0;
        double addedProgress = 0.0;
        double per = 15.0 / (lastRow - skippedLines.size());
        
        
        try {
            Workbook wb = Workbook.getWorkbook(file);
            Sheet sheet = wb.getSheet(0);
            
            int row = 0;
            while (row < lastRow) {
                if (!skippedLines.contains(row + 1)) {
                    try {
                        String[] line = new String[coloms];
                        int colom = 0;
                        while (colom < coloms) {
                            line[colom] = sheet.getCell(colom, row).getContents();
                            colom++;
                        }
                        System.out.println(Arrays.toString(line));
                        lines.add(line);

                        addedProgress += per;
                        int bot = (int) Math.floor(addedProgress);
                        if (bot > currentProgress) {
                            currentProgress = bot;
                            _.getMF().setProgress(0 + currentProgress);
                        }    
                    } catch (Exception e) {
                         System.out.println("Exception Excel Extraction: "+ e.getMessage());
                    }
                }
                row++;
            }
        } catch (BiffException | IOException e) {
            System.out.println("Exception Excel Extraction: "+ e.getMessage());
        }
    }  
 
}
