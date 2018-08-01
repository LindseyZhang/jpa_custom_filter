create table todos (

  id bigint(20) primary key,

  text varchar(100) not null,

  completed boolean default false

) charset utf8;
