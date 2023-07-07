package co.edu.unicauca.gesrotes.services;

import co.edu.unicauca.gesrotes.models.CompleteTurn;
import co.edu.unicauca.gesrotes.models.CompleteTurnFeeding;
import co.edu.unicauca.gesrotes.models.Shift;
import co.edu.unicauca.gesrotes.models.Turn;
import co.edu.unicauca.gesrotes.models.Validation;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface ITurnService {
    Integer addTurn(Turn turn);

    Integer updateTurn(Turn turn);

    Optional<List<CompleteTurn>> getTurnBySubject(String idSubject);

    Optional<List<CompleteTurn>> getTurnByStudentSubject(String idSubject, String idStudent);

    Optional<Turn> getTurnById(Integer idTurn);

    Integer deleteById(Integer idTurn);

    Integer deleteAsociations(String idSubject, String idStudent, Date date);

    Optional<List<CompleteTurnFeeding>> getTurnFeeding(String idSubject, Date date);

    List<Shift> getShift();

    Optional<List<Validation>> getValidations(String idSubject, Date date);
}
