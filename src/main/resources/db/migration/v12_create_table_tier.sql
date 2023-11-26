create table if not exists tier
(
    id          int auto_increment primary key,
    name        tinytext not null,
    description text
);
