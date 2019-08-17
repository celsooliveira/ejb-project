-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: avaliacao
-- ------------------------------------------------------
-- Server version	5.6.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aluno_avaliacao_turma`
--

DROP TABLE IF EXISTS `aluno_avaliacao_turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno_avaliacao_turma` (
  `id_aluno_avalia_turma` int(11) NOT NULL AUTO_INCREMENT,
  `id_aluno` int(11) NOT NULL,
  `id_turma` int(11) NOT NULL,
  `dt_avaliacao` date NOT NULL,
  `concluida` bit(1) NOT NULL,
  `transmitida` bit(1) NOT NULL,
  `hashAvaliacao` varchar(256) NOT NULL,
  `dt_inclusao` datetime NOT NULL,
  `dt_alteracao` datetime DEFAULT NULL,
  `usuario_inc` int(11) NOT NULL,
  `usuario_alt` int(11) DEFAULT NULL,
  `nr_versao` int(11) NOT NULL,
  PRIMARY KEY (`id_aluno_avalia_turma`),
  UNIQUE KEY `hashAvaliacao_UNIQUE` (`hashAvaliacao`),
  KEY `id_aluno_idx` (`id_aluno`),
  KEY `id_turma_idx` (`id_turma`),
  CONSTRAINT `id_aluno_idx` FOREIGN KEY (`id_aluno`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_turma_idx` FOREIGN KEY (`id_turma`) REFERENCES `turma` (`id_turma`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno_avaliacao_turma`
--

LOCK TABLES `aluno_avaliacao_turma` WRITE;
/*!40000 ALTER TABLE `aluno_avaliacao_turma` DISABLE KEYS */;
/*!40000 ALTER TABLE `aluno_avaliacao_turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aluno_turma`
--

DROP TABLE IF EXISTS `aluno_turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno_turma` (
  `id_aluno_turma` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `id_turma` int(11) NOT NULL,
  PRIMARY KEY (`id_aluno_turma`),
  KEY `id_turma_idx` (`id_turma`),
  KEY `id_usuario_idx` (`id_usuario`),
  CONSTRAINT `idturma_idx` FOREIGN KEY (`id_turma`) REFERENCES `turma` (`id_turma`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `iduser_idx` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno_turma`
--

LOCK TABLES `aluno_turma` WRITE;
/*!40000 ALTER TABLE `aluno_turma` DISABLE KEYS */;
/*!40000 ALTER TABLE `aluno_turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avaliacao_resposta`
--

DROP TABLE IF EXISTS `avaliacao_resposta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avaliacao_resposta` (
  `id_avaliacao_resposta` int(11) NOT NULL AUTO_INCREMENT,
  `id_aluno_avalia_modulo` int(11) NOT NULL,
  `id_pergunta` int(11) NOT NULL,
  `id_resposta` int(11) DEFAULT NULL,
  `texto` varchar(255) DEFAULT NULL,
  `dt_inclusao` datetime NOT NULL,
  `dt_alteracao` datetime DEFAULT NULL,
  `usuario_inc` int(11) NOT NULL,
  `usuario_alt` int(11) DEFAULT NULL,
  `nr_versao` int(11) NOT NULL,
  PRIMARY KEY (`id_avaliacao_resposta`),
  KEY `idalunoAvaliaModulo_idx` (`id_aluno_avalia_modulo`),
  KEY `idpergunta_idx` (`id_pergunta`),
  KEY `idresposta_idx` (`id_resposta`),
  CONSTRAINT `ARidalunoAvaliaModulo` FOREIGN KEY (`id_aluno_avalia_modulo`) REFERENCES `aluno_avaliacao_turma` (`id_aluno_avalia_turma`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ARidpergunta` FOREIGN KEY (`id_pergunta`) REFERENCES `pergunta` (`id_pergunta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ARidresposta` FOREIGN KEY (`id_resposta`) REFERENCES `resposta` (`id_resposta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao_resposta`
--

LOCK TABLES `avaliacao_resposta` WRITE;
/*!40000 ALTER TABLE `avaliacao_resposta` DISABLE KEYS */;
/*!40000 ALTER TABLE `avaliacao_resposta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `id_curso` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCurso` varchar(255) NOT NULL,
  `dt_inclusao` datetime NOT NULL,
  `dt_alteracao` datetime DEFAULT NULL,
  `usuario_inc` int(11) NOT NULL,
  `usuario_alt` int(11) DEFAULT NULL,
  `nr_versao` int(11) NOT NULL,
  PRIMARY KEY (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (4,'PG MIT em Engenharia de Software com Java','2015-11-30 00:00:00',NULL,1,NULL,1);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso_modulo`
--

DROP TABLE IF EXISTS `curso_modulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso_modulo` (
  `id_curso_modulo` int(11) NOT NULL AUTO_INCREMENT,
  `id_modulo` int(11) NOT NULL,
  `id_curso` int(11) NOT NULL,
  PRIMARY KEY (`id_curso_modulo`),
  KEY `id_modulo_idx` (`id_modulo`),
  KEY `id_curso_idx` (`id_curso`),
  CONSTRAINT `id_curso` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_modulo` FOREIGN KEY (`id_modulo`) REFERENCES `modulo` (`id_modulo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso_modulo`
--

LOCK TABLES `curso_modulo` WRITE;
/*!40000 ALTER TABLE `curso_modulo` DISABLE KEYS */;
INSERT INTO `curso_modulo` VALUES (4,2,4),(5,3,4),(6,4,4),(7,5,4),(8,6,4),(9,7,4),(10,8,4),(11,9,4),(12,10,4),(13,11,4),(14,12,4),(15,13,4),(16,14,4),(17,15,4);
/*!40000 ALTER TABLE `curso_modulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formulario`
--

DROP TABLE IF EXISTS `formulario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formulario` (
  `id_formulario` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` text NOT NULL,
  `dt_inclusao` datetime NOT NULL,
  `dt_alteracao` datetime DEFAULT NULL,
  `usuario_inc` int(11) NOT NULL,
  `usuario_alt` int(11) DEFAULT NULL,
  `nr_versao` int(11) NOT NULL,
  PRIMARY KEY (`id_formulario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formulario`
--

LOCK TABLES `formulario` WRITE;
/*!40000 ALTER TABLE `formulario` DISABLE KEYS */;
INSERT INTO `formulario` VALUES (3,'Formulario I','2015-11-28 15:00:37',NULL,1,NULL,1);
/*!40000 ALTER TABLE `formulario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formulario_item`
--

DROP TABLE IF EXISTS `formulario_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formulario_item` (
  `id_formulario_item` int(11) NOT NULL,
  `id_formulario` int(11) DEFAULT NULL,
  `id_topico` int(11) DEFAULT NULL,
  `id_pergunta` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_formulario_item`),
  UNIQUE KEY `idformulario_item_UNIQUE` (`id_formulario_item`),
  UNIQUE KEY `formTopicPergunta` (`id_formulario`,`id_topico`,`id_pergunta`),
  KEY `id_formulario_idx` (`id_formulario`),
  KEY `id_topico_idx` (`id_topico`),
  KEY `id_pergunta_idx` (`id_pergunta`),
  CONSTRAINT `id_formulario` FOREIGN KEY (`id_formulario`) REFERENCES `formulario` (`id_formulario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_pergunta` FOREIGN KEY (`id_pergunta`) REFERENCES `pergunta` (`id_pergunta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_topico` FOREIGN KEY (`id_topico`) REFERENCES `topico` (`id_topico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Relacionamento formulario x topico x pergunta';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formulario_item`
--

LOCK TABLES `formulario_item` WRITE;
/*!40000 ALTER TABLE `formulario_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `formulario_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo` (
  `grupo` varchar(40) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  PRIMARY KEY (`grupo`,`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` VALUES ('ADMIN','deco'),('Aluno','Andre'),('Aluno','Damara'),('Aluno','Daniel'),('Aluno','Denise'),('Aluno','Ederson'),('Aluno','Everling'),('Aluno','Éverton'),('Aluno','Ezequiel'),('Aluno','Fabrício'),('Aluno','Josiane'),('Aluno','Kehl'),('Aluno','Leandro'),('Aluno','Luciano'),('Aluno','Marcio'),('Aluno','Marco'),('Aluno','Matheus'),('Aluno','Pablo'),('Aluno','Sebastian'),('Professor','Aquino'),('Professor','Bruno'),('Professor','Conrad'),('Professor','Felix'),('Professor','Flavio'),('Professor','Fred'),('Professor','Magela'),('Professor','Manoel'),('Professor','Thiago');
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulo`
--

DROP TABLE IF EXISTS `modulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modulo` (
  `id_modulo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `dt_inclusao` datetime NOT NULL,
  `dt_alteracao` datetime DEFAULT NULL,
  `usuario_inc` int(11) NOT NULL,
  `usuario_alt` int(11) DEFAULT NULL,
  `nr_versao` int(11) NOT NULL,
  PRIMARY KEY (`id_modulo`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulo`
--

LOCK TABLES `modulo` WRITE;
/*!40000 ALTER TABLE `modulo` DISABLE KEYS */;
INSERT INTO `modulo` VALUES (2,'Projeto de Bloco','2015-11-29 00:00:00',NULL,1,NULL,1),(3,'Introdução à Engenharia de Software','2015-11-29 00:00:00',NULL,1,NULL,1),(4,'Processos de Desenvolvimento de Software','2015-11-29 00:00:00',NULL,1,NULL,1),(5,'Métricas de Desenvolvimento de Software','2015-11-29 00:00:00',NULL,1,NULL,1),(6,'Análise e Projeto de Sistemas Orientados a Objetos','2015-11-29 00:00:00',NULL,1,NULL,1),(7,'Projeto de Bloco - 2° bloco','2015-11-29 00:00:00',NULL,1,NULL,1),(8,'Programação Orientadas a Objetos com Java','2015-11-29 00:00:00',NULL,1,NULL,1),(9,'Acesso a dados, Multithreading e Interface gráfica em Java','2015-11-29 00:00:00',NULL,1,NULL,1),(10,'Projeto de Bloco (Web e Componentes com JAVA)','2015-11-29 00:00:00',NULL,1,NULL,1),(11,'Aplicação Web','2015-11-29 00:00:00',NULL,1,NULL,1),(12,'Aplicações na Camada de Negócios','2015-11-29 00:00:00',NULL,1,NULL,1),(13,'TCC','2015-11-29 00:00:00',NULL,1,NULL,1),(14,'Tópicos Avançados','2015-11-29 00:00:00',NULL,1,NULL,1),(15,'TCC - Entrega Final','2015-11-29 00:00:00',NULL,1,NULL,1);
/*!40000 ALTER TABLE `modulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil` (
  `id_perfil` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(200) DEFAULT NULL,
  `administrador` bit(1) DEFAULT NULL,
  `professor` bit(1) DEFAULT NULL,
  `aluno` bit(1) DEFAULT NULL,
  `dt_inclusao` datetime NOT NULL,
  `dt_alteracao` datetime DEFAULT NULL,
  `usuario_inc` int(11) NOT NULL,
  `usuario_alt` int(11) DEFAULT NULL,
  `nr_versao` int(11) NOT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (3,'Admin','','\0','\0','2015-12-04 00:00:00',NULL,1,NULL,1),(4,'Professor','\0','','\0','2015-12-04 00:00:00',NULL,1,NULL,1),(5,'Aluno','\0','\0','','2015-12-04 00:00:00',NULL,1,NULL,1);
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pergunta`
--

DROP TABLE IF EXISTS `pergunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pergunta` (
  `id_pergunta` int(11) NOT NULL AUTO_INCREMENT,
  `pergunta` varchar(255) NOT NULL,
  `peso` decimal(5,2) DEFAULT NULL,
  `objetiva` bit(1) NOT NULL,
  `justificativa` bit(1) NOT NULL,
  `dt_inclusao` datetime NOT NULL,
  `dt_alteracao` datetime DEFAULT NULL,
  `usuario_inc` int(11) NOT NULL,
  `usuario_alt` int(11) DEFAULT NULL,
  `nr_versao` int(11) NOT NULL,
  PRIMARY KEY (`id_pergunta`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pergunta`
--

LOCK TABLES `pergunta` WRITE;
/*!40000 ALTER TABLE `pergunta` DISABLE KEYS */;
INSERT INTO `pergunta` VALUES (11,'Pergunta I',3.00,'','\0','2015-11-28 15:01:06',NULL,1,NULL,1);
/*!40000 ALTER TABLE `pergunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resposta`
--

DROP TABLE IF EXISTS `resposta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resposta` (
  `id_resposta` int(11) NOT NULL AUTO_INCREMENT,
  `id_pergunta` int(11) NOT NULL,
  `nota` varchar(45) NOT NULL,
  `resposta` decimal(5,2) NOT NULL,
  `dt_inclusao` datetime NOT NULL,
  `dt_alteracao` datetime DEFAULT NULL,
  `usuario_inc` int(11) NOT NULL,
  `usuario_alt` int(11) DEFAULT NULL,
  `nr_versao` int(11) NOT NULL,
  PRIMARY KEY (`id_resposta`),
  KEY `idpergunta_idx` (`id_pergunta`),
  CONSTRAINT `idpergunta` FOREIGN KEY (`id_pergunta`) REFERENCES `pergunta` (`id_pergunta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resposta`
--

LOCK TABLES `resposta` WRITE;
/*!40000 ALTER TABLE `resposta` DISABLE KEYS */;
/*!40000 ALTER TABLE `resposta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topico`
--

DROP TABLE IF EXISTS `topico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topico` (
  `id_topico` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  `dt_inclusao` datetime NOT NULL,
  `dt_alteracao` datetime DEFAULT NULL,
  `usuario_inc` int(11) NOT NULL,
  `usuario_alt` int(11) DEFAULT NULL,
  `nr_versao` int(11) NOT NULL,
  PRIMARY KEY (`id_topico`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topico`
--

LOCK TABLES `topico` WRITE;
/*!40000 ALTER TABLE `topico` DISABLE KEYS */;
INSERT INTO `topico` VALUES (3,'Topico 1','2015-11-26 00:07:55',NULL,1,NULL,1);
/*!40000 ALTER TABLE `topico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma`
--

DROP TABLE IF EXISTS `turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turma` (
  `id_turma` int(11) NOT NULL AUTO_INCREMENT,
  `id_professor` int(11) NOT NULL,
  `modulo_id_modulo` int(11) NOT NULL,
  `numero` int(10) unsigned NOT NULL,
  `dt_inicial` datetime NOT NULL,
  `dt_final` datetime NOT NULL,
  `dt_inicio_avaliacao` datetime NOT NULL,
  `dt_final_avaliacao` datetime NOT NULL,
  `texto_email` varchar(255) NOT NULL,
  `id_formulario` int(11) NOT NULL,
  `dt_inclusao` datetime NOT NULL,
  `dt_alteracao` datetime DEFAULT NULL,
  `usuario_inc` int(11) NOT NULL,
  `usuario_alt` int(11) DEFAULT NULL,
  `nr_versao` int(11) NOT NULL,
  PRIMARY KEY (`id_turma`),
  KEY `fk_turma_modulo_idx` (`modulo_id_modulo`),
  KEY `fk_turma_usuario1_idx` (`id_professor`),
  KEY `fk_formulario_idx` (`id_formulario`),
  KEY `id_turma_idx` (`id_turma`),
  CONSTRAINT `fk_formulario` FOREIGN KEY (`id_formulario`) REFERENCES `formulario` (`id_formulario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_turma_modulo` FOREIGN KEY (`modulo_id_modulo`) REFERENCES `modulo` (`id_modulo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_turma_usuario1` FOREIGN KEY (`id_professor`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma`
--

LOCK TABLES `turma` WRITE;
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` VALUES (2,3,2,1,'2013-09-13 00:00:00','2014-05-24 00:00:00','2014-05-24 00:00:00','2014-05-24 00:00:00','Teste',3,'2015-12-04 01:54:28',NULL,1,NULL,1),(3,4,3,1,'2013-09-14 00:00:00','2013-11-30 00:00:00','2013-11-30 00:00:00','2013-11-30 00:00:00','teste',3,'2015-12-04 01:54:28',NULL,1,NULL,1),(4,5,4,1,'2013-11-22 00:00:00','2014-03-29 00:00:00','2014-03-29 00:00:00','2014-03-29 00:00:00','teste',3,'2015-12-04 00:00:00',NULL,1,NULL,1);
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `sobrenome` varchar(255) NOT NULL,
  `dt_nascimento` date NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `user` varchar(45) DEFAULT NULL,
  `senha` varchar(150) NOT NULL,
  `dt_inclusao` datetime NOT NULL,
  `dt_alteracao` datetime DEFAULT NULL,
  `usuario_inc` int(11) NOT NULL,
  `usuario_alt` int(11) DEFAULT NULL,
  `nr_versao` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `user_UNIQUE` (`user`),
  KEY `id_aluno_idx` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Nome do Professor','Sobrenome do Professor','2015-08-20','email.do.professor@email.com','deco','54ca7b83a424aed496ef5ef4f0ddf94222949e097b7d8683f2bd58165e0823dd','2015-08-20 23:57:50',NULL,1,NULL,0),(3,'Frederico','Novaes','2015-11-30','fred@avaliacao.com.br','Fred','401f1721a42a814961323c460dd7d2036231ddf590b5d898c9cd086a46526bdb','2015-11-30 00:00:00',NULL,1,NULL,1),(4,'Tomás',' de Aquino Tinoco Botelho','2015-11-30','aquino@avaliacao.com.br','Aquino','2e1021e99b90e63287b516570052bdcb09a7f956682d3c5500016521253d2b19','2015-11-30 00:00:00',NULL,1,NULL,1),(5,'Rogério','Magela','2015-11-30','magela@avaliacao.com.br','Magela','3e61f9d96b4c9397206bf4e8b6c20cd8d0dbdf2a0547867b721721351e3e7f74','2015-11-30 00:00:00',NULL,1,NULL,1),(6,'Bruno','Freitas Braga','2015-11-30','bruno@avaliacao.com.br','Bruno','2f2781e5ab48853fc883d2be6d96bc5d012d07be8a9eb87f2592407e0986965b','2015-11-30 00:00:00',NULL,1,NULL,1),(7,'Conrad','Marques Peres','2015-11-30','conrad@avaliacao.com.br','Conrad','b92f91849d855b40496e911e9b3241fbae4a65b92b383b293a00ea32565d6543','2015-11-30 00:00:00',NULL,1,NULL,1),(8,'André','Felix da Silva','2015-11-30','felix@avaliacao.com.br','Felix','f6b6aad7a7690810466cb5288aea79c4eccd72d05bae7ab16be65bf9b3b6538e','2015-11-30 00:00:00',NULL,1,NULL,1),(9,'Flavio','Longue Guimarães','2015-11-30','flavio@avaliacao.com.br','Flavio','496ac691756603b8ef265e92b998edabbd228865785eb672f086a62bd44af041','2015-11-30 00:00:00',NULL,1,NULL,1),(10,'Manoel','Pedro Sá','2015-11-30','manoel@avaliacao.com.br','Manoel','e1ab46c6c93c344f92ee4a5c253724fc1fdd0f2152542ca2ac5b47ef2922af0a','2015-11-30 00:00:00',NULL,1,NULL,1),(11,'Thiago','Correia Medeiros','2015-11-30','thiago@avaliacao.com.br','Thiago','400030bc46b7498638dbaaf8c5b6f793fa60651ec38eff8a579a5a15c0044a40','2015-11-30 00:00:00',NULL,1,NULL,1),(12,'André','Luiz Brochado Schmitt','2015-12-04','deco.schmitt@gmail.com','Andre','54ca7b83a424aed496ef5ef4f0ddf94222949e097b7d8683f2bd58165e0823dd','2015-12-04 00:00:00',NULL,1,NULL,1),(14,'Damara','Daiane Viegas Da Silva','2015-12-04','deco.schmitt@gmail.com','Damara','54ca7b83a424aed496ef5ef4f0ddf94222949e097b7d8683f2bd58165e0823dd','2015-12-04 00:00:00',NULL,1,NULL,1),(15,'Daniel','Berlese Pinto','2015-12-04','deco.schmitt@gmail.com','Daniel','54ca7b83a424aed496ef5ef4f0ddf94222949e097b7d8683f2bd58165e0823dd','2015-12-04 00:00:00',NULL,1,NULL,1),(16,'Daniel','Douglas Everling','2015-12-04','deco.schmitt@gmail.com','Eveling','54ca7b83a424aed496ef5ef4f0ddf94222949e097b7d8683f2bd58165e0823dd','2015-12-04 00:00:00',NULL,1,NULL,1),(17,'Denise','Matté Giacomolli','2015-12-04','deco.schmitt@gmail.com','Denise','54ca7b83a424aed496ef5ef4f0ddf94222949e097b7d8683f2bd58165e0823dd','2015-12-04 00:00:00',NULL,1,NULL,1),(18,'Ederson','Buss Jeske','2015-12-04','deco.schmitt@gmail.com','Ederson','54ca7b83a424aed496ef5ef4f0ddf94222949e097b7d8683f2bd58165e0823dd','2015-12-04 00:00:00',NULL,1,NULL,1),(19,'Éverton','Mengotti Fernandes','2015-12-04','deco.schmitt@gmail.com','Éverton','54ca7b83a424aed496ef5ef4f0ddf94222949e097b7d8683f2bd58165e0823dd','2015-12-04 00:00:00',NULL,1,NULL,1),(20,'Ezequiel','Ficner','2015-12-04','deco.schmitt@gmail.com','Ezequiel','54ca7b83a424aed496ef5ef4f0ddf94222949e097b7d8683f2bd58165e0823dd','2015-12-04 00:00:00',NULL,1,NULL,1),(21,'Fabrício','Dos Santos','2015-12-04','deco.schmitt@gmail.com','Fabrício','54ca7b83a424aed496ef5ef4f0ddf94222949e097b7d8683f2bd58165e0823dd','2015-12-04 00:00:00',NULL,1,NULL,1),(22,'Josiane','Cavalheiro Begnini','2015-12-04','deco.schmitt@gmail.com','Josiane','54ca7b83a424aed496ef5ef4f0ddf94222949e097b7d8683f2bd58165e0823dd','2015-12-04 00:00:00',NULL,1,NULL,1),(23,'Leandro','Silva Licker','2015-12-04','deco.schmitt@gmail.com','Leandro','54ca7b83a424aed496ef5ef4f0ddf94222949e097b7d8683f2bd58165e0823dd','2015-12-04 00:00:00',NULL,1,NULL,1),(24,'Luciano','Lima Da Rosa','2015-12-04','lucianoldr@gmail.com','Luciano','54ca7b83a424aed496ef5ef4f0ddf94222949e097b7d8683f2bd58165e0823dd','2015-12-04 00:00:00',NULL,1,NULL,1),(25,'Marcio','Roberto De Mello','2015-12-04','deco.schmitt@gmail.com','Marcio','54ca7b83a424aed496ef5ef4f0ddf94222949e097b7d8683f2bd58165e0823dd','2015-12-04 00:00:00',NULL,1,NULL,1),(26,'Marco','Aurélio Costa','2015-12-04','deco.schmitt@gmail.com','Marco','54ca7b83a424aed496ef5ef4f0ddf94222949e097b7d8683f2bd58165e0823dd','2015-12-04 00:00:00',NULL,1,NULL,1),(27,'Matheus','Steckert Pessoa','2015-12-04','deco.schmitt@gmail.com','Matheus','54ca7b83a424aed496ef5ef4f0ddf94222949e097b7d8683f2bd58165e0823dd','2015-12-04 00:00:00',NULL,1,NULL,1),(28,'Pablo','Teixeira Gonçalves','2015-12-04','deco.schmitt@gmail.com','Pablo','54ca7b83a424aed496ef5ef4f0ddf94222949e097b7d8683f2bd58165e0823dd','2015-12-04 00:00:00',NULL,1,NULL,1),(29,'Sebastian','Rei Gomes Da Silva','2015-12-04','deco.schmitt@gmail.com','Sebastian','54ca7b83a424aed496ef5ef4f0ddf94222949e097b7d8683f2bd58165e0823dd','2015-12-04 00:00:00',NULL,1,NULL,1),(30,'Thiago','Nunes Kehl','2015-12-04','deco.schmitt@gmail.com','Kehl','54ca7b83a424aed496ef5ef4f0ddf94222949e097b7d8683f2bd58165e0823dd','2015-12-04 00:00:00',NULL,1,NULL,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_perfil`
--

DROP TABLE IF EXISTS `usuario_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_perfil` (
  `id_usuario_perfil` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `id_perfil` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario_perfil`),
  KEY `iduser_idx` (`id_usuario`),
  KEY `perfil_idx` (`id_perfil`),
  CONSTRAINT `iduser` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `perfil` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id_perfil`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_perfil`
--

LOCK TABLES `usuario_perfil` WRITE;
/*!40000 ALTER TABLE `usuario_perfil` DISABLE KEYS */;
INSERT INTO `usuario_perfil` VALUES (3,1,3),(4,3,4),(5,4,4),(6,5,4),(7,6,4),(8,7,4),(9,8,4),(10,9,4),(11,10,4),(12,11,4),(32,12,5),(33,14,5),(34,15,5),(35,16,5),(36,17,5),(37,18,5),(38,19,5),(39,20,5),(40,21,5),(41,22,5),(42,23,5),(43,24,5),(44,25,5),(45,26,5),(46,27,5),(47,28,5),(48,29,5),(49,30,5);
/*!40000 ALTER TABLE `usuario_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_turma`
--

DROP TABLE IF EXISTS `usuario_turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_turma` (
  `id_usuario_turma` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id_user` int(11) NOT NULL,
  `turma_id_turma` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario_turma`),
  KEY `fk_usuario_has_turma_turma1_idx` (`turma_id_turma`),
  KEY `fk_usuario_has_turma_usuario1_idx` (`usuario_id_user`),
  CONSTRAINT `FK_gipnyjva78a74r1uc283wll8b` FOREIGN KEY (`turma_id_turma`) REFERENCES `turma` (`id_turma`),
  CONSTRAINT `fk_usuario_has_turma_usuario1` FOREIGN KEY (`usuario_id_user`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_turma`
--

LOCK TABLES `usuario_turma` WRITE;
/*!40000 ALTER TABLE `usuario_turma` DISABLE KEYS */;
INSERT INTO `usuario_turma` VALUES (92,12,3),(93,14,3),(94,15,3),(95,16,3),(96,15,3),(97,18,3),(98,19,3),(99,20,3),(100,21,3),(101,22,3),(102,23,3),(103,24,3),(104,25,3),(105,26,3),(106,27,3),(107,28,3),(108,29,3),(109,30,3),(128,12,4),(129,14,4),(130,15,4),(131,16,4),(132,17,4),(133,18,4),(134,19,4),(135,20,4),(136,21,4),(137,22,4),(138,23,4),(139,24,4),(140,25,4),(141,26,4),(142,27,4),(143,28,4),(144,29,4),(145,30,4),(165,12,2),(166,14,2),(167,15,2),(168,16,2),(169,17,2),(170,18,2),(171,19,2),(172,20,2),(173,21,2),(174,22,2),(175,23,2),(176,24,2),(177,25,2),(178,26,2),(179,27,2),(180,28,2),(181,29,2),(182,30,2);
/*!40000 ALTER TABLE `usuario_turma` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-04  2:17:36
