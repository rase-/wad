/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Pattern(regexp="[a-zA-Z0-9']*+", message="Joukkueen nimen tulee sisältää vain kirjaimia, numeroita ja ':sta")
    private String name;
    @OneToMany(mappedBy = "team", cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Player> players;
    @OneToMany(mappedBy = "team", cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<AnnualBudget> budgets;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addPlayer(Player player) {
        if(!players.contains(player)) {
            players.add(player);
        }
        
        player.setTeam(this);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return this.name;
    }
    public void addBudget(AnnualBudget budget) {
        this.budgets.add(budget);
    }
}
