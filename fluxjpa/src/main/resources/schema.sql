create table IF NOT EXISTS TB_EVENTS(
ID integer not null AUTO_INCREMENT,
EVENT_NAME varchar (200),
EVENT_DESCRIPTION varchar(100),
CREATED_BY varchar(255),
CREATED_DT TIMESTAMP,
MODIFIED_BY varchar(255),
MODIFIED_DT TIMESTAMP,
PRIMARY KEY (ID)
);