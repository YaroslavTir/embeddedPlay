-- liquibase formatted sql
-- changeset scriptq context:default
create table country (
    id varchar(36) not null,
    iso varchar(10),
    primary key (id)
);
create table person (
    id varchar(36) not null,
    street varchar(250),
    post varchar(10),
    coordinate varchar(10),
    country_id varchar(36) null,
    office_street varchar(250),
    office_post varchar(10),
    office_coordinate varchar(10),
    office_country_id varchar(36) null,
    primary key (id),
    CONSTRAINT fk_country FOREIGN KEY (country_id) REFERENCES country (id),
    CONSTRAINT fk_office_country FOREIGN KEY (office_country_id) REFERENCES country (id)
);



insert into country values ('da9be00b-76b0-11e6-9ba7-44a842ecf33c', 'nl');
insert into country values ('dfbd546a-76b0-11e6-9ba7-44a842ecf33c', 'uk');

insert into person values('8ea1af81-767e-11e6-9ba7-44a842ecf33c',
                        'this is my street',
                        '12333',
                        'c',
                        'da9be00b-76b0-11e6-9ba7-44a842ecf33c',
                        'Opps, I love this place :)',
                        '12222',
                        'office c',
                        'dfbd546a-76b0-11e6-9ba7-44a842ecf33c');
