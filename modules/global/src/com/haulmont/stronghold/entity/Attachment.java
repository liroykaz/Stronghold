package com.haulmont.stronghold.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.FileDescriptor;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.OneToOne;
import java.util.Collection;
import java.util.Set;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@NamePattern("%s %s|attachment,comments")
@Table(name = "STRONGHOLD_ATTACHMENT")
@Entity(name = "stronghold$Attachment")
public class Attachment extends StandardEntity {
    private static final long serialVersionUID = 2480255276693329778L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ATTACHMENT_ID")
    protected FileDescriptor attachment;

    @JoinTable(name = "STRONGHOLD_MATERIAL_ATTACHMENT_LINK",
        joinColumns = @JoinColumn(name = "ATTACHMENT_ID"),
        inverseJoinColumns = @JoinColumn(name = "MATERIAL_ID"))
    @ManyToMany
    protected List<Material> materials;


    @NotNull
    @Column(name = "COMMENTS", nullable = false)
    protected String comments;

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }


    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public List<Material> getMaterials() {
        return materials;
    }


    public FileDescriptor getAttachment() {
        return attachment;
    }

    public void setAttachment(FileDescriptor attachment) {
        this.attachment = attachment;
    }



















}