package co.edu.unicauca.gesrotes.service;

import co.edu.unicauca.gesrotes.domain.Asociacion;
import co.edu.unicauca.gesrotes.domain.Etiqueta;
import co.edu.unicauca.gesrotes.domain.Servicio;
import co.edu.unicauca.gesrotes.mapper.AsociacionMapper;
import co.edu.unicauca.gesrotes.repository.AsociacionRepository;
import co.edu.unicauca.gesrotes.rest.dto.response.AsociacionResponseDTO;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsociacionService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private AsociacionRepository asociacionRepository;

    @Autowired
    private AsociacionMapper asociacionMapper;

    public List<AsociacionResponseDTO> list() {
        List<Asociacion> asociaciones = asociacionRepository.findAll();
        return asociacionMapper.toDtos(asociaciones);
    }

     public AsociacionResponseDTO create(Long idEtiqueta, Long idServicio){
        Asociacion asociacion = new Asociacion();

        Etiqueta etiqueta = entityManager.getReference(Etiqueta.class, idEtiqueta);
         Servicio servicio = entityManager.getReference(Servicio.class, idServicio);
         asociacion.setEtiqueta(etiqueta);
         asociacion.setServicio(servicio);

         asociacionRepository.save(asociacion);
         return asociacionMapper.toDto(asociacion);
     }
}
