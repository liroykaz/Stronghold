create table STRONGHOLD_ORGANIZATION_DIRECTORY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORG_NAME varchar(255),
    ORG_ADDRESS varchar(255),
    ORG_EMAIL varchar(255),
    --
    primary key (ID)
);
