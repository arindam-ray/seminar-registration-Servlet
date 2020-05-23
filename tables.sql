// table
create table reg_master(
reg_id		int(5) primary key auto_increment,
name		varchar(100) not null,
mobile		varchar(15) not null,
email		varchar(100) unique,
affiliation	varchar(200),
occupation	varchar(100)
);

