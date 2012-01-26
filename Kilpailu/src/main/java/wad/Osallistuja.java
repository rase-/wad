/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad;

/**
 *
 * @author tonykova
 */
public class Osallistuja {
    private String nimi;
    private String email;
    private boolean osallistuuKilpailuun;
    public Osallistuja() {
        
    }

    public String getEmail() {
        return email;
    }

    public String getNimi() {
        return nimi;
    }

    public boolean isOsallistuuKilpailuun() {
        return osallistuuKilpailuun;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setOsallistuuKilpailuun(boolean osallistuuKilpailuun) {
        this.osallistuuKilpailuun = osallistuuKilpailuun;
    }
    
   
}
