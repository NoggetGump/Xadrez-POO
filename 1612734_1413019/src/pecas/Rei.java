package pecas;

import movimentos.Horizontal;
import movimentos.Vertical;
import tabuleiro.Consts;
import vetor.Vet;

public class Rei extends Peca
{
	Vertical V = new Vertical();
	Horizontal H = new Horizontal();
	
	/**
	 * 
	 *	Construtores de Peca
	 *
	 * */
	
	public Rei(int x, int y, char cor)
	{
		super(x, y, cor);

		V.addIfTrue(new Vet(v), null , AllMoves, true);
		V.addIfTrue(new Vet(v), null, AllMoves, false);
		H.addIfTrue(new Vet(v), null, AllMoves, true);
		H.addIfTrue(new Vet(v), null, AllMoves, false);
	}
	
	public Rei(Vet v, char cor)
	{
		super(v, cor);

		V.addIfTrue(new Vet(this.v), null , AllMoves, true);
		V.addIfTrue(new Vet(this.v), null, AllMoves, false);
		H.addIfTrue(new Vet(this.v), null, AllMoves, true);
		H.addIfTrue(new Vet(this.v), null, AllMoves, false);
	}
	
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
}