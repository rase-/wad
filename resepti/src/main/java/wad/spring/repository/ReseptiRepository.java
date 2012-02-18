/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.spring.domain.Resepti;

/**
 *
 * @author tonykovanen
 */
public interface ReseptiRepository extends JpaRepository<Resepti, Long> {
    
}
