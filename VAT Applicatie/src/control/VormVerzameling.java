/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Vorm;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Leon
 */
public class VormVerzameling implements Serializable {
    
    private ArrayList<Vorm> vormLijst;

    /**
     * Constructor van VormVerzameling
     */
    public VormVerzameling() {
        vormLijst = new ArrayList<>();
    }
    
    /**
     * Haal een vorm op aan de hand van zijn positie in de lijst
     * @param index de positie
     * @return de Vorm
     */
    public Vorm getVorm(int index) {
        return vormLijst.get(index);
    }
    
    /**
     * Voeg een nieuwe vorm toe aan de lijst
     * @param vorm de vorm
     */
    public void voegToe(Vorm vorm) {
        vormLijst.add(vorm);
    }
    
    /**
     * Verwijder een vorm uit de lijst
     * @param index de positie
     */
    public void verwijderVorm(int index) {
        vormLijst.remove(index);
    }
    
    /**
     * Haal alle vormen op
     * @return lijst met alle vormen
     */
    public ArrayList<Vorm> getAlleVormen() {
        return vormLijst;
    }

    @Override
    public String toString() {
        String s = "";
        for (Vorm v : vormLijst) {
            s = s + "\n" + v.toString();
        }
        return s;
    }
    
}
