-- begin STRONGHOLD_STUDENT
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
    NAME varchar(255) not null,
    SURNAME varchar(255) not null,
    PATRONYMIC varchar(255),
    EMAIL varchar(255),
    SKYPE varchar(255),
    POSITION_ID uuid,
    ORGANIZATION_ID uuid,
    USER_ID uuid,
    --
    primary key (ID)
)^
-- end STRONGHOLD_STUDENT
-- begin STRONGHOLD_SUBJECT
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
    NAME varchar(255) not null,
    AUTHOR_ID uuid,
    TEACHER_ID uuid,
    COURSE_ID uuid,
    --
    primary key (ID)
)^
-- end STRONGHOLD_SUBJECT
-- begin STRONGHOLD_MATERIAL
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
    DURATION integer,
    TYPE_MATERIAL integer,
    --
    primary key (ID)
)^
-- end STRONGHOLD_MATERIAL
-- begin STRONGHOLD_COURSE
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
    START_DATE timestamp not null,
    ALL_DURATION varchar(255) not null,
    SUBJECT_ID uuid,
    END_DATE date,
    --
    primary key (ID)
)^
-- end STRONGHOLD_COURSE
-- begin STRONGHOLD_POSITION_DIRECTORY
create table STRONGHOLD_POSITION_DIRECTORY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    POSITION_NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end STRONGHOLD_POSITION_DIRECTORY
-- begin STRONGHOLD_PROJECT_DIRECTORY
create table STRONGHOLD_PROJECT_DIRECTORY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PROJECT_NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end STRONGHOLD_PROJECT_DIRECTORY
-- begin STRONGHOLD_ORGANIZATION_DIRECTORY
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
    ORG_NAME varchar(255) not null,
    ORG_ADDRESS varchar(255),
    ORG_EMAIL varchar(255),
    --
    primary key (ID)
)^
-- end STRONGHOLD_ORGANIZATION_DIRECTORY
-- begin STRONGHOLD_MATERIALS_MAP
create table STRONGHOLD_MATERIALS_MAP (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    MAP_KEY integer,
    MATERIAL_ID uuid,
    --
    primary key (ID)
)^
-- end STRONGHOLD_MATERIALS_MAP

-- begin STRONGHOLD_STUDENT_PROJECT_DIRECTORY_LINK
create table STRONGHOLD_STUDENT_PROJECT_DIRECTORY_LINK (
    PROJECT_DIRECTORY_ID uuid,
    STUDENT_ID uuid,
    primary key (PROJECT_DIRECTORY_ID, STUDENT_ID)
)^
-- end STRONGHOLD_STUDENT_PROJECT_DIRECTORY_LINK
-- begin STRONGHOLD_ATTACHMENT
create table STRONGHOLD_ATTACHMENT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ATTACHMENT_ID uuid,
    COMMENTS varchar(255) not null,
    --
    primary key (ID)
)^
-- end STRONGHOLD_ATTACHMENT

-- begin STRONGHOLD_MATERIAL_ATTACHMENT_LINK
create table STRONGHOLD_MATERIAL_ATTACHMENT_LINK (
    ATTACHMENT_ID uuid,
    MATERIAL_ID uuid,
    primary key (ATTACHMENT_ID, MATERIAL_ID)
)^
-- end STRONGHOLD_MATERIAL_ATTACHMENT_LINK

-- begin STRONGHOLD_SUBJECT_MATERIALS_MAP_LINK
create table STRONGHOLD_SUBJECT_MATERIALS_MAP_LINK (
    MATERIALS_MAP_ID uuid,
    SUBJECT_ID uuid,
    primary key (MATERIALS_MAP_ID, SUBJECT_ID)
)^
-- end STRONGHOLD_SUBJECT_MATERIALS_MAP_LINK
-- begin STRONGHOLD_COURSE_STUDENT_LINK
create table STRONGHOLD_COURSE_STUDENT_LINK (
    COURSE_ID uuid,
    STUDENT_ID uuid,
    primary key (COURSE_ID, STUDENT_ID)
)^
-- end STRONGHOLD_COURSE_STUDENT_LINK
