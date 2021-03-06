package pecas;

import movimentos.Diagonal;
import movimentos.Horizontal;
import movimentos.Roque;
import movimentos.Vertical;
import tabuleiro.Consts;
import tabuleiro.Tabuleiro;
import vetor.Vet;

public class Rei extends Peca
{
	private boolean jaMoveu = false;
	public float valor = 0;
	/**
	 * 
	 *	Construtores de Peca
	 *
	 * */

	public Rei(int x, int y, char cor){super(x, y, cor, 0f);}

	public Rei(Vet v, char cor){super(v, cor, 0f);}

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

	public String nome()
	{
		return "Rei";
	}

	public boolean getJaMoveu()
	{
		return jaMoveu;
	}

	public void toogleJaMoveu()
	{
		if(jaMoveu)
			return;
		else
			jaMoveu = true;
	}

	public void AtualizaMoves(Tabuleiro tab)
	{
		Vertical V = new Vertical(tab, this.v);
		Horizontal H = new Horizontal(tab, this.v);
		Diagonal D = new Diagonal(tab, this.v);
		Roque R = new Roque(tab, this.v);
		Vet temp = new Vet();

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

		if(this.corP())
		{
			temp.set(Consts.xyFin, Consts.xyIni);
			R.roqueEsquerdaP(this, temp, AllMoves);
			temp.set(Consts.xyIni, Consts.xyIni);
			R.roqueDireitaP(this, temp, AllMoves);
		}
		else
		{
			temp.set(Consts.xyIni, Consts.xyFin);
			R.roqueEsquerdaB(this, temp, AllMoves);
			temp.set(Consts.xyFin, Consts.xyFin);
			R.roqueDireitaB(this, temp, AllMoves);
		}
	}
}
