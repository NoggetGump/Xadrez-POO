package pecas;

import movimentos.Vertical;
import movimentos.Horizontal;
import tabuleiro.Consts;
import tabuleiro.Tabuleiro;
import vetor.Vet;

public class Torre extends Peca
{

	boolean jaMoveu = false;

	/**
	 * 
	 *	Construtores de Peca
	 *
	 * */
	
	public Torre(int x, int y, char cor){super(x, y, cor);}
	
	public Torre(Vet v, char cor){super(v, cor);}
	
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
	
	public String nomePeca()
	{
		if(this.getCor() == 'b')
		{
			return "Torre Branca";
		}
		else
		{
			return "Torre Preto";
		}
	}
	
	public boolean getJaMoveu()
	{
		return jaMoveu;
	}
	
	public void toogleJaMoveu()
	{
		jaMoveu = !jaMoveu;
	}
	
	public void AtualizaMoves(Tabuleiro tab)
	{
		Vertical V = new Vertical(tab, this.v);
		Horizontal H = new Horizontal(tab, this.v);
		
		AllMoves.clear();
		comiveis.clear();
		
		H.allHorMov(AllMoves, comiveis);
		V.allVerMov(AllMoves, comiveis);
	}
}
