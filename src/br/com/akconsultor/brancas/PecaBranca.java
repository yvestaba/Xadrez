package br.com.akconsultor.brancas;

import br.com.akconsultor.Direcao;
import br.com.akconsultor.Peca;
import br.com.akconsultor.Tabuleiro;

public abstract class PecaBranca extends Peca{

	public void desfazPosicao() {
		Tabuleiro.temPecaBranca[this.posicaoColuna][this.posicaoLinha] = false;
		Tabuleiro.layout[this.posicaoColuna][this.posicaoLinha] = " ";
	}

	public void setPosicao(int coluna, int linha) {
		this.posicaoColuna = coluna;
		this.posicaoLinha = linha;
		Tabuleiro.temPecaBranca[coluna][linha] = true;
		Tabuleiro.layout[coluna][linha] = this.getNome();

	}
	
	public void getCapturou() {
		if(this.podeCapturar[this.posicaoColuna][this.posicaoLinha]) {
			Tabuleiro.temPecaPreta[this.posicaoColuna][this.posicaoLinha] = false;
			System.out.println("Peça preta capturada\n");
		}
	}
	
	public void resolveCheck() {
		if (Tabuleiro.getQuantasPecasFazemCheck() > 1) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {

					this.verificaDestino[i][j] = false;

				}
			}
		} else {
			if (Tabuleiro.getDirecaoCheck() == Direcao.ELE) {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (i == Tabuleiro.getColunaCheck() && j == Tabuleiro.getLinhaCheck()) {

						} else {
							this.verificaDestino[i][j] = false;
						}
					}
				}
			} else if (Tabuleiro.getDirecaoCheck() == Direcao.HORIZONTAL) {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (j == Tabuleiro.getLinhaCheck()) {
							if (Tabuleiro.reiBranco[0] < Tabuleiro.getColunaCheck() && i <= Tabuleiro.getColunaCheck()
									&& i > Tabuleiro.reiBranco[0]) {

							} else if (Tabuleiro.reiBranco[0] > Tabuleiro.getColunaCheck()
									&& i >= Tabuleiro.getColunaCheck() && i < Tabuleiro.reiBranco[0]) {

							} else {
								this.verificaDestino[i][j] = false;
							}
						} else {
							this.verificaDestino[i][j] = false;
						}
					}
				}
			} else if (Tabuleiro.getDirecaoCheck() == Direcao.VERTICAL) {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (i == Tabuleiro.getColunaCheck()) {
							if (Tabuleiro.reiBranco[1] < Tabuleiro.getLinhaCheck() && j <= Tabuleiro.getLinhaCheck()
									&& j > Tabuleiro.reiBranco[1]) {

							} else if (Tabuleiro.reiBranco[1] > Tabuleiro.getLinhaCheck()
									&& j >= Tabuleiro.getLinhaCheck() && j < Tabuleiro.reiBranco[1]) {

							} else {
								this.verificaDestino[i][j] = false;
							}
						} else {
							this.verificaDestino[i][j] = false;
						}
					}
				}
			} else if (Tabuleiro.getDirecaoCheck() == Direcao.DIAGONALHORARIO) {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (Tabuleiro.reiBranco[0] < Tabuleiro.getColunaCheck()
								&& i - Tabuleiro.getColunaCheck() == j - Tabuleiro.getLinhaCheck()
								&& i > Tabuleiro.reiBranco[0] && i <= Tabuleiro.getColunaCheck()) {

						} else if (Tabuleiro.reiBranco[0] > Tabuleiro.getColunaCheck()
								&& i - Tabuleiro.getColunaCheck() == j - Tabuleiro.getLinhaCheck()
								&& i < Tabuleiro.reiBranco[0] && i >= Tabuleiro.getColunaCheck()) {

						} else {

							this.verificaDestino[i][j] = false;
						}
					}
				}
			} else if (Tabuleiro.getDirecaoCheck() == Direcao.DIAGONALANTIHORARIO) {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (Tabuleiro.reiBranco[0] < Tabuleiro.getColunaCheck()
								&& i - Tabuleiro.getColunaCheck() == -1 * (j - Tabuleiro.getLinhaCheck())
								&& i > Tabuleiro.reiBranco[0] && i <= Tabuleiro.getColunaCheck()) {

						} else if (Tabuleiro.reiBranco[0] > Tabuleiro.getColunaCheck()
								&& i - Tabuleiro.getColunaCheck() == -1 * (j - Tabuleiro.getLinhaCheck())
								&& i < Tabuleiro.reiBranco[0] && i >= Tabuleiro.getColunaCheck()) {

						} else {

							this.verificaDestino[i][j] = false;
						}
					}
				}
			}
		}
	}
	
	public void protegeRei() {
		if(Tabuleiro.isVezDosBrancos()) {
		// verificando se precisa proteger para a direita
		for (int h = this.posicaoColuna - 1; h > 0; h--) {
			if (Tabuleiro.reiBranco[0] == h && Tabuleiro.reiBranco[1] == this.posicaoLinha) {
				for (int i = this.posicaoColuna; i < 7; i++) {
					
					if (Tabuleiro.temPecaPreta[i + 1][this.posicaoLinha]
							&& Tabuleiro.layout[i + 1][this.posicaoLinha] == "t"
							|| Tabuleiro.layout[i + 1][this.posicaoLinha] == "d") {

						for (int j = 0; j < 8; j++) {
							for (int k = 0; k < 8; k++) {
								if (k != this.posicaoLinha) {
									this.verificaDestino[j][k] = false;
								}
							}
						}

						break;
					} else if (Tabuleiro.temPecaBranca[i + 1][this.posicaoLinha] || Tabuleiro.temPecaPreta[i + 1][this.posicaoLinha]) {
						break;
					}
				}
			} else if (Tabuleiro.temPecaBranca[h][this.posicaoLinha] || Tabuleiro.temPecaPreta[h][this.posicaoLinha]) {
				break;
			}
		}

		// verificando se precisa proteger para a esquerda
		for (int h = this.posicaoColuna + 1; h < 8; h++) {
			if (Tabuleiro.reiBranco[0] == h && Tabuleiro.reiBranco[1] == this.posicaoLinha) {
				for (int i = this.posicaoColuna; i > 0; i--) {
					
					if (Tabuleiro.temPecaPreta[i - 1][this.posicaoLinha]
							&& Tabuleiro.layout[i - 1][this.posicaoLinha] == "t"
							|| Tabuleiro.layout[i - 1][this.posicaoLinha] == "d") {

						for (int j = 0; j < 8; j++) {
							for (int k = 0; k < 8; k++) {
								if (k != this.posicaoLinha) {
									this.verificaDestino[j][k] = false;
								}
							}
						}

						break;
					} else if (Tabuleiro.temPecaBranca[i - 1][this.posicaoLinha] || Tabuleiro.temPecaPreta[i - 1][this.posicaoLinha]) {
						break;
					}
				}
			} else if (Tabuleiro.temPecaBranca[h][this.posicaoLinha] || Tabuleiro.temPecaPreta[h][this.posicaoLinha]) {
				break;
			}
		}

		// verificando se precisa proteger para frente

		for (int h = this.posicaoLinha - 1; h > 0; h--) {
			if (Tabuleiro.reiBranco[0] == this.posicaoColuna && Tabuleiro.reiBranco[1] == h) {
				for (int i = this.posicaoLinha; i < 7; i++) {
					
					if (Tabuleiro.temPecaPreta[this.posicaoColuna][i + 1]
							&& Tabuleiro.layout[this.posicaoColuna][i + 1] == "t"
							|| Tabuleiro.layout[this.posicaoColuna][i + 1] == "d") {
						for (int j = 0; j < 8; j++) {
							for (int k = 0; k < 8; k++) {
								if (j != this.posicaoColuna) {
									this.verificaDestino[j][k] = false;
								}
							}
						}

						break;
					} else if (Tabuleiro.temPecaBranca[this.posicaoColuna][i + 1] || Tabuleiro.temPecaPreta[this.posicaoColuna][i + 1]) {
						break;
					}
				}
			} else if (Tabuleiro.temPecaBranca[this.posicaoColuna][h]
					|| Tabuleiro.temPecaPreta[this.posicaoColuna][h]) {
				break;
			}
		}

		// verificando se precisa proteger para trás
		for (int h = this.posicaoLinha + 1; h < 8; h++) {
			if (Tabuleiro.reiBranco[0] == this.posicaoColuna && Tabuleiro.reiBranco[1] == h) {
				for (int i = this.posicaoLinha; i > 0; i--) {
					
					if (Tabuleiro.temPecaPreta[this.posicaoColuna][i - 1]
							&& Tabuleiro.layout[this.posicaoColuna][i - 1] == "t"
							|| Tabuleiro.layout[this.posicaoColuna][i - 1] == "d") {
						for (int j = 0; j < 8; j++) {
							for (int k = 0; k < 8; k++) {
								if (j != this.posicaoColuna) {
									this.verificaDestino[j][k] = false;
								}
							}
						}

						break;
					} else if (Tabuleiro.temPecaBranca[this.posicaoColuna][i - 1] || Tabuleiro.temPecaPreta[this.posicaoColuna][i - 1]) {
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
				if (Tabuleiro.reiBranco[0] == g && Tabuleiro.reiBranco[1] == h) {

					for (int i = this.posicaoColuna; i < 7; i++) {
						int j = this.posicaoLinha + (i - this.posicaoColuna);

						
						if (Tabuleiro.temPecaPreta[i + 1][j + 1] && Tabuleiro.layout[i + 1][j + 1] == "b"
								|| Tabuleiro.layout[i + 1][j + 1] == "d") {

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
						} else if (Tabuleiro.temPecaBranca[i + 1][j + 1] || Tabuleiro.temPecaPreta[i + 1][j + 1]) {
							break;
						}


					}
				} else if (Tabuleiro.temPecaBranca[g][h] || Tabuleiro.temPecaPreta[g][h]) {
					break;
				}
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se precisa proteger para a diagonal direita-trás

		try {
			for (int g = this.posicaoColuna - 1; g > 0; g--) {
				int h = this.posicaoLinha + 1 + (this.posicaoColuna - 1 - g);
				if (Tabuleiro.reiBranco[0] == g && Tabuleiro.reiBranco[1] == h) {
					for (int i = this.posicaoColuna; i < 7; i++) {
						int j = this.posicaoLinha - (i - this.posicaoColuna);

						
						if (Tabuleiro.temPecaPreta[i + 1][j - 1] && Tabuleiro.layout[i + 1][j - 1] == "b"
								|| Tabuleiro.layout[i + 1][j - 1] == "d") {

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
						} else if (Tabuleiro.temPecaBranca[i + 1][j - 1] || Tabuleiro.temPecaPreta[i + 1][j - 1]) {
							break;
						}

					}
				} else if (Tabuleiro.temPecaBranca[g][h] || Tabuleiro.temPecaPreta[g][h]) {
					break;
				}
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se precisa proteger para a diagonal esquerda-trás

		try {
			for (int g = this.posicaoColuna + 1; g < 8; g++) {
				int h = this.posicaoLinha + 1 + (g - (this.posicaoColuna + 1));
				if (Tabuleiro.reiBranco[0] == g && Tabuleiro.reiBranco[1] == h) {
					for (int i = this.posicaoColuna; i > 0; i--) {
						int j = this.posicaoLinha - (this.posicaoColuna - i);

						
						if (Tabuleiro.temPecaPreta[i - 1][j - 1] && Tabuleiro.layout[i - 1][j - 1] == "b"
								|| Tabuleiro.layout[i - 1][j - 1] == "d") {

							for (int k = 0; k < 8; k++) {
								for (int l = 0; l < 8; l++) {

									if (k == i - 1 && l == j - 1) {
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
						} else if (Tabuleiro.temPecaBranca[i - 1][j - 1] || Tabuleiro.temPecaPreta[i - 1][j - 1]) {
							break;
						}

					}
				} else if (Tabuleiro.temPecaBranca[g][h] || Tabuleiro.temPecaPreta[g][h]) {
					break;
				}
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}

		// verificando se precisa proteger para a diagonal esquerda-frente

		try {
			for (int g = this.posicaoColuna + 1; g < 8; g++) {
				int h = this.posicaoLinha - 1 - (g - (this.posicaoColuna + 1));
				if (Tabuleiro.reiBranco[0] == g && Tabuleiro.reiBranco[1] == h) {
					for (int i = this.posicaoColuna; i > 0; i--) {
						int j = this.posicaoLinha + (this.posicaoColuna - i);

						
						if (Tabuleiro.temPecaPreta[i - 1][j + 1] && Tabuleiro.layout[i - 1][j + 1] == "b"
								|| Tabuleiro.layout[i - 1][j + 1] == "d") {

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
						} else if (Tabuleiro.temPecaBranca[i - 1][j + 1] || Tabuleiro.temPecaPreta[i - 1][j + 1]) {
							break;
						}

					}

				} else if (Tabuleiro.temPecaBranca[g][h] || Tabuleiro.temPecaPreta[g][h]) {
					break;
				}
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}
		}
	}
	
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
		protegeRei();
		if (Tabuleiro.isCheck() && Tabuleiro.isVezDosBrancos()) {
			this.resolveCheck();
		}
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				System.out.print(j +"," + i + "" + this.verificaDestino[j][i] + " ");
			}
			System.out.println();
		} System.out.println();

	}

}
