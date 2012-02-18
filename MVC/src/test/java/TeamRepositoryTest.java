/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wad.spring.domain.Player;
import wad.spring.domain.Team;
import wad.spring.repository.TeamRepository;

/**
 *
 * @author tonykovanen
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context-test.xml",
    "classpath:spring-database-test.xml"})
public class TeamRepositoryTest {
    @Autowired
    TeamRepository teamRepository;
    
    public TeamRepositoryTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void createIncrementsNumberOfTeamsByOne() {
        long first = teamRepository.count();
        Team team = new Team();
        team.setName("nimi");
        teamRepository.save(team);
        long second = teamRepository.count();
        assertTrue(first == second - 1);
    }
    
}
