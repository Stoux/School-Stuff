/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 * Een vorm class die andere vormen kunnen extenden
 * Module: VH5I
 * Datum: 10-2013
 * @author Leon Stam
 */
public abstract class Vorm implements Serializable {
    
    /**
     * Haal de naam op van de vorm
     * @return de naam
     */
    public abstract String getNaam();
    
    /**
     * Haal de inhoud op van de vorm
     * @return de inhoud
     */
    public abstract double getInhoud();
    
    /**
     * Haal de string met dimensies op van de vorm
     * @return de dimensies
     */
    public abstract String getDimensies();
    
    @Override
    public String toString() {
        return getNaam() + " | " + getDimensies();
    }
    
}
