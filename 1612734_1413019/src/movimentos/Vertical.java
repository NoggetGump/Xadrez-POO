package movimentos;

import java.util.ArrayList;
import tabuleiro.Consts;
import tabuleiro.Tabuleiro;
import vetor.*;

public class Vertical {

	private static Tabuleiro tab;
	private Vet coorPeca;
	
	public Vertical(Tabuleiro tab, Vet v)
	{
		Vertical.tab = tab;
		this.coorPeca = v;
	}

	public boolean addIfTrue(Vet v, Vet Temp, ArrayList<Vet> AllMoves, ArrayList<Vet> comiveis, boolean sentido)
	{ //sentido = true, se movimento for positivo
		if(sentido)
		{
			v.addY(1);
			if(v.getY() <= Consts.xyFin && !tab.perguntaCasaPeca(v))
			{
				AllMoves.add(v);
				if(Temp!=null)
					Temp.addY(1);
				return true;
			}
			else
				if(comiveis != null && v.getY() <= Consts.xyFin && tab.perguntaComivel(coorPeca, v))
					comiveis.add(v);
		}
		else
		{
			v.addY(-1);
			if(v.getY() >= Consts.xyIni && !tab.perguntaCasaPeca(v))
			{
				AllMoves.add(v);
				if(Temp!=null)
					Temp.addY(-1);
				return true;
			}
			else
				if(comiveis != null && v.getY() >= Consts.xyIni && tab.perguntaComivel(coorPeca, v))
					comiveis.add(v);
		}

		return false;
	}

	public boolean ver(ArrayList<Vet> AllMoves, ArrayList<Vet> comiveis, boolean sentido) //ATUALIZA TODOS OS MOVIMENTOS POSSIVEIS PARA EIXO Y POSITIVO A PARTIR DA PECA.
	{ //RETORNA FALSE CASO NÃO HAJA MOVIMENTOS POSSIVEIS NO SENTIDO ESCOLHIDO. sentido = true, se movimento for positivo. 
		Vet Temp = new Vet(coorPeca);

		while(addIfTrue(new Vet(Temp), Temp, AllMoves, comiveis, sentido));
		if(AllMoves.isEmpty())
			return false;

		return true;
	}

	public boolean allVerMov(ArrayList<Vet> AllMoves,  ArrayList<Vet> comiveis) //ATUALIZA TODOS OS MOVIMENTOS POSSIVEIS PARA EIXO Y A PARTIR DA PECA.
	{ //RETORNA FALSE CASO NÃO TENHA ADICIONADO NENHUM MOVIMENTO A LISTA.
		boolean b1 = ver(AllMoves, comiveis, true);
		boolean b2 = ver(AllMoves, comiveis, false);

		if(b1 && b2)
			return true;

		return false;
	}
}