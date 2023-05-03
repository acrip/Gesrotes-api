package co.edu.unicauca.gesrotes.mapper;

import co.edu.unicauca.gesrotes.domain.Servicio;
import co.edu.unicauca.gesrotes.rest.dto.ServicioDTO;
import co.edu.unicauca.gesrotes.rest.dto.request.ServicioRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper
@MapperConfig(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ServicioMapper {
    ServicioDTO toServicioDto(Servicio servicio);

    List<ServicioDTO> toServicioDtos(List<Servicio> servicios);

    @Mapping(source = "idEtiqueta", target = "etiqueta.id")
    Servicio toServicio(ServicioRequestDTO request);
}
