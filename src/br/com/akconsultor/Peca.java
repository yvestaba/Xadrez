package br.com.akconsultor;

public abstract class Peca {
	protected int posicaoColuna;
	protected int posicaoLinha;
	protected String nome;
	public boolean[][] verificaDestino = new boolean[8][8];
	
	public abstract void casaInicial();

	public abstract void ondePodeAndar();

	public abstract void podeCapturar();

	public abstract void podeAndarOuCapturar();

	public abstract void getVerificaDestino();
	
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
}
