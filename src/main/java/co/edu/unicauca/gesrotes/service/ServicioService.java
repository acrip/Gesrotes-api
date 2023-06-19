package co.edu.unicauca.gesrotes.service;

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
        return servicioMapper.toServicioDtos(servicioRepository.findAll());
    }

    public ServicioDTO crear(ServicioRequestDTO servicioRequest) {
        Servicio servicio = servicioMapper.toServicio(servicioRequest);
        return servicioMapper.toServicioDto(servicioRepository.save(servicio));
    }

    public ServicioDTO obtener(Long id) {
        return servicioRepository.findById(id)
                .map(servicioMapper::toServicioDto)
                .orElseThrow();
    }

    public ServicioDTO actualizar(Long id, ServicioRequestDTO servicioRequest) {
        Servicio servicio = servicioRepository.findById(id).orElseThrow();
        servicio.setName(servicioRequest.name());

        servicioRepository.save(servicio);
        return servicioMapper.toServicioDto(servicio);
    }

    public void eliminar(Long id) {
            servicioRepository.deleteById(id);
    }
}
