drop table booking;
drop table flights;
drop table traveler;
drop table admin;
drop table airport;

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
	fare number(8,2),
	taxes number(8,2),
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
	constraint booking_booking_id_pk primary key(booking_id),
	constraint booking_login_id_fk foreign key (login_id) references traveler(login_id),
	constraint booking_flight_id_fk foreign key (flight_id) references flights(flight_id)
);

<<<<<<< HEAD
select * from Flights;
=======
select * from Admin;
select * from Traveler;
>>>>>>> fd12166bbe214cb08faa3e675ce36b75bfa83011
