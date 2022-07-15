drop table if exists trans;

create table if not exists Transaction(
  ID INT not null AUTO_INCREMENT,
  Transaction_date date not null,
  Vendor varchar(50) not null,
  Type varchar(50) not null,
  Amount DECIMAL(6,2) not null,
  Category varchar(50)
);