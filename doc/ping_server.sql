/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/3/27 星期一 10:41:39                       */
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
   running_state        boolean comment '1:运行，0:未运行',
   launch_time          datetime,
   cost                 bigint comment '单位:ms',
   recover_time         datetime,
   disconnect_time      datetime,
   type                 int comment 'pc，路由。。。可在系统中增加类型，不同类型不同ico/图片',
   yn                   int comment '1:可用；0:停用',
   icon                 varchar(50),
   disconnect_times     int comment '在位置节点设置，下面所有设备生效',
   is_location          int comment '1:位置，0:设备',
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
   mobilephone          varchar(100) comment '多个以逗号分隔',
   telephone            varchar(20) comment '多个以逗号分隔',
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
   job_status           int comment '是否启动任务',
   cron_expression      varchar(40),
   repeat_interval      int,
   start_delay          int,
   description          varchar(200),
   bean_class           varchar(100) comment '任务执行时调用哪个类的方法 包名+类名',
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

alter table system_config comment '配置系统变量,
系统配置一般是随系统启动时加载一次，修改后需要重启系统。当然部分属性可以按客户需求动态调整。';

alter table data_dictionary_value add constraint FK_Reference_7 foreign key (dd_id)
      references data_dictionary (id) on delete restrict on update restrict;

alter table device_2_scheduel_job add constraint FK_Reference_5 foreign key (device_id)
      references device (id) on delete restrict on update restrict;

alter table device_2_scheduel_job add constraint FK_Reference_6 foreign key (scheduel_job_id)
      references schedule_job (id) on delete restrict on update restrict;

alter table group_2_person add constraint FK_Reference_10 foreign key (person_id)
      references person (id) on delete restrict on update restrict;

alter table group_2_person add constraint FK_Reference_11 foreign key (group_id)
      references groups (id) on delete restrict on update restrict;

alter table groups_2_permission add constraint FK_Reference_8 foreign key (groups_id)
      references groups (id) on delete restrict on update restrict;

alter table groups_2_permission add constraint FK_Reference_9 foreign key (permission_id)
      references permission (id) on delete restrict on update restrict;

alter table location_2_user add constraint FK_Reference_12 foreign key (location_id)
      references device (id) on delete restrict on update restrict;

alter table location_2_user add constraint FK_Reference_4 foreign key (user_id)
      references person (id) on delete restrict on update restrict;

alter table ping_server_2_device add constraint FK_Reference_1 foreign key (device_id)
      references device (id) on delete restrict on update restrict;

alter table ping_server_2_device add constraint FK_Reference_2 foreign key (ping_server_id)
      references ping_server (id) on delete restrict on update restrict;

