update STRONGHOLD_PROJECT_DIRECTORY set PROJECT_NAME = '' where PROJECT_NAME is null ;
alter table STRONGHOLD_PROJECT_DIRECTORY alter column PROJECT_NAME set not null ;
