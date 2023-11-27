package io.bootify.gestion_biblio_def_def.service;

import io.bootify.gestion_biblio_def_def.domain.Bibliotecario;
import io.bootify.gestion_biblio_def_def.domain.Prestamo;
import io.bootify.gestion_biblio_def_def.model.BibliotecarioDTO;
import io.bootify.gestion_biblio_def_def.repos.BibliotecarioRepository;
import io.bootify.gestion_biblio_def_def.repos.PrestamoRepository;
import io.bootify.gestion_biblio_def_def.util.NotFoundException;
import io.bootify.gestion_biblio_def_def.util.WebUtils;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class BibliotecarioService {

    private final BibliotecarioRepository bibliotecarioRepository;
    private final PrestamoRepository prestamoRepository;

    public BibliotecarioService(final BibliotecarioRepository bibliotecarioRepository,
            final PrestamoRepository prestamoRepository) {
        this.bibliotecarioRepository = bibliotecarioRepository;
        this.prestamoRepository = prestamoRepository;
    }

    public List<BibliotecarioDTO> findAll() {
        final List<Bibliotecario> bibliotecarios = bibliotecarioRepository.findAll(Sort.by("id"));
        return bibliotecarios.stream()
                .map(bibliotecario -> mapToDTO(bibliotecario, new BibliotecarioDTO()))
                .toList();
    }

    public BibliotecarioDTO get(final Long id) {
        return bibliotecarioRepository.findById(id)
                .map(bibliotecario -> mapToDTO(bibliotecario, new BibliotecarioDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final BibliotecarioDTO bibliotecarioDTO) {
        final Bibliotecario bibliotecario = new Bibliotecario();
        mapToEntity(bibliotecarioDTO, bibliotecario);
        return bibliotecarioRepository.save(bibliotecario).getId();
    }

    public void update(final Long id, final BibliotecarioDTO bibliotecarioDTO) {
        final Bibliotecario bibliotecario = bibliotecarioRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(bibliotecarioDTO, bibliotecario);
        bibliotecarioRepository.save(bibliotecario);
    }

    public void delete(final Long id) {
        bibliotecarioRepository.deleteById(id);
    }

    private BibliotecarioDTO mapToDTO(final Bibliotecario bibliotecario,
            final BibliotecarioDTO bibliotecarioDTO) {
        bibliotecarioDTO.setId(bibliotecario.getId());
        bibliotecarioDTO.setNombre(bibliotecario.getNombre());
        bibliotecarioDTO.setApellido(bibliotecario.getApellido());
        bibliotecarioDTO.setDni(bibliotecario.getDni());
        bibliotecarioDTO.setZona(bibliotecario.getZona());
        return bibliotecarioDTO;
    }

    private Bibliotecario mapToEntity(final BibliotecarioDTO bibliotecarioDTO,
            final Bibliotecario bibliotecario) {
        bibliotecario.setNombre(bibliotecarioDTO.getNombre());
        bibliotecario.setApellido(bibliotecarioDTO.getApellido());
        bibliotecario.setDni(bibliotecarioDTO.getDni());
        bibliotecario.setZona(bibliotecarioDTO.getZona());
        return bibliotecario;
    }

    public String getReferencedWarning(final Long id) {
        final Bibliotecario bibliotecario = bibliotecarioRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        final Prestamo bibliotecarioPrestamo = prestamoRepository.findFirstByBibliotecario(bibliotecario);
        if (bibliotecarioPrestamo != null) {
            return WebUtils.getMessage("bibliotecario.prestamo.bibliotecario.referenced", bibliotecarioPrestamo.getId());
        }
        return null;
    }

}
