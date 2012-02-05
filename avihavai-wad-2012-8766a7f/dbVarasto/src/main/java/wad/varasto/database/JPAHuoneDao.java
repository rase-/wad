package wad.varasto.database;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import wad.varasto.domain.Huone;

@Repository
public class JPAHuoneDao implements HuoneDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(Huone instance) {
        entityManager.merge(instance);
    }

    @Override
    public Huone read(int id) {
        return entityManager.find(Huone.class, id);
    }

    @Override
    public void delete(Huone instance) {
        entityManager.remove(instance);
    }

    @Override
    public Huone update(Huone instance) {
        return entityManager.merge(instance);
    }

    @Override
    public List<Huone> list() {
        Query q = entityManager.createQuery("SELECT h FROM Huone h");
        return q.getResultList();
    }
}
