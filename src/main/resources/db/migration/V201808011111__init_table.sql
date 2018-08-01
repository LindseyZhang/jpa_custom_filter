create table products (
  id bigint(20) primary key,
  name varchar(100) not null,
  price double,
  category varchar(50),
  brand varchar(50),
  description varchar(200),
  production_date date,
  production_place varchar(50)
) charset utf8;