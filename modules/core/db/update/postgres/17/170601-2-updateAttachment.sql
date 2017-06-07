alter table STRONGHOLD_ATTACHMENT add column COMMENTS varchar(255) ;
alter table STRONGHOLD_ATTACHMENT drop column COMMENT_ cascade ;
