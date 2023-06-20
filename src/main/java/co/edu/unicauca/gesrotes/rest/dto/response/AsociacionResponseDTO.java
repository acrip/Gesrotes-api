package co.edu.unicauca.gesrotes.rest.dto.response;

import co.edu.unicauca.gesrotes.rest.dto.EscenarioDTO;
import co.edu.unicauca.gesrotes.rest.dto.EtiquetaDTO;
import co.edu.unicauca.gesrotes.rest.dto.ServicioDTO;

public record AsociacionResponseDTO(
        Long id,
        EtiquetaDTO etiqueta,
        ServicioDTO servicio,
        EscenarioDTO escenario
) {
}
