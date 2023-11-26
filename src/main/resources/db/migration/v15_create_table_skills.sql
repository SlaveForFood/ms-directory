create table if not exists skills
(
    id              int auto_increment primary key,
    name            tinytext not null,
    description     text,
    parent_skill_id int      not null references skills (id),
    base_skill_id   int      not null references base_skills (id)
);
