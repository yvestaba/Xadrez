package br.com.akconsultor.pretas;

import br.com.akconsultor.Tabuleiro;

public class CavaloPreto extends PecaPreta{
	private String nome = "c";


	@Override
	public void casaInicial() {
		if (Tabuleiro.temPecaPreta[6][7] == false) {
			this.setPosicao(6, 7);
		} else {
			this.setPosicao(1, 7);
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
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha + 2]) {
				this.podeCapturar[this.posicaoColuna + 1][this.posicaoLinha + 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha + 2]) {
				this.podeCapturar[this.posicaoColuna - 1][this.posicaoLinha + 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha - 2]) {
				this.podeCapturar[this.posicaoColuna - 1][this.posicaoLinha - 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha - 2]) {
				this.podeCapturar[this.posicaoColuna + 1][this.posicaoLinha - 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 2][this.posicaoLinha + 1]) {
				this.podeCapturar[this.posicaoColuna + 2][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 2][this.posicaoLinha + 1]) {
				this.podeCapturar[this.posicaoColuna - 2][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 2][this.posicaoLinha - 1]) {
				this.podeCapturar[this.posicaoColuna - 2][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 2][this.posicaoLinha - 1]) {
				this.podeCapturar[this.posicaoColuna + 2][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

	}


	

	public String getNome() {
		return nome;
	}



	public CavaloPreto() {

		casaInicial();
		Tabuleiro.listaPretas.add(this);

	}

}
