alter table DISKEXCHANGE_DISK add constraint FK_DISKEXCHANGE_DISK_ON_OWNER foreign key (OWNER_ID) references SEC_USER(ID);
create index IDX_DISKEXCHANGE_DISK_ON_OWNER on DISKEXCHANGE_DISK (OWNER_ID);
