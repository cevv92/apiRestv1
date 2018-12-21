CREATE TABLE Country
(
   id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
   version bigint not null default 0,
   countryName varchar(100) NOT NULL,
   population int NOT NULL
)
;