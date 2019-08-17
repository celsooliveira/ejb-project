insert into aluno_avaliacao_turma (id_aluno,id_turma,dt_avaliacao,concluida,transmitida,hashAvaliacao,dt_inclusao,usuario_inc,nr_versao)
 select tal.usuario_id_user,tal.turma_id_turma,tur.dt_inicio_avaliacao,false,false,rand(),curdate(),1,1
  from usuario_turma tal
  inner join turma tur on tal.turma_id_turma = tur.id_turma	