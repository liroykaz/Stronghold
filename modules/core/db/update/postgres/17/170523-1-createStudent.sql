create table STRONGHOLD_STUDENT (
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
    SURNAME varchar(255),
    PATRONYMIC varchar(255),
    EMAIL varchar(255),
    SKYPE varchar(255),
    POSITION_ID uuid,
    PROJECT_ID uuid,
    ORGANIZATION_ID uuid,
    USER_ID uuid,
    --
    primary key (ID)
);
