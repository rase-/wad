/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.varasto.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author tonykovanen
 */
@Entity
public class Henkilo implements Serializable{
    @Id
    private String nimi;
    @Column(name = "OSOITE")
    private String osoite;
    @Column(name = "PUHELNNUMERO")
    private String puhelinnumero;
    @ManyToOne
    private Huone huone;
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    public void setPuhelinnumero(String puhelinnumero) {
        this.puhelinnumero = puhelinnumero;
    }

    public String getNimi() {
        return nimi;
    }

    public String getOsoite() {
        return osoite;
    }

    public String getPuhelinnumero() {
        return puhelinnumero;
    }
    public void setHuone(Huone huone) {
        this.huone = huone;
    }
    public Huone getHuone() {
        return this.huone;
    }
}
