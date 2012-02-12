/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.leffa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wad.domain.Leffa;

/**
 *
 * @author tonykova
 */
public interface LeffaRepository extends JpaRepository<Leffa, Integer>{
    
}
