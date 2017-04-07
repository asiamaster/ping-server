/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/3/27 ����һ 10:41:39                       */
/*==============================================================*/


drop table if exists data_dictionary;

drop table if exists data_dictionary_value;

drop table if exists device;

drop table if exists device_2_scheduel_job;

drop table if exists group_2_person;

drop table if exists groups;

drop table if exists groups_2_permission;

drop table if exists location_2_user;

drop table if exists permission;

drop table if exists person;

drop table if exists ping_server;

drop table if exists ping_server_2_device;

drop table if exists schedule_job;

drop table if exists system_config;

/*==============================================================*/
/* Table: data_dictionary                                       */
/*==============================================================*/
create table data_dictionary
(
   id                   bigint not null auto_increment,
   code                 varchar(50),
   name                 varchar(50),
   remark               varchar(1000),
   created              datetime,
   modified             datetime,
   yn                   int,
   primary key (id)
);

/*==============================================================*/
/* Table: data_dictionary_value                                 */
/*==============================================================*/
create table data_dictionary_value
(
   id                   bigint not null auto_increment,
   dd_id                bigint,
   sort                 int,
   code                 varchar(255),
   value                varchar(30),
   remark               varchar(1000),
   period_begin         datetime,
   period_end           datetime,
   created              datetime,
   modified             datetime,
   yn                   int,
   primary key (id)
);

/*==============================================================*/
/* Table: device                                                */
/*==============================================================*/
create table device
(
   id                   bigint not null auto_increment,
   parent_id            bigint,
   name                 varchar(20),
   host                 varchar(15),
   port                 int,
   running_state        boolean comment '1:���У�0:δ����',
   launch_time          datetime,
   cost                 bigint comment '��λ:ms',
   recover_time         datetime,
   disconnect_time      datetime,
   type                 int comment 'pc��·�ɡ���������ϵͳ���������ͣ���ͬ���Ͳ�ͬico/ͼƬ',
   yn                   int comment '1:���ã�0:ͣ��',
   icon                 varchar(50),
   disconnect_times     int comment '��λ�ýڵ����ã����������豸��Ч',
   is_location          int comment '1:λ�ã�0:�豸',
   mask_code          varchar(15),
   primary key (id)
);

/*==============================================================*/
/* Table: device_2_scheduel_job                                 */
/*==============================================================*/
create table device_2_scheduel_job
(
   id                   bigint not null auto_increment,
   device_id            bigint,
   scheduel_job_id      bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: group_2_person                                        */
/*==============================================================*/
create table group_2_person
(
   id                   bigint not null auto_increment,
   group_id             bigint,
   person_id            bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: groups                                                */
/*==============================================================*/
create table groups
(
   id                   bigint not null auto_increment,
   name                 varchar(20),
   created              datetime,
   modified             datetime,
   yn                   int,
   primary key (id)
);

/*==============================================================*/
/* Table: groups_2_permission                                   */
/*==============================================================*/
create table groups_2_permission
(
   id                   bigint not null auto_increment,
   groups_id            bigint,
   permission_id        bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: location_2_user                                       */
/*==============================================================*/
create table location_2_user
(
   id                   bigint not null,
   user_id              bigint,
   location_id          char(10),
   primary key (id)
);

/*==============================================================*/
/* Table: permission                                            */
/*==============================================================*/
create table permission
(
   id                   bigint not null auto_increment,
   name                 varchar(20),
   code                 varchar(20),
   created              datetime,
   modified             datetime,
   yn                   int,
   primary key (id)
);

/*==============================================================*/
/* Table: person                                                */
/*==============================================================*/
create table person
(
   id                   bigint not null auto_increment,
   name                 varchar(20),
   mobilephone          varchar(100) comment '����Զ��ŷָ�',
   telephone            varchar(20) comment '����Զ��ŷָ�',
   primary key (id)
);

/*==============================================================*/
/* Table: ping_server                                           */
/*==============================================================*/
create table ping_server
(
   id                   bigint not null auto_increment,
   name                 varchar(20),
   host                 varchar(15),
   port                 int,
   created              datetime,
   modified             datetime,
   yn                   int,
   primary key (id)
);

/*==============================================================*/
/* Table: ping_server_2_device                                  */
/*==============================================================*/
create table ping_server_2_device
(
   id                   bigint not null auto_increment,
   ping_server_id       bigint,
   device_id            bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: schedule_job                                          */
/*==============================================================*/
create table schedule_job
(
   id                   bigint not null auto_increment,
   createTime           datetime,
   updateTime           datetime,
   job_name             varchar(40),
   job_group            varchar(40),
   job_status           int comment '�Ƿ���������',
   cron_expression      varchar(40),
   repeat_interval      int,
   start_delay          int,
   description          varchar(200),
   bean_class           varchar(100) comment '����ִ��ʱ�����ĸ���ķ��� ����+����',
   is_concurrent        int,
   spring_id            varchar(40),
   method_name          varchar(40),
   primary key (id)
);

/*==============================================================*/
/* Table: system_config                                         */
/*==============================================================*/
create table system_config
(
   id                   bigint not null auto_increment,
   name                 varchar(255),
   code                 varchar(255),
   value                varchar(255),
   `desc`               varchar(255),
   created              datetime,
   modified             datetime,
   yn                   int,
   primary key (id)
);
