create table if not exists factions
(
    id          int auto_increment primary key,
    name        tinytext not null,
    description text
);

