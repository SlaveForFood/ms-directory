create table if not exists heroes_skills
(
    id        int auto_increment primary key,
    heroes_id int not null references heroes (id),
    skills_id int not null references skills (id)
);
