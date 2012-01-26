/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tonykova
 */
public class Viesti {
    private String tunnus;
    private String viesti;
    
    public Viesti(String tunnus, String viesti) {
        this.tunnus = tunnus;
        this.viesti = viesti;
    }
    public String toString() {
        return tunnus + ": " + viesti;
    }
    public String getTunnus() {
        return this.tunnus;
    }
    public String getViesti() {
        return this.viesti;
    }
}
