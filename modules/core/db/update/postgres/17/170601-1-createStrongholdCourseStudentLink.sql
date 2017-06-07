create table STRONGHOLD_COURSE_STUDENT_LINK (
    COURSE_ID uuid,
    STUDENT_ID uuid,
    primary key (COURSE_ID, STUDENT_ID)
);
