package com.haulmont.stronghold.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.List;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Table(name = "STRONGHOLD_MATERIAL")
@NamePattern("%s %s|typeMaterial,duration")
@Entity(name = "stronghold$Material")
public class Material extends StandardEntity {
    private static final long serialVersionUID = -3251616188954541293L;

    @Column(name = "TYPE_MATERIAL")
    protected Integer typeMaterial;

    @Column(name = "DURATION")
    protected Integer duration;

    @JoinTable(name = "STRONGHOLD_MATERIAL_FILE_DESCRIPTOR_LINK",
        joinColumns = @JoinColumn(name = "MATERIAL_ID"),
        inverseJoinColumns = @JoinColumn(name = "FILE_DESCRIPTOR_ID"))
    @OnDeleteInverse(DeletePolicy.DENY)
    @OnDelete(DeletePolicy.CASCADE)
    @ManyToMany
    protected List<FileDescriptor> attachment;

    public List<FileDescriptor> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<FileDescriptor> attachment) {
        this.attachment = attachment;
    }


    public NewEnum getTypeMaterial() {
        return typeMaterial == null ? null : NewEnum.fromId(typeMaterial);
    }

    public void setTypeMaterial(NewEnum typeMaterial) {
        this.typeMaterial = typeMaterial == null ? null : typeMaterial.getId();
    }


    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }



}