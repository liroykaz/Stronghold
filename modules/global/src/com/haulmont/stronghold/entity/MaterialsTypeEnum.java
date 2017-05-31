package com.haulmont.stronghold.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum MaterialsTypeEnum implements EnumClass<Integer> {

    lecture(1),
    practice(2),
    materialForIssue(3),
    presentation(4),
    taskForIndependentWork(5);

    private Integer id;

    MaterialsTypeEnum(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static MaterialsTypeEnum fromId(Integer id) {
        for (MaterialsTypeEnum at : MaterialsTypeEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}