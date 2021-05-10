package br.com.akconsultor;



import br.com.akconsultor.brancas.*;
import br.com.akconsultor.pretas.*;

public class TestaJogo {
	
	
	
	public static void main(String[] args) {
		//sempre deve-se criar um tabuleiro e usar o método comecouOJogo assim que o jogo começa, apenas uma vez
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.comecouOJogo();

		//a criação de peças devem seguir este padrão. Quem preferir, pode mudar o nome da referência
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
		ReiPreto reiP = new ReiPreto();
		
		tabuleiro.verTabuleiro();
		/*a partir daqui, começam as jogadas. Primeiro deve-se usar o método referenciaDaPeca.getVerificaDestino.
		 * Vai aparecer na tela as casas que a peça pode andar, indicada pelo modeo "coluna,linha"
		 * O método de mover precisa receber a referência da peça, assim como o número da coluna e linha de destino, respectivamente
		*/
		
		peao5.getVerificaDestino();
		tabuleiro.movePecaBranca(peao5, 4, 3);
		
		p3.getVerificaDestino();
		tabuleiro.movePecaPreta(p3, 5, 4);
		
		peao5.getVerificaDestino();
		tabuleiro.movePecaBranca(peao5, 5, 4);
		
		p1.getVerificaDestino();
		tabuleiro.movePecaPreta(p1, 7, 4);
		
		damaB.getVerificaDestino();
		tabuleiro.movePecaBranca(damaB, 7, 4);
		
		t1.getVerificaDestino();
		tabuleiro.movePecaPreta(t1, 7, 4);
		
		bispo2.getVerificaDestino();
		tabuleiro.movePecaBranca(bispo2, 4, 1);
		
		p6.getVerificaDestino();
		tabuleiro.movePecaPreta(p6, 2, 4);
		
		bispo2.getVerificaDestino();
		tabuleiro.movePecaBranca(bispo2, 7, 4);
		
		p2.getVerificaDestino();
		tabuleiro.movePecaPreta(p2, 6, 5);
		
		peao2.getVerificaDestino();
		tabuleiro.movePecaBranca(peao2, 1, 3);
		
		p5.getVerificaDestino();
		tabuleiro.movePecaPreta(p5, 3, 4);
		
		bispo2.getVerificaDestino();
		tabuleiro.movePecaBranca(bispo2, 6, 5);
		
		reiP.getVerificaDestino();
		tabuleiro.movePecaPreta(reiP, 3, 6);
		
		peao5.getVerificaDestino();
		tabuleiro.movePecaBranca(peao5, 5, 5);
		
		p4.getVerificaDestino();
		tabuleiro.movePecaPreta(p4, 5, 5);
		
		cavalo1.getVerificaDestino();
		tabuleiro.movePecaBranca(cavalo1, 2, 2);
		
		damaP.getVerificaDestino();
		tabuleiro.movePecaPreta(damaP, 4, 7);
		
		cavalo1.getVerificaDestino();
		tabuleiro.movePecaBranca(cavalo1, 4, 1);
		
		reiP.getVerificaDestino();
		tabuleiro.movePecaPreta(reiP, 2, 6);
		
		peao1.getVerificaDestino();
		tabuleiro.movePecaBranca(peao1, 0, 2);
		
		b2.getVerificaDestino();
		tabuleiro.movePecaPreta(b2, 6, 3);
		
		cavalo2.getVerificaDestino();
		tabuleiro.movePecaBranca(cavalo2, 5, 2);
		
		p6.getVerificaDestino();
		tabuleiro.movePecaPreta(p6, 1, 3);
		
		bispo1.getVerificaDestino();
		tabuleiro.movePecaBranca(bispo1, 1, 1);
		
		c2.getVerificaDestino();
		tabuleiro.movePecaPreta(c2, 2, 5);
		
		reiB.getVerificaDestino();
		tabuleiro.movePecaBranca(reiB, 2, 0);
	}

}
