package pecas;

import movimentos.Diagonal;
import movimentos.Horizontal;
import movimentos.Vertical;
import tabuleiro.Consts;
import tabuleiro.Tabuleiro;
import vetor.Vet;

public class Rainha extends Peca
{

	/**
	 * 
	 *	Construtores de Peca
	 *
	 * */

	public Rainha(int x, int y, char cor){super(x, y, cor);}
	
	public Rainha(Vet v, char cor){super(v, cor);}
	
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
	
	public String nomePeca()
	{
		return "Rainha";
	}
	
	public void AtualizaMoves(Tabuleiro tab)
	{
		Vertical V = new Vertical(tab);
		Horizontal H = new Horizontal(tab);
		Diagonal D = new Diagonal(tab);
		
		H.allHorMov(this.v, AllMoves);
		V.allVerMov(this.v, AllMoves);
		D.allMovDiag(this.v, AllMoves);
	}
}
