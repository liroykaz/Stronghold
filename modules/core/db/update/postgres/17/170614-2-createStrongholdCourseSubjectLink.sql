alter table STRONGHOLD_COURSE_SUBJECT_LINK add constraint FK_SCSL_COURSE foreign key (COURSE_ID) references STRONGHOLD_COURSE(ID);
alter table STRONGHOLD_COURSE_SUBJECT_LINK add constraint FK_SCSL_SUBJECT foreign key (SUBJECT_ID) references STRONGHOLD_SUBJECT(ID);
