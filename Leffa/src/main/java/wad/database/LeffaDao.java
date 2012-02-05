/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.database;

import java.util.List;
import wad.domain.Leffa;

/**
 *
 * @author tonykovanen
 */
public interface LeffaDao extends DAO<Leffa>{
    public List<Leffa> list();
    public Leffa read(int leffaId);
}
