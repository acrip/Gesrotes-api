package co.edu.unicauca.gesrotes.repositories;

import co.edu.unicauca.gesrotes.models.TagServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ITagServiceRepository extends JpaRepository<TagServiceModel, String> {
    @Query(value = "SELECT * FROM `tag_service` WHERE id_tag = ?1 AND id_service = ?2", nativeQuery = true)
    public Optional<TagServiceModel> findAssociationTagService(Integer idTag, String idService);
}
