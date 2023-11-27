package io.bootify.gestion_biblio_def_def.repos;

import io.bootify.gestion_biblio_def_def.domain.Bibliotecario;
import io.bootify.gestion_biblio_def_def.domain.Lector;
import io.bootify.gestion_biblio_def_def.domain.Libro;
import io.bootify.gestion_biblio_def_def.domain.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    Prestamo findFirstByLibro(Libro libro);

    Prestamo findFirstByLector(Lector lector);

    Prestamo findFirstByBibliotecario(Bibliotecario bibliotecario);

}
