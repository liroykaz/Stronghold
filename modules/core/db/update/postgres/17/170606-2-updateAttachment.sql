update STRONGHOLD_ATTACHMENT set COMMENTS = '' where COMMENTS is null ;
alter table STRONGHOLD_ATTACHMENT alter column COMMENTS set not null ;
