update STRONGHOLD_COURSE set START_DATE = current_timestamp where START_DATE is null ;
alter table STRONGHOLD_COURSE alter column START_DATE set not null ;
update STRONGHOLD_COURSE set ALL_DURATION = '' where ALL_DURATION is null ;
alter table STRONGHOLD_COURSE alter column ALL_DURATION set not null ;
