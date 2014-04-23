/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ectltool.opdrachtinterface;

/**
 *
 * @author Leon
 */
public class OpdrachtCollection {
    
    private Table table;
    private FileModel model;

    public OpdrachtCollection(Table table, FileModel model) {
        this.table = table;
        this.model = model;
    }

    public FileModel getFileModel() {
        return model;
    }

    public Table getDatabaseTable() {
        return table;
    } 
    
}
