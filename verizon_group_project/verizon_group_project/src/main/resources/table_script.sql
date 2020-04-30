drop table booking;
drop table flights;
drop table traveler;
drop table admin;
drop table airport;

drop sequence hibernate_sequence;

create sequence hibernate_sequence start with 1 increment by 1;

create table Traveler(
	login_id varchar2(50),
	email varchar2(50),
	name varchar2(50),
	password varchar2(70),
	
	constraint traveler_login_id_pk primary key ( login_id )

);

create table Admin(
	login_id varchar2(50),
	email varchar2(50),
	name varchar2(50),
	password varchar2(70),
	
	constraint admin_login_id_pk primary key ( login_id )
);

create table Airport(
	airport_id varchar2(4),
	constraint airport_airport_id_pk primary key(airport_id)
);

create table Flights(
	flight_id number(8),
	fare number(10,2),
	taxes number(10,2),
	from_airport varchar2(4),
	to_airport varchar2(4),
	constraint flights_flight_id_pk primary key(flight_id),
	constraint flights_from_airport_fk foreign key(from_airport) references airport(airport_id),
	constraint filghts_to_airport_fk foreign key(to_airport) references airport(airport_id)
);

create table Booking(
	booking_id number(8),
	login_id varchar2(15),
	date_of_travel date,
	number_of_travelers number(2),
	flight_id number(8),
	cost number(10,2),
	constraint booking_booking_id_pk primary key(booking_id),
	constraint booking_login_id_fk foreign key (login_id) references traveler(login_id),
	constraint booking_flight_id_fk foreign key (flight_id) references flights(flight_id)
);

select * from Flights;
select * from Admin;
select * from Traveler;

insert into Traveler values ('test', 'test@infy.com', 'Test' , 'test');
insert into Airport values ('TST');
insert into Airport values ('TSF');
insert into Flights values (1, 100.20, 10.20, 'TSF', 'TST');
insert into Booking (booking_id, login_id, date_of_travel, number_of_travelers, flight_id, COST) values (1000, 'test', TO_DATE('2003/07/09', 'yyyy/mm/dd'), 2, 1, 2000.20);

