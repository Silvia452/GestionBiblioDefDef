package io.bootify.gestion_biblio_def_def.model;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PrestamoDTO {

    private Long id;

    private LocalDate fechaPrestamo;

    private LocalDate fechaDevolucion;

    @NotNull
    private Long libro;

    @NotNull
    private Long lector;

    @NotNull
    private Long bibliotecario;

}
