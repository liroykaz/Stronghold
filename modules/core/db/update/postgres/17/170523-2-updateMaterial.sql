alter table STRONGHOLD_MATERIAL add column ATTACHMENT_ID uuid ;
alter table STRONGHOLD_MATERIAL drop column ATTACHMENT cascade ;
