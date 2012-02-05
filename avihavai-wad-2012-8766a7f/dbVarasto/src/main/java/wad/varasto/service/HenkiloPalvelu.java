/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.varasto.service;

import java.util.List;
import wad.varasto.domain.Henkilo;

/**
 *
 * @author tonykovanen
 */
public interface HenkiloPalvelu {
    public void lisaa(Henkilo henkilo);
    public List<Henkilo> listaa();
    public void poista(String nimi);
    public Henkilo hae(String nimi);
    public void update(Henkilo henkilo);
}
