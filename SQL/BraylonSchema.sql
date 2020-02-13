drop database if exists braylon;
create database braylon;
use braylon;

<<<<<<< HEAD
create table `User` (
	user_id int primary key auto_increment,
    username varchar(50) not null,
    email varchar(50) not null,
    `password` varchar(1000) not null,
=======
create table `user` (
	user_id int primary key auto_increment,
    username varchar(50) not null,
    email varchar(50) not null,
    password varchar(1000) not null,
>>>>>>> jgzlz-master
    enabled boolean not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null
);
<<<<<<< HEAD
insert into User values (1,'Mayzer','mayzer@mayzer.com','$2a$10$WRYCREJfr26bvGSD4RF37OISaCiyTTmwjeYpklJmEiAU/KAdfFK4u',1,'Mayzer','Muhammed'),(2,'Jake','jake@jake.com','$2a$10$WRYCREJfr26bvGSD4RF37OISaCiyTTmwjeYpklJmEiAU/KAdfFK4u',1,'Jake','White'),
							(3,'Marcus','marcus@marcus.com','$2a$10$WRYCREJfr26bvGSD4RF37OISaCiyTTmwjeYpklJmEiAU/KAdfFK4u',1,'Marcus','Elliot');


create table Customer (
=======

create table customer (
>>>>>>> jgzlz-master
	customer_id int primary key auto_increment,
    customer_first_name varchar(50) not null,
    customer_last_name varchar(50) not null,
    address varchar(50) not null,
    phone varchar(50) not null,
    company_name varchar(50) not null,
    email varchar(50) not null,
<<<<<<< HEAD
    user_id int null,
    foreign key (user_id) references `User`(user_id)
=======
    user_id int not null,
    foreign key (user_id) references `user`(user_id)
>>>>>>> jgzlz-master
);

insert into Customer values (1, 'Beth', 'Raymond', '123 Main St','123-123-1234','Genesis10','beth@beth.com', 1),(2, 'Joe', 'Gonzalez', '10 Joe Lane','234-123-1245','Joe Gonzalez','Joe@joe.joe', 2);
<<<<<<< HEAD
create table `Order` (
=======

insert into `user` values (1,'Mayzer','mayzer@mayzer.com','$2a$10$IuKgHhWowwrQt9i5IgxB6uU.3Mr5l32DiRCbddTfP1vptAnW5BwWe',1,'Mayzer','Muhammed'),(2,'Jake','jake@jake.com','$2a$10$IuKgHhWowwrQt9i5IgxB6uU.3Mr5l32DiRCbddTfP1vptAnW5BwWe',1,'Jake','White'),(3,'Marcus','marcus@marcus.com','$2a$10$IuKgHhWowwrQt9i5IgxB6uU.3Mr5l32DiRCbddTfP1vptAnW5BwWe',1,'Marcus','Elliott');

create table `order` (
>>>>>>> jgzlz-master
	order_id int primary key auto_increment,
    customer_id int not null,
    order_date date not null,
    fulfillment_date date,
    status varchar(50) not null,
    price decimal not null,
    user_id int not null,
<<<<<<< HEAD
    foreign key (user_id) references `User`(user_id),
    foreign key (customer_id) references Customer(customer_id)
);

insert into `Order` values (1,1,'2020-02-12','2020-03-12','pending','20123.12','1'),(2,2,'2020-02-12','2020-03-12','pending','1234.12','2'),(3,1,'2020-02-12','2020-03-12','pending','5342.12','2'),(4,2,'2020-02-12','2020-03-12','pending','2123.12','3');

create table `Role`(
=======
    foreign key (user_id) references User(user_id),
    foreign key (customer_id) references Customer(customer_id)
);
insert into `order` values (1,1,'2020-02-12','2020-03-12','pending','20123.12','1'),(2,2,'2020-02-12','2020-03-12','pending','1234.12','2'),(3,1,'2020-02-12','2020-03-12','pending','5342.12','2'),(4,2,'2020-02-12','2020-03-12','pending','2123.12','3');

create table `role`(
>>>>>>> jgzlz-master
	role_id int primary key auto_increment,
	role varchar(50) not null
);

insert into `role` values (1,'ROLE_ADMIN'),(2,'ROLE_USER');
#bridge table 
create table user_role(
	user_id int not null,
	role_id int not null,
	primary key(user_id,role_id),
	foreign key (user_id) references User(user_id),
	foreign key (role_id) references Role(role_id)
);

insert into user_role values (1,1),(1,2),(2,1);
<<<<<<< HEAD

create table `Product` (
=======
    
create table `product` (
>>>>>>> jgzlz-master
	product_id int primary key auto_increment,
    product_name varchar(50) not null,
    inventory int not null,
    price decimal not null
);
<<<<<<< HEAD
insert into `Product` values (1,'Screen',23,1234.12),(2,'Camera',53,4534.12),(3,'Light',233,123.12);
create table order_product(
	order_id int not null,
    product_id int not null,
    foreign key (order_id) references `Order`(order_id),
    foreign key (product_id) references Product(product_id)
);
insert into order_product values (1,1),(1,2),(1,3),(2,1),(2,3),(3,1),(4,1),(4,2);
=======

insert into `product` values (1,'Screen',23,1234.12),(2,'Camera',53,4534.12),(3,'Light',233,123.12);

create table order_product(
	order_id int not null,
    product_id int not null,
    foreign key (order_id) references `order`(order_id),
    foreign key (product_id) references product(product_id)
);

>>>>>>> jgzlz-master
create table sales_visit (
	sales_visit_id int primary key auto_increment,
    visit_date date not null,
    customer_id int not null,
    user_id int not null,
    location varchar(50) not null,
    notes varchar(450) not null,
<<<<<<< HEAD
    foreign key (user_id) references User(user_id),
    foreign key (customer_id) references Customer(customer_id)
);

insert into sales_visit values (1,'2020-02-12',2,1,'Home','ahhh'),(2,'2020-02-14',1,2,'Company','ahhh'),(3,'2020-02-16',2,3,'Home','ahhh'),(4,'2020-02-17',1,2,'Home','ahhh'),(5,'2020-02-18',2,1,'AHOIASFH','ahhh');

-- select * from Customer;
-- select * from User;
-- Select * from User u where username like "Beth";
-- select * from SalesVisit;
-- SELECT c.*, s.userId FROM User u JOIN SalesVisit s ON s.customerId = u.userId JOIN Customer c ON s.customerID = c.customerID WHERE u.userId = 1;
-- SELECT * FROM user_role;

=======
    foreign key (user_id) references `user`(user_id),
    foreign key (customer_id) references Customer(customer_id)
);
insert into order_product values (1,1),(1,2),(1,3),(2,1),(2,3),(3,1),(4,1),(4,2);

-- select * from customer;
-- select * from user;
-- Select * from user u where username like "Beth";
-- select * from sales_visit;
-- SELECT c.*, s.user_id FROM user u JOIN sales_visit s ON s.customer_id = u.user_id JOIN customer c ON s.customer_id = c.customer_id WHERE u.user_id = 1;
>>>>>>> jgzlz-master
