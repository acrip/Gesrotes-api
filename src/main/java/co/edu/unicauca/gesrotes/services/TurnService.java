package co.edu.unicauca.gesrotes.services;

import co.edu.unicauca.gesrotes.models.CompleteTurn;
import co.edu.unicauca.gesrotes.models.CompleteTurnFeeding;
import co.edu.unicauca.gesrotes.models.Shift;
import co.edu.unicauca.gesrotes.models.Turn;
import co.edu.unicauca.gesrotes.models.TurnFeeding;
import co.edu.unicauca.gesrotes.models.Validation;
import co.edu.unicauca.gesrotes.repositories.ICompleteTurnFeedingRepository;
import co.edu.unicauca.gesrotes.repositories.ICompleteTurnRepository;
import co.edu.unicauca.gesrotes.repositories.IShiftRepository;
import co.edu.unicauca.gesrotes.repositories.ITurnFeedingRepository;
import co.edu.unicauca.gesrotes.repositories.ITurnRepository;
import co.edu.unicauca.gesrotes.repositories.IValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TurnService implements ITurnService {
    @Autowired
    ITurnRepository turnRepository;
    @Autowired
    ITurnFeedingRepository turnFeedingRepository;
    @Autowired
    ICompleteTurnRepository completeTurnRepository;
    @Autowired
    ICompleteTurnFeedingRepository completeTurnFeedingRepository;
    @Autowired
    IShiftRepository shiftRepository;
    @Autowired
    IValidationRepository validationRepository;

    @Override
    public Integer addTurn(Turn turn) {
        if (turnRepository.findExistTurn(turn.getIdStudent(), turn.getIdSubject(), turn.getIdScenary(), turn.getIdTag(),
                turn.getIdShift(), turn.getDate()).isPresent()) {
            return -1;
        }
        if (turn.getDate().isAfter(LocalDate.now()) || turn.getDate().isEqual(LocalDate.now())) {
            turnRepository.save(turn);
            validationFeeding(turn);
            return 1;
        }
        return 0;
    }

    private void validationFeeding(Turn turn) {
        switch (turn.getIdShift()) {
            case "1":
                turnFeedingRepository.save(new TurnFeeding("1", turn.getIdTurn()));
                break;
            case "2":
                turnFeedingRepository.save(new TurnFeeding("2", turn.getIdTurn()));
                break;
            case "3":
                turnFeedingRepository.save(new TurnFeeding("3", turn.getIdTurn()));
                break;
        }
    }

    @Override
    public Optional<List<CompleteTurn>> getTurnBySubject(String idSubject) {
        return completeTurnRepository.findCompleteBySubject(idSubject);
    }

    @Override
    public Optional<List<CompleteTurn>> getTurnByStudentSubject(String idSubject, String idStudent) {
        return completeTurnRepository.findByStudentSubject(idSubject, idStudent);
    }

    @Override
    public Optional<Turn> getTurnById(Integer idTurn) {
        return turnRepository.findById(idTurn);
    }

    @Override
    public Integer deleteById(Integer idTurn) {
        if (getTurnById(idTurn).isPresent()) {
            Turn turn = getTurnById(idTurn).get();
            turnRepository.delete(turn);
            return 1;
        }
        return 0;
    }

    @Override
    public Integer deleteAsociations(String idSubject, String idStudent, Date date) {
        Optional<List<Turn>> turn = turnRepository.findByIdStudentAndIdSubjectAndDate(idSubject, idStudent, date);
        if (turn.isPresent() && !turn.get().isEmpty()) {
            for (Turn actualTurn : turn.get()) {
                turnRepository.delete(actualTurn);
            }
            return 1;
        }
        return 0;
    }

    @Override
    public Integer updateTurn(Turn turn) {
        if (turnRepository.findExistTurn(turn.getIdStudent(), turn.getIdSubject(), turn.getIdScenary(), turn.getIdTag(),
                turn.getIdShift(), turn.getDate()).isPresent()) {
            return -1;
        }
        Optional<Turn> auxTurn = getTurnById(turn.getIdTurn());
        if (turn.getDate().isAfter(LocalDate.now()) || turn.getDate().isEqual(LocalDate.now()) && auxTurn.isPresent()) {
            if (auxTurn.get().getIdStudent().equals(turn.getIdStudent())
                    && auxTurn.get().getIdSubject().equals(turn.getIdSubject())
                    && auxTurn.get().getIdShift().equals(turn.getIdShift())) {
                if (!auxTurn.get().getIdScenary().equals(turn.getIdScenary()) || !auxTurn.get().getIdTag().equals(turn.getIdTag()) || !auxTurn.get().getDate().equals(turn.getDate())) {
                    turnRepository.save(turn);
                    return 1;
                }
            } else {
                return -2;
            }
        }
        return 0;
    }

    @Override
    public Optional<List<CompleteTurnFeeding>> getTurnFeeding(String idSubject, Date date) {
        return completeTurnFeedingRepository.getCompleteTurnFeeding(idSubject, date);
    }

    @Override
    public List<Shift> getShift() {
        return shiftRepository.findAll();
    }

    @Override
    public Optional<List<Validation>> getValidations(String idSubject, Date date) {
        return validationRepository.findValidationsToDate(idSubject, date);
    }
}