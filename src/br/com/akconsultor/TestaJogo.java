package br.com.akconsultor;

public class TestaJogo {
	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.comecouOJogo();

		PeaoBranco peao1 = new PeaoBranco();
		PeaoBranco peao2 = new PeaoBranco();
		PeaoBranco peao3 = new PeaoBranco();
		PeaoBranco peao4 = new PeaoBranco();
		PeaoBranco peao5 = new PeaoBranco();
		PeaoBranco peao6 = new PeaoBranco();
		PeaoBranco peao7 = new PeaoBranco();
		PeaoBranco peao8 = new PeaoBranco();

		TorreBranca torre1 = new TorreBranca();
		TorreBranca torre2 = new TorreBranca();

		CavaloBranco cavalo1 = new CavaloBranco();
		CavaloBranco cavalo2 = new CavaloBranco();
		
		BispoBranco bispo1 = new BispoBranco();
		BispoBranco bispo2 = new BispoBranco();

		VerTabuleiro vt1 = new VerTabuleiro();
		
		peao4.getVerificaDestino();
		
		MovePecaBranca mb1 = new MovePecaBranca(peao4, 3, 3);
		
		VerTabuleiro vt2 = new VerTabuleiro();
		VerOndeTemPecaBranca vb1 = new VerOndeTemPecaBranca();
		
		peao4.getPosicao();
		
	}

}
