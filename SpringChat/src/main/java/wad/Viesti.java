/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author tonykovanen
 */
public class Viesti {
    @Pattern(regexp="\\w+", message = "KŠyttŠjŠtunnus tulee olla yksi sana")
    private String tunnus;
    @NotNull
    @Pattern(regexp="^[a-zA-Z0-9ŠšŸ€…†]*$", message="ViestissŠ ei saa olla erikoismerkkejŠ")
    private String viesti;
    
   public Viesti(String tunnus, String viesti) {
        this.tunnus = tunnus;
        this.viesti = viesti;
    }
   public Viesti(String viesti) {
       this.viesti = viesti;
   }
   public Viesti() {
       
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
