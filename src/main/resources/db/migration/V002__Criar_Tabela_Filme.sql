create table filmes(
    idFilme            int              auto_increment,
    nomeFilme          varchar(100)     not null,
    classificacao      varchar(10)      not null,
    primary key(idFilme)
);

insert into atores(nomeFilme, classificacao) values ('Inimigo Mortal', '14 anos');
insert into atores(nomeFilme, classificacao) values ('Malévola', '10 anos');
insert into atores(nomeFilme, classificacao) values ('Aladdin', '10 anos');
insert into atores(nomeFilme, classificacao) values ('Gente Grande', '12 anos');
insert into atores(nomeFilme, classificacao) values ('Marley e Eu', 'Livre');