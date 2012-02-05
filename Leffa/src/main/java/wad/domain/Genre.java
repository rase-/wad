/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author tonykovanen
 */
@Entity
public class Genre implements Serializable{
    @Id
    private String nimi;
    @ManyToMany
    private List<Leffa> leffat;
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    public String getNimi() {
        return this.nimi;
    }

    public void setLeffat(List<Leffa> leffat) {
        this.leffat = leffat;
    }

    public List<Leffa> getLeffat() {
        return leffat;
    }
    public void lisaaLeffa(Leffa leffa) {
        this.leffat.add(leffa);
    }
}
