create table atores(
    idAtor         int          auto_increment,
    nomeAtor       varchar(100) not null,
    idadeAtor      int          not null,
    primary key(idAtor)
);

insert into atores(nomeAtor, idadeAtor) values ('Jackie Chan', 68);
insert into atores(nomeAtor, idadeAtor) values ('Angelina Jolie', 47);
insert into atores(nomeAtor, idadeAtor) values ('Will Smith', 54);
insert into atores(nomeAtor, idadeAtor) values ('Adam Sandler', 56);
insert into atores(nomeAtor, idadeAtor) values ('Jennifer Aniston', 54);