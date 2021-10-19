insert into messages (name, room_id)
values ('message1', 1),
       ('message2', 1),
       ('message3', 2);

insert into rooms(name)
values ('room1'),
       ('room2');

insert into roles(name)
values ('ROLE_ADMIN'),
       ('ROLE_USER');

insert into users(username, password, role_id)
VALUES ('admin',
        '$2a$10$kHUgz24PZRj8IK1ebedLfuSX6ruAi/JBM2lGKX981ItCTgwZE8/Se',
        (select id from roles where name = 'ROLE_ADMIN'));

insert into users(username, password, role_id)
VALUES ('user',
        '$2a$10$kHUgz24PZRj8IK1ebedLfuSX6ruAi/JBM2lGKX981ItCTgwZE8/Se',
        (select id from roles where name = 'ROLE_USER'));