package wad.database;

import java.util.List;
import wad.domain.Asunto;

/**
 *
 * @author tonykovanen
 */
public interface AsuntoDao extends DAO<Asunto>{
    public List<Asunto> list();
    public Asunto read(String osoite);
}



