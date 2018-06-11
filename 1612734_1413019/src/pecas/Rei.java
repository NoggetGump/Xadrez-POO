package pecas;

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
		return "Rei";
	}

	public void AtualizaMoves(Tabuleiro tab)
	{
		Vertical V = new Vertical(tab);
		Horizontal H = new Horizontal(tab);
		
		V.addIfTrue(new Vet(this.v), null , AllMoves, true);
		V.addIfTrue(new Vet(this.v), null, AllMoves, false);
		H.addIfTrue(new Vet(this.v), null, AllMoves, true);
		H.addIfTrue(new Vet(this.v), null, AllMoves, false);
	}
}
