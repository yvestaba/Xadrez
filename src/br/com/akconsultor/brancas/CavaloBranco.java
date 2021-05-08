package br.com.akconsultor.brancas;

import br.com.akconsultor.Tabuleiro;

public class CavaloBranco extends PecaBranca {

	private String nome = "C";


	@Override
	public void casaInicial() {
		if (Tabuleiro.temPecaBranca[1][0] == false) {
			this.setPosicao(1, 0);
		} else {
			this.setPosicao(6, 0);
		}

	}

	@Override
	public void ondePodeAndar() {
		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha + 2] == false
					&& Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha + 2] == false) {
				this.podeMover[this.posicaoColuna + 1][this.posicaoLinha + 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha + 2] == false
					&& Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha + 2] == false) {
				this.podeMover[this.posicaoColuna - 1][this.posicaoLinha + 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha - 2] == false
					&& Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha - 2] == false) {
				this.podeMover[this.posicaoColuna - 1][this.posicaoLinha - 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha - 2] == false
					&& Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha - 2] == false) {
				this.podeMover[this.posicaoColuna + 1][this.posicaoLinha - 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 2][this.posicaoLinha + 1] == false
					&& Tabuleiro.temPecaPreta[this.posicaoColuna + 2][this.posicaoLinha + 1] == false) {
				this.podeMover[this.posicaoColuna + 2][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 2][this.posicaoLinha + 1] == false
					&& Tabuleiro.temPecaPreta[this.posicaoColuna - 2][this.posicaoLinha + 1] == false) {
				this.podeMover[this.posicaoColuna - 2][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 2][this.posicaoLinha - 1] == false
					&& Tabuleiro.temPecaPreta[this.posicaoColuna - 2][this.posicaoLinha - 1] == false) {
				this.podeMover[this.posicaoColuna - 2][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 2][this.posicaoLinha - 1] == false
					&& Tabuleiro.temPecaPreta[this.posicaoColuna + 2][this.posicaoLinha - 1] == false) {
				this.podeMover[this.posicaoColuna + 2][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

	}

	@Override
	public void podeCapturar() {
		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha + 2]) {
				this.podeCapturar[this.posicaoColuna + 1][this.posicaoLinha + 2] = true;
			}
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha + 2]) {
				this.atrapalhaRei[this.posicaoColuna + 1][this.posicaoLinha + 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha + 2]) {
				this.podeCapturar[this.posicaoColuna - 1][this.posicaoLinha + 2] = true;
			}
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha + 2]) {
				this.atrapalhaRei[this.posicaoColuna - 1][this.posicaoLinha + 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha - 2]) {
				this.podeCapturar[this.posicaoColuna - 1][this.posicaoLinha - 2] = true;
			}
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha - 2]) {
				this.atrapalhaRei[this.posicaoColuna - 1][this.posicaoLinha - 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha - 2]) {
				this.podeCapturar[this.posicaoColuna + 1][this.posicaoLinha - 2] = true;
			}
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha - 2]) {
				this.atrapalhaRei[this.posicaoColuna + 1][this.posicaoLinha - 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 2][this.posicaoLinha + 1]) {
				this.podeCapturar[this.posicaoColuna + 2][this.posicaoLinha + 1] = true;
			}
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 2][this.posicaoLinha + 1]) {
				this.atrapalhaRei[this.posicaoColuna + 2][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 2][this.posicaoLinha + 1]) {
				this.podeCapturar[this.posicaoColuna - 2][this.posicaoLinha + 1] = true;
			}
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 2][this.posicaoLinha + 1]) {
				this.atrapalhaRei[this.posicaoColuna - 2][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 2][this.posicaoLinha - 1]) {
				this.podeCapturar[this.posicaoColuna - 2][this.posicaoLinha - 1] = true;
			}
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 2][this.posicaoLinha - 1]) {
				this.atrapalhaRei[this.posicaoColuna - 2][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 2][this.posicaoLinha - 1]) {
				this.podeCapturar[this.posicaoColuna + 2][this.posicaoLinha - 1] = true;
			}
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 2][this.posicaoLinha - 1]) {
				this.atrapalhaRei[this.posicaoColuna + 2][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

	}

	public String getNome() {
		return nome;
	}

	public CavaloBranco() {

		casaInicial();
		Tabuleiro.listaBrancas.add(this);

	}



}
