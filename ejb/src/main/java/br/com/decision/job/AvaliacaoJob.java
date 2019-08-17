package br.com.decision.job;

import java.io.Serializable;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.decision.service.AlunoAvaliacaoTurmaService;
import br.com.decision.service.TurmaService;

@Stateless
public class AvaliacaoJob implements Serializable {

	private static final long serialVersionUID = 5318689477897702946L;

	@Inject
	private AlunoAvaliacaoTurmaService alunoAvaliacaoTurmaService;

	@Inject
	private TurmaService turmaService;

	@Schedule(second = "*/30", minute = "*", hour = "*", persistent = false)
	public void initAvaliacao() {
		alunoAvaliacaoTurmaService.processAlunoAvaliacaoTurma(turmaService.searchTurmasPendentes());
	}

	@Schedule(second = "*/30", minute = "*", hour = "*", persistent = false)
	public void exportAvaliacao() {
		alunoAvaliacaoTurmaService.exportAvaliacoes(alunoAvaliacaoTurmaService.searchAlunoAvaliacaoTurmaToExport());
	}

	@Schedule(second = "*/30", minute = "*", hour = "*", persistent = false)
	public void closeAvaliacao() {
		alunoAvaliacaoTurmaService.closeAlunoAvaliacaoTurma();
	}

}
