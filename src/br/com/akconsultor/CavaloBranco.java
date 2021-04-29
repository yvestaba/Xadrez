package br.com.akconsultor;

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
				this.tabuleiro.podeMover[this.posicaoColuna + 1][this.posicaoLinha + 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha + 2] == false
					&& Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha + 2] == false) {
				this.tabuleiro.podeMover[this.posicaoColuna - 1][this.posicaoLinha + 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha - 2] == false
					&& Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha - 2] == false) {
				this.tabuleiro.podeMover[this.posicaoColuna - 1][this.posicaoLinha - 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha - 2] == false
					&& Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha - 2] == false) {
				this.tabuleiro.podeMover[this.posicaoColuna + 1][this.posicaoLinha - 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 2][this.posicaoLinha + 1] == false
					&& Tabuleiro.temPecaPreta[this.posicaoColuna + 2][this.posicaoLinha + 1] == false) {
				this.tabuleiro.podeMover[this.posicaoColuna + 2][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 2][this.posicaoLinha + 1] == false
					&& Tabuleiro.temPecaPreta[this.posicaoColuna - 2][this.posicaoLinha + 1] == false) {
				this.tabuleiro.podeMover[this.posicaoColuna - 2][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 2][this.posicaoLinha - 1] == false
					&& Tabuleiro.temPecaPreta[this.posicaoColuna - 2][this.posicaoLinha - 1] == false) {
				this.tabuleiro.podeMover[this.posicaoColuna - 2][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 2][this.posicaoLinha - 1] == false
					&& Tabuleiro.temPecaPreta[this.posicaoColuna + 2][this.posicaoLinha - 1] == false) {
				this.tabuleiro.podeMover[this.posicaoColuna + 2][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

	}

	@Override
	public void podeCapturar() {
		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha + 2]) {
				this.tabuleiro.podeCapturar[this.posicaoColuna + 1][this.posicaoLinha + 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha + 2]) {
				this.tabuleiro.podeCapturar[this.posicaoColuna - 1][this.posicaoLinha + 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha - 2]) {
				this.tabuleiro.podeCapturar[this.posicaoColuna - 1][this.posicaoLinha - 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha - 2]) {
				this.tabuleiro.podeCapturar[this.posicaoColuna + 1][this.posicaoLinha - 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 2][this.posicaoLinha + 1]) {
				this.tabuleiro.podeCapturar[this.posicaoColuna + 2][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 2][this.posicaoLinha + 1]) {
				this.tabuleiro.podeCapturar[this.posicaoColuna - 2][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 2][this.posicaoLinha - 1]) {
				this.tabuleiro.podeCapturar[this.posicaoColuna - 2][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 2][this.posicaoLinha - 1]) {
				this.tabuleiro.podeCapturar[this.posicaoColuna + 2][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

	}

	@Override
	public void podeAndarOuCapturar() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (this.tabuleiro.podeMover[i][j] || this.tabuleiro.podeCapturar[i][j]) {
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
				this.tabuleiro.podeMover[i][j] = false;
				this.tabuleiro.podeCapturar[i][j] = false;
				this.tabuleiro.podeMoverOuCapturar[i][j] = false;

			}
		}
		ondePodeAndar();
		podeCapturar();
		podeAndarOuCapturar();
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				System.out.print(this.verificaDestino[j][i] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

	public String getNome() {
		return nome;
	}

	CavaloBranco() {

		casaInicial();

	}



}
