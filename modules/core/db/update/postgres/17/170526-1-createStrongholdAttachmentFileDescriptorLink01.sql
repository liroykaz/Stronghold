create table STRONGHOLD_ATTACHMENT_FILE_DESCRIPTOR_LINK (
    ATTACHMENT_ID uuid,
    FILE_DESCRIPTOR_ID uuid,
    primary key (ATTACHMENT_ID, FILE_DESCRIPTOR_ID)
);
