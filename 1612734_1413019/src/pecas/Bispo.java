package pecas;

import java.util.ArrayList;

import movimentos.Diagonal;
import tabuleiro.Consts;
import tabuleiro.Tabuleiro;
import vetor.Vet;

public class Bispo extends Peca
{	
	/**
	 *
	 *	Construtores de Peca
	 *
	 * */

	public Bispo(int x, int y, char cor){super(x, y, cor);}

	public Bispo(Vet v, char cor){super(v , cor);}

	/**
	 * 
	 *	Retorna o path da imagem
	 *
	 * */

	public String imgPeca()
	{
		if(this.cor == 'p')
			return Consts.bispoP.getPath();
		else
			return Consts.bispoB.getPath();
	}
	
	public String nomePeca()
	{
		return "Bispo";
	}
	
	public void AtualizaMoves(Tabuleiro tab)
	{
		Diagonal D = new Diagonal(tab);
		
		AllMoves.clear();
		
		D.allMovDiag(this.v, this.AllMoves);
	}
}