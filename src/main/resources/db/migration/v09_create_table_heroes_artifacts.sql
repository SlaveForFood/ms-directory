create table if not exists heroes_artifacts
(
    id           int auto_increment primary key,
    count        int not null,
    heroes_id    int not null references heroes (id),
    artefacts_id int not null references artifacts (id)
);
