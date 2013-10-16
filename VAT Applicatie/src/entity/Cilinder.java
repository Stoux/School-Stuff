/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Leon
 */
public class Cilinder extends Vorm {

    private double straal;
    private double hoogte;

    /**
     * Maak een nieuwe cilinder aan
     * @param straal De straal van de cirkel
     * @param hoogte De hoogte van de cilinder
     */
    public Cilinder(double straal, double hoogte) {
        this.straal = straal;
        this.hoogte = hoogte;
    }
    
    @Override
    public double getInhoud() {
        return Math.pow(Math.PI * straal, 2) * hoogte;
    }

    @Override
    public String getNaam() {
        return "Cilinder";
    }

    @Override
    public String getDimensies() {
        return "Straal: " + straal + " | Hoogte: " + hoogte;
    }
    
}
