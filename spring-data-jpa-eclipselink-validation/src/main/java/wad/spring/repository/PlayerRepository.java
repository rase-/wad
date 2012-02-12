package wad.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.spring.domain.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByName(String name);
}
