package co.edu.unicauca.gesrotes.services;

import co.edu.unicauca.gesrotes.models.CompleteSubject;
import co.edu.unicauca.gesrotes.models.Coordinator;
import co.edu.unicauca.gesrotes.models.Subject;

import java.util.List;
import java.util.Optional;

public interface ICoordinatorService {
    List<Coordinator> getCoordinators();

    Boolean addSubject(Subject subject);

    List<CompleteSubject> getSubjectsToCoordinator(String id);

    Optional<Coordinator> getCoordinator(String id);
}
