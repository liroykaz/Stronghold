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
import java.util.Collection;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Table(name = "STRONGHOLD_MATERIAL")
@NamePattern(" %s %s|duration,typeMaterial")
@Entity(name = "stronghold$Material")
public class Material extends StandardEntity {
    private static final long serialVersionUID = -3251616188954541293L;

    @Column(name = "DURATION")
    protected Integer duration;

    @JoinTable(name = "STRONGHOLD_MATERIAL_ATTACHMENT_LINK",
        joinColumns = @JoinColumn(name = "MATERIAL_ID"),
        inverseJoinColumns = @JoinColumn(name = "ATTACHMENT_ID"))
    @ManyToMany
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @OnDelete(DeletePolicy.CASCADE)
    protected List<Attachment> attachment;


    @Column(name = "TYPE_MATERIAL")
    protected Integer typeMaterial;

    @JoinTable(name = "STRONGHOLD_SUBJECT_MATERIAL_LINK",
        joinColumns = @JoinColumn(name = "MATERIAL_ID"),
        inverseJoinColumns = @JoinColumn(name = "SUBJECT_ID"))
    @ManyToMany
    protected List<Subject> subjects;

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }


    public void setTypeMaterial(MaterialsTypeEnum typeMaterial) {
        this.typeMaterial = typeMaterial == null ? null : typeMaterial.getId();
    }

    public MaterialsTypeEnum getTypeMaterial() {
        return typeMaterial == null ? null : MaterialsTypeEnum.fromId(typeMaterial);
    }

    public List<Attachment> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<Attachment> attachment) {
        this.attachment = attachment;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}