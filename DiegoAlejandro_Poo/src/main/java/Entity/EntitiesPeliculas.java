package Entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter @Setter
@ToString @EqualsAndHashCode
@Table(name = "PELICULAS")
public class EntitiesPeliculas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_peliculas_id")
    @SequenceGenerator(sequenceName = "seq_peliculas_id", name = "seq_peliculas_id", allocationSize = 1)
    @Column(name = "IDPRODUCTO")
    private Long id;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "DIRECTOR")
    private String director;
    @Column(name = "AÑO")
    private LocalDate año;
    @Column(name = "GENERO")
    private String genero;
    @Column(name = "DURACION_MINUTOS")
    private int duracion_minutos;
    @Column(name = "PUNTUACION")
    private int puntuacion;




}
