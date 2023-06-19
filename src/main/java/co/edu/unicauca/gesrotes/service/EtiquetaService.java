package co.edu.unicauca.gesrotes.service;

import co.edu.unicauca.gesrotes.domain.Escenario;
import co.edu.unicauca.gesrotes.domain.Etiqueta;
import co.edu.unicauca.gesrotes.mapper.EtiquetaMapper;
import co.edu.unicauca.gesrotes.repository.EscenarioRepository;
import co.edu.unicauca.gesrotes.repository.EtiquetaRepository;
import co.edu.unicauca.gesrotes.rest.dto.EtiquetaDTO;
import co.edu.unicauca.gesrotes.rest.dto.request.EtiquetaRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtiquetaService {
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Autowired
    private EscenarioRepository escenarioRepository;

    @Autowired
    private EtiquetaMapper etiquetaMapper;

    public List<EtiquetaDTO> listar() {
        return etiquetaMapper.toEtiquetaDtos(etiquetaRepository.findAll());
    }

    public EtiquetaDTO crear(EtiquetaRequestDTO etiquetaRequest) {
        Etiqueta etiqueta = etiquetaMapper.toEtiqueta(etiquetaRequest);
        return etiquetaMapper.toEtiquetaDto(etiquetaRepository.save(etiqueta));
    }

    public EtiquetaDTO obtener(Long id) {
        return etiquetaRepository.findById(id)
                .map(etiquetaMapper::toEtiquetaDto)
                .orElseThrow();
    }

    public EtiquetaDTO actualizar(Long id, EtiquetaRequestDTO etiquetaRequest) {
        Etiqueta etiqueta = etiquetaRepository.findById(id).orElseThrow();
        etiqueta.setName(etiquetaRequest.name());

        if (etiqueta.getEscenario().getId() != etiquetaRequest.idEscenario()) {
            Escenario escenario = escenarioRepository.getReferenceById(etiquetaRequest.idEscenario());
            etiqueta.setEscenario(escenario);
        }
        etiquetaRepository.save(etiqueta);
        return etiquetaMapper.toEtiquetaDto(etiqueta);
    }

    public void eliminar(Long id) {
        etiquetaRepository.deleteById(id);
    }
}
