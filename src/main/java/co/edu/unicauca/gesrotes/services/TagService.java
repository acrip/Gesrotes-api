package co.edu.unicauca.gesrotes.services;

import co.edu.unicauca.gesrotes.models.CompleteTag;
import co.edu.unicauca.gesrotes.models.CompleteTagService;
import co.edu.unicauca.gesrotes.models.Tag;
import co.edu.unicauca.gesrotes.models.TagServiceModel;
import co.edu.unicauca.gesrotes.repositories.ICompleteTagRepository;
import co.edu.unicauca.gesrotes.repositories.ICompleteTagServiceRepository;
import co.edu.unicauca.gesrotes.repositories.IServiceRepository;
import co.edu.unicauca.gesrotes.repositories.ITagRepository;
import co.edu.unicauca.gesrotes.repositories.ITagServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService implements ITagService {

    @Autowired
    ITagRepository tagRepository;
    @Autowired
    ITagServiceRepository tagServiceRepository;
    @Autowired
    ICompleteTagRepository completeTagRepository;
    @Autowired
    IServiceRepository serviceRepository;
    @Autowired
    ICompleteTagServiceRepository completeTagServiceRepository;

    @Override
    public Optional<List<CompleteTag>> getAll() {
        return completeTagRepository.findAllTag();
    }

    @Override
    public Optional<List<CompleteTag>> getAllByScenary(String id) {
        return completeTagRepository.findAllByScenary(id);
    }

    public Optional<Tag> getById(Integer id) {
        return tagRepository.findById(id);
    }

    public Optional<List<Tag>> getByName(String name) {
        return tagRepository.findByName(name);
    }

    @Override
    public Integer addTag(Tag tag) {
        Optional<List<Tag>> tags = getByName(tag.getName());
        if (tags.isPresent()) {
            for (Tag auxTag : tags.get()) {
                if (tag.getIdScenary().equals(auxTag.getIdScenary())) {
                    return 0;
                }
            }
        }
        if (tagRepository.save(tag) != null) {
            return 1;
        }
        return -1;

    }

    @Override
    public Integer deleteTag(Integer id) {
        Optional<Tag> tag = getById(id);
        if (tag.isPresent()) {
            tagRepository.deleteTag(id);
            return 1;
        }
        return 0;
    }

    @Override
    public Integer addTagService(TagServiceModel tagService) {
        try {
            if (tagServiceRepository.findAssociationTagService(tagService.getIdTag(), tagService.getIdService())
                    .isPresent()) {
                return 0;
            }
            tagServiceRepository.save(tagService);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public Optional<CompleteTagService> getAsociation(Integer idTag, String idService) {
        return completeTagServiceRepository.getTagService(idTag, idService);
        /*if (tagServiceRepository.findAssociationTagService(idTag, idService).isPresent()) {
            String nameTag = tagRepository.findById(idTag).get().getName();
            String nameService = serviceRepository.findById(idService).get().getName();
            String[] asociacion = { nameTag, nameService };
            return null;
        }
        return null;/* */
    }

    @Override
    public Optional<List<CompleteTagService>> getAsociations() {
        return completeTagServiceRepository.getTagServices();
        /*List<TagServiceModel> tagsServices = tagServiceRepository.findAll();
        if (tagsServices.isEmpty()){
            return null;
        }
        List<String[]> asociaciones = new ArrayList<>();
        for(TagServiceModel tagService: tagsServices){
            String nameTag = tagRepository.findById(tagService.getIdTag()).get().getName();
            String nameService = serviceRepository.findById(tagService.getIdService()).get().getName();
            String[] asociacion = {nameTag, nameService};
            asociaciones.add(asociacion);
        }
        return asociaciones;*/
    }

    @Override
    public Integer deleteAsociation(String id) {
        if (tagServiceRepository.findById(id).isPresent()) {
            tagServiceRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

}
