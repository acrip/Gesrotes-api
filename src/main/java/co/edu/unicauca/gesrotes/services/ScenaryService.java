package co.edu.unicauca.gesrotes.services;

import co.edu.unicauca.gesrotes.models.Scenary;
import co.edu.unicauca.gesrotes.repositories.IScenaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenaryService implements IScenaryService {

    @Autowired
    IScenaryRepository scenaryRepository;

    @Override
    public List<Scenary> getScenaries() {
        return scenaryRepository.findAll();
    }

}
