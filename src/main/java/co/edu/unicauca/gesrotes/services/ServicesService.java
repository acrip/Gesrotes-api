package co.edu.unicauca.gesrotes.services;

import co.edu.unicauca.gesrotes.models.Service;
import co.edu.unicauca.gesrotes.repositories.IServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServicesService implements IServicesService {
    @Autowired
    IServiceRepository serviceRepository;

    @Override
    public List<Service> getServices() {
        return serviceRepository.findAll();
    }

}
