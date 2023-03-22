alter table filmes add constraint FK_filmes_genero foreign key(idGenero) references genero(idGenero);
alter table filmes add constraint FK_filmes_atores foreign key(idAtor) references atores(idAtor);