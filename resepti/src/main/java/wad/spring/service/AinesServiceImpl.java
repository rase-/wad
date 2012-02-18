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
import wad.spring.repository.AinesRepository;
import wad.spring.repository.ReseptiRepository;

/**
 *
 * @author tonykovanen
 */
@Service
public class AinesServiceImpl implements AinesService{
    @Autowired
    AinesRepository repo;
    @Autowired
    ReseptiRepository reseptiRepo;

    @Override
    @Transactional(readOnly = true)
    public List<Aines> listAll() {
        return repo.findAll();
    }

    @Override
    public Aines findOne(long id) {
        return repo.findOne(id);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Aines aines, long reseptiId) {
        Resepti resepti = reseptiRepo.findOne(reseptiId);
        resepti.getAinekset().add(aines);
        reseptiRepo.save(resepti);
        aines.getReseptit().add(resepti);
        repo.save(aines);
    }
    @Override
    @Transactional
    public void save(Aines aines) {
        repo.save(aines);
    }
}
