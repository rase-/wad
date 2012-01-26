/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.varasto.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import wad.varasto.domain.Esine;

/**
 *
 * @author tonykovanen
 */
@Service
public class SimpleEsinePalvelu implements EsinePalvelu{
    private List<Esine> esineet = new ArrayList<Esine>();

    @Override
    public void lisaa(Esine esine) {
        this.esineet.add(esine);
    }

    @Override
    public List<Esine> listaa() {
        return this.esineet;
    }

    @Override
    public void poista(int esineId) {
        Esine esine = null;
        for (Esine e : esineet) {
            if (e.getId() == esineId) {
                esine = e;
                break;
            }
        }
        
        if (esine != null) {
            esineet.remove(esine);
        }
    }
}
