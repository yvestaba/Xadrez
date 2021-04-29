package br.com.akconsultor.brancas;

import br.com.akconsultor.Tabuleiro;

public class TorreBranca extends PecaBranca {

	private String nome = "T";

	Tabuleiro tabuleiro = new Tabuleiro();

	@Override
	public void casaInicial() {
		if (Tabuleiro.temPecaBranca[0][0] == false) {
			this.setPosicao(0, 0);
		} else {
			this.setPosicao(7, 0);
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
				System.out.print(j +"," + i + "" + this.verificaDestino[j][i] + " ");
			}
			System.out.println();
		} System.out.println();
	}

	public String getNome() {
		return nome;
	}

	public TorreBranca() {

		casaInicial();

	}


}
