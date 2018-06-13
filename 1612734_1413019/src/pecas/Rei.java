package pecas;

import movimentos.Diagonal;
import movimentos.Horizontal;
import movimentos.Vertical;
import tabuleiro.Consts;
import tabuleiro.Tabuleiro;
import vetor.Vet;

public class Rei extends Peca
{
	
	/**
	 * 
	 *	Construtores de Peca
	 *
	 * */
	
	public Rei(int x, int y, char cor){super(x, y, cor);}
	
	public Rei(Vet v, char cor){super(v, cor);}
	
	/**
	 * 
	 *	Retorna o path da imagem
	 *
	 * */
	
	public String imgPeca()
	{
		if(this.cor == 'p')
			return Consts.reiP.getPath();
		else
			return Consts.reiB.getPath();
	}
	
	public String nomePeca()
	{
		if(this.getCor() == 'b')
		{
			return "Rei Branco";
		}
		else
		{
			return "Rei Preto";
		}
	}

	public void AtualizaMoves(Tabuleiro tab)
	{
		Vertical V = new Vertical(tab, this.v);
		Horizontal H = new Horizontal(tab, this.v);
		Diagonal D = new Diagonal(tab, this.v);
		
		AllMoves.clear();
		comiveis.clear();

		V.addIfTrue(new Vet(this.v), null , AllMoves, comiveis, true);
		V.addIfTrue(new Vet(this.v), null, AllMoves, comiveis, false);
		H.addIfTrue(new Vet(this.v), null, AllMoves, comiveis, true);
		H.addIfTrue(new Vet(this.v), null, AllMoves, comiveis,  false);
		D.DPPmove(new Vet(this.v), AllMoves, comiveis);
		D.DNPmove(new Vet(this.v), AllMoves, comiveis);
		D.DPNmove(new Vet(this.v), AllMoves, comiveis);
		D.DNNmove(new Vet(this.v), AllMoves, comiveis);
	}
}
