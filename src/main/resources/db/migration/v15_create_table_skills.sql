create table if not exists skills
(
    id              int auto_increment primary key,
    name            tinytext not null,
    description     text,
    parent_skill_id int references skills (id),
    base_skill_id   int references base_skills (id)
);
