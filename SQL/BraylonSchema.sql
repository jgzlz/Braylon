drop database if exists braylon;

create database braylon;

use braylon;

create table `user` (
	user_id int primary key auto_increment,
    username varchar(50) not null,
    email varchar(50) not null,
    password varchar(1000) not null,
    enabled boolean not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null
);

create table customer (
	customer_id int primary key auto_increment,
    customer_first_name varchar(50) not null,
    customer_last_name varchar(50) not null,
    address varchar(50) not null,
    phone varchar(50) not null,
    company_name varchar(50) not null,
    email varchar(50) not null,
    user_id int not null,
    foreign key (user_id) references `user`(user_id)
);

create table `order` (
	order_id int primary key auto_increment,
    customer_id int not null,
    order_date date not null,
    fulfillment_date date,
    status varchar(50) not null,
    price decimal not null,
    user_id int not null,
    foreign key (user_id) references User(user_id),
    foreign key (customer_id) references Customer(customer_id)
);
create table `role`(
	role_id int primary key auto_increment,
	role varchar(50) not null
);

#bridge table 
create table `user_role`(
	user_id int not null,
	role_id int not null,
	primary key(user_id,role_id),
	foreign key (user_id) references User(user_id),
	foreign key (role_id) references Role(role_id)
);

create table `product` (
	product_id int primary key auto_increment,
    product_name varchar(50) not null,
    inventory int not null,
    price decimal not null
);

create table order_product(
	order_id int not null,
    product_id int not null,
    foreign key (order_id) references `order`(order_id),
    foreign key (product_id) references product(product_id)
);

create table sales_visit (
	salesvisit_id int primary key auto_increment,
    visit_date date not null,
    customer_id int not null,
    user_id int not null,
    location varchar(50) not null,
    notes varchar(450) not null,
    foreign key (user_id) references User(user_id),
    foreign key (customer_id) references Customer(customer_id)
);


-- select * from customer;
-- select * from user;
-- Select * from user u where username like "Beth";
-- select * from sales_visit;
-- SELECT c.*, s.user_id FROM user u JOIN sales_visit s ON s.customer_id = u.user_id JOIN customer c ON s.customer_id = c.customer_id WHERE u.user_id = 1;