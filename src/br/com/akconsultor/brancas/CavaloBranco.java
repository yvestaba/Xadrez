package br.com.akconsultor.brancas;

import br.com.akconsultor.Tabuleiro;

public class CavaloBranco extends PecaBranca {

	private String nome = "C";

	Tabuleiro tabuleiro = new Tabuleiro();

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
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha + 2]) {
				this.podeCapturar[this.posicaoColuna - 1][this.posicaoLinha + 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha - 2]) {
				this.podeCapturar[this.posicaoColuna - 1][this.posicaoLinha - 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha - 2]) {
				this.podeCapturar[this.posicaoColuna + 1][this.posicaoLinha - 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 2][this.posicaoLinha + 1]) {
				this.podeCapturar[this.posicaoColuna + 2][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 2][this.posicaoLinha + 1]) {
				this.podeCapturar[this.posicaoColuna - 2][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 2][this.posicaoLinha - 1]) {
				this.podeCapturar[this.posicaoColuna - 2][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 2][this.posicaoLinha - 1]) {
				this.podeCapturar[this.posicaoColuna + 2][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

	}

	@Override
	public void podeAndarOuCapturar() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (this.podeMover[i][j] || this.podeCapturar[i][j]) {
					this.verificaDestino[i][j] = true;
				}
			}
		}

	}

	@Override
	public void getVerificaDestino() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				this.verificaDestino[i][j] = false;
				this.podeMover[i][j] = false;
				this.podeCapturar[i][j] = false;
				this.podeMoverOuCapturar[i][j] = false;

			}
		}
		ondePodeAndar();
		podeCapturar();
		podeAndarOuCapturar();
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				System.out.print(j +"," + i + "" + this.verificaDestino[j][i] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

	public String getNome() {
		return nome;
	}

	public CavaloBranco() {

		casaInicial();

	}



}
