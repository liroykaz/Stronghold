package com.haulmont.stronghold.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NamePattern("%s %s|startDate,allDuration")
@Table(name = "STRONGHOLD_COURSE")
@Entity(name = "stronghold$Course")
public class Course extends StandardEntity {
    private static final long serialVersionUID = 2782157117458101464L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_DATE")
    protected Date startDate;

    @Column(name = "ALL_DURATION")
    protected String allDuration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBJECT_ID")
    protected Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENTS_ID")
    protected Student students;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }


    public Student getStudents() {
        return students;
    }

    public void setStudents(Student students) {
        this.students = students;
    }


    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setAllDuration(String allDuration) {
        this.allDuration = allDuration;
    }

    public String getAllDuration() {
        return allDuration;
    }


}