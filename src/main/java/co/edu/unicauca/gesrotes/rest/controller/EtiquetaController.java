package co.edu.unicauca.gesrotes.rest.controller;

import co.edu.unicauca.gesrotes.rest.dto.EtiquetaDTO;
import co.edu.unicauca.gesrotes.rest.dto.request.EtiquetaRequestDTO;
import co.edu.unicauca.gesrotes.service.EtiquetaService;
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
@RequestMapping(path = "v1/etiqueta", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtiquetaController {

    @Autowired
    private EtiquetaService etiquetaService;

    @GetMapping
    public ResponseEntity<List<EtiquetaDTO>> listar() {
        return ResponseEntity.ok(etiquetaService.listar());
    }

    @PostMapping
    public ResponseEntity<EtiquetaDTO> crear(@RequestBody EtiquetaRequestDTO etiquetaRequest) {
        EtiquetaDTO etiquetaDto = etiquetaService.crear(etiquetaRequest);
        URI location = URI.create("v1/etiqueta/" + etiquetaDto.id());
        return ResponseEntity.created(location).body(etiquetaDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<EtiquetaDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(etiquetaService.obtener(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<EtiquetaDTO> actualizar(@PathVariable Long id, @RequestBody EtiquetaRequestDTO etiquetaRequest) {
        return ResponseEntity.ok(etiquetaService.actualizar(id, etiquetaRequest));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        etiquetaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
