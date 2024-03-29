create table if not exists artifacts
(
    id          int auto_increment primary key,
    name        tinytext not null,
    description text     not null,
    cost        int      not null,
    sale        bool     not null,
    type_id     int      not null references artifact_type (id),
    class_id    int      not null references artifact_class (id)
);
