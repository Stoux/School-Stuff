/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 * Een Bol Vorm
 * Module: VH5I
 * Datum: 10-2013
 * @author Leon Stam
 */
public class Bol extends Vorm {

    private double straal;

    /**
     * Maak een nieuwe bol aan
     * @param straal De straal van de bol
     */
    public Bol(double straal) {
        this.straal = straal;
    }
    
    @Override
    public double getInhoud() {
        return ((1.0 / 3.0) * 4.0) * Math.PI * Math.pow(straal, 3);
    }

    @Override
    public String getNaam() {
        return "Bol";
    }

    @Override
    public String getDimensies() {
        return "Straal: " + straal;
    }
    
}
