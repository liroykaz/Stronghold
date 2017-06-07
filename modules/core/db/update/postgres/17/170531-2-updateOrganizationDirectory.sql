update STRONGHOLD_ORGANIZATION_DIRECTORY set ORG_NAME = '' where ORG_NAME is null ;
alter table STRONGHOLD_ORGANIZATION_DIRECTORY alter column ORG_NAME set not null ;
