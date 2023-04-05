create table atores(
    idator         int          auto_increment,
    nomeator       varchar(100) not null,
    idadeator      int          not null,
    primary key(idator)
);

insert into atores(nomeator, idadeator) values ('Jackie Chan', 68);
insert into atores(nomeator, idadeator) values ('Angelina Jolie', 47);
insert into atores(nomeator, idadeator) values ('Will Smith', 54);
insert into atores(nomeator, idadeator) values ('Adam Sandler', 56);
insert into atores(nomeator, idadeator) values ('Jennifer Aniston', 54);

create table generos(
    idgenero           int              auto_increment,
    generofilme        varchar(100)     not null,
    primary key(idgenero)
);

insert into generos(generofilme) values ('Ação');
insert into generos(generofilme) values ('Fantasia');
insert into generos(generofilme) values ('Musical');
insert into generos(generofilme) values ('Comédia');
insert into generos(generofilme) values ('Infantil');

create table filmes(
    idfilme            int              auto_increment,
    nomefilme          varchar(100)     not null,
    classificacao      varchar(10)      not null,
    idator             int              not null,
    idgenero           int              not null,
    primary key(idfilme)
);

insert into filmes(nomefilme, classificacao, idator, idgenero) values ('Inimigo Mortal', '14 anos', 1, 1);
insert into filmes(nomefilme, classificacao, idator, idgenero) values ('Malévola', '10 anos', 2, 2);
insert into filmes(nomefilme, classificacao, idator, idgenero) values ('Aladdin', '10 anos', 3, 3);
insert into filmes(nomefilme, classificacao, idator, idgenero) values ('Gente Grande', '12 anos', 4, 4);
insert into filmes(nomefilme, classificacao, idator, idgenero) values ('Marley e Eu', 'Livre', 5, 5);

alter table filmes add constraint FK_filmes_genero foreign key(idgenero) references generos(idgenero);
alter table filmes add constraint FK_filmes_atores foreign key(idator) references atores(idator);

