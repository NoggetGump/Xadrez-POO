package pecas;

import movimentos.Vertical;
import movimentos.Horizontal;
import tabuleiro.Consts;
import vetor.Vet;

public class Torre extends Peca
{
	Vertical V = new Vertical();
	Horizontal H = new Horizontal();
	
	/**
	 * 
	 *	Construtores de Peca
	 *
	 * */
	
	public Torre(int x, int y, char cor)
	{
		super(x, y, cor);
		H.allHorMov(this.v, AllMoves);
		V.allVerMov(this.v, AllMoves);
	}
	
	public Torre(Vet v, char cor)
	{
		super(v, cor);
		H.allHorMov(this.v, AllMoves);
		V.allVerMov(this.v, AllMoves);
	}
	
	/**
	 * 
	 *	Retorna o path da imagem
	 *
	 * */

	public String imgPeca()
	{
		if(this.cor == 'p')
			return Consts.torreP.getPath();
		else
			return Consts.torreB.getPath();
	}
}