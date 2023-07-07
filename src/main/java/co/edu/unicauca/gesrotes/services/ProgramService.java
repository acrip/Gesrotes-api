package co.edu.unicauca.gesrotes.services;

import co.edu.unicauca.gesrotes.models.Program;
import co.edu.unicauca.gesrotes.repositories.IProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService implements IProgramService {

    @Autowired
    IProgramRepository programRepository;

    @Override
    public List<Program> getPrograms() {
        return programRepository.findAll();
    }

}
