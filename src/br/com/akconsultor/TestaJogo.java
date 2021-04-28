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

		VerTabuleiro VerTabuleiro1 = new VerTabuleiro();
		System.out.println();

		peao1.getVerificaDestino();
		System.out.println();
		
		MovePecaBranca moveBranca1 = new MovePecaBranca((Peca)peao1, 0, 3);
		
		VerTabuleiro VerTabuleiro2 = new VerTabuleiro();

	}

}
