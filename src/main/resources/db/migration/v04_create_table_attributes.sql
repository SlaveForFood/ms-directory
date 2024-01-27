create table if not exists attributes
(
    id   int auto_increment primary key,
    name tinytext not null,
    is_debuff boolean not null default false
);
