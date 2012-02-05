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
import wad.domain.Genre;

/**
 *
 * @author tonykovanen
 */
@Service
public class SimpleGenrePalvelu implements GenrePalvelu{
    @Autowired
    GenreDao genreDao;
    
    @Override
    @Transactional
    public void lisaa(Genre genre) {
        genreDao.create(genre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Genre> listaa() {
        return genreDao.list();
    }

    @Override
    @Transactional
    public void update(Genre genre) {
        genreDao.update(genre);
    }

    @Override
    public Genre hae(String nimi) {
        return genreDao.read(nimi);
    }
    
}
