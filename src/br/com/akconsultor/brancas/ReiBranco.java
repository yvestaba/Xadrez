package br.com.akconsultor.brancas;

import br.com.akconsultor.Tabuleiro;

public class ReiBranco extends PecaBranca {

	private String nome = "R";

	@Override
	public void casaInicial() {
		this.setPosicao(4, 0);
	}

	@Override
	public void ondePodeAndar() {

		// verificando se pode andar para a direita
		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha]) {

			} else {
				this.podeMover[this.posicaoColuna + 1][this.posicaoLinha] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode andar para a esquerda
		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha]) {

			} else {
				this.podeMover[this.posicaoColuna - 1][this.posicaoLinha] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode andar para frente
		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][this.posicaoLinha + 1]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna][this.posicaoLinha + 1]) {

			} else {
				this.podeMover[this.posicaoColuna][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode andar para trás
		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][this.posicaoLinha - 1]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna][this.posicaoLinha - 1]) {

			} else {
				this.podeMover[this.posicaoColuna][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode andar para a diagonal direita-frente

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha + 1]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha + 1]) {

			} else {
				this.podeMover[this.posicaoColuna + 1][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode andar para a diagonal direita-trás

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha - 1]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha - 1]) {
			} else {
				this.podeMover[this.posicaoColuna + 1][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
		}

		// verificando se pode andar para a diagonal esquerda-trás

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha - 1]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha - 1]) {

			} else {
				this.podeMover[this.posicaoColuna - 1][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode andar para a diagonal esquerda-frente

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha + 1]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha + 1]) {

			} else {
				this.podeMover[this.posicaoColuna - 1][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

	}

	@Override
	public void podeCapturar() {
		// verificando se pode capturar para a direita
		try {
		if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha]) {
			this.podeCapturar[this.posicaoColuna + 1][this.posicaoLinha] = true;

		}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode capturar para a esquerda
		try {
		if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha]) {
			this.podeCapturar[this.posicaoColuna - 1][this.posicaoLinha] = true;

		}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode capturar para frente
		try {
		if (Tabuleiro.temPecaPreta[this.posicaoColuna][this.posicaoLinha + 1]) {
			this.podeCapturar[this.posicaoColuna][this.posicaoLinha + 1] = true;
		}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode capturar para trás
		try {
		if (Tabuleiro.temPecaPreta[this.posicaoColuna][this.posicaoLinha - 1]) {
			this.podeCapturar[this.posicaoColuna][this.posicaoLinha - 1] = true;

		}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode capturar para a diagonal direita-frente

		try {

			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha + 1]) {
				this.podeCapturar[this.posicaoColuna + 1][this.posicaoLinha + 1] = true;

			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode capturar para a diagonal direita-trás

		try {

			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha - 1]) {
				this.podeCapturar[this.posicaoColuna + 1][this.posicaoLinha - 1] = true;

			}
		} catch (ArrayIndexOutOfBoundsException ex) {
		}

		// verificando se pode capturar para a diagonal esquerda-trás

		try {

			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha - 1]) {
				this.podeCapturar[this.posicaoColuna - 1][this.posicaoLinha - 1] = true;

			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode capturar para a diagonal esquerda-frente

		try {

			if (Tabuleiro.temPecaPreta[this.posicaoLinha - 1][this.posicaoColuna + 1]) {
				this.podeCapturar[this.posicaoLinha - 1][this.posicaoColuna + 1] = true;

			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

	}

	public String getNome() {
		return nome;
	}

	public ReiBranco() {

		casaInicial();

	}

}
