/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.varasto.domain;

/**
 *
 * @author tonykovanen
 */
public class Esine {
    private static int LASKURI = 1;

    private Integer id;
    private String nimi;
    private Double paino;

    public Esine() {
        id = LASKURI++;
    }

    public Integer getId() {
        return id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setPaino(Double paino) {
        this.paino = paino;
    }
    public Double getPaino() {
        return this.paino;
    }
}

