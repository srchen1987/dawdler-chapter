/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/7/29 17:56:43                           */
/*==============================================================*/


drop table if exists t_gold_info;

drop table if exists t_order;

drop table if exists t_product;

drop table if exists t_product_operate_info;

drop table if exists t_user;

/*==============================================================*/
/* Table: t_gold_info                                           */
/*==============================================================*/
create table t_gold_info
(
   gold_info_id         int not null auto_increment comment '金币明细表主键',
   user_id              int comment '用户id',
   global_tx_id         varchar(32) comment '全局事务id',
   branch_tx_id         varchar(32) comment '分支事务id',
   status               varchar(16) comment '事务状态',
   addtime              int comment '添加时间',
   amount               decimal comment '金额',
   primary key (gold_info_id)
);

alter table t_gold_info comment '用户金币明细表';

/*==============================================================*/
/* Table: t_order                                               */
/*==============================================================*/
create table t_order
(
   order_id             int not null auto_increment comment '订单id',
   product_id           int comment '产品id',
   addtime              int comment '添加时间',
   amount               decimal comment '金额',
   primary key (order_id)
);

alter table t_order comment '订单表';

/*==============================================================*/
/* Table: t_product                                             */
/*==============================================================*/
create table t_product
(
   product_id           int not null auto_increment comment '产品id',
   product_name         varchar(32) comment '产品名称',
   stock                int comment '库存数量',
   addtime              int comment '添加时间',
   amount               decimal comment '金额',
   primary key (product_id)
);

alter table t_product comment '产品表,库存也放这里了 为了简单实现效果';

/*==============================================================*/
/* Table: t_product_operate_info                                */
/*==============================================================*/
create table t_product_operate_info
(
   product_operate_id   int not null auto_increment comment '库存操作明细表id',
   global_tx_id         varchar(32) comment '全局事务id',
   branch_tx_id         varchar(32) comment '分支事务id',
   status               varchar(16) comment '事务状态',
   addtime              int comment '添加时间',
   stock                int comment '库存数量',
   primary key (product_operate_id)
);

alter table t_product_operate_info comment '产品库存操作明细表';

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   user_id              int not null auto_increment comment '用户id',
   username             varchar(32) comment '用户名',
   password             varchar(32) comment '密码',
   addtime              int comment '添加时间',
   lastlogin            int comment '最后登录时间',
   gold                 decimal comment '金币余额',
   primary key (user_id)
);

alter table t_user comment '用户表';

alter table t_gold_info add constraint FK_Relationship_1 foreign key (user_id)
      references t_user (user_id) on delete restrict on update restrict;

alter table t_order add constraint FK_Relationship_2 foreign key (product_id)
      references t_product (product_id) on delete restrict on update restrict;

