/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.util.List;
import wad.spring.domain.Aines;

/**
 *
 * @author tonykovanen
 */
public interface AinesService {
    List<Aines> listAll();
    Aines findOne(long id);
    void saveOrUpdate(Aines aines, long reseptiId);
    void save(Aines aines);
}
