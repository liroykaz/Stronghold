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

@NamePattern("%s|name")
@Table(name = "STRONGHOLD_SUBJECT")
@Entity(name = "stronghold$Subject")
public class Subject extends StandardEntity {
    private static final long serialVersionUID = 1676889631617269365L;

    @Column(name = "NAME")
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID", unique = true)
    protected User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEACHER_ID")
    protected User teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATERIALS_MAP_ID")
    protected MaterialsMap materialsMap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_ID")
    protected Course course;

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


    public MaterialsMap getMaterialsMap() {
        return materialsMap;
    }

    public void setMaterialsMap(MaterialsMap materialsMap) {
        this.materialsMap = materialsMap;
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