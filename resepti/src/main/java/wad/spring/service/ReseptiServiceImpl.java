/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.spring.domain.Aines;
import wad.spring.domain.Resepti;
import wad.spring.repository.ReseptiRepository;

/**
 *
 * @author tonykovanen
 */
@Service
public class ReseptiServiceImpl implements ReseptiService {
    @Autowired
    ReseptiRepository repo;
    
    @Override
    @Transactional(readOnly = true)
    public List<Resepti> listAll() {
        return repo.findAll();
    }

    @Override
    public Resepti findOne(long id) {
        return repo.findOne(id);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Resepti resepti) {
        repo.save(resepti);
    }
    @Override
    @Transactional
    public void delete(long reseptiId) {
        Resepti resepti = repo.findOne(reseptiId);
        List<Aines> ainekset = resepti.getAinekset();
        for (Aines a : ainekset) {
            for (int i = 0; i < a.getReseptit().size(); i++) {
                if (a.getReseptit().get(i).getId() == reseptiId) {
                    a.getReseptit().remove(i);
                    break;
                }
            }
        }
        repo.delete(reseptiId);
    }
}
