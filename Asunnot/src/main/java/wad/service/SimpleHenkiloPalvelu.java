    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.database.HenkiloDao;
import wad.domain.Henkilo;

/**
 *
 * @author tonykova
 */
@Service
public class SimpleHenkiloPalvelu implements HenkiloPalvelu {
    @Autowired
    HenkiloDao henkiloDao;

    @Override
    @Transactional
    public void lisaa(Henkilo henkilo) {
        henkiloDao.create(henkilo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Henkilo> listaa() {
        return henkiloDao.list();
    }

    @Override
    @Transactional
    public void update(Henkilo henkilo) {
        henkiloDao.update(henkilo);
    }

    @Override
    @Transactional(readOnly = true)
    public Henkilo hae(String nimi) {
        return henkiloDao.read(nimi);
    }
    
    
}
