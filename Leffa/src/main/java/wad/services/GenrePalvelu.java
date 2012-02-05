/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.services;

import java.util.List;
import wad.domain.Genre;

/**
 *
 * @author tonykovanen
 */
public interface GenrePalvelu {
    public void lisaa(Genre genre);
    public List<Genre> listaa();
    public void update(Genre genre);
    public Genre hae(String nimi);
}
