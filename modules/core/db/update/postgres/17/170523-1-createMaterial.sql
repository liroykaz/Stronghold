create table STRONGHOLD_MATERIAL (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TYPE_MATERIAL integer,
    ATTACHMENT varchar(255),
    DURATION integer,
    --
    primary key (ID)
);
