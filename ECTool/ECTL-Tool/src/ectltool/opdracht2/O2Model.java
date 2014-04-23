/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ectltool.opdracht2;

import ectltool.opdracht2.O2Entity.Land;
import ectltool.opdrachtinterface.FileModel;
import ectltool.opdrachtinterface.Loadable;
import ectltool.presentation._;
import java.util.Arrays;

/**
 *
 * @author Leon
 */
public class O2Model extends FileModel  {

    @Override
    public void startedECTL() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new TimeFrame().setVisible(true);
            }
        }).start();
        
        while (!TimeFrame.selected) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }

    @Override
    public void endedECTL() {
        TimeFrame.selected = false;
    }
    
    
    
    @Override
    public String[] cleanLine(String[] line) {
        if (line.length == 7) {
            return line;
        } else if (line.length == 6) { //Missing Mobile number
            String[] newArray;
            if (line[4].contains(" (")) {
                String[] split = line[4].split(" \\(");
                newArray = new String[] {
                    line[0],
                    line[1],
                    line[2],
                    line[3],
                    split[0],
                    split[1].substring(0, 2),
                    line[5]
                };
            } else {
                newArray = new String[] {
                    line[0],
                    line[1],
                    line[2],
                    null,
                    line[3],
                    line[4],
                    line[5]
                };
            }
            return newArray;
        } else { //Invalid data?
            _.log("Could not clean entry, invalid data? Entry: " + Arrays.toString(line));
            return null;
        }
    }

    @Override
    public Loadable transformLine(String[] line) {        
        try {
            int klantNr = Integer.parseInt(line[0]);
            Land land = Land.parse(line[5]);
            String percentageString = line[6];
            if (percentageString.contains(",")) {
                percentageString = line[6].split(",")[1];
            }
            int percentage = Integer.parseInt(percentageString);
            return new O2Entity(klantNr, line[1], line[2], line[3], line[4], land, percentage);
        } catch (NumberFormatException e) {
            _.log("NAN Error. Entry: " + Arrays.toString(line) + " | Exception: " + e.getMessage());
            return null;
        }
    }
    
    
    
}
