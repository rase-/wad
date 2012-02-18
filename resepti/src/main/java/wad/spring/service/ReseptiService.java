/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.util.List;
import wad.spring.domain.Resepti;

/**
 *
 * @author tonykovanen
 */
public interface ReseptiService {
    List<Resepti> listAll();
    Resepti findOne(long id);
    void saveOrUpdate(Resepti resepti);
    void delete(long reseptiId);
}
