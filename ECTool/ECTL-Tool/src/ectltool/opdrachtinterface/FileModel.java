/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ectltool.opdrachtinterface;

/**
 *
 * @author Leon
 */
public abstract class FileModel {
    
    
    /**
     * Clean the line
     * @param line The array from file
     * @return A cleaned version of that array
     */
    public abstract String[] cleanLine(String[] line);
    
    /**
     * Transform a line into a loadable
     * @param line The line
     * @return A new Loadable
     */
    public abstract Loadable transformLine(String[] line);  
    
    
}
