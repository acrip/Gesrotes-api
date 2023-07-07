package co.edu.unicauca.gesrotes.controllers;

import co.edu.unicauca.gesrotes.models.CompleteTag;
import co.edu.unicauca.gesrotes.models.CompleteTagService;
import co.edu.unicauca.gesrotes.models.Tag;
import co.edu.unicauca.gesrotes.models.TagServiceModel;
import co.edu.unicauca.gesrotes.services.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/scenary")
public class TagController {

    @Autowired
    ITagService tagService;

    @GetMapping("/tag")
    public ResponseEntity<?> tags(@RequestParam(required = false) String id) {
        if (id == null) {
            Optional<List<CompleteTag>> tags = tagService.getAll();
            if (tags.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(tags);
        } else {
            Optional<List<CompleteTag>> tags = tagService.getAllByScenary(id);
            if (tags.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(tags);
        }
    }

    @PostMapping("/tag/add")
    public ResponseEntity<?> addTag(@RequestBody Tag tag) {
        Integer response = tagService.addTag(tag);
        if (response == 1) {
            return ResponseEntity.ok("Etiqueta agregada correctamente");
        } else if (response == 0) {
            return ResponseEntity.status(409).body("La etiqueta ya existe");
        } else {
            return ResponseEntity.status(400).body("Ocurrió un error inesperado");
        }
    }

    @GetMapping("/tag/delete")
    public ResponseEntity<?> deleteTag(@RequestParam(required = true) Integer id) {
        Integer response = tagService.deleteTag(id);
        if (response == 1) {
            return ResponseEntity.ok("Etiqueta eliminada correctamente");
        } else {
            return ResponseEntity.status(400).body("La etiqueta que desea eliminar no existe");
        }

    }

    @PostMapping("/tagService/add")
    public ResponseEntity<?> addTagService(@RequestParam(required = true) Integer idTag,
                                           @RequestParam(required = true) String idService) {
        TagServiceModel tagServiceAssociation = new TagServiceModel(null, idTag, idService);
        Integer response = tagService.addTagService(tagServiceAssociation);
        if (response == 1) {
            return ResponseEntity.ok("Asociación creada");
        } else if (response == 0) {
            return ResponseEntity.status(409).body("La asociación ya existe");
        } else {
            return ResponseEntity.status(400).body("Error");
        }
    }

    @GetMapping("/tagService")
    public ResponseEntity<?> getTagService(@RequestParam(required = false) Integer idTag, @RequestParam(required = false) String idService) {
        //String[] asociation = null;
        //List<String[]> asociations = new ArrayList<>();
        Optional<CompleteTagService> asociation = Optional.empty();
        Optional<List<CompleteTagService>> asociations = Optional.empty();
        String response = "";
        if (idService == null && idTag == null) {
            asociations = tagService.getAsociations();
            response = "No hay asociaciones";
        } else {
            asociation = tagService.getAsociation(idTag, idService);
            response = "No existe esta asociación";
        }
        if (asociation.isPresent() && asociation.get() != null) {
            return ResponseEntity.ok(asociation);
        }
        if (asociations.isPresent() && !asociations.get().isEmpty()) {
            return ResponseEntity.ok(asociations);
        }
        return ResponseEntity.status(404).body(response);
    }

    @GetMapping("/tagService/delete")
    public ResponseEntity<?> deleteTagService(@RequestParam(required = true) String id) {
        Integer response = tagService.deleteAsociation(id);
        if (response == 1) {
            return ResponseEntity.ok("Eliminado correctamente");
        } else {
            return ResponseEntity.status(400).body("El registro que se desea eliminar no existe");
        }
    }

}
