package co.edu.unicauca.gesrotes.mapper;

import co.edu.unicauca.gesrotes.domain.Asociacion;
import co.edu.unicauca.gesrotes.rest.dto.response.AsociacionResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper
@MapperConfig(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface AsociacionMapper {

    List<AsociacionResponseDTO> toDtos(List<Asociacion> source);

    @Mapping(source = "etiqueta.escenario", target = "escenario")
    @Mapping(target = "escenario.etiquetas", ignore = true)
    AsociacionResponseDTO toDto(Asociacion source);
}
