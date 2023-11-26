create table if not exists artifacts_attributes
(
    id           int auto_increment primary key,
    count        int not null,
    artifact_id  int not null references artifacts (id),
    attribute_id int not null references attributes (id)
);
