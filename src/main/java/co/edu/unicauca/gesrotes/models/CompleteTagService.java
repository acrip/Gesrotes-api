package co.edu.unicauca.gesrotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tag_service")
public class CompleteTagService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tag_service")
    private Integer idTagService;
    @Column(name = "id_tag")
    private Integer idTag;
    private String nameTag;
    @Column(name = "id_service")
    private String idService;
    private String nameService;
    private String nameHospital;

    public CompleteTagService() {
    }

    public CompleteTagService(Integer idTagService, Integer idTag, String nameTag, String idService, String nameService,
            String nameHospital) {
        this.idTagService = idTagService;
        this.idTag = idTag;
        this.nameTag = nameTag;
        this.idService = idService;
        this.nameService = nameService;
        this.nameHospital = nameHospital;
    }

    public Integer getIdTagService() {
        return idTagService;
    }

    public String getNameTag() {
        return nameTag;
    }

    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getNameHospital() {
        return nameHospital;
    }

    public void setNameHospital(String nameHospital) {
        this.nameHospital = nameHospital;
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
