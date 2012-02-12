/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.database.LeffaDao;
import wad.leffa.repository.LeffaRepository;
import wad.domain.Leffa;

/**
 *
 * @author tonykovanen
 */
@Service
public class SimpleLeffaPalvelu implements LeffaPalvelu{
    @Autowired
    LeffaRepository leffaRepo;
    
    @Override
    @Transactional
    public void lisaa(Leffa leffa) {
        leffaRepo.save(leffa);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Leffa> listaa() {
        return leffaRepo.findAll();
    }

    @Override
    @Transactional
    public void update(Leffa leffa) {
        leffaRepo.save(leffa);
    }

    @Override
    public Leffa hae(int leffaId) {
        return leffaRepo.findOne(leffaId);
    }
    
}
