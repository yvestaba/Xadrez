package br.com.akconsultor;

import br.com.akconsultor.brancas.*;
import br.com.akconsultor.pretas.*;

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
		
		PeaoPreto p1 = new PeaoPreto();
		PeaoPreto p2 = new PeaoPreto();
		PeaoPreto p3 = new PeaoPreto();
		PeaoPreto p4 = new PeaoPreto();
		PeaoPreto p5 = new PeaoPreto();
		PeaoPreto p6 = new PeaoPreto();
		PeaoPreto p7 = new PeaoPreto();
		PeaoPreto p8 = new PeaoPreto();
		
		TorrePreta t1 = new TorrePreta();
		TorrePreta t2 = new TorrePreta();

		VerTabuleiro vt1 = new VerTabuleiro();
		
		peao4.getVerificaDestino();
		new MovePecaBranca(peao4, 3, 3);
		
		
		
		p4.getVerificaDestino();
		
		new MovePecaPreta(p4, 4, 4);
		
		
		
		peao4.getVerificaDestino();
		
		new MovePecaBranca(peao4, 4, 4);
		
	
		
		p2.getVerificaDestino();
		
		new MovePecaPreta(p2, 6, 4);
		
		bispo1.getVerificaDestino();
		
		new MovePecaBranca(bispo1, 6, 4);
		
		t1.getVerificaDestino();
		
		new MovePecaPreta(t1, 4, 7);
		
		t1.getVerificaDestino();
		
		new MovePecaPreta(t1, 4, 4);

		

	}

}
