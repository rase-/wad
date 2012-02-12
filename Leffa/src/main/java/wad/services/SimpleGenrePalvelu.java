/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.database.GenreDao;
import wad.leffa.repository.GenreRepository;
import wad.domain.Genre;

/**
 *
 * @author tonykovanen
 */
@Service
public class SimpleGenrePalvelu implements GenrePalvelu{
    @Autowired
    GenreRepository genreRepo;
    
    @Override
    @Transactional
    public void lisaa(Genre genre) {
        genreRepo.save(genre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Genre> listaa() {
        return genreRepo.findAll();
    }

    @Override
    @Transactional
    public void update(Genre genre) {
        genreRepo.save(genre);
    }

    @Override
    public Genre hae(String nimi) {
        return genreRepo.findOne(nimi);
    }
    
}
