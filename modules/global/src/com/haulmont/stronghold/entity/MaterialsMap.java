package com.haulmont.stronghold.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import java.util.List;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@NamePattern("%s %s|mapKey,material")
@Table(name = "STRONGHOLD_MATERIALS_MAP")
@Entity(name = "stronghold$MaterialsMap")
public class MaterialsMap extends StandardEntity {
    private static final long serialVersionUID = 1446807405402043271L;

    @Column(name = "MAP_KEY")
    protected Integer mapKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATERIAL_ID")
    protected Material material;

    @JoinTable(name = "STRONGHOLD_SUBJECT_MATERIALS_MAP_LINK",
        joinColumns = @JoinColumn(name = "MATERIALS_MAP_ID"),
        inverseJoinColumns = @JoinColumn(name = "SUBJECT_ID"))
    @ManyToMany
    protected List<Subject> subjects;

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }


    public void setMapKey(Integer mapKey) {
        this.mapKey = mapKey;
    }

    public Integer getMapKey() {
        return mapKey;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }


}