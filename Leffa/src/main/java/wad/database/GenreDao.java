/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.database;

import java.util.List;
import wad.domain.Genre;

/**
 *
 * @author tonykovanen
 */
public interface GenreDao extends DAO<Genre>{
    public List<Genre> list();
    public Genre read(String nimi);
}
