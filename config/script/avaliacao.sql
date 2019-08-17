-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema avaliacao
-- -----------------------------------------------------
-- DB projeto de bloco

-- -----------------------------------------------------
-- Schema avaliacao
--
-- DB projeto de bloco
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `avaliacao` ;
USE `avaliacao` ;

-- -----------------------------------------------------
-- Table `avaliacao`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `avaliacao`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `sobrenome` VARCHAR(255) NOT NULL,
  `dt_nascimento` DATE NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `email` VARCHAR(100) NULL,
  `senha` VARCHAR(45) NOT NULL,
  `dt_inclusao` DATETIME NOT NULL,
  `dt_alteracao` DATETIME NULL,
  `usuario_inc` INT NOT NULL,
  `usuario_alt` INT NULL,
  `nr_versao` INT NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avaliacao`.`perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `avaliacao`.`perfil` (
  `id_perfil` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(200) NULL,
  `administrador` BINARY NULL,
  `professor` BINARY NULL,
  `aluno` BINARY NULL,
  `dt_inclusao` DATETIME NOT NULL,
  `dt_alteracao` DATETIME NULL,
  `usuario_inc` INT NOT NULL,
  `usuario_alt` INT NULL,
  `nr_versao` INT NOT NULL,
  PRIMARY KEY (`id_perfil`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avaliacao`.`usuario_perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `avaliacao`.`usuario_perfil` (
  `id_usuario_perfil` INT NOT NULL AUTO_INCREMENT,
  `id_usuario` INT NOT NULL,
  `id_perfil` INT NOT NULL,
  PRIMARY KEY (`id_usuario_perfil`),
  INDEX `iduser_idx` (`id_usuario` ASC),
  INDEX `perfil_idx` (`id_perfil` ASC),
  CONSTRAINT `iduser`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `avaliacao`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `perfil`
    FOREIGN KEY (`id_perfil`)
    REFERENCES `avaliacao`.`perfil` (`id_perfil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avaliacao`.`modulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `avaliacao`.`modulo` (
  `id_modulo` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `dt_inclusao` DATETIME NOT NULL,
  `dt_alteracao` DATETIME NULL,
  `usuario_inc` INT NOT NULL,
  `usuario_alt` INT NULL,
  `nr_versao` INT NOT NULL,
  PRIMARY KEY (`id_modulo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avaliacao`.`turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `avaliacao`.`turma` (
  `id_turma` INT NOT NULL AUTO_INCREMENT,
  `id_professor` INT NOT NULL,
  `modulo_id_modulo` INT NOT NULL,
  `numero` INT UNSIGNED NOT NULL,
  `dt_inicial` DATETIME NOT NULL,
  `dt_final` DATETIME NOT NULL,
  `dt_inclusao` DATETIME NOT NULL,
  `dt_alteracao` DATETIME NULL,
  `usuario_inc` INT NOT NULL,
  `usuario_alt` INT NULL,
  `nr_versao` INT NOT NULL,
  PRIMARY KEY (`id_turma`),
  INDEX `fk_turma_modulo_idx` (`modulo_id_modulo` ASC),
  INDEX `fk_turma_usuario1_idx` (`id_professor` ASC),
  CONSTRAINT `fk_turma_modulo`
    FOREIGN KEY (`modulo_id_modulo`)
    REFERENCES `avaliacao`.`modulo` (`id_modulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turma_usuario1`
    FOREIGN KEY (`id_professor`)
    REFERENCES `avaliacao`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avaliacao`.`aluno_turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `avaliacao`.`aluno_turma` (
  `id_aluno_turma` INT NOT NULL AUTO_INCREMENT,
  `id_usuario` INT NOT NULL,
  `id_turma` INT NOT NULL,
  PRIMARY KEY (`id_aluno_turma`),
  INDEX `ATidturma` (`id_turma` ASC),
  INDEX `ATidusuario` (`id_usuario` ASC),
  CONSTRAINT `ATiduser`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `avaliacao`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ATidturma`
    FOREIGN KEY (`id_turma`)
    REFERENCES `avaliacao`.`turma` (`id_turma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avaliacao`.`formulario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `avaliacao`.`formulario` (
  `id_formulario` INT NOT NULL,
  `descricao` TEXT NOT NULL,
  `dt_inclusao` DATETIME NOT NULL,
  `dt_alteracao` DATETIME NULL,
  `usuario_inc` INT NOT NULL,
  `usuario_alt` INT NULL,
  `nr_versao` INT NOT NULL,
  PRIMARY KEY (`id_formulario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avaliacao`.`topico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `avaliacao`.`topico` (
  `id_topico` INT NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_topico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avaliacao`.`pergunta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `avaliacao`.`pergunta` (
  `id_pergunta` INT NOT NULL,
  `id_formulario` INT NOT NULL,
  `id_topico` INT NOT NULL,
  `pergunta` VARCHAR(255) NOT NULL,
  `peso` DECIMAL(5,2) NULL,
  `objetiva` BINARY NOT NULL,
  `justificativa` BINARY NOT NULL,
  `dt_inclusao` DATETIME NOT NULL,
  `dt_alteracao` DATETIME NULL,
  `usuario_inc` INT NOT NULL,
  `usuario_alt` INT NULL,
  `nr_versao` INT NOT NULL,
  PRIMARY KEY (`id_pergunta`),
  INDEX `idformulario_idx` (`id_formulario` ASC),
  INDEX `idtopico_idx` (`id_topico` ASC),
  CONSTRAINT `idformulario`
    FOREIGN KEY (`id_formulario`)
    REFERENCES `avaliacao`.`formulario` (`id_formulario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idtopico`
    FOREIGN KEY (`id_topico`)
    REFERENCES `avaliacao`.`topico` (`id_topico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avaliacao`.`resposta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `avaliacao`.`resposta` (
  `id_resposta` INT NOT NULL,
  `id_pergunta` INT NOT NULL,
  `nota` VARCHAR(45) NOT NULL,
  `resposta` DECIMAL(5,2) NOT NULL,
  `dt_inclusao` DATETIME NOT NULL,
  `dt_alteracao` DATETIME NULL,
  `usuario_inc` INT NOT NULL,
  `usuario_alt` INT NULL,
  `nr_versao` INT NOT NULL,
  PRIMARY KEY (`id_resposta`),
  INDEX `idpergunta_idx` (`id_pergunta` ASC),
  CONSTRAINT `idpergunta`
    FOREIGN KEY (`id_pergunta`)
    REFERENCES `avaliacao`.`pergunta` (`id_pergunta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avaliacao`.`turma_formulario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `avaliacao`.`turma_formulario` (
  `id_turma_formulario` INT NOT NULL AUTO_INCREMENT,
  `id_turma` INT NOT NULL,
  `id_formulario` INT NOT NULL,
  `dt_inicio_avaliacao` DATETIME NOT NULL,
  `dt_final_avaliacao` DATETIME NOT NULL,
  `texto_email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_turma_formulario`),
  INDEX `idformulario_idx` (`id_formulario` ASC),
  INDEX `idturma_idx` (`id_turma` ASC),
  CONSTRAINT `TFidformulario`
    FOREIGN KEY (`id_formulario`)
    REFERENCES `avaliacao`.`formulario` (`id_formulario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `TFidturma`
    FOREIGN KEY (`id_turma`)
    REFERENCES `avaliacao`.`turma` (`id_turma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avaliacao`.`aluno_avaliacao_modulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `avaliacao`.`aluno_avaliacao_modulo` (
  `id_aluno_avalia_modulo` INT NOT NULL,
  `id_usuario` INT NOT NULL,
  `id_turma_formulario` INT NOT NULL,
  `dt_avaliacao` DATE NOT NULL,
  `concluida` BINARY NOT NULL,
  `transmitida` BINARY NOT NULL,
  `usuario_turma_usuario_id_user` INT NULL,
  `usuario_turma_turma_id_turma` INT NULL,
  PRIMARY KEY (`id_aluno_avalia_modulo`, `usuario_turma_usuario_id_user`, `usuario_turma_turma_id_turma`),
  INDEX `iduser_idx` (`id_usuario` ASC),
  INDEX `id_turma_formulario_idx` (`id_turma_formulario` ASC),
  CONSTRAINT `AAMiduser`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `avaliacao`.`aluno_turma` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `AAMid_turma_formulario`
    FOREIGN KEY (`id_turma_formulario`)
    REFERENCES `avaliacao`.`turma_formulario` (`id_turma_formulario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avaliacao`.`avaliacao_resposta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `avaliacao`.`avaliacao_resposta` (
  `id_avaliacao_resposta` INT NOT NULL,
  `id_aluno_avalia_modulo` INT NOT NULL,
  `id_pergunta` INT NOT NULL,
  `id_resposta` INT NULL,
  `texto` VARCHAR(255) NULL,
  PRIMARY KEY (`id_avaliacao_resposta`),
  INDEX `idalunoAvaliaModulo_idx` (`id_aluno_avalia_modulo` ASC),
  INDEX `idpergunta_idx` (`id_pergunta` ASC),
  INDEX `idresposta_idx` (`id_resposta` ASC),
  CONSTRAINT `ARidalunoAvaliaModulo`
    FOREIGN KEY (`id_aluno_avalia_modulo`)
    REFERENCES `avaliacao`.`aluno_avaliacao_modulo` (`id_aluno_avalia_modulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ARidpergunta`
    FOREIGN KEY (`id_pergunta`)
    REFERENCES `avaliacao`.`pergunta` (`id_pergunta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ARidresposta`
    FOREIGN KEY (`id_resposta`)
    REFERENCES `avaliacao`.`resposta` (`id_resposta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avaliacao`.`usuario_turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `avaliacao`.`usuario_turma` (
  `id_usuario_turma` INT NOT NULL AUTO_INCREMENT,
  `usuario_id_user` INT NOT NULL,
  `turma_id_turma` INT NOT NULL,
  PRIMARY KEY (`id_usuario_turma`),
  INDEX `fk_usuario_has_turma_turma1_idx` (`turma_id_turma` ASC),
  INDEX `fk_usuario_has_turma_usuario1_idx` (`usuario_id_user` ASC),
  CONSTRAINT `fk_usuario_has_turma_usuario1`
    FOREIGN KEY (`usuario_id_user`)
    REFERENCES `avaliacao`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avaliacao`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `avaliacao`.`curso` (
  `id_cusro` INT NOT NULL,
  `nomeCurso` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_cusro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avaliacao`.`curso_modulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `avaliacao`.`curso_modulo` (
  `id_curso_modulo` INT NOT NULL,
  `id_modulo` INT NOT NULL,
  `id_curso` INT NOT NULL,
  PRIMARY KEY (`id_curso_modulo`),
  INDEX `id_modulo_idx` (`id_modulo` ASC),
  INDEX `id_curso_idx` (`id_curso` ASC),
  CONSTRAINT `id_modulo`
    FOREIGN KEY (`id_modulo`)
    REFERENCES `avaliacao`.`modulo` (`id_modulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_curso`
    FOREIGN KEY (`id_curso`)
    REFERENCES `avaliacao`.`curso` (`id_cusro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

