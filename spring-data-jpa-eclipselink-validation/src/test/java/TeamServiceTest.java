
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wad.spring.domain.Team;
import wad.spring.repository.TeamRepository;
import wad.spring.service.TeamService;
import wad.spring.service.TeamServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TeamServiceTest {

    private static class TeamRepositoryTestImpl implements TeamRepository {

        private ArrayList<Team> teams = new ArrayList<Team>();
        private HashMap<Long, Team> map = new HashMap<Long, Team>();
        private long COUNT = 0;

        public TeamRepositoryTestImpl() {
        }

        @Override
        public List<Team> findAll() {
            return this.teams;
        }

        @Override
        public List<Team> findAll(Sort sort) {
            return teams;
        }

        @Override
        public List<Team> save(Iterable<? extends Team> itrbl) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void flush() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Team saveAndFlush(Team t) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void deleteInBatch(Iterable<Team> itrbl) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Page<Team> findAll(Pageable pgbl) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Team save(Team t) {
            t.setId(COUNT++);
            teams.add(t);
            map.put(t.getId(), t);
            return t;
        }

        @Override
        public Team findOne(Long id) {
            return map.get(id);
        }

        @Override
        public boolean exists(Long id) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public long count() {
            return teams.size();
        }

        @Override
        public void delete(Long id) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void delete(Team t) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void delete(Iterable<? extends Team> itrbl) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void deleteAll() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    @Autowired
    TeamService teamService;

    @Configuration
    static class Config {

        @Bean
        public TeamService teamService() {
            TeamService teamService = new TeamServiceImpl(new TeamRepositoryTestImpl());
            return teamService;
        }
    }

    @Test
    public void testNewTeamHasBeenCreated() {
        long first = teamService.list().size();
        Team t = new Team();
        t.setName("Tiimi");
        teamService.create(t);
        List<Team> teams = teamService.list();
        long after = teams.size();
        Assert.assertEquals(1, after);
    }

    @Test
    public void afterAddingATeamATeamOfThatNameIsInUse() {
        Team t = new Team();
        t.setName("Tiimz");
        teamService.create(t);
        List<Team> list = teamService.list();
        Team second = new Team();
        for (Team team : list) {
            if (team.getName().equals(t.getName())) {
                second = team;
            }
        }
        Assert.assertEquals(t.getName(), second.getName());
    }

    @Test
    public void afterAddingATeamSizeIncrementsByOne() {
        Team t = new Team();
        t.setName("temp");
        long first = teamService.list().size();
        teamService.create(t);
        long after = teamService.list().size();
        Assert.assertEquals(first, after - 1);
    }

    @Test
    public void eachIdIsUnique() {
        boolean unique = true;
        Team t = new Team();
        t.setName("nimi");
        teamService.create(t);
        List<Team> list = teamService.list();
        List<Long> ids = new ArrayList<Long>();
        for (Team team : list) {
            if (ids.contains(team.getId())) {
                unique = false;
                break;
            }
            ids.add(team.getId());
        }
        Assert.assertTrue(unique);
    }
}