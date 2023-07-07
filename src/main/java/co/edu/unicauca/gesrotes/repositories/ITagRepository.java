package co.edu.unicauca.gesrotes.repositories;

import co.edu.unicauca.gesrotes.models.Tag;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Transactional
public interface ITagRepository extends JpaRepository<Tag, Integer> {

    @Query(value = "SELECT * FROM `tag` WHERE id_scenary = ?1", nativeQuery = true)
    Optional<List<Tag>> findAllByScenary(String id);

    @Query(value = "SELECT * FROM tag WHERE name = ?1", nativeQuery = true)
    Optional<List<Tag>> findByName(String name);

    @Modifying
    @Query(value = "DELETE FROM tag WHERE id_tag = ?1", nativeQuery = true)
    void deleteTag(Integer id);
}
