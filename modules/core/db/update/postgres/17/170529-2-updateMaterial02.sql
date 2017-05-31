alter table STRONGHOLD_MATERIAL add column TYPE_MATERIAL integer ;
alter table STRONGHOLD_MATERIAL drop column MATERIAL_TYPE cascade ;
