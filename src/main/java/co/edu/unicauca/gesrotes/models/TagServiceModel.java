package co.edu.unicauca.gesrotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tag_service")
public class TagServiceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tag_service")
    private Integer idTagService;
    @Column(name = "id_tag")
    private Integer idTag;
    @Column(name = "id_service")
    private String idService;

    public TagServiceModel() {
    }

    public TagServiceModel(Integer idTagService, Integer idTag, String idService) {
        this.idTagService = idTagService;
        this.idTag = idTag;
        this.idService = idService;
    }

    public Integer getIdTagService() {
        return idTagService;
    }

    public void setIdTagService(Integer idTagService) {
        this.idTagService = idTagService;
    }

    public Integer getIdTag() {
        return idTag;
    }

    public void setIdTag(Integer idTag) {
        this.idTag = idTag;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

}
