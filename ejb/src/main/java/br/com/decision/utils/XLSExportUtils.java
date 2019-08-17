package br.com.decision.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import br.com.decision.entity.AlunoAvaliacaoTurma;
import br.com.decision.entity.AvaliacaoResposta;
import br.com.decision.entity.Curso;
import br.com.decision.entity.FormularioItem;
import br.com.decision.entity.Resposta;
import br.com.decision.entity.Turma;
import br.com.decision.entity.Usuario;

public class XLSExportUtils implements Serializable {

	private static final long serialVersionUID = 2696790518940426313L;

	public static void exportToXLS(final Path folder, final List<AlunoAvaliacaoTurma> avaliacoes) throws IOException {
		final HSSFWorkbook workbook = new HSSFWorkbook();
		final HSSFSheet sheetAvaliacao = workbook.createSheet("Avaliações");
		int rownum = 0;
		for (final AlunoAvaliacaoTurma avaliacao : avaliacoes) {
			int cellnum = 0;
			final Row row = sheetAvaliacao.createRow(rownum++);
			row.createCell(cellnum++).setCellValue(buildCursoFromAvaliacao(avaliacao));
			row.createCell(cellnum++).setCellValue(buildModuloFromAvaliacao(avaliacao));
			row.createCell(cellnum++).setCellValue(buildTurmaFromAvaliacao(avaliacao));
			row.createCell(cellnum++).setCellValue(buildProfessorFromAvaliacao(avaliacao));
			row.createCell(cellnum++).setCellValue(buildAlunoFromAvaliacao(avaliacao));

			for (final FormularioItem formularioItem : buildFormularioItemFromAvaliacao(avaliacao)) {
				row.createCell(cellnum++).setCellValue(buildTopicoFromFormularioItem(formularioItem));
				row.createCell(cellnum++).setCellValue(buildPerguntaFromFormularioItem(formularioItem));
				row.createCell(cellnum++).setCellValue(buildRespostaFromFormularioItem(formularioItem));
			}

			createFile(folder, workbook, avaliacao);
		}
	}

	private static void createFile(final Path folder, final HSSFWorkbook workbook, final AlunoAvaliacaoTurma avaliacao)
			throws IOException {
		final Path filePath = buildFileName(folder, avaliacao);

		if (!Files.exists(filePath)) {
			Files.createFile(filePath);
		}

		try (FileOutputStream out = new FileOutputStream(filePath.toFile())) {
			workbook.write(out);
			System.out.println("Arquivo Excel criado com sucesso!");
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	private static Path buildFileName(final Path folder, final AlunoAvaliacaoTurma avaliacao) {
		final Turma turma = avaliacao.getTurma();
		final Curso curso = turma.getCurso();
		final Usuario aluno = avaliacao.getAluno();

		final StringBuilder fileName = new StringBuilder();
		fileName.append(curso.getNomeCurso()).append("_");
		fileName.append(aluno.getNome()).append("_").append(aluno.getSobrenome()).append("_");
		fileName.append(turma.getNumero()).append("_");
		fileName.append(buildDateAsString()).append(".xls");

		return folder.resolve(fileName.toString());
	}

	private static String buildDateAsString() {
		return new SimpleDateFormat("dd:MM:yyyy HH.mm.ss").format(new Date());
	}

	private static List<FormularioItem> buildFormularioItemFromAvaliacao(final AlunoAvaliacaoTurma avaliacao) {
		final List<FormularioItem> formularioItens = new ArrayList<FormularioItem>();
		for (final AvaliacaoResposta avaliacaoResposta : avaliacao.getAvaliacaoRespostas()) {
			formularioItens.addAll(avaliacaoResposta.getPergunta().getFormularioItems());
		}
		return formularioItens;
	}

	private static String buildCursoFromAvaliacao(final AlunoAvaliacaoTurma avaliacao) {
		final StringBuilder sb = new StringBuilder();
		sb.append(avaliacao.getTurma().getCurso().getNomeCurso());
		return sb.toString();

	}

	private static String buildModuloFromAvaliacao(final AlunoAvaliacaoTurma avaliacao) {
		return avaliacao.getTurma().getModulo().getNome();
	}

	private static Integer buildTurmaFromAvaliacao(final AlunoAvaliacaoTurma avaliacao) {
		return avaliacao.getTurma().getNumero();
	}

	private static String buildProfessorFromAvaliacao(final AlunoAvaliacaoTurma avaliacao) {
		final StringBuilder sb = new StringBuilder();
		final Usuario professor = avaliacao.getTurma().getProfessor();
		sb.append(professor.getNome()).append(" ").append(professor.getSobrenome());
		return sb.toString();
	}

	private static String buildAlunoFromAvaliacao(final AlunoAvaliacaoTurma avaliacao) {
		final StringBuilder sb = new StringBuilder();
		final Usuario aluno = avaliacao.getAluno();
		sb.append(aluno.getNome()).append(" ").append(aluno.getSobrenome());
		return sb.toString();
	}

	private static String buildTopicoFromFormularioItem(final FormularioItem formularioItem) {
		final StringBuilder sb = new StringBuilder();
		sb.append(formularioItem.getTopico().getDescricao());
		return sb.toString();
	}

	private static String buildPerguntaFromFormularioItem(final FormularioItem formularioItem) {
		return formularioItem.getPergunta().getDsPergunta();
	}

	private static String buildRespostaFromFormularioItem(final FormularioItem formularioItem) {
		final StringBuilder sb = new StringBuilder();

		for (final Resposta resposta : formularioItem.getPergunta().getRespostas()) {
			if (Boolean.TRUE.equals(formularioItem.getPergunta().getObjetiva()) && resposta.getResposta() != null) {
				sb.append(resposta.getResposta());
			}

			if (Boolean.TRUE.equals(formularioItem.getPergunta().getJustificativa()) && !StringUtils.isBlank(resposta.getTexto())) {
				sb.append(resposta.getTexto());
			}
		}
		return sb.toString();
	}

}
