package io.bootify.gestion_biblio_def_def.repos;

import io.bootify.gestion_biblio_def_def.domain.Libro;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LibroRepository extends JpaRepository<Libro, Long> {
}
