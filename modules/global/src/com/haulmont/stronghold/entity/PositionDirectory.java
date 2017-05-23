package com.haulmont.stronghold.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|positionName")
@Table(name = "STRONGHOLD_POSITION_DIRECTORY")
@Entity(name = "stronghold$PositionDirectory")
public class PositionDirectory extends StandardEntity {
    private static final long serialVersionUID = -4558026019975136095L;

    @Column(name = "POSITION_NAME")
    protected String positionName;

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionName() {
        return positionName;
    }


}