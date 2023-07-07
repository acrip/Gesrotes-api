package co.edu.unicauca.gesrotes.controllers;

import co.edu.unicauca.gesrotes.models.Service;
import co.edu.unicauca.gesrotes.services.IServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ServiceController {
    @Autowired
    IServicesService servicesService;

    @GetMapping("/service")
    public List<Service> getScenaries() {
        return servicesService.getServices();
    }
}

