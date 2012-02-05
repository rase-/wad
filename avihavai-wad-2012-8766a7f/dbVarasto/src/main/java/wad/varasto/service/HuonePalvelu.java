package wad.varasto.service;

import java.util.List;
import wad.varasto.domain.Henkilo;
import wad.varasto.domain.Huone;

public interface HuonePalvelu {
    public void lisaa(Huone huone);
    public List<Huone> listaa();
    public void poista(int huoneId);
    public List<Henkilo> ketaHuoneessa(int huoneId);
    public Huone etsiHuone(int huoneId);
    public void update(Huone huone);
}
