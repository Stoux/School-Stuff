/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Blok;
import entity.Bol;
import entity.Cilinder;
import entity.Vorm;
import java.util.ArrayList;

/**
 * Controle class die alles omtrent de vormen regelt
 * Module: VH5I
 * Datum: 10-2013
 * @author Leon Stam
 */
public class VormControle {
    
    private VormVerzameling vormVerzameling;
    
    public VormControle() {
        vormVerzameling = new VormVerzameling();
    }
    
    /**
     * Parse een String naar double
     * @param s de String
     * @return 
     */
    public double parseDouble(String s) {
        double d;
        try {
            d = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            d = 0;
        }
        return d;
    }
    
    /**
     * Check of een string een double is & groter dan 0 is
     * @param s De string
     * @return is een double
     */
    public boolean isGeldigeDouble(String s) {
        boolean returnBoolean;
        try {
            double d = Double.parseDouble(s);
            if (d > 0) returnBoolean = true;
            else returnBoolean = false;
        } catch (NumberFormatException e) {
            returnBoolean = false;
        }
        return returnBoolean;
    }
    
    /**
     * Maak een nieuwe bol aan
     * @param straal de straal
     */
    public void maakBol(double straal) {
        vormVerzameling.voegToe(new Bol(straal));
    }
    
    /**
     * Maak een nieuw blok aan
     * @param lengte de lengte
     * @param breedte de breedte
     * @param hoogte de hoogte
     */
    public void maakBlok(double lengte, double breedte, double hoogte) {
        vormVerzameling.voegToe(new Blok(hoogte, breedte, lengte));
    }
    
    /**
     * Maak een nieuwe cilinder aan
     * @param straal de straal
     * @param hoogte de hoogte
     */
    public void maakCilinder(double straal, double hoogte) {
        vormVerzameling.voegToe(new Cilinder(straal, hoogte));
    }
    
    /**
     * Haal een vorm op aan de hand van de positie in de lijst
     * @param index de positie
     */
    public Vorm getVorm(int index) {
        return vormVerzameling.getVorm(index);
    }
    
    /**
     * Verwijder een vorm aan de hand van de positie in de lijst
     * @param index positie 
     */
    public void verwijderVorm(int index) {
        vormVerzameling.verwijderVorm(index);
    }
    
    public ArrayList<Vorm> getAlleVormen() {
        return vormVerzameling.getAlleVormen();
    }
    
    /**
     * Haal de totale inhoud op van alle vormen
     * @return de inhoud
     */
    public double totaalInhoud() {
        double d = 0;
        for (Vorm v : vormVerzameling.getAlleVormen()) {
            d = d + v.getInhoud();
        }
        return d;
    }
    
    /**
     * Sla de huidge VormVerameling op
     * @return gelukt
     */
    public boolean slaVormVerzamelingOp() {
        return IOManager.saveVormVerzameling(vormVerzameling);
    }
    
    /**
     * Laad een eventuele opgeslagen VormVerzameling
     * @return gelukt
     */
    public boolean laadVormVerzameling() {
        boolean returnBoolean;
        VormVerzameling vV = IOManager.laadVormVerzameling();
        if (vV == null) {
            return false;
        } else {
            vormVerzameling = vV;
            return true;
        }
    }
    
}
