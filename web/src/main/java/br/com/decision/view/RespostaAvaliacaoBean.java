package br.com.decision.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.decision.entity.AlunoAvaliacaoTurma;
import br.com.decision.entity.AvaliacaoResposta;
import br.com.decision.entity.FormularioItem;
import br.com.decision.entity.Pergunta;
import br.com.decision.entity.Topico;
import br.com.decision.enumeration.LikertEnum;
import br.com.decision.service.AlunoAvaliacaoTurmaService;
import br.com.decision.utils.AvaliacaoHashUtils;
import br.com.decision.utils.StringUtils;
import br.com.decision.xml.AvaliacaoHash;

@Named
@SessionScoped
public class RespostaAvaliacaoBean extends CrudBaseBean<AlunoAvaliacaoTurma, AlunoAvaliacaoTurmaService> {

	private static final long serialVersionUID = 5660252985908274741L;

	@Inject
	private AlunoAvaliacaoTurmaService alunoAvaliacaoTurmaService;

	private Map<Topico, List<AvaliacaoResposta>> mapAvaliacoes;

	private String hash;

	@Produces
	public AlunoAvaliacaoTurma getAvaliacao() throws IOException {
		final AlunoAvaliacaoTurma alunoAvaliacaoTurma = searchAlunoAvaliacaoTurma();
		buildAvaliacoes(alunoAvaliacaoTurma);
		setEntity(alunoAvaliacaoTurma);
		validateAvaliacao();
		return alunoAvaliacaoTurma;
	}

	private void validateAvaliacao() throws IOException {
		if (getEntity() != null && getEntity().getTurma() != null
				&& Calendar.getInstance().getTime().after(getEntity().getTurma().getDtFinalAvaliacao())) {
			FacesContext.getCurrentInstance().getExternalContext().dispatch("avaliacaoNaoEncontrada.xhtml");
		}
	}

	@Produces
	public List<LikertEnum> getLikert() {
		return Arrays.asList(LikertEnum.values());
	}

	@Override
	public void preSave() {
		super.preSave();
		closeAvaliacao();
	}

	private void closeAvaliacao() {
		getEntity().setConcluida(true);

		for (final AvaliacaoResposta avaliacaoResposta : getEntity().getAvaliacaoRespostas()) {
			if ((avaliacaoResposta.getPergunta().getObjetiva() && avaliacaoResposta.getResposta().getResposta() == null)
					|| (avaliacaoResposta.getPergunta().getJustificativa() && StringUtils.isBlank(avaliacaoResposta.getResposta().getTexto()))) {
				getEntity().setConcluida(false);
			}
		}
	}

	public Map<Topico, List<AvaliacaoResposta>> getMapAvaliacoes() {
		return mapAvaliacoes;
	}

	public void setMapAvaliacoes(final Map<Topico, List<AvaliacaoResposta>> mapAvaliacoes) {
		this.mapAvaliacoes = mapAvaliacoes;
	}

	private Map<Topico, List<AvaliacaoResposta>> buildAvaliacoes(final AlunoAvaliacaoTurma alunoAvaliacaoTurma) {
		mapAvaliacoes = new HashMap<Topico, List<AvaliacaoResposta>>();

		for (final AvaliacaoResposta avaliacaoResposta : buildAvaliacaoRespostas(alunoAvaliacaoTurma)) {
			final Topico topico = buildTopicoFromAvaliacaoResposta(avaliacaoResposta);

			if (!mapAvaliacoes.containsKey(topico)) {
				mapAvaliacoes.put(topico, new ArrayList<AvaliacaoResposta>());
			}
			mapAvaliacoes.get(topico).add(avaliacaoResposta);
		}
		return mapAvaliacoes;
	}

	private Topico buildTopicoFromAvaliacaoResposta(final AvaliacaoResposta avaliacaoResposta) {
		final Pergunta pergunta = avaliacaoResposta.getPergunta();
		final List<FormularioItem> formulariosItens = pergunta.getFormularioItems();

		if (formulariosItens.size() > 1) {
			System.out.println("DEVERIA TER APENAS UM TOPICO");
		}

		for (final FormularioItem formularioItem : formulariosItens) {
			return formularioItem.getTopico();
		}
		return null;
	}

	private List<AvaliacaoResposta> buildAvaliacaoRespostas(final AlunoAvaliacaoTurma alunoAvaliacaoTurma) {
		if (alunoAvaliacaoTurma != null && alunoAvaliacaoTurma.getAvaliacaoRespostas() != null) {
			return alunoAvaliacaoTurma.getAvaliacaoRespostas();
		}
		return Collections.emptyList();
	}

	private AlunoAvaliacaoTurma searchAlunoAvaliacaoTurma() {
		try {
			final String hash = getHash();
			if (!StringUtils.isBlank(hash)) {
				final AvaliacaoHash avaliacaoHash = AvaliacaoHashUtils.buildAvaliacaoHashFromURLParameter(hash);
				return getService().searchAlunoAvaliacaoTurma(avaliacaoHash.getAlunoId(), avaliacaoHash.getTurmaId());
			}
		} catch(final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getHash() {
		final String urlHash = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("value");
		if (!StringUtils.isBlank(urlHash)) {
			hash = urlHash;
		}
		return hash;
	}

	@Override
	public AlunoAvaliacaoTurmaService getService() {
		return alunoAvaliacaoTurmaService;
	}

	@Override
	public String getModalTittle() {
		return null;
	}

	@Override
	public AlunoAvaliacaoTurma buildNewInstance() {
		return null;
	}

	@Override
	public String getModalWidth() {
		return "350px;";
	}

	@Override
	public String getModalHeight() {
		return "550px;";
	}

}
