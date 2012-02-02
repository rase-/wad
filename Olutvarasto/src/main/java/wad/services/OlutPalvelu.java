package wad.services;

import wad.domain.Olut;
import java.util.List;

public interface OlutPalvelu {
    Olut lisaaOlut(Olut olut);
    void poistaOlut(int tunnus);
    Olut muokkaaTaiLisaaOlut(int tunnus, Olut olut);
    Olut annaOlut(int tunnus);
    List<Olut> listaaOluet();
}