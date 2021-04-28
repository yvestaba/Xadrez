package br.com.akconsultor;

public class CavaloBranco extends PecaBranca {

	private String nome = "C";

	Tabuleiro tabuleiro = new Tabuleiro();

	@Override
	public void casaInicial() {
		if (Tabuleiro.temPecaBranca[1][0] == false) {
			this.posicaoColuna = 1;
			this.posicaoLinha = 0;
			Tabuleiro.temPecaBranca[1][0] = true;
			Tabuleiro.layout[1][0] = this.nome;
		} else {
			this.posicaoColuna = 6;
			this.posicaoLinha = 0;
			Tabuleiro.temPecaBranca[6][0] = true;
			Tabuleiro.layout[6][0] = this.nome;
		}

	}

	@Override
	public void ondePodeAndar() {
		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha + 2] == false
					|| Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha + 2] == false) {
				this.tabuleiro.podeMover[this.posicaoColuna + 1][this.posicaoLinha + 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha + 2] == false
					|| Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha + 2] == false) {
				this.tabuleiro.podeMover[this.posicaoColuna - 1][this.posicaoLinha + 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha - 2] == false
					|| Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha - 2] == false) {
				this.tabuleiro.podeMover[this.posicaoColuna - 1][this.posicaoLinha - 2] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		try {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha - 2] == false
					|| Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha - 2] == false) {
				this.tabuleiro.podeMover[this.posicaoColuna + 1][this.posicaoLinha - 2] = true;
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
		ondePodeAndar();
		podeCapturar();
		podeAndarOuCapturar();
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				System.out.print(this.verificaDestino[j][i] + " ");
			}
			System.out.println();
		} System.out.println();

	}
	
	public int getPosicaoColuna() {
		return posicaoColuna;
	}

	public void setPosicaoColuna(int posicaoColuna) {
		this.posicaoColuna = posicaoColuna;
	}

	public int getPosicaoLinha() {
		return posicaoLinha;
	}

	public void setPosicaoLinha(int posicaoLinha) {
		this.posicaoLinha = posicaoLinha;
	}

	public String getNome() {
		return nome;
	}

	CavaloBranco() {

		casaInicial();

	}

}
