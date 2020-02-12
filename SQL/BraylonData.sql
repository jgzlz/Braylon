use braylon;

insert into SalesRep values
 (1, 'Chon', 'Xiong', '123 Main St','123-123-1234','Genesis10','chon@chon.com'),
 (2, 'Tom', 'Carlson', '10 Tom Lane','234-123-4567','Genesis10','Tom@tom.com');

insert into Customer values (1, 'Beth', 'Raymond', '123 Main St','123-123-1234','Genesis10','beth@beth.com', 1),
(2, 'Joe', 'Gonzalez', '10 Joe Lane','234-123-1245','Joe Gonzalez','Joe@joe.joe', 2);

insert into User values 
(1,'Mayzer','mayzer@mayzer.com','$2a$10$IuKgHhWowwrQt9i5IgxB6uU.3Mr5l32DiRCbddTfP1vptAnW5BwWe',1,'Mayzer','Muhammed'),
(2,'Jake','jake@jake.com','$2a$10$IuKgHhWowwrQt9i5IgxB6uU.3Mr5l32DiRCbddTfP1vptAnW5BwWe',1,'Jake','White'),
(3,'Marcus','marcus@marcus.com','$2a$10$IuKgHhWowwrQt9i5IgxB6uU.3Mr5l32DiRCbddTfP1vptAnW5BwWe',1,'Marcus','Elliott');

insert into `Order` values 
(1,1,'2020-02-12','2020-03-12','pending','20123.12','1'),
(2,2,'2020-02-12','2020-03-12','pending','1234.12','2'),
(3,1,'2020-02-12','2020-03-12','pending','5342.12','2'),
(4,2,'2020-02-12','2020-03-12','pending','2123.12','3');


insert into `Role` values 
(1,'Admin'), (2,'SalesRep'), (3,'Executive');

insert into `Product` values 
(1,'Screen',23,1234.12),
(2,'Camera',53,4534.12),
(3,'Light',233,123.12);

insert into orderProduct values 
(1,1),(1,2),(1,3),(2,1),(2,3),(3,1),(4,1),(4,2);

insert into SalesVisit values 
(1,'2020-02-12',2,1,'Home','ahhh'),
(2,'2020-02-14',1,2,'Company','ahhh'),
(3,'2020-02-16',2,3,'Home','ahhh'),
(4,'2020-02-17',1,2,'Home','ahhh'),
(5,'2020-02-18',2,1,'AHOIASFH','ahhh');-- select * from Customer;
