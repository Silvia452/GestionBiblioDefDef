package io.bootify.gestion_biblio_def_def.repos;

import io.bootify.gestion_biblio_def_def.domain.Lector;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LectorRepository extends JpaRepository<Lector, Long> {
}
