package co.edu.unicauca.gesrotes.rest.dto;

import java.util.List;

public record EscenarioDTO(long id, String name, List<EtiquetaDTO> etiquetas) {
}
