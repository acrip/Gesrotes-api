package co.edu.unicauca.gesrotes.repositories;

import co.edu.unicauca.gesrotes.models.CompleteTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ICompleteTagRepository extends JpaRepository<CompleteTag, String> {
    @Query(value = "SELECT t.*, s.name name_scenary FROM tag t JOIN scenary s ON s.id_scenary = t.id_scenary WHERE t.id_scenary = ?1", nativeQuery = true)
    Optional<List<CompleteTag>> findAllByScenary(String idScenary);

    @Query(value = "SELECT t.*, s.name name_scenary FROM tag t JOIN scenary s ON s.id_scenary = t.id_scenary", nativeQuery = true)
    Optional<List<CompleteTag>> findAllTag();
}
