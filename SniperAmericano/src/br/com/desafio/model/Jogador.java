package br.com.desafio.model;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

	private String nome;
	private List<Jogador> assassinatos = new ArrayList<Jogador>();
	private int morte = 0;
	private String arma;
	
	public Jogador(String nome) {
		this.nome = nome;
	}

	public Jogador(String nome, String arma) {
		this.nome = nome;
		this.arma = arma;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Jogador> getAssassinatos() {
		return assassinatos;
	}
	
	public void addAssassinato(Jogador assassinado) {
		this.assassinatos.add(assassinado);
	}
	
	public void quantidadeDeMortes() {
		this.morte++;
	}
	
	public int getMortes() {
		return morte;
	}
	
	public String getArma() {
		return arma;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        return hash;
    }
}
