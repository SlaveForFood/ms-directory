create table if not exists base_skills
(
    id                   int auto_increment primary key,
    name                 tinytext not null,
    description          text,
    parent_base_skill_id int references base_skills
);
