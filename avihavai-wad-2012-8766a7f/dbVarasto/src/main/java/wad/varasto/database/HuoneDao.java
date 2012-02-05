package wad.varasto.database;

import java.util.List;
import wad.varasto.domain.Huone;

public interface HuoneDao extends DAO<Huone> {
    public List<Huone> list();
}
