alter table STRONGHOLD_SUBJECT_MATERIALS_MAP_LINK add constraint FK_SSMML_MATERIALS_MAP foreign key (MATERIALS_MAP_ID) references STRONGHOLD_MATERIALS_MAP(ID);
alter table STRONGHOLD_SUBJECT_MATERIALS_MAP_LINK add constraint FK_SSMML_SUBJECT foreign key (SUBJECT_ID) references STRONGHOLD_SUBJECT(ID);
