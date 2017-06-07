update STRONGHOLD_SUBJECT set NAME = '' where NAME is null ;
alter table STRONGHOLD_SUBJECT alter column NAME set not null ;
