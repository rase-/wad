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
import wad.domain.Leffa;

/**
 *
 * @author tonykovanen
 */
@Service
public class SimpleLeffaPalvelu implements LeffaPalvelu{
    @Autowired
    LeffaDao leffaDao;
    
    @Override
    @Transactional
    public void lisaa(Leffa leffa) {
        leffaDao.create(leffa);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Leffa> listaa() {
        return leffaDao.list();
    }

    @Override
    public void update(Leffa leffa) {
        leffaDao.update(leffa);
    }

    @Override
    public Leffa hae(int leffaId) {
        return leffaDao.read(leffaId);
    }
    
}
