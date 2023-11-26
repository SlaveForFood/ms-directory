create table if not exists entities
(
    id      int auto_increment primary key,
    name    tinytext not null,
    cost    int      not null,
    tier_id int      not null references tier (id)
);
