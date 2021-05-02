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
		
		DamaBranca damaB = new DamaBranca();
		
		ReiBranco reiB = new ReiBranco();
		
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
		
		CavaloPreto c1 = new CavaloPreto();
		CavaloPreto c2 = new CavaloPreto();
		
		BispoPreto b1 = new BispoPreto();
		BispoPreto b2 = new BispoPreto();
		
		DamaPreta damaP = new DamaPreta();
		
		tabuleiro.verTabuleiro();
		
		peao5.getVerificaDestino();
		
		tabuleiro.movePecaBranca(peao5, 4, 3);
		
//		for(int i = 0; i < 8; i++) {
//			System.out.println(Tabuleiro.checaEnPassant[i]);
//		}
		
		peao5.getVerificaDestino();
		
		tabuleiro.movePecaBranca(peao5, 4, 4);
		
		p3.getVerificaDestino();
		
		tabuleiro.movePecaPreta(p3, 5, 4);
		
//		for(int i = 0; i < 8; i++) {
//			System.out.println(Tabuleiro.checaEnPassant[i]);
//		}
		
		p5.getVerificaDestino();
		
		tabuleiro.movePecaPreta(p5, 3, 4);
		
		peao5.getVerificaDestino();
		
		tabuleiro.movePecaBranca(peao5, 3, 5);
		
		tabuleiro.verOndeTemPecaPreta();
		
		p3.getVerificaDestino();
		
		tabuleiro.movePecaPreta(p3, 5, 3);
		
		peao7.getVerificaDestino();
		
		tabuleiro.movePecaBranca(peao7, 6, 3);
		
		p3.getVerificaDestino();
		
		tabuleiro.movePecaPreta(p3, 6, 2);
		
		p6.getVerificaDestino();
		
		tabuleiro.movePecaPreta(p6, 2, 4);
		
		p6.getVerificaDestino();
		
		tabuleiro.movePecaPreta(p6, 2, 3);
		
		peao2.getVerificaDestino();
		
		tabuleiro.movePecaBranca(peao2, 1, 3);
		
		p6.getVerificaDestino();
		
		tabuleiro.movePecaPreta(p6, 1, 2);
		
		peao1.getVerificaDestino();
		
		tabuleiro.movePecaBranca(peao2, 0, 3);
		
		peao1.getVerificaDestino();
		
		tabuleiro.movePecaBranca(peao1, 0, 3);
		
		peao1.getVerificaDestino();
		
		tabuleiro.movePecaBranca(peao1, 0, 4);
		
		p7.getVerificaDestino();
		
		tabuleiro.movePecaPreta(p7, 1, 4);
		
		peao1.getVerificaDestino();
		
		tabuleiro.movePecaBranca(peao1, 1, 5);
		
		
		
		
	
		
		
		

	}

}
