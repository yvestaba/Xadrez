package br.com.akconsultor.brancas;

import br.com.akconsultor.Tabuleiro;

public class TorreBranca extends PecaBranca {

	private String nome = "T";


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
				this.podeMover[i + 1][this.posicaoLinha] = true;
			}
		}

		// verificando se pode andar para a esquerda
		for (int i = this.posicaoColuna; i > 0; i--) {
			if (Tabuleiro.temPecaPreta[i - 1][this.posicaoLinha]
					|| Tabuleiro.temPecaBranca[i - 1][this.posicaoLinha]) {
				break;
			} else {
				this.podeMover[i - 1][this.posicaoLinha] = true;
			}
		}

		// verificando se pode andar para frente
		for (int i = this.posicaoLinha; i < 7; i++) {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][i + 1]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna][i + 1]) {
				break;
			} else {
				this.podeMover[this.posicaoColuna][i + 1] = true;
			}
		}

		// verificando se pode andar para tr�s
		for (int i = this.posicaoLinha; i > 0; i--) {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][i - 1]
					|| Tabuleiro.temPecaBranca[this.posicaoColuna][i - 1]) {
				break;
			} else {
				this.podeMover[this.posicaoColuna][i - 1] = true;
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
				this.podeCapturar[i + 1][this.posicaoLinha] = true;
				break;
			}
		}

		// verificando se pode capturar para a esquerda
		for (int i = this.posicaoColuna; i > 0; i--) {
			if (Tabuleiro.temPecaBranca[i - 1][this.posicaoLinha]) {
				break;
			}
			if (Tabuleiro.temPecaPreta[i - 1][this.posicaoLinha]) {
				this.podeCapturar[i - 1][this.posicaoLinha] = true;
				break;
			}
		}

		// verificando se pode capturar para frente
		for (int i = this.posicaoLinha; i < 7; i++) {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna][i + 1]) {
				break;
			}
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][i + 1]) {
				this.podeCapturar[this.posicaoColuna][i + 1] = true;
				break;
			}
		}

		// verificando se pode capturar para tr�s
		for (int i = this.posicaoLinha; i > 0; i--) {
			if (Tabuleiro.temPecaBranca[this.posicaoColuna][i - 1]) {
				break;
			}
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][i - 1]) {
				this.podeCapturar[this.posicaoColuna][i - 1] = true;
				break;
			}
		}

	}

	public String getNome() {
		return nome;
	}

	public TorreBranca() {

		casaInicial();
		Tabuleiro.listaBrancas.add(this);

	}


}
