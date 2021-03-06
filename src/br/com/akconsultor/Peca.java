package br.com.akconsultor;

public abstract class Peca {
	protected int posicaoColuna;
	protected int posicaoLinha;
	protected String nome;
	public boolean[][] verificaDestino = new boolean[8][8];
	/*
	 * vari?vel criada somente para proibir o rei de andar em certas casas proibidas
	 * logo abaixo
	 */
	public boolean[][] atrapalhaRei = new boolean[8][8];
	protected boolean[][] podeMover = new boolean[8][8];
	protected boolean[][] podeCapturar = new boolean[8][8];
	protected boolean[][] podeMoverOuCapturar = new boolean[8][8];
	protected boolean enPassantDireita = false;
	protected boolean enPassantEsquerda = false;

	public abstract void setPosicao(int coluna, int linha);

	protected abstract void casaInicial();

	public abstract void ondePodeAndar();

	public abstract void podeCapturar();

	public void podeAndarOuCapturar() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (this.podeMover[i][j] || this.podeCapturar[i][j]) {
					this.verificaDestino[i][j] = true;
				}
			}
		}

	}

	/*
	 * m?todo usado antes de mover pe?as. Alguns m?todos chamam este, ent?o ? normal
	 * visualizar v?rias verifica??es de destino, mesmo sem cham?-las diretamente
	 */
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
		// se a pe?a est? no meio da linha de fogo para o rei, ela n?o pode sair. Esse
		// m?todo ? diferente para o pr?prio rei
		protegeRei();
		if (Tabuleiro.isCheck()) {
			this.resolveCheck();
		}
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				System.out.print(j + "," + i + "" + this.verificaDestino[j][i] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

	public abstract void desfazPosicao();

	public String getNome() {
		return this.nome;
	}

	public String getPosicao() {
		return "Coluna: " + this.posicaoColuna + " Linha: " + this.posicaoLinha;
	}

	/*
	 * N?o entendi como usa m?todos em matriz, depois eu vejo como faz
	 */

//	public boolean[][] getPodeMover() {
//		return podeMover;
//	}
//
//	public void setPodeMover(boolean[][] podeMover) {
//		this.podeMover = podeMover;
//	}
//
//	public boolean[][] getPodeCapturar() {
//		return podeCapturar;
//	}
//
//	public void setPodeCapturar(boolean[][] podeCapturar) {
//		this.podeCapturar = podeCapturar;
//	}
//
//	public boolean[][] getPodeMoverOuCapturar() {
//		return podeMoverOuCapturar;
//	}

	public void setPodeMoverOuCapturar(boolean[][] podeMoverOuCapturar) {
		this.podeMoverOuCapturar = podeMoverOuCapturar;
	}

	public void setVerificaDestino(boolean[][] verificaDestino) {
		this.verificaDestino = verificaDestino;
	}

	public void setEnPassantDireita(boolean enPassant) {
	}

	public void setEnPassantEsquerda(boolean enPassantEsquerda) {
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

	public boolean isEnPassantDireita() {
		return enPassantDireita;
	}

	public boolean isEnPassantEsquerda() {
		return enPassantEsquerda;
	}

	public void resetEnPassant() {

	}

	// o tabuleiro precisa saber onde o rei est?
	public void setRei() {

	}

	public void protegeRei() {

	}

	// m?todo criado somente para proibir o rei de andar em certas casas proibidas
	public void resetAtrapalhaRei() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				this.atrapalhaRei[i][j] = false;
			}
		}
	}

	/* se o pr?prio rei est? em check, cada pe?a ser? proibida de se mover em certas
	casas que normalmente poderiam */
	public void resolveCheck() {

	}

}
