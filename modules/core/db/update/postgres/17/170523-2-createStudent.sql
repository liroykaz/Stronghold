alter table STRONGHOLD_STUDENT add constraint FK_STRONGHOLD_STUDENT_POSITION foreign key (POSITION_ID) references STRONGHOLD_POSITION_DIRECTORY(ID);
alter table STRONGHOLD_STUDENT add constraint FK_STRONGHOLD_STUDENT_PROJECT foreign key (PROJECT_ID) references STRONGHOLD_PROJECT_DIRECTORY(ID);
alter table STRONGHOLD_STUDENT add constraint FK_STRONGHOLD_STUDENT_ORGANIZATION foreign key (ORGANIZATION_ID) references STRONGHOLD_ORGANIZATION_DIRECTORY(ID);
alter table STRONGHOLD_STUDENT add constraint FK_STRONGHOLD_STUDENT_USER foreign key (USER_ID) references SEC_USER(ID);
create unique index IDX_STRONGHOLD_STUDENT_UK_USER_ID on STRONGHOLD_STUDENT (USER_ID) where DELETE_TS is null ;
create index IDX_STRONGHOLD_STUDENT_POSITION on STRONGHOLD_STUDENT (POSITION_ID);
create index IDX_STRONGHOLD_STUDENT_PROJECT on STRONGHOLD_STUDENT (PROJECT_ID);
create index IDX_STRONGHOLD_STUDENT_ORGANIZATION on STRONGHOLD_STUDENT (ORGANIZATION_ID);
create index IDX_STRONGHOLD_STUDENT_USER on STRONGHOLD_STUDENT (USER_ID);