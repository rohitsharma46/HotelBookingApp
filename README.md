# HotelBookingApp
This project is a Dynamic Web Project and intended to make a similar app as Hotel Booking.

In Version 1.0 , it enable the customer to Create the profile as well as let them reset the password.
If User name is not available , customer profile wouldn't be created and customer will be redirected the Index Page.
Once a customer Login , a session will be created which is destroyed if customer chose to Logout.




JRE - 1.8,
Server- Tomcat 9.0,
MySQL Connector - mysql-connector-java-8.0.19.jar


DB Details:-

create database userData;
use userData;
CREATE TABLE users (
    Personid int NOT NULL AUTO_INCREMENT,fname varchar(255) NOT NULL,lname varchar(255),pwd varchar(255), Age int,PRIMARY KEY (Personid)
    );

insert into users (fname,lname,pwd,Age) values("test","testL","test",25);
select * from users;
