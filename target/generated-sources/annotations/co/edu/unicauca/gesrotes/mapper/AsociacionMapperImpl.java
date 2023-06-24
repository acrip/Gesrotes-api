package co.edu.unicauca.gesrotes.mapper;

import co.edu.unicauca.gesrotes.domain.Asociacion;
import co.edu.unicauca.gesrotes.domain.Etiqueta;
import co.edu.unicauca.gesrotes.domain.Servicio;
import co.edu.unicauca.gesrotes.rest.dto.EscenarioDTO;
import co.edu.unicauca.gesrotes.rest.dto.EtiquetaDTO;
import co.edu.unicauca.gesrotes.rest.dto.ServicioDTO;
import co.edu.unicauca.gesrotes.rest.dto.response.AsociacionResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-24T18:07:30-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class AsociacionMapperImpl implements AsociacionMapper {

    @Override
    public List<AsociacionResponseDTO> toDtos(List<Asociacion> source) {
        if ( source == null ) {
            return null;
        }

        List<AsociacionResponseDTO> list = new ArrayList<AsociacionResponseDTO>( source.size() );
        for ( Asociacion asociacion : source ) {
            list.add( toDto( asociacion ) );
        }

        return list;
    }

    @Override
    public AsociacionResponseDTO toDto(Asociacion source) {
        if ( source == null ) {
            return null;
        }

        EscenarioDTO escenario = null;
        Long id = null;
        EtiquetaDTO etiqueta = null;
        ServicioDTO servicio = null;

        escenario = etiquetaToEscenarioDTO( source.getEtiqueta() );
        id = source.getId();
        etiqueta = etiquetaToEtiquetaDTO( source.getEtiqueta() );
        servicio = servicioToServicioDTO( source.getServicio() );

        AsociacionResponseDTO asociacionResponseDTO = new AsociacionResponseDTO( id, etiqueta, servicio, escenario );

        return asociacionResponseDTO;
    }

    protected EscenarioDTO etiquetaToEscenarioDTO(Etiqueta etiqueta) {
        if ( etiqueta == null ) {
            return null;
        }

        long id = 0L;
        String name = null;

        if ( etiqueta.getId() != null ) {
            id = etiqueta.getId();
        }
        name = etiqueta.getName();

        List<EtiquetaDTO> etiquetas = null;

        EscenarioDTO escenarioDTO = new EscenarioDTO( id, name, etiquetas );

        return escenarioDTO;
    }

    protected EtiquetaDTO etiquetaToEtiquetaDTO(Etiqueta etiqueta) {
        if ( etiqueta == null ) {
            return null;
        }

        long id = 0L;
        String name = null;

        if ( etiqueta.getId() != null ) {
            id = etiqueta.getId();
        }
        name = etiqueta.getName();

        EtiquetaDTO etiquetaDTO = new EtiquetaDTO( id, name );

        return etiquetaDTO;
    }

    protected ServicioDTO servicioToServicioDTO(Servicio servicio) {
        if ( servicio == null ) {
            return null;
        }

        long id = 0L;
        String name = null;

        if ( servicio.getId() != null ) {
            id = servicio.getId();
        }
        name = servicio.getName();

        ServicioDTO servicioDTO = new ServicioDTO( id, name );

        return servicioDTO;
    }
}
