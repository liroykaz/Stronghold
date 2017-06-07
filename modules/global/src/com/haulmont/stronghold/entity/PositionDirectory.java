package com.haulmont.stronghold.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.validation.constraints.NotNull;

@NamePattern("%s|positionName")
@Table(name = "STRONGHOLD_POSITION_DIRECTORY")
@Entity(name = "stronghold$PositionDirectory")
public class PositionDirectory extends StandardEntity {
    private static final long serialVersionUID = -4558026019975136095L;

    @NotNull
    @Column(name = "POSITION_NAME", nullable = false)
    protected String positionName;

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionName() {
        return positionName;
    }


}