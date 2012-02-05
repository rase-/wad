/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.database;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import wad.domain.Genre;
import wad.domain.Leffa;


@Repository
public class JPAGenreDao implements GenreDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Genre> list() {
        Query q = entityManager.createQuery("SELECT g FROM Genre g");
        return q.getResultList();
    }

    @Override
    public Genre read(int id) {
       throw new UnsupportedOperationException("lol");
    }

    @Override
    public void create(Genre instance) {
        entityManager.merge(instance);
    }

    @Override
    public void delete(Genre instance) {
        entityManager.remove(instance);
    }

    @Override
    public Genre update(Genre instance) {
        return entityManager.merge(instance);
    }

    public Genre read(String nimi) {
        return entityManager.find(Genre.class, nimi);
    }
    
}
