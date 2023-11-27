package io.bootify.gestion_biblio_def_def.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LibroDTO {

    private Long id;

    @Size(max = 255)
    private String titulo;

    @Size(max = 255)
    private String autor;

}
