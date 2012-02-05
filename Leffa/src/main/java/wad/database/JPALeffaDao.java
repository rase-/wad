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
import wad.domain.Leffa;


@Repository
public class JPALeffaDao implements LeffaDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Leffa> list() {
        Query q = entityManager.createQuery("SELECT l FROM Leffa l");
        return q.getResultList();
    }

    @Override
    public Leffa read(int leffaId) {
       return entityManager.find(Leffa.class, leffaId);
    }

    @Override
    public void create(Leffa instance) {
        entityManager.merge(instance);
    }

    @Override
    public void delete(Leffa instance) {
        entityManager.remove(instance);
    }

    @Override
    public Leffa update(Leffa instance) {
        return entityManager.merge(instance);
    }

    
}
