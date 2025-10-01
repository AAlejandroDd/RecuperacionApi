package Services;

import Entity.EntitiesPeliculas;
import Exceptions.ExceptionPeliculaDontRegister;
import Exceptions.ExceptionsNotFound;
import Models.DTOPeliculas;
import Repository.RepositoryPeliculas;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Slf4j
@Service
@CrossOrigin
public class ServicesPeliculas {

    @Autowired
    private RepositoryPeliculas repo;

    public Page<DTOPeliculas> getAllPeliculas(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<EntitiesPeliculas> pageEntity = repo.findAll(pageable);
        return pageEntity.map(this::ConvertirADTO);
    }

    public DTOPeliculas insert(@Valid DTOPeliculas json) {
        if (json == null){
            throw new IllegalArgumentException("La información de la pelicula no puede ser nula");
        }
        try{
            EntitiesPeliculas objData = ConvertirAEntity(json);
            EntitiesPeliculas PeliculaGuardada = repo.save(objData);
            return ConvertirADTO(PeliculaGuardada);
        }catch (Exception e){
            log.error("Error al registrar la pelicula" + e.getMessage());
            throw new ExceptionPeliculaDontRegister("La Pelicula no pudo ser registrada");
        }
    }

    public DTOPeliculas update(Long id, @Valid DTOPeliculas json) {
        EntitiesPeliculas peliculaExistente = repo.findById(id).orElseThrow(()-> new ExceptionsNotFound("Pelicula no encontrada."));

        peliculaExistente.setAño(json.getAño());
        peliculaExistente.setDirector(json.getDirector());
        peliculaExistente.setGenero(json.getGenero());
        peliculaExistente.setPuntuacion(json.getPuntuacion());
        peliculaExistente.setTitulo(json.getTitulo());

        EntitiesPeliculas peliculaActualizada = repo.save(peliculaExistente);
        return ConvertirADTO(peliculaActualizada);
    }

    public boolean delete(Long id) {
        EntitiesPeliculas existencia = repo.findById(id).orElse(null);
        if (existencia != null){
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    private DTOPeliculas ConvertirADTO(EntitiesPeliculas objEntity) {
        DTOPeliculas dto = new DTOPeliculas();
        dto.setId(objEntity.getId());
        dto.setAño(objEntity.getAño());
        dto.setDirector(objEntity.getDirector());
        dto.setPuntuacion(objEntity.getPuntuacion());
        dto.setGenero(objEntity.getGenero());
        dto.setDuracion_minutos(objEntity.getDuracion_minutos());
        return dto;
    }

    private EntitiesPeliculas ConvertirAEntity(@Valid DTOPeliculas json) {
        EntitiesPeliculas entity = new EntitiesPeliculas();
        entity.setGenero(json.getGenero());
        entity.setAño(json.getAño());
        entity.setDuracion_minutos(json.getDuracion_minutos());
        entity.setDirector(json.getDirector());
        entity.setPuntuacion(json.getPuntuacion());
        return entity;
    }

}
