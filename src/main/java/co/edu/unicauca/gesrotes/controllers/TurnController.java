package co.edu.unicauca.gesrotes.controllers;

import co.edu.unicauca.gesrotes.models.CompleteTurn;
import co.edu.unicauca.gesrotes.models.CompleteTurnFeeding;
import co.edu.unicauca.gesrotes.models.Shift;
import co.edu.unicauca.gesrotes.models.Turn;
import co.edu.unicauca.gesrotes.services.ITurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/turn")
public class TurnController {
    @Autowired
    ITurnService turnService;

    @PostMapping("/add")
    public ResponseEntity<?> addTurn(@RequestBody Turn turn) {
        Integer response = turnService.addTurn(turn);
        if (response == 1) {
            return ResponseEntity.ok("Turno creado");
        } else if (response == 0) {
            return ResponseEntity.status(400).body("La fecha debe ser mayor a la actual");
        }
        return ResponseEntity.status(400).body("Ya existe un turno creado en este horario");
    }

    @GetMapping
    public ResponseEntity<?> getTurn(@RequestParam(required = true) String idSubject,
                                     @RequestParam(required = false) String idStudent) {
        if (idStudent == null) {
            Optional<List<CompleteTurn>> turns = turnService.getTurnBySubject(idSubject);
            if (turns.isPresent() && !turns.get().isEmpty()) {
                return ResponseEntity.ok().body(turns);
            }
        } else {
            Optional<List<CompleteTurn>> turns = turnService.getTurnByStudentSubject(idSubject, idStudent);
            if (turns.isPresent() && !turns.get().isEmpty()) {
                return ResponseEntity.ok().body(turns);
            }
        }
        List<CompleteTurn> turns = new ArrayList<>();
        return ResponseEntity.ok(turns);
    }

    @GetMapping("/delete")
    public ResponseEntity<?> deleteTurn(@RequestParam(required = true) Integer idTurn) {
        Integer response = turnService.deleteById(idTurn);
        if (response == 1) {
            return ResponseEntity.ok().body("Turno eliminado correctamente");
        }
        return ResponseEntity.status(404).body("El turno no existe");

    }

    @DeleteMapping("/deleteAsociations")
    public ResponseEntity<?> deleteAsociations(@RequestParam(required = true) String idSubject,
                                               @RequestParam(required = true) String idStudent, @RequestParam(required = true) String date) {
        Integer response = turnService.deleteAsociations(idSubject, idStudent, Date.valueOf(date));
        if (response == 1) {
            return ResponseEntity.ok().body("Asociaciones eliminadas correctamente");
        }
        return ResponseEntity.status(404).body("No hay asociaciones");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateTurn(@RequestBody Turn turn) {
        Integer response = turnService.updateTurn(turn);
        if (response == 1) {
            return ResponseEntity.ok("Turno actualizado");
        } else if (response == 0) {
            return ResponseEntity.status(400).body("La fecha debe ser mayor a la actual");
        } else if (response == -2) {
            return ResponseEntity.status(400).body("Sólo se puede cambiar el lugar y la fecha. Inténtelo nuevamente");
        }
        return ResponseEntity.status(400).body("No se han hecho cambios en el turno. Intente cambiar la fecha o el lugar");
    }

    @GetMapping("/feeding")
    public ResponseEntity<?> getFeeding(@RequestParam(required = true) String idSubject,
                                        @RequestParam(required = true) String date) {
        Optional<List<CompleteTurnFeeding>> turnFeeding = turnService.getTurnFeeding(idSubject, Date.valueOf(date));
        if (turnFeeding.isPresent() && !turnFeeding.get().isEmpty()) {
            return ResponseEntity.ok(turnFeeding);
        } else {
            List<CompleteTurnFeeding> turns = new ArrayList<>();
            return ResponseEntity.status(200).body(turns);
        }
    }

    @GetMapping("/shift")
    public ResponseEntity<?> getShift() {
        List<Shift> shifts = turnService.getShift();
        if (!shifts.isEmpty()) {
            return ResponseEntity.ok(shifts);
        }
        return ResponseEntity.status(404).body("No hay jornadas creadas.");
    }
}
