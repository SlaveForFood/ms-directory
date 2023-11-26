create table if not exists base_skills_factions
(
    id            int auto_increment primary key,
    count         int not null,
    base_skill_id int not null references base_skills (id),
    faction_id    int not null references factions (id)
);
