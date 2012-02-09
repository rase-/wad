package wad.varasto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.varasto.database.HuoneDao;
import wad.varasto.domain.Henkilo;
import wad.varasto.domain.Huone;

@Service
public class SimpleHuonePalvelu implements HuonePalvelu {

    @Autowired
    private HuoneDao huoneDao;

    @Override
    @Transactional
    public void lisaa(Huone huone) {
        huoneDao.create(huone);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Huone> listaa() {
        return huoneDao.list();
    }

    @Override
    @Transactional
    public void poista(int esineId) {
        Huone e = huoneDao.read(esineId);
        if (e != null) {
            huoneDao.delete(e);
        }
    }

    @Override
    public List<Henkilo> ketaHuoneessa(int huoneId) {
        Huone h = huoneDao.read(huoneId);
        if( h != null) {
            return h.getHenkilot();
        }
        else return null;
    }
    @Override
    public Huone etsiHuone(int huoneId) {
        return huoneDao.read(huoneId);
    }
    @Override
    @Transactional
    public void update(Huone huone) {
        huoneDao.update(huone);
    }

    @Override
    @Transactional
    public void lisaaHenkilo(Henkilo henkilo, int huoneId) {
        Huone huone = huoneDao.read(huoneId);
        huone.getHenkilot().add(henkilo);
        henkilo.setHuone(huone);
        huoneDao.update(huone);
    }
}
