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
import wad.domain.Asunto;

/**
 *
 * @author tonykova
 */
@Repository
public class JPAAsuntoDao implements AsuntoDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Asunto> list() {
        Query q = entityManager.createQuery("SELECT a FROM Asunto a");
        return q.getResultList();
    }

    @Override
    public Asunto read(String osoite) {
        return entityManager.find(Asunto.class, osoite);
    }

    @Override
    public void create(Asunto instance) {
        entityManager.merge(instance);
    }

    @Override
    public Asunto read(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Asunto instance) {
        entityManager.remove(instance);
    }

    @Override
    public Asunto update(Asunto instance) {
        return entityManager.merge(instance);
    }
    
}
