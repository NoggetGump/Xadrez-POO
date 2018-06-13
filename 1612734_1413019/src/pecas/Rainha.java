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
		if(this.getCor() == 'b')
		{
			return "Rainha Branca";
		}
		else
		{
			return "Rainha Preta";
		}
	}
	
	public void AtualizaMoves(Tabuleiro tab)
	{
		Vertical V = new Vertical(tab, this.v);
		Horizontal H = new Horizontal(tab, this.v);
		Diagonal D = new Diagonal(tab, this.v);
		
		AllMoves.clear();
		comiveis.clear();
		
		H.allHorMov(AllMoves, comiveis);
		V.allVerMov(AllMoves, comiveis);
		D.allMovDiag(AllMoves, comiveis);
	}
}
