/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.service;

import java.util.List;
import wad.domain.Asunto;

/**
 *
 * @author tonykova
 */
public interface AsuntoPalvelu {
    public void lisaa(Asunto asunto);
    public List<Asunto> listaa();
    public void update(Asunto asunto);
    public Asunto hae(String osoite);
}
