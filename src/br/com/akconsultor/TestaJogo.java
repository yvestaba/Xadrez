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
		
		VerTabuleiro verTabuleiro1 = new VerTabuleiro();
		
		cavalo1.getVerificaDestino();
		
		MovePecaBranca moveBranca1 = new MovePecaBranca(cavalo1, 2, 2);		
		
		VerTabuleiro verTabuleiro2 = new VerTabuleiro();
		
		peao4.getVerificaDestino();
		
		MovePecaBranca moveBranca2 = new MovePecaBranca(peao4, 3, 3);
		
		VerTabuleiro verTabuleiro3 = new VerTabuleiro();
		
		torre1.getVerificaDestino();

	}

}
