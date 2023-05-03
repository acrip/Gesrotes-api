package co.edu.unicauca.gesrotes.rest.controller;

import co.edu.unicauca.gesrotes.rest.dto.ServicioDTO;
import co.edu.unicauca.gesrotes.rest.dto.request.ServicioRequestDTO;
import co.edu.unicauca.gesrotes.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping(path = "v1/servicio", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public ResponseEntity<List<ServicioDTO>> listar() {
        return ResponseEntity.ok(servicioService.listar());
    }

    @PostMapping
    public ResponseEntity<ServicioDTO> crear(@RequestBody ServicioRequestDTO servicioRequest) {
        ServicioDTO servicioDto = servicioService.crear(servicioRequest);
        URI location = URI.create("v1/servicio/" + servicioDto.id());
        return ResponseEntity.created(location).body(servicioDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<ServicioDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(servicioService.obtener(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<ServicioDTO> actualizar(@PathVariable Long id, @RequestBody ServicioRequestDTO servicioRequest) {
        return ResponseEntity.ok(servicioService.actualizar(id, servicioRequest));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        servicioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}