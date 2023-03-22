create table genero(
    idGenero           int              auto_increment,
    generoFilme        varchar(100)     not null,
    primary key(idGenero)
);

insert into atores(generoFilme) values ('Ação');
insert into atores(generoFilme) values ('Fantasia');
insert into atores(generoFilme) values ('Musical');
insert into atores(generoFilme) values ('Comédia');
insert into atores(generoFilme) values ('Infantil');