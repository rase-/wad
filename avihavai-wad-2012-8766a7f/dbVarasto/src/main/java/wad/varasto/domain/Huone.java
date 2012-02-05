package wad.varasto.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class Huone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @Column(name = "KERROS")
    private int kerros;
    @Column(name = "KAPASITEETTI")
    private int kapasiteetti;
    @OneToMany
    private List<Henkilo> henkilot;
    public Huone() {
    }

    public int getId() {
        return id;
    }

    public int getKapasiteetti() {
        return kapasiteetti;
    }

    public int getKerros() {
        return kerros;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKapasiteetti(int kapasiteetti) {
        this.kapasiteetti = kapasiteetti;
    }

    public void setKerros(int kerros) {
        this.kerros = kerros;
    }
    public List<Henkilo> getHenkilot() {
        return this.henkilot;
    }
    public void lisaaHenkilo(Henkilo henkilo) {
        this.henkilot.add(henkilo);
    }
}
