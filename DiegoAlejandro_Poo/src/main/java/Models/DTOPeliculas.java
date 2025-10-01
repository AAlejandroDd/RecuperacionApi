package Models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter
@ToString
@EqualsAndHashCode

public class DTOPeliculas {

    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String director;

    @NotBlank
    private String Genero;

    @PastOrPresent(message = "La fecha no puede ser futura")
    private LocalDate año;

    @Positive(message = "deben ser minutos")
    private int duracion_minutos;

    @Positive(message = "debe ser una puntuacion")
    private int puntuacion;



}
