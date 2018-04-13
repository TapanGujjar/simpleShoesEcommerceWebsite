# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table categories (
  categoryid                    integer auto_increment not null,
  categoryname                  varchar(255),
  constraint pk_categories primary key (categoryid)
);

create table company (
  companyid                     integer auto_increment not null,
  companyname                   varchar(255),
  constraint pk_company primary key (companyid)
);

create table occasion (
  occasionid                    integer auto_increment not null,
  occasionname                  varchar(255),
  constraint pk_occasion primary key (occasionid)
);

create table products (
  productid                     integer auto_increment not null,
  productname                   varchar(255),
  productdesc                   varchar(255),
  producttype                   varchar(255),
  productmaterial               varchar(255),
  productsolheight              varchar(255),
  productsolmaterial            varchar(255),
  constraint pk_products primary key (productid)
);

create table users (
  userid                        integer auto_increment not null,
  fname                         varchar(255),
  lname                         varchar(255),
  email                         varchar(255),
  password                      varchar(255),
  accesskey                     varchar(255),
  constraint pk_users primary key (userid)
);


# --- !Downs

drop table if exists categories;

drop table if exists company;

drop table if exists occasion;

drop table if exists products;

drop table if exists users;

