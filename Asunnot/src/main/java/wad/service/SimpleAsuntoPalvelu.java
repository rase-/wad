/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.database.AsuntoDao;
import wad.domain.Asunto;

/**
 *
 * @author tonykova
 */
@Service
public class SimpleAsuntoPalvelu implements AsuntoPalvelu{
    @Autowired
    AsuntoDao asuntoDao;
    
    @Override
    @Transactional
    public void lisaa(Asunto asunto) {
        asuntoDao.create(asunto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Asunto> listaa() {
        return asuntoDao.list();
    }

    @Override
    @Transactional
    public void update(Asunto asunto) {
        asuntoDao.update(asunto);
    }

    @Override
    @Transactional(readOnly = true)
    public Asunto hae(String osoite) {
        return asuntoDao.read(osoite);
    }
    
}
