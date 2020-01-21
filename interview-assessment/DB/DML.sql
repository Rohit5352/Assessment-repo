INSERT INTO `xebia_retailstore`.`role_detail`
(`id`,`created_date`,`modified_date`,`name`)
VALUES
(1, now(), now(), 'Employee'),
(2, now(), now(), 'Customer'),
(3, now(), now(), 'AffiliateUserz');


INSERT INTO `xebia_retailstore`.`user_detail`
(`id`,`created_date`,`modified_date`,`name`,`password`,`role_id`)
VALUES
(1, now(), now(), 'Rohit', '1234', 1),
(2, now(), now(), 'Akash', '1234', 2),
(3, now(), now(), 'Rahul', '1234', 3);

update `user_detail` 
set created_date = '2016-11-14 11:23:45' 
where id = 2;

update `user_detail` 
set created_date = '2016-10-11 11:23:45' 
where id = 3;

INSERT INTO `xebia_retailstore`.`store_detail`
(`id`,`created_date`,`location`,`modified_date`,`name`)
VALUES
(1, now(), 'Pune', now(), 'PUMA');

INSERT INTO `xebia_retailstore`.`product_detail`
(`id`,`category`,`created_date`,`modified_date`,`name`,`store_id`)
VALUES
(1, 'Grocery', now(), now(), 'WheatGrains', 1),
(2, 'Fashion', now(), now(), 'Cosmatics', 1),
(3, 'Sports', now(), now(), 'FootballAccesories', 1);

INSERT INTO `xebia_retailstore`.`store_user_details`
(`stores_id`,`users_id`)
VALUES
(1,1),
(1,2),
(1,3);




