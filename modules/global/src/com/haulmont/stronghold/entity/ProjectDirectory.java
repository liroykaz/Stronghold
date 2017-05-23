package com.haulmont.stronghold.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|projectName")
@Table(name = "STRONGHOLD_PROJECT_DIRECTORY")
@Entity(name = "stronghold$ProjectDirectory")
public class ProjectDirectory extends StandardEntity {
    private static final long serialVersionUID = 1209381733388025237L;

    @Column(name = "PROJECT_NAME")
    protected String projectName;

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }


}