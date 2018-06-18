package movimentos;

import java.util.ArrayList;
import tabuleiro.Consts;
import tabuleiro.Tabuleiro;
import vetor.*;

public class Horizontal {

	private static Tabuleiro tab;
	private Vet coorPeca;

	public Horizontal(Tabuleiro tab, Vet v)
	{
		Horizontal.tab = tab;
		this.coorPeca = v;
	}

	public boolean addIfTrue(Vet v, Vet Temp, ArrayList<Vet> AllMoves, ArrayList<Vet> comiveis, boolean sentido)
	{ //sentido = true, se movimento for positivo
		if(sentido)
		{
			v.addX(1);
			if(v.getX() <= Consts.xyFin && !tab.perguntaCasaPeca(v))
			{
				AllMoves.add(v);
				if(Temp!=null)
					Temp.addX(1);
				return true;
			}
			else
				if(v.getX() <= Consts.xyFin && tab.perguntaComivel(coorPeca, v))
					comiveis.add(v);
		}
		else
		{
			v.addX(-1);
			if(v.getX() >= Consts.xyIni && !tab.perguntaCasaPeca(v))
			{
				AllMoves.add(v);
				if(Temp!=null)
					Temp.addX(-1);
				return true;
			}
			else
				if(v.getX() >= Consts.xyIni && tab.perguntaComivel(coorPeca, v))
					comiveis.add(v);
		}

		return false;
	}

	public boolean hor(ArrayList<Vet> AllMoves, ArrayList<Vet> comiveis, boolean sentido)//RETORNA TODOS OS MOVIMENTOS POSSIVEIS PARA UM SENTIDO DO EIXO X.
	{ //sentido = true, se movimento for positivo. RETORNA NULL CASO NÃO HAJA MOVIMENTOS POSSIVEIS NO SENTIDO ESCOLHIDO.
		Vet Temp = new Vet(coorPeca);

		while(addIfTrue(new Vet(Temp), Temp, AllMoves, comiveis, sentido));
		if(AllMoves.isEmpty())
			return false;
		else 

			return true;
	}

	public boolean  allHorMov(ArrayList<Vet> AllMoves,  ArrayList<Vet> comiveis) //RETORNA TODOS OS MOVIMENTOS POSSIVEIS PARA O EIXO X.
	{ //RETORNA FALSE CASO NÃO TENHA ADICIONADO NENHUM MOVIMENTO A LISTA.
		boolean b1 = hor(AllMoves, comiveis, true);
		boolean b2 = hor(AllMoves, comiveis, false);

	if (b1 && b2)
		return true;

	return false;
	}
}
