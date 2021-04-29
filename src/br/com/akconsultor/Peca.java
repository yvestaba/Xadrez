package br.com.akconsultor;

public abstract class Peca {
	protected int posicaoColuna;
	protected int posicaoLinha;
	protected String nome;
	public boolean[][] verificaDestino = new boolean[8][8];
	
	public abstract void setPosicao(int coluna, int linha);
	
	protected abstract void casaInicial();

	public abstract void ondePodeAndar();

	public abstract void podeCapturar();

	public abstract void podeAndarOuCapturar();

	public abstract void getVerificaDestino();
	
	public abstract void desfazPosicao();
	

	public String getNome() {
		return nome;
	}
	
	public void getPosicao() {
		System.out.println("Coluna: " + this.posicaoColuna + " Linha: " + this.posicaoLinha);
	}
}
