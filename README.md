# smartbrain
Campus Assignment 😂

## Basic usage

**Create Table**
create table if not exists participants (
	id serial primary key,
	name varchar(100) not null default '',
	age int not null default 0,
	address varchar(255) null default null,
	created_at timestamp not null default current_timestamp,
	updated_at timestamp not null default current_timestamp,
	deleted_at timestamp null default null
);
create table if not exists instructors (
	id serial primary key,
	name varchar(100) not null default '',
	age int not null default 0,
	created_at timestamp not null default current_timestamp,
	updated_at timestamp not null default current_timestamp,
	deleted_at timestamp null default null
);
create table if not exists courses (
	id serial primary key,
	name varchar(100) not null default '',
	created_at timestamp not null default current_timestamp,
	updated_at timestamp not null default current_timestamp,
	deleted_at timestamp null default null
);
create table if not exists report_cards (
	id serial primary key,
	instructor_id integer null,
	participant_id integer null,
	course_id integer null,
	school_year varchar(100) null default '1997',
	score integer not null default 0,
	created_at timestamp not null default current_timestamp,
	updated_at timestamp not null default current_timestamp,
	deleted_at timestamp null default null
);

insert into participants (name, age, address) values ('Harun Nur Rasyid', 24, 'Jl. Rawa Bebek RT 004/008 No 20');
insert into instructors (name, age) values ('Dadang', 35, 'Jl. Durian dalam RT 006/001 No 50');
insert into courses (name) values ('Matematika'), ('Bahasa Indonesia');
insert into report_cards (instructor_id, participant_id, course_id, school_year, score) values (1, 1, 1, '2021', 100), (1, 1, 2, '2021', 90);
```
