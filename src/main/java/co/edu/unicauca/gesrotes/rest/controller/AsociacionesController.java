package co.edu.unicauca.gesrotes.rest.controller;

import co.edu.unicauca.gesrotes.rest.dto.response.AsociacionResponseDTO;
import co.edu.unicauca.gesrotes.service.AsociacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(path = "v1/asociacion", produces = MediaType.APPLICATION_JSON_VALUE)
public class AsociacionesController {

    @Autowired
    private AsociacionService asociacionService;


    @GetMapping
    public ResponseEntity<List<AsociacionResponseDTO>> list(){
        return ResponseEntity.ok(asociacionService.list());
    }
}
