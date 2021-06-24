alter table DISKEXCHANGE_TAKEN_ITEM add constraint FK_DISKEXCHANGE_TAKEN_ITEM_ON_DISK foreign key (DISK_ID) references DISKEXCHANGE_DISK(ID);
alter table DISKEXCHANGE_TAKEN_ITEM add constraint FK_DISKEXCHANGE_TAKEN_ITEM_ON_USER foreign key (USER_ID) references SEC_USER(ID);
create index IDX_DISKEXCHANGE_TAKEN_ITEM_ON_DISK on DISKEXCHANGE_TAKEN_ITEM (DISK_ID);
create index IDX_DISKEXCHANGE_TAKEN_ITEM_ON_USER on DISKEXCHANGE_TAKEN_ITEM (USER_ID);
