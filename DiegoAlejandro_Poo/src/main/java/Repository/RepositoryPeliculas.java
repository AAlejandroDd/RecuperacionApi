package Repository;

import Entity.EntitiesPeliculas;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface RepositoryPeliculas extends JpaRepository<EntitiesPeliculas, Long> {
    Page<EntitiesPeliculas> findAll(Pageable pageable);
}
