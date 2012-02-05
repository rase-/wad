/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.varasto.database;

import java.util.List;
import wad.varasto.domain.Henkilo;

/**
 *
 * @author tonykovanen
 */
public interface HenkiloDao extends DAO<Henkilo>{
    public List<Henkilo> list();
    
    public Henkilo read(String nimi);
}
