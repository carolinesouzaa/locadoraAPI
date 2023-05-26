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

create table generos(
    idGenero           int              auto_increment,
    generoFilme        varchar(100)     not null,
    primary key(idGenero)
);

insert into generos(generoFilme) values ('Ação');
insert into generos(generoFilme) values ('Fantasia');
insert into generos(generoFilme) values ('Musical');
insert into generos(generoFilme) values ('Comédia');
insert into generos(generoFilme) values ('Infantil');


create table filmes(
    idFilme            int              auto_increment,
    nomeFilme          varchar(100)     not null,
    classificacao      varchar(10)      not null,
    idAtor             int              not null,
    idGenero           int              not null,
    primary key(idFilme)
);

insert into filmes(nomeFilme, classificacao, idAtor, idGenero) values ('Inimigo Mortal', '14 anos', 1, 1);
insert into filmes(nomeFilme, classificacao, idAtor, idGenero) values ('Malévola', '10 anos', 2, 2);
insert into filmes(nomeFilme, classificacao, idAtor, idGenero) values ('Aladdin', '10 anos', 3, 3);
insert into filmes(nomeFilme, classificacao, idAtor, idGenero) values ('Gente Grande', '12 anos', 4, 4);
insert into filmes(nomeFilme, classificacao, idAtor, idGenero) values ('Marley e Eu', 'Livre', 5, 5);

alter table filmes add constraint FK_filmes_genero foreign key(idGenero) references generos(idGenero);
alter table filmes add constraint FK_filmes_atores foreign key(idAtor) references atores(idAtor);

