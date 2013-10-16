/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Leon
 */
public class Blok extends Vorm  {

    private double hoogte;
    private double breedte;
    private double lengte;

    /**
     * Maak een nieuw blok aan 
     * @param hoogte De hoogte
     * @param breedte De breedte
     * @param lengte De lengte
     */
    public Blok(double hoogte, double breedte, double lengte) {
        this.hoogte = hoogte;
        this.breedte = breedte;
        this.lengte = lengte;
    }
    
    @Override
    public double getInhoud() {
        return hoogte * breedte * lengte;
    }

    @Override
    public String getNaam() {
        return "Blok";
    }

    @Override
    public String getDimensies() {
        return "Hoogte: " + hoogte + " | Breedte: " + breedte + " | Lengte: " + lengte;
    }
    
}
