create table STRONGHOLD_COURSE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    START_DATE timestamp,
    ALL_DURATION varchar(255),
    SUBJECT_ID uuid,
    STUDENTS_ID uuid,
    --
    primary key (ID)
);
