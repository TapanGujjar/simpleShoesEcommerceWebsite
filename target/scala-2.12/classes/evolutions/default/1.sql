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
  category_category_id          integer,
  occasion_occasion_id          integer,
  productsolheight              varchar(255),
  productsolmaterial            varchar(255),
  manufacturers_company_id      integer,
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

alter table products add constraint fk_products_category_category_id foreign key (category_category_id) references categories (categoryid) on delete restrict on update restrict;
create index ix_products_category_category_id on products (category_category_id);

alter table products add constraint fk_products_occasion_occasion_id foreign key (occasion_occasion_id) references occasion (occasionid) on delete restrict on update restrict;
create index ix_products_occasion_occasion_id on products (occasion_occasion_id);

alter table products add constraint fk_products_manufacturers_company_id foreign key (manufacturers_company_id) references company (companyid) on delete restrict on update restrict;
create index ix_products_manufacturers_company_id on products (manufacturers_company_id);


# --- !Downs

alter table products drop foreign key fk_products_category_category_id;
drop index ix_products_category_category_id on products;

alter table products drop foreign key fk_products_occasion_occasion_id;
drop index ix_products_occasion_occasion_id on products;

alter table products drop foreign key fk_products_manufacturers_company_id;
drop index ix_products_manufacturers_company_id on products;

drop table if exists categories;

drop table if exists company;

drop table if exists occasion;

drop table if exists products;

drop table if exists users;

