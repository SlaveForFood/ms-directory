create table if not exists entities_skills
(
    id          int auto_increment primary key,
    entities_id int not null references entities (id),
    skills_id   int not null references skills (id)
);
