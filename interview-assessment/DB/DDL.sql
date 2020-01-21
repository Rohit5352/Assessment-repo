drop table if exists product_detail
drop table if exists role_detail
drop table if exists store_detail
drop table if exists store_user_details
drop table if exists user_detail
create table product_detail (id bigint not null auto_increment, category varchar(255), created_date datetime not null, modified_date datetime not null, name varchar(255), store_id bigint, primary key (id)) engine=MyISAM
create table role_detail (id bigint not null auto_increment, created_date datetime not null, modified_date datetime not null, name varchar(255), primary key (id)) engine=MyISAM
create table store_detail (id bigint not null auto_increment, created_date datetime not null, location varchar(255), modified_date datetime not null, name varchar(255), primary key (id)) engine=MyISAM
create table store_user_details (stores_id bigint not null, users_id bigint not null, primary key (stores_id, users_id)) engine=MyISAM
create table user_detail (id bigint not null auto_increment, created_date datetime not null, modified_date datetime not null, name varchar(255), password varchar(255), role_id bigint, primary key (id)) engine=MyISAM
alter table product_detail add constraint FKpwth07qyd1ohyjm3ia60w1bhb foreign key (store_id) references store_detail (id)
alter table store_user_details add constraint FKj66dp5w2yq24pwt6w424bx47i foreign key (users_id) references user_detail (id)
alter table store_user_details add constraint FKnsuia1ur77rdbj81qxl313rmh foreign key (stores_id) references store_detail (id)
alter table user_detail add constraint FK2m9kvfxmc424j5qvq3g2h5y81 foreign key (role_id) references role_detail (id)
