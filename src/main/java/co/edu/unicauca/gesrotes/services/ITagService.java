package co.edu.unicauca.gesrotes.services;

import co.edu.unicauca.gesrotes.models.CompleteTag;
import co.edu.unicauca.gesrotes.models.CompleteTagService;
import co.edu.unicauca.gesrotes.models.Tag;
import co.edu.unicauca.gesrotes.models.TagServiceModel;

import java.util.List;
import java.util.Optional;

public interface ITagService {
    Optional<List<CompleteTag>> getAll();

    Optional<List<CompleteTag>> getAllByScenary(String id);

    Integer addTag(Tag tag);

    Integer deleteTag(Integer id);

    Integer addTagService(TagServiceModel tagService);

    Optional<CompleteTagService> getAsociation(Integer idTag, String idService);

    Optional<List<CompleteTagService>> getAsociations();

    Integer deleteAsociation(String id);
}


