package br.com.eveloso.gasked.jetty.dto;

public class JogadorDTO {

	private String name;
	
	private PlayerDTO partida;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerDTO getPartida() {
		return partida;
	}

	public void setPartida(PlayerDTO partida) {
		this.partida = partida;
	}
	
	
}
