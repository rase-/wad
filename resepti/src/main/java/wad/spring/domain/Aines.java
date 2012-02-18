/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.domain;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 *
 * @author tonykovanen
 */
@Entity
public class Aines {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Pattern(regexp="^[a-zA-Z0-9äöüÄÖÜ ]*$", message="Nimessä ei tule olla erikoismerkkejä")
    private String nimi;
    private List<Resepti> reseptit;

    public void setId(long id) {
        this.id = id;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setReseptit(List<Resepti> reseptit) {
        this.reseptit = reseptit;
    }

    public long getId() {
        return id;
    }

    public String getNimi() {
        return nimi;
    }

    public List<Resepti> getReseptit() {
        return reseptit;
    }
}
