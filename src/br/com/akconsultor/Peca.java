package br.com.akconsultor;

public abstract class Peca {
	protected int posicaoColuna;
	protected int posicaoLinha;
	protected String nome;
	protected boolean[][] verificaDestino = new boolean[8][8];
	protected boolean[][] podeMover = new boolean[8][8];
	protected boolean[][] podeCapturar = new boolean[8][8];
	protected boolean[][] podeMoverOuCapturar = new boolean[8][8];
	
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
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				System.out.print(j +"," + i + "" + this.verificaDestino[j][i] + " ");
			}
			System.out.println();
		} System.out.println();

	}
	
	public abstract void desfazPosicao();
	

	public String getNome() {
		return this.nome;
	}
	
	public void getPosicao() {
		System.out.println("Coluna: " + this.posicaoColuna + " Linha: " + this.posicaoLinha);
	}

	public boolean[][] getPodeMover() {
		return podeMover;
	}

	public void setPodeMover(boolean[][] podeMover) {
		this.podeMover = podeMover;
	}

	public boolean[][] getPodeCapturar() {
		return podeCapturar;
	}

	public void setPodeCapturar(boolean[][] podeCapturar) {
		this.podeCapturar = podeCapturar;
	}

	public boolean[][] getPodeMoverOuCapturar() {
		return podeMoverOuCapturar;
	}

	public void setPodeMoverOuCapturar(boolean[][] podeMoverOuCapturar) {
		this.podeMoverOuCapturar = podeMoverOuCapturar;
	}

	public void setVerificaDestino(boolean[][] verificaDestino) {
		this.verificaDestino = verificaDestino;
	}
	
	
}
