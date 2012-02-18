package wad.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.spring.domain.Team;
import wad.spring.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService {

    TeamRepository teamRepository;
    
    public TeamServiceImpl() {
        
    }
    @Autowired
    public TeamServiceImpl(TeamRepository teamrepo) {
        this.teamRepository = teamrepo;
    }
    
    @Override
    @Transactional
    public void create(Team team) {
        teamRepository.save(team);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Team> list() {
        return teamRepository.findAll();
    }

    @Override
    public Team findOne(Long id) {
        return teamRepository.findOne(id);
    }
}
