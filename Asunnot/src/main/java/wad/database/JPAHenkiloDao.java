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
import wad.domain.Henkilo;

/**
 *
 * @author tonykova
 */
@Repository
public class JPAHenkiloDao implements HenkiloDao {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Henkilo> list() {
        Query q = entityManager.createQuery("SELECT h FROM Henkilo h");
        return q.getResultList();
    }

    @Override
    public Henkilo read(String nimi) {
        return entityManager.find(Henkilo.class, nimi);
    }

    @Override
    public void create(Henkilo instance) {
        entityManager.merge(instance);
    }

    @Override
    public Henkilo read(int id) {
        throw new UnsupportedOperationException("Not supported yet!");
    }

    @Override
    public void delete(Henkilo instance) {
        entityManager.remove(instance);
    }

    @Override
    public Henkilo update(Henkilo instance) {
        return entityManager.merge(instance);
    }
    
}
