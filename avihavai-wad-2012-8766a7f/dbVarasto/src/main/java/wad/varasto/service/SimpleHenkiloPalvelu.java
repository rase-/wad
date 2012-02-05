/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.varasto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.varasto.database.HenkiloDao;
import wad.varasto.domain.Henkilo;

/**
 *
 * @author tonykovanen
 */
@Service
public class SimpleHenkiloPalvelu implements HenkiloPalvelu{
    
    @Autowired
    private HenkiloDao henkiloDao;
    
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
    public void poista(String nimi) {
        Henkilo h = henkiloDao.read(nimi);
        if (h != null) {
            henkiloDao.delete(h);
        }
    }

    @Override
    public Henkilo hae(String nimi) {
        return henkiloDao.read(nimi);
    }
    @Override
    @Transactional
    public void update(Henkilo henkilo) {
        henkiloDao.update(henkilo);
    }
}
