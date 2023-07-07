package co.edu.unicauca.gesrotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tag")
public class CompleteTag {
    @Id
    @Column(name = "id_tag")
    private Integer idTag;
    @Column(name = "name")
    private String name;
    @Column(name = "id_scenary")
    private String idScenary;
    private String nameScenary;

    public CompleteTag() {
    }

    public CompleteTag(Integer idTag, String name, String idScenary, String nameScenary) {
        this.idTag = idTag;
        this.name = name;
        this.idScenary = idScenary;
        this.nameScenary = nameScenary;
    }

    public Integer getIdTag() {
        return idTag;
    }

    public void setIdTag(Integer idTag) {
        this.idTag = idTag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdScenary() {
        return idScenary;
    }

    public void setIdScenary(String idScenary) {
        this.idScenary = idScenary;
    }

    public String getNameScenary() {
        return nameScenary;
    }

    public void setNameScenary(String nameScenary) {
        this.nameScenary = nameScenary;
    }
}
