drop database if exists braylon;

create database braylon;

use braylon;

create table `User` (
	userId int primary key auto_increment,
    username varchar(50) not null,
    email varchar(50) not null,
    password varchar(1000) not null,
    enabled boolean not null,
    firstName varchar(50) not null,
    lastName varchar(50) not null
);

create table Customer (
	customerId int primary key auto_increment,
    customerFirstName varchar(50) not null,
    customerLastName varchar(50) not null,
    address varchar(50) not null,
    phone varchar(50) not null,
    companyName varchar(50) not null,
    email varchar(50) not null,
    userId int not null,
    foreign key (userId) references `User`(userId)
);

create table `Order` (
	orderId int primary key auto_increment,
    customerId int not null,
    orderDate date not null,
    fulfillmentDate date,
    status varchar(50) not null,
    price decimal not null,
    userId int not null,
    foreign key (userId) references User(userId),
    foreign key (customerId) references Customer(customerId)
);
create table `Role`(
	roleId int primary key auto_increment,
	role varchar(50) not null
);

#bridge table 
create table `userRole`(
	userId int not null,
	roleId int not null,
	primary key(userId,roleId),
	foreign key (userId) references User(userId),
	foreign key (roleId) references Role(roleId)
);

create table `Product` (
	productId int primary key auto_increment,
    productName varchar(50) not null,
    inventory int not null,
    price decimal not null
);

create table orderProduct(
	orderId int not null,
    productId int not null,
    foreign key (orderId) references `Order`(orderId),
    foreign key (productId) references Product(productId)
);

create table SalesVisit (
	salesvisitId int primary key auto_increment,
    visitDate date not null,
    customerId int not null,
    userId int not null,
    location varchar(50) not null,
    notes varchar(450) not null,
    foreign key (userId) references User(userId),
    foreign key (customerId) references Customer(customerId)
);


-- select * from Customer;
-- select * from User;
-- Select * from User u where username like "Beth";
-- select * from SalesVisit;
-- SELECT c.*, s.userId FROM User u JOIN SalesVisit s ON s.customerId = u.userId JOIN Customer c ON s.customerID = c.customerID WHERE u.userId = 1;