package co.edu.unicauca.gesrotes.repositories;

import co.edu.unicauca.gesrotes.models.CompleteTagService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ICompleteTagServiceRepository extends JpaRepository<CompleteTagService, Integer> {
    @Query(value = "SELECT ts.id_tag_service, ts.id_tag, t.name name_tag, ts.id_service, s.name name_service, sc.name name_hospital FROM tag_service ts JOIN tag t ON ts.id_tag = t.id_tag JOIN service s ON s.id_service = ts.id_service JOIN scenary sc ON t.id_scenary = sc.id_scenary", nativeQuery = true)
    Optional<List<CompleteTagService>> getTagServices();

    @Query(value = "SELECT ts.id_tag_service, ts.id_tag, t.name name_tag, ts.id_service, s.name name_service, sc.name name_hospital FROM tag_service ts JOIN tag t ON ts.id_tag = t.id_tag JOIN service s ON s.id_service = ts.id_service JOIN scenary sc ON t.id_scenary = sc.id_scenary WHERE ts.id_tag = ?1 AND ts.id_service = ?1", nativeQuery = true)
    Optional<CompleteTagService> getTagService(Integer idTag, String idService);
}
