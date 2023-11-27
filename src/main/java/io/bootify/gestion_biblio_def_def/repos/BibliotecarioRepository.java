package io.bootify.gestion_biblio_def_def.repos;

import io.bootify.gestion_biblio_def_def.domain.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {
}
