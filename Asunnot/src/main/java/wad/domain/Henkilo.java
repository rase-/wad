/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author tonykova
 */
@Entity
public class Henkilo implements Serializable {

    @Id
    private String nimi;
    @Column(name = "PUHELINNUMERO")
    private String puhelinnumero;
    @Column(name = "SAHKOPOSTIOSOITE")
    private String sahkopostiosoite;

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setPuhelinnumero(String puhelinnumero) {
        this.puhelinnumero = puhelinnumero;
    }

    public void setSahkopostiosoite(String sahkopostiosoite) {
        this.sahkopostiosoite = sahkopostiosoite;
    }

    public String getNimi() {
        return nimi;
    }

    public String getPuhelinnumero() {
        return puhelinnumero;
    }

    public String getSahkopostiosoite() {
        return sahkopostiosoite;
    }
}
