package br.com.decision.enumeration;

public enum LikertEnum {

	CONCORDO_TOTALMENTE(0, "Concordo totalmente"),
	CONCORDO(1, "Concordo"),
	NAO_CONCORDO_NEM_DISCORDO(2, "Não concordo nem discordo"),
	DISCORDO(3, "Discordo"),
	DISCORDO_TOTALMENTE(4, "Discordo totalmente"),
	NAO_SEI_AVALIAR(5, "Não sei avaliar");

	private int cod;
	private String descricao;

	private LikertEnum(final int cod, final String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

}