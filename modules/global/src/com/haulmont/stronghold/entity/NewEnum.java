package com.haulmont.stronghold.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum NewEnum implements EnumClass<Integer> {

    lecture(1),
    practice(2),
    materialForIssue(3),
    presentation(4),
    taskForIndependentWork(5);

    private Integer id;

    NewEnum(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static NewEnum fromId(Integer id) {
        for (NewEnum at : NewEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}