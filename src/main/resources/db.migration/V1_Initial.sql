create table servers
(
	name varchar(256),
	address varchar(256) not null,
	port integer not null,
	country varchar(256),
	stateprov varchar(256),
	city varchar(256),
	owner varchar(256),
	active boolean default false not null,
	modtime timestamp default CURRENT_TIMESTAMP,
	constraint primary_key
		primary key (address, port)
)
;

