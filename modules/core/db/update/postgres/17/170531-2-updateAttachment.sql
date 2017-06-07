alter table STRONGHOLD_ATTACHMENT add column COMMENT_ varchar(255) ^
update STRONGHOLD_ATTACHMENT set COMMENT_ = '' where COMMENT_ is null ;
alter table STRONGHOLD_ATTACHMENT alter column COMMENT_ set not null ;
