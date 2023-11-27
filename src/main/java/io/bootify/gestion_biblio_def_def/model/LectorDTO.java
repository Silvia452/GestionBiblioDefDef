package io.bootify.gestion_biblio_def_def.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LectorDTO {

    private Long id;

    @Size(max = 255)
    private String nombre;

    @Size(max = 255)
    private String apellido;

    @Size(max = 20)
    private String dni;

}
