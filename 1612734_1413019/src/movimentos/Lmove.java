package movimentos;

import java.util.ArrayList;
import tabuleiro.Consts;
import tabuleiro.Tabuleiro;
import vetor.*;

public class Lmove {

	private static Tabuleiro tab;
	private Vet coorPeca;

	public Lmove(Tabuleiro tab, Vet coorPeca)
	{
		Lmove.tab = tab;
		this.coorPeca = coorPeca;
	}

	public void L1(ArrayList<Vet> AllMoves, ArrayList<Vet> comiveis, int Mx, int My) //
	{
		Vet Temp = new Vet(coorPeca);

		Temp.add(Mx, 2*My);
		if(Temp.getX() <= Consts.xyFin
		&& Temp.getX() >= Consts.xyIni
		&& Temp.getY() <= Consts.xyFin
		&& Temp.getY() >= Consts.xyIni
		&& !tab.perguntaCasaPeca(Temp))
			AllMoves.add(Temp);
		else
			if(Temp.getX() <= Consts.xyFin
			&& Temp.getX() >= Consts.xyIni
			&& Temp.getY() <= Consts.xyFin
			&& Temp.getY() >= Consts.xyIni
			&& tab.perguntaComivel(Temp, coorPeca))
				comiveis.add(Temp);
	}

	public void L2(ArrayList<Vet> AllMoves, ArrayList<Vet> comiveis, int Mx, int My) //
	{
		Vet Temp = new Vet(coorPeca);

		Temp.add(2*Mx, My);
		if(Temp.getX() <= Consts.xyFin
		&& Temp.getX() >= Consts.xyIni
		&& Temp.getY() <= Consts.xyFin
		&& Temp.getY() >= Consts.xyIni
		&& !tab.perguntaCasaPeca(Temp))
			AllMoves.add(Temp);
		else
			if(Temp.getX() <= Consts.xyFin
			&& Temp.getX() >= Consts.xyIni
			&& Temp.getY() <= Consts.xyFin
			&& Temp.getY() >= Consts.xyIni
			&& tab.perguntaComivel(Temp, coorPeca))
				comiveis.add(Temp);
	}

	public boolean Lmoves(ArrayList<Vet> AllMoves, ArrayList<Vet> comiveis) //TODOS OS MOVIMENTOS EM "L" - CAVALO
	{
		int Mx = 1;
		int My = 1;
		for(int i = 0; i < 2; i++)
		{
			L1(AllMoves, comiveis, Mx, My);
			L1(AllMoves, comiveis, Mx, -My);
			L2(AllMoves, comiveis, Mx, My);
			L2(AllMoves, comiveis, Mx, -My);
			Mx *= -1;
			My *= -1;
		}

		return false;
	}
}