package co.edu.unicauca.gesrotes.mapper;

import co.edu.unicauca.gesrotes.domain.Etiqueta;
import co.edu.unicauca.gesrotes.rest.dto.EtiquetaDTO;
import co.edu.unicauca.gesrotes.rest.dto.request.EtiquetaRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper
@MapperConfig(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface EtiquetaMapper  {
    EtiquetaDTO toEtiquetaDto(Etiqueta etiqueta);

    List<EtiquetaDTO> toEtiquetaDtos(List<Etiqueta> etiquetas);

    @Mapping(source = "idEscenario", target = "escenario.id")
    Etiqueta toEtiqueta(EtiquetaRequestDTO request);
}
