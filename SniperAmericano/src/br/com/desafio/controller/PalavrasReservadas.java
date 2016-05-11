package br.com.desafio.controller;

public enum PalavrasReservadas {

	INCIO_PARTIDA {
		@Override
		public String toString() {
			return "has started";
		}
	},

	FIM_PARTIDA {
		@Override
		public String toString() {
			return "has ended";
		}
	},

	ASSASSINATO {
		@Override
		public String toString() {
			return "killed";
		}

	},
	
	JOGADOR_ABSOLUTO {
		@Override
		public String toString() {
			return "<WORLD>";
		}
	}
}