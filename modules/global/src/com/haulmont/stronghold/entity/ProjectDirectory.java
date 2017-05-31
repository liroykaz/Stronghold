package com.haulmont.stronghold.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@NamePattern("%s|projectName")
@Table(name = "STRONGHOLD_PROJECT_DIRECTORY")
@Entity(name = "stronghold$ProjectDirectory")
public class ProjectDirectory extends StandardEntity {
    private static final long serialVersionUID = 1209381733388025237L;

    @Column(name = "PROJECT_NAME")
    protected String projectName;

    @JoinTable(name = "STRONGHOLD_STUDENT_PROJECT_DIRECTORY_LINK",
        joinColumns = @JoinColumn(name = "PROJECT_DIRECTORY_ID"),
        inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
    @ManyToMany
    protected List<Student> students;

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }


    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }


}