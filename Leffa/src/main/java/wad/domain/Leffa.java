/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author tonykovanen
 */
@Entity
public class Leffa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @Column(name = "NIMI")
    private String nimi;
    @Column(name = "PITUUS")
    private double pituus;
    @Column(name = "VUOSI")
    private String vuosi;
    @ManyToMany
    private List<Genre> genret;
    
    public Leffa(String nimi, double pituus, String vuosi) {
        this.nimi = nimi;
        this.pituus = pituus;
        this.vuosi = vuosi;
    }
    public Leffa() {
        
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setPituus(double pituus) {
        this.pituus = pituus;
    }

    public void setVuosi(String vuosi) {
        this.vuosi = vuosi;
    }

    public String getNimi() {
        return nimi;
    }

    public double getPituus() {
        return pituus;
    }

    public String getVuosi() {
        return vuosi;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public List<Genre> getGenret() {
        return this.genret;
    }
    public void setGenret(List<Genre> genret) {
        this.genret = genret;
    }
    public void lisaaGenre(Genre genre) {
        this.genret.add(genre);
    }
}
