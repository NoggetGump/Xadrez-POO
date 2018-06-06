package pecas;

import movimentos.Diagonal;
import movimentos.Horizontal;
import movimentos.Vertical;
import tabuleiro.Consts;
import vetor.Vet;

public class Rainha extends Peca
{
	Vertical V = new Vertical();
	Horizontal H = new Horizontal();
	Diagonal D = new Diagonal();

	/**
	 * 
	 *	Construtores de Peca
	 *
	 * */

	public Rainha(int x, int y, char cor)
	{
		super(x, y, cor);		
		H.allHorMov(this.v, AllMoves);
		V.allVerMov(this.v, AllMoves);
		D.allMovDiag(this.v, this.AllMoves);
	}
	
	public Rainha(Vet v, char cor)
	{
		super(v, cor);		
		H.allHorMov(this.v, AllMoves);
		V.allVerMov(this.v, AllMoves);
		D.allMovDiag(this.v, AllMoves);
	}
	
	/**
	 * 
	 *	Retorna o path da imagem
	 *
	 * */
	
	public String imgPeca()
	{
		if(this.cor == 'p')
			return Consts.rainhaP.getPath();
		else
			return Consts.rainhaB.getPath();
	}
}