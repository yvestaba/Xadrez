package br.com.akconsultor;

public class TorreBranca extends PecaBranca {

	private String nome = "T";

	Tabuleiro tabuleiro = new Tabuleiro();

	@Override
	public void casaInicial() {
		if (Tabuleiro.temPecaBranca[0][0] == false) {
			this.posicaoColuna = 0;
			this.posicaoLinha = 0;
			Tabuleiro.temPecaBranca[0][0] = true;
			Tabuleiro.layout[0][0] = this.nome;
		} else {
			this.posicaoColuna = 7;
			this.posicaoLinha = 0;
			Tabuleiro.temPecaBranca[7][0] = true;
			Tabuleiro.layout[7][0] = this.nome;
		}

	}

	@Override
	public void ondePodeAndar() {

		// verificando se pode andar para a direita
		for (int i = this.posicaoColuna; i < 7; i++) {
			if (Tabuleiro.temPecaPreta[i + 1][this.posicaoLinha]
					|| Tabuleiro.temPecaBranca[i + 1][this.posicaoLinha]) {
				break;
			} else {
				this.tabuleiro.podeMover[i + 1][this.posicaoLinha] = true;
			}
		}

		// verificando se pode andar para a esquerda
		for (int i = this.posicaoColuna; i > 0; i--) {
			if (Tabuleiro.temPecaPreta[i - 1][this.posicaoLinha]
					|| Tabuleiro.temPecaBranca[i - 1][this.posicaoLinha]) {
				break;
			} else {
				this.tabuleiro.podeMover[i - 1][this.posicaoLinha] = true;
			}
		}

		// verificando se pode andar para frente
		for (int i = this.posicaoLinha; i < 7; i++) {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][i + 1]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna][i + 1]) {
				break;
			} else {
				this.tabuleiro.podeMover[this.posicaoColuna][i + 1] = true;
			}
		}

		// verificando se pode andar para trás
		for (int i = this.posicaoLinha; i > 0; i--) {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][i - 1]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna][i + 1]) {
				break;
			} else {
				this.tabuleiro.podeMover[this.posicaoColuna][i - 1] = true;
			}
		}

	}

	@Override
	public void podeCapturar() {
		// verificando se pode capturar para a direita
		for (int i = this.posicaoColuna; i < 7; i++) {
			if (Tabuleiro.temPecaBranca[i + 1][this.posicaoLinha]) {
				break;
			}
			if (Tabuleiro.temPecaPreta[i + 1][this.posicaoLinha]) {
				this.tabuleiro.podeCapturar[i + 1][this.posicaoLinha] = true;
				break;
			}
		}

		// verificando se pode capturar para a esquerda
		for (int i = this.posicaoColuna; i > 0; i--) {
			if (Tabuleiro.temPecaBranca[i - 1][this.posicaoLinha]) {
				break;
			}
			if (Tabuleiro.temPecaPreta[i - 1][this.posicaoLinha]) {
				this.tabuleiro.podeCapturar[i - 1][this.posicaoLinha] = true;
				break;
			}
		}

		// verificando se pode capturar para frente
		for (int i = this.posicaoLinha; i < 7; i++) {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna][i + 1]) {
				break;
			}
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][i + 1]) {
				this.tabuleiro.podeCapturar[this.posicaoColuna][i + 1] = true;
				break;
			}
		}

		// verificando se pode capturar para trás
		for (int i = this.posicaoLinha; i > 0; i--) {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna][i - 1]) {
				break;
			}
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][i - 1]) {
				this.tabuleiro.podeCapturar[this.posicaoColuna][i - 1] = true;
				break;
			}
		}

	}

	public void podeAndarOuCapturar() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (this.tabuleiro.podeMover[i][j] || this.tabuleiro.podeCapturar[i][j]) {
					this.verificaDestino[i][j] = true;
				}
			}
		}
	}

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

	TorreBranca() {

		casaInicial();

	}

}
