package co.edu.unicauca.gesrotes.controllers;

import co.edu.unicauca.gesrotes.models.Scenary;
import co.edu.unicauca.gesrotes.services.IScenaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ScenaryController {
    @Autowired
    IScenaryService scenaryService;

    @GetMapping("/scenaries")
    public List<Scenary> getScenaries() {
        return scenaryService.getScenaries();
    }
}
