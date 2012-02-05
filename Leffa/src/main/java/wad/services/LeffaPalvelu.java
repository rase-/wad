/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.services;

import java.util.List;
import wad.domain.Leffa;

/**
 *
 * @author tonykovanen
 */
public interface LeffaPalvelu {
    public void lisaa(Leffa leffa);
    public List<Leffa> listaa();
    public void update(Leffa leffa);
    public Leffa hae(int leffaId);
}
