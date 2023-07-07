package co.edu.unicauca.gesrotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tag")
    private Integer idTag;
    @Column(name = "name")
    private String name;
    @Column(name = "id_scenary")
    private String idScenary;

    public Tag() {
    }

    public Tag(String name, String idScenary) {
        this.name = name;
        this.idScenary = idScenary;
    }

    public Tag(Integer idTag, String name, String idScenary) {
        this.idTag = idTag;
        this.name = name;
        this.idScenary = idScenary;
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

}
