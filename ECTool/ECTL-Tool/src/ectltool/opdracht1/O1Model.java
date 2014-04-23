/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ectltool.opdracht1;

import ectltool.opdrachtinterface.FileModel;
import ectltool.opdrachtinterface.Loadable;
import ectltool.presentation._;
import java.util.Arrays;

/**
 *
 * @author Leon
 */
public class O1Model extends FileModel {

    @Override
    public String[] cleanLine(String[] line) {
        if (line.length == 7) {
            return line;
        } else if (line.length == 6) { //Missing Mobile number
            String[] newArray = new String[] {
                line[0],
                line[1],
                line[2],
                null,
                line[3],
                line[4],
                line[5]
            };
            return newArray;
        } else { //Invalid data?
            _.log("Could not clean entry, invalid data? Entry: " + Arrays.toString(line));
            return null;
        }
    }

    @Override
    public Loadable transformLine(String[] line) {
        try {
            int id = Integer.parseInt(line[0]);
            int percentage = Integer.parseInt(line[6]);
            return new O1Entity(id, line[1], line[2], line[3], line[4], line[5], percentage);
        } catch (NumberFormatException e) {
            _.log("Could not transform entry, not a number. Entry: " + Arrays.toString(line));
            return null;
        }
    }
    
    
    
}
