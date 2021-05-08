package br.com.akconsultor.brancas;

import br.com.akconsultor.Tabuleiro;
import br.com.akconsultor.pretas.*;

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
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha]) {
				this.atrapalhaRei[this.posicaoColuna + 1][this.posicaoLinha] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode capturar para a esquerda
		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha]) {
				this.podeCapturar[this.posicaoColuna - 1][this.posicaoLinha] = true;
			}
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha]) {
				this.atrapalhaRei[this.posicaoColuna - 1][this.posicaoLinha] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode capturar para frente
		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][this.posicaoLinha + 1]) {
				this.podeCapturar[this.posicaoColuna][this.posicaoLinha + 1] = true;
			}
			if (Tabuleiro.temPecaBranca[this.posicaoColuna][this.posicaoLinha + 1]) {
				this.atrapalhaRei[this.posicaoColuna][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode capturar para trás
		try {
			if (Tabuleiro.temPecaPreta[this.posicaoColuna][this.posicaoLinha - 1]) {
				this.podeCapturar[this.posicaoColuna][this.posicaoLinha - 1] = true;
			}
			if (Tabuleiro.temPecaBranca[this.posicaoColuna][this.posicaoLinha - 1]) {
				this.atrapalhaRei[this.posicaoColuna][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode capturar para a diagonal direita-frente

		try {

			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha + 1]) {
				this.podeCapturar[this.posicaoColuna + 1][this.posicaoLinha + 1] = true;
			}
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha + 1]) {
				this.atrapalhaRei[this.posicaoColuna + 1][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode capturar para a diagonal direita-trás

		try {

			if (Tabuleiro.temPecaPreta[this.posicaoColuna + 1][this.posicaoLinha - 1]) {
				this.podeCapturar[this.posicaoColuna + 1][this.posicaoLinha - 1] = true;
			}
			if (Tabuleiro.temPecaBranca[this.posicaoColuna + 1][this.posicaoLinha - 1]) {
				this.atrapalhaRei[this.posicaoColuna + 1][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
		}

		// verificando se pode capturar para a diagonal esquerda-trás

		try {

			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoLinha - 1]) {
				this.podeCapturar[this.posicaoColuna - 1][this.posicaoLinha - 1] = true;
			}
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha - 1]) {
				this.atrapalhaRei[this.posicaoColuna - 1][this.posicaoLinha - 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se pode capturar para a diagonal esquerda-frente

		try {

			if (Tabuleiro.temPecaPreta[this.posicaoColuna - 1][this.posicaoColuna + 1]) {
				this.podeCapturar[this.posicaoColuna - 1][this.posicaoColuna + 1] = true;
			}
			if (Tabuleiro.temPecaBranca[this.posicaoColuna - 1][this.posicaoLinha + 1]) {
				this.atrapalhaRei[this.posicaoColuna - 1][this.posicaoLinha + 1] = true;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

	}

	public String getNome() {
		return nome;
	}

	public void setRei() {
		Tabuleiro.reiBranco[0] = this.posicaoColuna;
		Tabuleiro.reiBranco[1] = this.posicaoLinha;
	}

	public void protegeRei() {
		if (Tabuleiro.isVezDosBrancos()) {
			for (PecaPreta peca : Tabuleiro.listaPretas) {
				try {
					peca.getVerificaDestino();
				} catch (ArrayIndexOutOfBoundsException ex) {
				}
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						try {
							if (peca.getNome() == "i") {
								try {
									this.verificaDestino[peca.getPosicaoColuna() + 1][peca.getPosicaoLinha()
											- 1] = false;
								} catch (ArrayIndexOutOfBoundsException ex) {
								}
								try {
									this.verificaDestino[peca.getPosicaoColuna() - 1][peca.getPosicaoLinha()
											- 1] = false;
								} catch (ArrayIndexOutOfBoundsException ex) {
								}
							} else if (peca.verificaDestino[i][j] == true || peca.atrapalhaRei[i][j]) {
								this.verificaDestino[i][j] = false;
							}
						} catch (ArrayIndexOutOfBoundsException ex) {
						}
					}
				}
			}
		}
	}

	public ReiBranco() {

		casaInicial();
		Tabuleiro.listaBrancas.add(this);

	}

}
