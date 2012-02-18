/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wad.spring.domain.Player;
import wad.spring.domain.Team;
import wad.spring.repository.PlayerRepository;
import wad.spring.repository.TeamRepository;

/**
 *
 * @author tonykovanen
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context-test.xml",
    "classpath:spring-database-test.xml"})
public class PlayerRepositoryTest {
    @Autowired
    TeamRepository teamRepository;
    
    @Autowired
    PlayerRepository playerRepository;

    @Test
    public void createIncrementsElementCountByOne() {
        long countAtStart = playerRepository.count();

        Player p = new Player();
        p.setName("Matti");
        playerRepository.save(p);

        long countAtEnd = playerRepository.count();
        Assert.assertTrue("Player count should be increased by one when adding an element.",
                countAtStart + 1 == countAtEnd);
    }
    @Test
    public void afterCreateSavedPlayerCanBeFound() {
        Player p = new Player();
        p.setName("Pekka");
        playerRepository.save(p);
        List<Player> found = playerRepository.findByName("Pekka");
        assertTrue(found.size() == 1);
    }
    @Test
    public void NumberOfPlayersIncrementsByTwoAfterAddingTwoToATeamAndDeletingTheTeam() {
        long first = playerRepository.count();
        Team team = new Team();
        team.setName("LeTeam");
        team = teamRepository.save(team);
        
        Player player = new Player();
        player.setName("Matti");
        team.addPlayer(player);

        player = new Player();
        player.setName("Pekka");
        team.addPlayer(player);
        team = teamRepository.save(team);
        
        teamRepository.delete(team);
        long second = playerRepository.count();
        assertTrue(first == second);
    }
}
