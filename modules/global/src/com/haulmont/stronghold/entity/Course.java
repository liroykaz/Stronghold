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
import java.util.List;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;
import javax.validation.constraints.NotNull;
import javax.persistence.OneToMany;
import java.util.Collection;

@NamePattern("%s %s %s|startDate,allDuration,endDate")
@Table(name = "STRONGHOLD_COURSE")
@Entity(name = "stronghold$Course")
public class Course extends StandardEntity {
    private static final long serialVersionUID = 2782157117458101464L;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_DATE", nullable = false)
    protected Date startDate;

    @NotNull
    @Column(name = "ALL_DURATION", nullable = false)
    protected String allDuration;

    @JoinTable(name = "STRONGHOLD_COURSE_SUBJECT_LINK",
        joinColumns = @JoinColumn(name = "COURSE_ID"),
        inverseJoinColumns = @JoinColumn(name = "SUBJECT_ID"))
    @ManyToMany
    protected List<Subject> subject;

    @JoinTable(name = "STRONGHOLD_COURSE_STUDENT_LINK",
        joinColumns = @JoinColumn(name = "COURSE_ID"),
        inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
    @ManyToMany
    protected List<Student> students;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    protected Date endDate;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public List<Subject> getSubject() {
        return subject;
    }

    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }








    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
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