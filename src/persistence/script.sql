create table aluno(idAluno  int primary key auto_increment,
                   nome  varchar(40));
                   
create table endereco(idEndereco  int primary key auto_increment,
                      rua  varchar(40),
                      bairro  varchar(40),
                      ID_Aluno int,
                      foreign key(ID_Aluno) references aluno(idAluno) on delete cascade);
    
                     
insert into aluno values(null,'teste');
insert into endereco values(null,'teste', 'teste', last_insert_id());


create or replace view v$consulta
as
select idAluno, nome, idEndereco, rua, bairro from endereco e
inner join aluno a
on a.idAluno=e.ID_Aluno;


create or replace view v$consultaAE
as
select idAluno, nome, idEndereco, rua, bairro from endereco e
inner join aluno a
on a.idAluno=e.ID_Aluno where idAluno=4;





select * from endereco e
inner join aluno a