create table if not exists entities_attributes
(
    id           int auto_increment primary key,
    count        int not null,
    entities_id  int not null references entities (id),
    attribute_id int not null references attributes (id)
);