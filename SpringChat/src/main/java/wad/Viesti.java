/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad;

/**
 *
 * @author tonykovanen
 */
public class Viesti {
    private String tunnus;
    private String viesti;
    
   public Viesti(String tunnus, String viesti) {
        this.tunnus = tunnus;
        this.viesti = viesti;
    }

    public void setTunnus(String tunnus) {
        this.tunnus = tunnus;
    }

    public void setViesti(String viesti) {
        this.viesti = viesti;
    }

    public String getTunnus() {
        return tunnus;
    }

    public String getViesti() {
        return viesti;
    }
}
