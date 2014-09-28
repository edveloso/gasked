package br.com.eveloso.gasked.jetty.dto;

public class JogadorDTO {

	private String name;
	
	private PartidaDTO partida;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PartidaDTO getPartida() {
		return partida;
	}

	public void setPartida(PartidaDTO partida) {
		this.partida = partida;
	}
	
	
}
