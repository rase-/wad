/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.service;

import java.util.List;
import wad.domain.Henkilo;

/**
 *
 * @author tonykova
 */
public interface HenkiloPalvelu {
    public void lisaa(Henkilo henkilo);
    public List<Henkilo> listaa();
    public void update(Henkilo henkilo);
    public Henkilo hae(String nimi);
}
