package br.com.akconsultor.pretas;

import br.com.akconsultor.*;

public abstract class PecaPreta extends Peca {

	public void desfazPosicao() {
		Tabuleiro.temPecaPreta[this.posicaoColuna][this.posicaoLinha] = false;
		Tabuleiro.layout[this.posicaoColuna][this.posicaoLinha] = " ";
	}

	public void setPosicao(int coluna, int linha) {
		this.posicaoColuna = coluna;
		this.posicaoLinha = linha;
		Tabuleiro.temPecaPreta[coluna][linha] = true;
		Tabuleiro.layout[coluna][linha] = this.getNome();

	}

	public void getCapturou() {
		if (this.podeCapturar[this.posicaoColuna][this.posicaoLinha]) {
			Tabuleiro.temPecaBranca[this.posicaoColuna][this.posicaoLinha] = false;
			System.out.println("Peça branca capturada\n");
		}
	}

	public void protegeRei() {
		// verificando se precisa proteger para a direita
		for (int h = this.posicaoColuna; h > 0; h--) {
			if (Tabuleiro.reiPreto[0] == h && Tabuleiro.reiPreto[1] == this.posicaoLinha) {
				for (int i = this.posicaoColuna; i < 7; i++) {
					if (Tabuleiro.temPecaPreta[i + 1][this.posicaoLinha]) {
						break;
					}
					if (Tabuleiro.temPecaBranca[i + 1][this.posicaoLinha]
							&& Tabuleiro.layout[i + 1][this.posicaoLinha] == "T"
							|| Tabuleiro.layout[i + 1][this.posicaoLinha] == "D") {

						for (int j = 0; j < 8; j++) {
							for (int k = 0; k < 8; k++) {
								if (k != this.posicaoLinha) {
									this.verificaDestino[j][k] = false;
								}
							}
						}

						break;
					}
				}
			} else if (Tabuleiro.temPecaBranca[h][this.posicaoLinha] || Tabuleiro.temPecaPreta[h][this.posicaoLinha]) {
				break;
			}
		}

		// verificando se precisa proteger para a esquerda
		for (int h = this.posicaoColuna; h < 8; h++) {
			if (Tabuleiro.reiPreto[0] == h && Tabuleiro.reiPreto[1] == this.posicaoLinha) {
				for (int i = this.posicaoColuna; i > 0; i--) {
					if (Tabuleiro.temPecaPreta[i - 1][this.posicaoLinha]) {
						break;
					}
					if (Tabuleiro.temPecaBranca[i - 1][this.posicaoLinha]
							&& Tabuleiro.layout[i - 1][this.posicaoLinha] == "T"
							|| Tabuleiro.layout[i - 1][this.posicaoLinha] == "D") {

						for (int j = 0; j < 8; j++) {
							for (int k = 0; k < 8; k++) {
								if (k != this.posicaoLinha) {
									this.verificaDestino[j][k] = false;
								}
							}
						}

						break;
					}
				}
			} else if (Tabuleiro.temPecaBranca[h][this.posicaoLinha] || Tabuleiro.temPecaPreta[h][this.posicaoLinha]) {
				break;
			}
		}

		// verificando se precisa proteger para frente

		for (int h = this.posicaoColuna; h > 0; h--) {
			if (Tabuleiro.reiPreto[0] == this.posicaoColuna && Tabuleiro.reiPreto[1] == h) {
				for (int i = this.posicaoLinha; i < 7; i++) {
					if (Tabuleiro.temPecaPreta[this.posicaoColuna][i + 1]) {
						break;
					}
					if (Tabuleiro.temPecaBranca[this.posicaoColuna][i + 1]
							&& Tabuleiro.layout[this.posicaoColuna][i + 1] == "T"
							|| Tabuleiro.layout[this.posicaoColuna][i + 1] == "D") {
						for (int j = 0; j < 8; j++) {
							for (int k = 0; k < 8; k++) {
								if (j != this.posicaoColuna) {
									this.verificaDestino[j][k] = false;
								}
							}
						}

						break;
					}
				}
			} else if (Tabuleiro.temPecaBranca[this.posicaoColuna][h]
					|| Tabuleiro.temPecaPreta[this.posicaoColuna][h]) {
				break;
			}
		}

		// verificando se precisa proteger para trás
		for (int h = this.posicaoColuna; h < 8; h++) {
			if (Tabuleiro.reiPreto[0] == this.posicaoColuna && Tabuleiro.reiPreto[1] == h) {
				for (int i = this.posicaoLinha; i > 0; i--) {
					if (Tabuleiro.temPecaPreta[this.posicaoColuna][i - 1]) {
						break;
					}
					if (Tabuleiro.temPecaBranca[this.posicaoColuna][i - 1]
							&& Tabuleiro.layout[this.posicaoColuna][i - 1] == "T"
							|| Tabuleiro.layout[this.posicaoColuna][i - 1] == "D") {
						for (int j = 0; j < 8; j++) {
							for (int k = 0; k < 8; k++) {
								if (j != this.posicaoColuna) {
									this.verificaDestino[j][k] = false;
								}
							}
						}

						break;
					}
				}
			} else if (Tabuleiro.temPecaBranca[this.posicaoColuna][h]
					|| Tabuleiro.temPecaPreta[this.posicaoColuna][h]) {
				break;
			}
		}

		// verificando se precisa proteger para a diagonal direita-frente

		try {
		for (int g = this.posicaoColuna - 1; g > 0; g--) {
			int h = this.posicaoLinha - 1 - (this.posicaoColuna - 1 - g);
			if (Tabuleiro.reiPreto[0] == g && Tabuleiro.reiPreto[1] == h) {

				for (int i = this.posicaoColuna; i < 7; i++) {
					int j = this.posicaoLinha + (i - this.posicaoColuna);
//					try {
						if (Tabuleiro.temPecaPreta[i + 1][j + 1]) {
							break;
						}
						if (Tabuleiro.temPecaBranca[i + 1][j + 1] && Tabuleiro.layout[i + 1][j + 1] == "B"
								|| Tabuleiro.layout[i + 1][j + 1] == "D") {

							for (int k = 0; k < 8; k++) {
								for (int l = 0; l < 8; l++) {

									if (k == i + 1 && l == j + 1) {
									} else if (k == i && l == j) {
									} else if (k == i - 1 && l == j - 1) {
									} else if (k == i - 2 && l == j - 2) {
									} else if (k == i - 3 && l == j - 3) {
									} else {
										this.verificaDestino[k][l] = false;
									}

								}
							}
							break;
						}
//					} catch (ArrayIndexOutOfBoundsException ex) {
//						break;
//					}

				}
			} else if (Tabuleiro.temPecaBranca[g][h] || Tabuleiro.temPecaPreta[g][h]) {
				break;
			}
		}} catch (ArrayIndexOutOfBoundsException ex) {
			
		}

		// verificando se precisa proteger para a diagonal direita-trás

		try {
		for (int g = this.posicaoColuna - 1; g > 0; g--) {
			int h = this.posicaoLinha + 1 + (this.posicaoColuna - 1 - g);
			if (Tabuleiro.reiPreto[0] == g && Tabuleiro.reiPreto[1] == h) {
				for (int i = this.posicaoColuna; i < 7; i++) {
					int j = this.posicaoLinha - (i - this.posicaoColuna);
//					try {
						if (Tabuleiro.temPecaPreta[i + 1][j - 1]) {
							break;
						}
						if (Tabuleiro.temPecaBranca[i + 1][j - 1] && Tabuleiro.layout[i + 1][j - 1] == "B"
								|| Tabuleiro.layout[i + 1][j - 1] == "D") {

							for (int k = 0; k < 8; k++) {
								for (int l = 0; l < 8; l++) {

									if (k == i + 1 && l == j - 1) {
									} else if (k == i && l == j) {
									} else if (k == i - 1 && l == j + 1) {
									} else if (k == i - 2 && l == j + 2) {
									} else if (k == i - 3 && l == j + 3) {
									}

									else {
										this.verificaDestino[k][l] = false;
									}

								}
							}
							break;
						}
//					} catch (ArrayIndexOutOfBoundsException ex) {
//						break;
//					}

				}
			} else if (Tabuleiro.temPecaBranca[g][h] || Tabuleiro.temPecaPreta[g][h]) {
				break;
			}
		}} catch (ArrayIndexOutOfBoundsException ex) {
			
		}

		// verificando se precisa proteger para a diagonal esquerda-trás

		try {
		for (int g = this.posicaoColuna + 1; g < 8; g++) {
			int h = this.posicaoLinha + 1 + (g - (this.posicaoColuna + 1));
			if (Tabuleiro.reiPreto[0] == g && Tabuleiro.reiPreto[1] == h) {
				for (int i = this.posicaoColuna; i > 0; i--) {
					int j = this.posicaoLinha - (this.posicaoColuna - i);
//					try {
						if (Tabuleiro.temPecaPreta[i - 1][j - 1]) {
							break;
						}
						if (Tabuleiro.temPecaBranca[i - 1][j - 1] && Tabuleiro.layout[i - 1][j - 1] == "B"
								|| Tabuleiro.layout[i - 1][j - 1] == "D") {

							for (int k = 0; k < 8; k++) {
								for (int l = 0; l < 8; l++) {

									if (k != i - 1 && l != j - 1) {
									} else if (k == i && l == j) {
									} else if (k == i + 1 && l == j + 1) {
									} else if (k == i + 2 && l == j + 2) {
									} else if (k == i + 3 && l == j + 3) {
									} else {
										this.verificaDestino[k][l] = false;
									}

								}
							}
							break;
						}
//					} catch (ArrayIndexOutOfBoundsException ex) {
//						break;
//					}

				}
			} else if (Tabuleiro.temPecaBranca[g][h] || Tabuleiro.temPecaPreta[g][h]) {
				break;
			}
		}} catch (ArrayIndexOutOfBoundsException ex) {
			
		}

		// verificando se precisa proteger para a diagonal esquerda-frente

		try {
		for (int g = this.posicaoColuna + 1; g < 8; g++) {
			int h = this.posicaoLinha - 1 - (g - (this.posicaoColuna + 1));
			if (Tabuleiro.reiPreto[0] == g && Tabuleiro.reiPreto[1] == h) {
				for (int i = this.posicaoColuna; i > 0; i--) {
					int j = this.posicaoLinha + (this.posicaoColuna - i);
//					try {
						if (Tabuleiro.temPecaPreta[i - 1][j + 1]) {
							break;
						}
						if (Tabuleiro.temPecaBranca[i - 1][j + 1] && Tabuleiro.layout[i - 1][j + 1] == "B"
								|| Tabuleiro.layout[i - 1][j + 1] == "D") {

							for (int k = 0; k < 8; k++) {
								for (int l = 0; l < 8; l++) {

									if (k == i - 1 && l == j + 1) {
									} else if (k == i && l == j) {
									} else if (k == i + 1 && l == j - 1) {
									} else if (k == i + 2 && l == j - 2) {
									} else if (k == i + 3 && l == j - 3) {
									} else {
										this.verificaDestino[k][l] = false;
									}

								}
							}
							break;
						}
//					} catch (ArrayIndexOutOfBoundsException ex) {
//						break;
//					}

				}

			} else if (Tabuleiro.temPecaBranca[g][h] || Tabuleiro.temPecaPreta[g][h]) {
				break;
			}
		}} catch (ArrayIndexOutOfBoundsException ex) {
			
		}
	}

}
