update STRONGHOLD_STUDENT set NAME = '' where NAME is null ;
alter table STRONGHOLD_STUDENT alter column NAME set not null ;
update STRONGHOLD_STUDENT set SURNAME = '' where SURNAME is null ;
alter table STRONGHOLD_STUDENT alter column SURNAME set not null ;
