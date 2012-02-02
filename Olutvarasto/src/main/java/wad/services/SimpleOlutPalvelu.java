/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.services;

import java.util.ArrayList;
import wad.domain.Olut;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author tonykova
 */
@Service
public class SimpleOlutPalvelu implements OlutPalvelu {

    List<Olut> oluet = new ArrayList<Olut>();
    private static int LASKURI = 0;

    @Override
    public Olut lisaaOlut(Olut olut) {
        olut.setId(LASKURI);
        LASKURI++;
        oluet.add(olut);
        return olut;
    }

    @Override
    public void poistaOlut(int tunnus) {
        for (int i = 0; i < oluet.size(); i++) {
            if ( tunnus == oluet.get(i).getId() ) {
                oluet.remove(i);
            }
        }
    }

    @Override
    public Olut muokkaaTaiLisaaOlut(int tunnus, Olut olut) {
        olut.setId(tunnus);
        Olut poistettava = oluet.remove(tunnus);
        oluet.add(olut);
        return olut;
    }

    @Override
    public Olut annaOlut(int tunnus) {
        for ( Olut olut : oluet ) {
            if ( olut.getId() == tunnus ) {
                return olut;
            }
        }
        return null;
    }

    @Override
    public List<Olut> listaaOluet() {
        return oluet;
    }
}
