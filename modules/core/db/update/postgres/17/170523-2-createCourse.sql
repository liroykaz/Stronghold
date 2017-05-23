alter table STRONGHOLD_COURSE add constraint FK_STRONGHOLD_COURSE_SUBJECT foreign key (SUBJECT_ID) references STRONGHOLD_SUBJECT(ID);
alter table STRONGHOLD_COURSE add constraint FK_STRONGHOLD_COURSE_STUDENTS foreign key (STUDENTS_ID) references STRONGHOLD_STUDENT(ID);
create index IDX_STRONGHOLD_COURSE_SUBJECT on STRONGHOLD_COURSE (SUBJECT_ID);
create index IDX_STRONGHOLD_COURSE_STUDENTS on STRONGHOLD_COURSE (STUDENTS_ID);
