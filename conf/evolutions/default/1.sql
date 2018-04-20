# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cart (
  cartid                        integer auto_increment not null,
  userid                        integer,
  productsizeid                 integer,
  value                         integer not null,
  constraint pk_cart primary key (cartid)
);

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

create table productcolor (
  productcolorid                integer auto_increment not null,
  productid                     integer,
  productimageurl               varchar(255),
  price                         integer not null,
  constraint pk_productcolor primary key (productcolorid)
);

create table productcolorjunction (
  productcolorid                integer,
  colorname                     varchar(255)
);

create table productcolorsize (
  productsizeid                 integer auto_increment not null,
  productcolorid                integer,
  size                          integer not null,
  quantity                      integer not null,
  constraint pk_productcolorsize primary key (productsizeid)
);

create table products (
  productid                     integer auto_increment not null,
  productname                   varchar(255),
  productdesc                   varchar(255),
  producttype                   varchar(255),
  productmaterial               varchar(255),
  productcategory               integer,
  productoccasion               integer,
  productsolheight              varchar(255),
  productsolmaterial            varchar(255),
  productmanufacturers          integer,
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

alter table cart add constraint fk_cart_userid foreign key (userid) references users (userid) on delete restrict on update restrict;
create index ix_cart_userid on cart (userid);

alter table cart add constraint fk_cart_productsizeid foreign key (productsizeid) references productcolorsize (productsizeid) on delete restrict on update restrict;
create index ix_cart_productsizeid on cart (productsizeid);

alter table productcolor add constraint fk_productcolor_productid foreign key (productid) references products (productid) on delete restrict on update restrict;
create index ix_productcolor_productid on productcolor (productid);

alter table productcolorjunction add constraint fk_productcolorjunction_productcolorid foreign key (productcolorid) references productcolor (productcolorid) on delete restrict on update restrict;
create index ix_productcolorjunction_productcolorid on productcolorjunction (productcolorid);

alter table productcolorsize add constraint fk_productcolorsize_productcolorid foreign key (productcolorid) references productcolor (productcolorid) on delete restrict on update restrict;
create index ix_productcolorsize_productcolorid on productcolorsize (productcolorid);

alter table products add constraint fk_products_productcategory foreign key (productcategory) references categories (categoryid) on delete restrict on update restrict;
create index ix_products_productcategory on products (productcategory);

alter table products add constraint fk_products_productoccasion foreign key (productoccasion) references occasion (occasionid) on delete restrict on update restrict;
create index ix_products_productoccasion on products (productoccasion);

alter table products add constraint fk_products_productmanufacturers foreign key (productmanufacturers) references company (companyid) on delete restrict on update restrict;
create index ix_products_productmanufacturers on products (productmanufacturers);


# --- !Downs

alter table cart drop foreign key fk_cart_userid;
drop index ix_cart_userid on cart;

alter table cart drop foreign key fk_cart_productsizeid;
drop index ix_cart_productsizeid on cart;

alter table productcolor drop foreign key fk_productcolor_productid;
drop index ix_productcolor_productid on productcolor;

alter table productcolorjunction drop foreign key fk_productcolorjunction_productcolorid;
drop index ix_productcolorjunction_productcolorid on productcolorjunction;

alter table productcolorsize drop foreign key fk_productcolorsize_productcolorid;
drop index ix_productcolorsize_productcolorid on productcolorsize;

alter table products drop foreign key fk_products_productcategory;
drop index ix_products_productcategory on products;

alter table products drop foreign key fk_products_productoccasion;
drop index ix_products_productoccasion on products;

alter table products drop foreign key fk_products_productmanufacturers;
drop index ix_products_productmanufacturers on products;

drop table if exists cart;

drop table if exists categories;

drop table if exists company;

drop table if exists occasion;

drop table if exists productcolor;

drop table if exists productcolorjunction;

drop table if exists productcolorsize;

drop table if exists products;

drop table if exists users;

