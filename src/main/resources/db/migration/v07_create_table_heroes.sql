create table if not exists heroes
(
    id          int auto_increment primary key,
    name        tinytext not null,
    description text,
    faction_id  int      not null references factions (id)
);
