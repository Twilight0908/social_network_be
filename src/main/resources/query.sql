create database if not exists social_network;

use social_network;

insert into role(name)
values ('ROLE_ADMIN'),
       ('ROLE_USER');

insert into account(avatar, ban, birthday, created_at, email, first_name, gender, last_name, online, password, phone,
                    thumbnail, username, role_id)
values ('', false, now(), now(), '', 'admin', true, 'admin', false, 'admin', '', '', 'admin', 1),
       ('', false, now(), now(), '', 'user', false, 'user', false, 'user', '', '', 'user', 2);