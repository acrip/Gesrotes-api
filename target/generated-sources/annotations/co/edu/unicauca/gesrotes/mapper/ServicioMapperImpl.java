package co.edu.unicauca.gesrotes.mapper;

import co.edu.unicauca.gesrotes.domain.Servicio;
import co.edu.unicauca.gesrotes.rest.dto.ServicioDTO;
import co.edu.unicauca.gesrotes.rest.dto.request.ServicioRequestDTO;
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
public class ServicioMapperImpl implements ServicioMapper {

    @Override
    public ServicioDTO toServicioDto(Servicio servicio) {
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

    @Override
    public List<ServicioDTO> toServicioDtos(List<Servicio> servicios) {
        if ( servicios == null ) {
            return null;
        }

        List<ServicioDTO> list = new ArrayList<ServicioDTO>( servicios.size() );
        for ( Servicio servicio : servicios ) {
            list.add( toServicioDto( servicio ) );
        }

        return list;
    }

    @Override
    public Servicio toServicio(ServicioRequestDTO request) {
        if ( request == null ) {
            return null;
        }

        Servicio servicio = new Servicio();

        servicio.setId( request.idEtiqueta() );
        servicio.setName( request.name() );

        return servicio;
    }
}
