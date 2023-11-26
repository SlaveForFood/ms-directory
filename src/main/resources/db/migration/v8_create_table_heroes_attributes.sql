create table if not exists heroes_attributes
(
    id           int auto_increment primary key,
    count        int not null,
    heroes_id    int not null references heroes (id),
    attribute_id int not null references attributes (id)
);
