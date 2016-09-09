-- liquibase formatted sql
-- changeset scriptq context:default
create table test (
    id varchar(36) not null,
    street varchar(250),
    post varchar(10),
    coordinate varchar(10),
    office_street varchar(250),
    office_post varchar(10),
    office_coordinate varchar(10),
    primary key (id)
);

insert into test values('8ea1af81-767e-11e6-9ba7-44a842ecf33c',
                        'this is my street',
                        '12333',
                        'c',
                        'Opps, I love this place :)',
                        '12222',
                        'office c');
