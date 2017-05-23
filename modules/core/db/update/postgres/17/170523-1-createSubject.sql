create table STRONGHOLD_SUBJECT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    AUTHOR_ID uuid,
    TEACHER_ID uuid,
    MATERIALS_MAP_ID uuid,
    COURSE_ID uuid,
    --
    primary key (ID)
);
