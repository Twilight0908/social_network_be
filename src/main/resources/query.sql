create database if not exists social_network;

use social_network;

insert into role(name)
values ('ROLE_ADMIN'),
       ('ROLE_USER');

insert into account(avatar, created_at, email, first_name, gender, last_name, password, thumbnail, username, role_id)
values ('', now(), '', 'admin', true, 'admin', 'admin', '', 'admin', 1),
       ('', now(), '', 'user', false, 'user', 'user', '', 'user', 2);