alter table STRONGHOLD_MATERIAL add constraint FK_STRONGHOLD_MATERIAL_ATTACHMENT foreign key (ATTACHMENT_ID) references STRONGHOLD_ATTACHMENT(ID);
create index IDX_STRONGHOLD_MATERIAL_ATTACHMENT on STRONGHOLD_MATERIAL (ATTACHMENT_ID);
