package co.edu.unicauca.gesrotes.repositories;

import co.edu.unicauca.gesrotes.models.CompleteTurnFeeding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface ICompleteTurnFeedingRepository extends JpaRepository<CompleteTurnFeeding, Integer> {
    @Query(value = "SELECT tf.id_turn_feeding, s.name name_student, tf.id_feeding, f.name name_feeding, tf.id_turn, sh.start_time, sh.end_time FROM `turn_feeding` tf JOIN turn t ON tf.id_turn = t.id_turn JOIN student s ON s.id_student = t.id_student JOIN feeding f ON tf.id_feeding = f.id_feeding JOIN shift sh ON sh.id_shift = t.id_shift WHERE t.id_subject = ?1 AND t.date = ?2", nativeQuery = true)
    Optional<List<CompleteTurnFeeding>> getCompleteTurnFeeding(String idSubject, Date date);
}
