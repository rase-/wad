/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.domain;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 *
 * @author tonykovanen
 */
@Entity
public class AnnualBudget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Pattern(regexp="[0-9]{4}", message="The annual budget's year must consist of 4 numbers")
    private String vuosi;
    private int summa;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Team team;

    public void setId(Long id) {
        this.id = id;
    }

    public void setSumma(int summa) {
        this.summa = summa;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setVuosi(String vuosi) {
        this.vuosi = vuosi;
    }

    public Long getId() {
        return id;
    }

    public int getSumma() {
        return summa;
    }

    public Team getTeam() {
        return team;
    }

    public String getVuosi() {
        return vuosi;
    }
}
