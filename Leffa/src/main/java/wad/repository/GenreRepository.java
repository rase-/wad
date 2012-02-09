/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Genre;

/**
 *
 * @author tonykova
 */
public interface GenreRepository extends JpaRepository<Genre, String> {
    
}
