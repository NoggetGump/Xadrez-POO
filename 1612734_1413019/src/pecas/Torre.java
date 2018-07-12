package pecas;

import movimentos.Vertical;
import movimentos.Horizontal;
import tabuleiro.Consts;
import tabuleiro.Tabuleiro;
import vetor.Vet;

public class Torre extends Peca
{
	private boolean jaMoveu = false;
	public float valor = 1;
	/**
	 * 
	 *	Construtores de Peca
	 *
	 * */

	public Torre(int x, int y, char cor){super(x, y, cor, 1f);}

	public Torre(Vet v, char cor){super(v, cor, 1f);}

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

	public String nome()
	{
		return "Torre";
	}
	
	public boolean getJaMoveu()
	{
		return jaMoveu;
	}
	
	public void toogleJaMoveu()
	{
		jaMoveu = !jaMoveu;
	}

	public int roqueAssist(Vet addRei, Vet addTorre)
	{
		if(this.getX() == Consts.xyIni && this.getY() == Consts.xyIni)
		{
			addRei.setX(-2);
			addTorre.setX(3);
			return 1;
		}
		if(this.getX() == Consts.xyFin && this.getY() == Consts.xyIni)
		{
			addRei.setX(2);
			addTorre.setX(-2);
			return 2;
		}
		if(this.getX() == Consts.xyIni && this.getY() == Consts.xyFin)
		{
			addRei.setX(-2);
			addTorre.setX(3);
			return 3;
		}
		if(this.getX() == Consts.xyFin && this.getY() == Consts.xyFin)
		{
			addRei.setX(2);
			addTorre.setX(-2);
			return 4;
		}
		
		return Consts.movIlegal;
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
