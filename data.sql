create table hibernate_users (
user_id serial primary key,
first_name text not null,
last_name text not null,
user_login varchar unique not null,
user_pass varchar not null,
is_manager boolean);


create table hibernate_reimbursements (
request_ID varchar unique not null,
submitted_by varchar references users(user_login),
submitted_date date not null,
request_amount integer not null,
submission_reason varchar not null,
current_status text references status(status_name)
);

create table status(
id serial primary key,
status_name text unique not null);
insert  into status values (default, 'Pending');
insert  into status values (default, 'Approved');
insert  into status values (default, 'Denied');


insert into hibernate_userspecs values (default,'Adminboi', true ,'Adminson', 'Admin', 'admin');
insert into hibernate_userspecs values (default,'Jonald', false ,'Trumden', 'IndenturedServant123', 'password');

insert  into reimbursements values ('PZ04sDD', 'IndenturedServant123', '12/30/2021', 4000, 'Had to buy glizzies for the whole firm', 'Approved');
insert into reimbursements values ('HS39FC', 'IndenturedServant123', '1/1/2921', 30000, 'Fed the company ducks', 'Approved');
insert into reimbursements values ('HF36SX', 'iamthelaw420', '1/1/2022', 100000, 'Rented venue for annual company party....and they say Im a mean boss come on now', 'Approved');
