-- begin DISKEXCHANGE_TAKEN_ITEM
create table DISKEXCHANGE_TAKEN_ITEM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DISK_ID varchar(36) not null,
    USER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end DISKEXCHANGE_TAKEN_ITEM
-- begin DISKEXCHANGE_DISK
create table DISKEXCHANGE_DISK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    OWNER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end DISKEXCHANGE_DISK
