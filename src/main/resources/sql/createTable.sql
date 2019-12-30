create table if not exists "PUBLIC"."SEND_LOG"
(
  GUID        VARCHAR(50)  not null
    primary key,
  TASK_ID     VARCHAR(50)  not null,
  SEND_TO     VARCHAR(255) not null,
  DRIVER_ID   VARCHAR(5)   not null,
  MARK        VARCHAR(4000),
  STATUS      INTEGER      not null,
  MESSAGE     CLOB,
  CREATE_TIME DATE,
  UPDATE_TIME DATE
);

