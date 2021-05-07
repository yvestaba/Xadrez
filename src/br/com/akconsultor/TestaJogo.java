package br.com.akconsultor;



import br.com.akconsultor.brancas.*;
import br.com.akconsultor.pretas.*;

public class TestaJogo {
	
	
	
	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.comecouOJogo();

		PeaoBranco peao1 = new PeaoBranco();
		Tabuleiro.listaBrancas.add(peao1);
		PeaoBranco peao2 = new PeaoBranco();
		Tabuleiro.listaBrancas.add(peao2);
		PeaoBranco peao3 = new PeaoBranco();
		Tabuleiro.listaBrancas.add(peao3);
		PeaoBranco peao4 = new PeaoBranco();
		Tabuleiro.listaBrancas.add(peao4);
		PeaoBranco peao5 = new PeaoBranco();
		Tabuleiro.listaBrancas.add(peao5);
		PeaoBranco peao6 = new PeaoBranco();
		Tabuleiro.listaBrancas.add(peao6);
		PeaoBranco peao7 = new PeaoBranco();
		Tabuleiro.listaBrancas.add(peao7);
		PeaoBranco peao8 = new PeaoBranco();
		Tabuleiro.listaBrancas.add(peao8);


		TorreBranca torre1 = new TorreBranca();
		Tabuleiro.listaBrancas.add(torre1);
		TorreBranca torre2 = new TorreBranca();
		Tabuleiro.listaBrancas.add(torre2);


		CavaloBranco cavalo1 = new CavaloBranco();
		Tabuleiro.listaBrancas.add(cavalo1);
		CavaloBranco cavalo2 = new CavaloBranco();
		Tabuleiro.listaBrancas.add(cavalo2);
		
		BispoBranco bispo1 = new BispoBranco();
		Tabuleiro.listaBrancas.add(bispo1);
		BispoBranco bispo2 = new BispoBranco();
		Tabuleiro.listaBrancas.add(bispo2);
		
		DamaBranca damaB = new DamaBranca();
		Tabuleiro.listaBrancas.add(damaB);
		
		ReiBranco reiB = new ReiBranco();
		Tabuleiro.listaBrancas.add(reiB);
		
		
		
		PeaoPreto p1 = new PeaoPreto();
		Tabuleiro.listaPretas.add(p1);
		PeaoPreto p2 = new PeaoPreto();
		Tabuleiro.listaPretas.add(p2);
		PeaoPreto p3 = new PeaoPreto();
		Tabuleiro.listaPretas.add(p3);
		PeaoPreto p4 = new PeaoPreto();
		Tabuleiro.listaPretas.add(p4);
		PeaoPreto p5 = new PeaoPreto();
		Tabuleiro.listaPretas.add(p5);
		PeaoPreto p6 = new PeaoPreto();
		Tabuleiro.listaPretas.add(p6);
		PeaoPreto p7 = new PeaoPreto();
		Tabuleiro.listaPretas.add(p7);
		PeaoPreto p8 = new PeaoPreto();
		Tabuleiro.listaPretas.add(p8);
		
		TorrePreta t1 = new TorrePreta();
		Tabuleiro.listaPretas.add(t1);
		TorrePreta t2 = new TorrePreta();
		Tabuleiro.listaPretas.add(t2);
		
		CavaloPreto c1 = new CavaloPreto();
		Tabuleiro.listaPretas.add(c1);
		CavaloPreto c2 = new CavaloPreto();
		Tabuleiro.listaPretas.add(c2);
		
		BispoPreto b1 = new BispoPreto();
		Tabuleiro.listaPretas.add(b1);
		BispoPreto b2 = new BispoPreto();
		Tabuleiro.listaPretas.add(b2);
		
		DamaPreta damaP = new DamaPreta();
		Tabuleiro.listaPretas.add(damaP);
		ReiPreto reiP = new ReiPreto();
		Tabuleiro.listaPretas.add(reiP);
		
		tabuleiro.verTabuleiro();
		
		peao5.getVerificaDestino();
		
		tabuleiro.movePecaBranca(peao5, 4, 3);
		
		bispo2.getVerificaDestino();
		
		tabuleiro.movePecaBranca(bispo2, 1, 4);
		
		p4.getVerificaDestino();
		
		tabuleiro.movePecaPreta(p4, 4, 4);
		
		reiP.getVerificaDestino();
		
		tabuleiro.movePecaPreta(reiP, 4, 6);
		
		p3.getVerificaDestino();
		
		tabuleiro.movePecaPreta(p3, 5, 5);
		
		peao4.getVerificaDestino();
		
		tabuleiro.movePecaBranca(peao4, 3, 3);
		
		bispo1.getVerificaDestino();
		
		tabuleiro.movePecaBranca(bispo1, 6, 4);
		
		p3.getVerificaDestino();
		
		
		
	
		
		
		

	}

}
