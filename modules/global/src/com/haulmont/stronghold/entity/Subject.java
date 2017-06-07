package com.haulmont.stronghold.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.security.entity.User;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@NamePattern("%s|name")
@Table(name = "STRONGHOLD_SUBJECT")
@Entity(name = "stronghold$Subject")
public class Subject extends StandardEntity {
    private static final long serialVersionUID = 1676889631617269365L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID", unique = true)
    protected User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEACHER_ID")
    protected User teacher;

    @JoinTable(name = "STRONGHOLD_SUBJECT_MATERIALS_MAP_LINK",
        joinColumns = @JoinColumn(name = "SUBJECT_ID"),
        inverseJoinColumns = @JoinColumn(name = "MATERIALS_MAP_ID"))
    @ManyToMany
    protected List<MaterialsMap> materialsMap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_ID")
    protected Course course;

    public List<MaterialsMap> getMaterialsMap() {
        return materialsMap;
    }

    public void setMaterialsMap(List<MaterialsMap> materialsMap) {
        this.materialsMap = materialsMap;
    }


    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }


    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }



    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}