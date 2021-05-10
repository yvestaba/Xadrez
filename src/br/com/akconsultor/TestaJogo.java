package br.com.akconsultor;



import br.com.akconsultor.brancas.*;
import br.com.akconsultor.pretas.*;

public class TestaJogo {
	public static void promovePeaoDamaBranca(PecaBranca peaoBranco) {
		if(peaoBranco.getPosicaoLinha() == 7) {
			
			new DamaBranca(peaoBranco.getPosicaoColuna(), 7);
			peaoBranco.setPosicaoLinha(50);
			peaoBranco.setPosicaoColuna(50);
		}
	}
	
	public static void promovePeaoDamaPreta(PecaPreta peaoPreto) {
		if(peaoPreto.getPosicaoLinha() == 0) {
			
			new DamaPreta(peaoPreto.getPosicaoColuna(), 0);
			peaoPreto.setPosicaoLinha(50);
			peaoPreto.setPosicaoColuna(50);
		}
	}
	
	
	public static void main(String[] args) {
		//sempre deve-se criar um tabuleiro e usar o método comecouOJogo assim que o jogo começa, apenas uma vez
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.comecouOJogo();

		//a criação de peças devem seguir este padrão. Quem preferir, pode mudar o nome da referência
		/*quando um peão é promovido para dama, é necessário criar uma nova referência para a nova dama
		 * Modelo: DamaPreta damaPretaPromovida = Tabuleiro.getRainhaPretaPromovida();
		 */
		
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
		 * Vai aparecer na tela as casas que a peça pode andar, indicada pelo modeo "coluna,linha" com a palavra true do lado
		 * O método de mover precisa receber a referência da peça, assim como o número da coluna e linha de destino, respectivamente
		*/
		
		peao5.getVerificaDestino();
		tabuleiro.movePecaBranca(peao5, 4, 3);
		
		p4.getVerificaDestino();
		tabuleiro.movePecaPreta(p4, 4, 4);
		
		peao6.getVerificaDestino();
		tabuleiro.movePecaBranca(peao6, 5, 3);
		
		p4.getVerificaDestino();
		tabuleiro.movePecaPreta(p4, 5, 3);
		
		bispo2.getVerificaDestino();
		tabuleiro.movePecaBranca(bispo2, 2, 3);
		
		damaP.getVerificaDestino();
		tabuleiro.movePecaPreta(damaP, 7, 3);
		
		reiB.getVerificaDestino();
		tabuleiro.movePecaBranca(reiB, 5, 0);
		
		p7.getVerificaDestino();
		tabuleiro.movePecaPreta(p7, 1, 4);
		
		bispo2.getVerificaDestino();
		tabuleiro.movePecaBranca(bispo2, 1, 4);
		
		c1.getVerificaDestino();
		tabuleiro.movePecaPreta(c1, 5, 5);
		
		cavalo2.getVerificaDestino();
		tabuleiro.movePecaBranca(cavalo2, 5, 2);
		
		damaP.getVerificaDestino();
		tabuleiro.movePecaPreta(damaP, 7, 5);
		
		peao4.getVerificaDestino();
		tabuleiro.movePecaBranca(peao4, 3, 2);
		
		c1.getVerificaDestino();
		tabuleiro.movePecaPreta(c1, 7, 4);
		
		cavalo2.getVerificaDestino();
		tabuleiro.movePecaBranca(cavalo2, 7, 3);
		
		damaP.getVerificaDestino();
		tabuleiro.movePecaPreta(damaP, 6, 4);
		
		cavalo2.getVerificaDestino();
		tabuleiro.movePecaBranca(cavalo2, 5, 4);
		
		p6.getVerificaDestino();
		tabuleiro.movePecaPreta(p6, 2, 5);
		
		peao7.getVerificaDestino();
		tabuleiro.movePecaBranca(peao7, 6, 3);
		
		c1.getVerificaDestino();
		tabuleiro.movePecaPreta(c1, 5, 5);
		
		torre2.getVerificaDestino();
		tabuleiro.movePecaBranca(torre2, 6, 0);
		
		p6.getVerificaDestino();
		tabuleiro.movePecaPreta(p6, 1, 4);
		
		peao8.getVerificaDestino();
		tabuleiro.movePecaBranca(peao8, 7, 3);
		
		damaP.getVerificaDestino();
		tabuleiro.movePecaPreta(damaP, 6, 5);
		
		peao8.getVerificaDestino();
		tabuleiro.movePecaBranca(peao8, 7, 4);
		
		damaP.getVerificaDestino();
		tabuleiro.movePecaPreta(damaP, 6, 4);
		
		damaB.getVerificaDestino();
		tabuleiro.movePecaBranca(damaB, 5, 2);
		
		c1.getVerificaDestino();
		tabuleiro.movePecaPreta(c1, 6, 7);
		
		bispo1.getVerificaDestino();
		tabuleiro.movePecaBranca(bispo1, 5, 3);
		
		damaP.getVerificaDestino();
		tabuleiro.movePecaPreta(damaP, 5, 5);
		
		cavalo1.getVerificaDestino();
		tabuleiro.movePecaBranca(cavalo1, 2, 2);
		
		b1.getVerificaDestino();
		tabuleiro.movePecaPreta(b1, 2, 4);
		
		cavalo1.getVerificaDestino();
		tabuleiro.movePecaBranca(cavalo1, 3, 4);
		
		damaP.getVerificaDestino();
		tabuleiro.movePecaPreta(damaP, 1, 1);
		
		bispo1.getVerificaDestino();
		tabuleiro.movePecaBranca(bispo1, 3, 5);
		
		b1.getVerificaDestino();
		tabuleiro.movePecaPreta(b1, 6, 0);
		
		peao5.getVerificaDestino();
		tabuleiro.movePecaBranca(peao5, 4, 4);
		
		damaP.getVerificaDestino();
		tabuleiro.movePecaPreta(damaP, 0, 0);
		
		reiB.getVerificaDestino();
		tabuleiro.movePecaBranca(reiB, 4, 1);
		
		c2.getVerificaDestino();
		tabuleiro.movePecaPreta(c2, 0, 5);
		
		cavalo2.getVerificaDestino();
		tabuleiro.movePecaBranca(cavalo2, 6, 6);
		
		reiP.getVerificaDestino();
		tabuleiro.movePecaPreta(reiP, 3, 7);
		
		damaB.getVerificaDestino();
		tabuleiro.movePecaBranca(damaB, 5, 5);
		
		c1.getVerificaDestino();
		tabuleiro.movePecaPreta(c1, 5, 5);
		
		bispo1.getVerificaDestino();
		tabuleiro.movePecaBranca(bispo1, 4, 6);
	}

}
