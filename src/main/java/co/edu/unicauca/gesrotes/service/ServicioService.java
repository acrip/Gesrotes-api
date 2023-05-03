package co.edu.unicauca.gesrotes.service;

import co.edu.unicauca.gesrotes.domain.Etiqueta;
import co.edu.unicauca.gesrotes.domain.Servicio;
import co.edu.unicauca.gesrotes.mapper.ServicioMapper;
import co.edu.unicauca.gesrotes.repository.EtiquetaRepository;
import co.edu.unicauca.gesrotes.repository.ServicioRepository;
import co.edu.unicauca.gesrotes.rest.dto.ServicioDTO;
import co.edu.unicauca.gesrotes.rest.dto.request.ServicioRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {
    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Autowired
    private ServicioMapper servicioMapper;

    public List<ServicioDTO> listar() {
        return servicioMapper.toServicioDtos(servicioRepository.findAllByEnabled(true));
    }

    public ServicioDTO crear(ServicioRequestDTO servicioRequest) {
        Servicio servicio = servicioMapper.toServicio(servicioRequest);
        return servicioMapper.toServicioDto(servicioRepository.save(servicio));
    }

    public ServicioDTO obtener(Long id) {
        return servicioRepository.findByIdAndEnabled(id, true)
                .map(servicioMapper::toServicioDto)
                .orElseThrow();
    }

    public ServicioDTO actualizar(Long id, ServicioRequestDTO servicioRequest) {
        Servicio servicio = servicioRepository.findByIdAndEnabled(id, true)
                .orElseGet(() -> new Servicio(id, servicioRequest.name()));
        servicio.setName(servicioRequest.name());

        if (servicio.getEtiqueta().getId() != servicioRequest.idEtiqueta()) {
            Etiqueta etiqueta = etiquetaRepository.getReferenceById(servicioRequest.idEtiqueta());
            servicio.setEtiqueta(etiqueta);
        }
        servicioRepository.save(servicio);
        return servicioMapper.toServicioDto(servicio);
    }

    public void eliminar(Long id) {
        //    servicioRepository.deleteById(id);
        servicioRepository.findById(id)
                .ifPresent(servicio -> {
                    servicio.setEnabled(false);
                    servicioRepository.save(servicio);
                });
    }
}
