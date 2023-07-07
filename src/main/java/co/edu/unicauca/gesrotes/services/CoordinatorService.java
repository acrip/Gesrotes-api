package co.edu.unicauca.gesrotes.services;

import co.edu.unicauca.gesrotes.models.CompleteSubject;
import co.edu.unicauca.gesrotes.models.Coordinator;
import co.edu.unicauca.gesrotes.models.Subject;
import co.edu.unicauca.gesrotes.repositories.ICompleteSubjectService;
import co.edu.unicauca.gesrotes.repositories.ICoordinatorRepository;
import co.edu.unicauca.gesrotes.repositories.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordinatorService implements ICoordinatorService {

    @Autowired
    ICoordinatorRepository coordinatorRepository;
    @Autowired
    ISubjectRepository subjectRepository;
    @Autowired
    ICompleteSubjectService completeSubjectService;

    @Override
    public List<Coordinator> getCoordinators() {
        return coordinatorRepository.findAll();
    }

    @Override
    public List<CompleteSubject> getSubjectsToCoordinator(String id) {
        return completeSubjectService.findSubjectsToCoordinator(id);
    }

    @Override
    public Boolean addSubject(Subject subject) {
        return true;
    }

    @Override
    public Optional<Coordinator> getCoordinator(String id) {
        return coordinatorRepository.findById(id);
    }

}
