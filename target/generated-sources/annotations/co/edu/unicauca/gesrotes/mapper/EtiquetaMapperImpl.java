package co.edu.unicauca.gesrotes.mapper;

import co.edu.unicauca.gesrotes.domain.Escenario;
import co.edu.unicauca.gesrotes.domain.Etiqueta;
import co.edu.unicauca.gesrotes.rest.dto.EtiquetaDTO;
import co.edu.unicauca.gesrotes.rest.dto.request.EtiquetaRequestDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-24T18:07:29-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class EtiquetaMapperImpl implements EtiquetaMapper {

    @Override
    public EtiquetaDTO toEtiquetaDto(Etiqueta etiqueta) {
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

    @Override
    public List<EtiquetaDTO> toEtiquetaDtos(List<Etiqueta> etiquetas) {
        if ( etiquetas == null ) {
            return null;
        }

        List<EtiquetaDTO> list = new ArrayList<EtiquetaDTO>( etiquetas.size() );
        for ( Etiqueta etiqueta : etiquetas ) {
            list.add( toEtiquetaDto( etiqueta ) );
        }

        return list;
    }

    @Override
    public Etiqueta toEtiqueta(EtiquetaRequestDTO request) {
        if ( request == null ) {
            return null;
        }

        Etiqueta etiqueta = new Etiqueta();

        etiqueta.setEscenario( etiquetaRequestDTOToEscenario( request ) );
        etiqueta.setName( request.name() );

        return etiqueta;
    }

    protected Escenario etiquetaRequestDTOToEscenario(EtiquetaRequestDTO etiquetaRequestDTO) {
        if ( etiquetaRequestDTO == null ) {
            return null;
        }

        Escenario escenario = new Escenario();

        if ( etiquetaRequestDTO.idEscenario() != null ) {
            escenario.setId( etiquetaRequestDTO.idEscenario() );
        }

        return escenario;
    }
}
