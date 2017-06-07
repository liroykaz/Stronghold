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

@NamePattern("%s %s|name,surname")
@Table(name = "STRONGHOLD_STUDENT")
@Entity(name = "stronghold$Student")
public class Student extends StandardEntity {
    private static final long serialVersionUID = -8325619115600022796L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @NotNull
    @Column(name = "SURNAME", nullable = false)
    protected String surname;

    @Column(name = "PATRONYMIC")
    protected String patronymic;

    @Column(name = "EMAIL")
    protected String email;

    @Column(name = "SKYPE")
    protected String skype;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POSITION_ID")
    protected PositionDirectory position;

    @JoinTable(name = "STRONGHOLD_STUDENT_PROJECT_DIRECTORY_LINK",
        joinColumns = @JoinColumn(name = "STUDENT_ID"),
        inverseJoinColumns = @JoinColumn(name = "PROJECT_DIRECTORY_ID"))
    @ManyToMany
    protected List<ProjectDirectory> project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID")
    protected OrganizationDirectory organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", unique = true)
    protected User user;



    public List<ProjectDirectory> getProject() {
        return project;
    }

    public void setProject(List<ProjectDirectory> project) {
        this.project = project;
    }


    public PositionDirectory getPosition() {
        return position;
    }

    public void setPosition(PositionDirectory position) {
        this.position = position;
    }



    public OrganizationDirectory getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationDirectory organization) {
        this.organization = organization;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getSkype() {
        return skype;
    }


}