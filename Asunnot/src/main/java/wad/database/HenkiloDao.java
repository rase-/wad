package wad.database;

import java.util.List;
import wad.domain.Henkilo;

/**
 *
 * @author tonykovanen
 */
public interface HenkiloDao extends DAO<Henkilo>{
    public List<Henkilo> list();
    public Henkilo read(String nimi);
}

