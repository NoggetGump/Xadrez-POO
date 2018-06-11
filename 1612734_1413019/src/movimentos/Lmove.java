package movimentos;

import java.util.ArrayList;
import tabuleiro.Consts;
import tabuleiro.Tabuleiro;
import vetor.*;

public class Lmove {

	private static Tabuleiro tab;
	
	public Lmove(Tabuleiro tab)
	{
		Lmove.tab = tab;
	}
	
	public boolean L1(Vet v, ArrayList<Vet> AllMoves, int Mx, int My) //
	{
		Vet Temp = new Vet(v);

		Temp.add(Mx, 2*My);
		if(Temp.getX() <= Consts.xyFin
		&& Temp.getX() >= Consts.xyIni
		&& Temp.getY() <= Consts.xyFin
		&& Temp.getY() >= Consts.xyIni
		&& !tab.perguntaCasaPeca(Temp))
		{
			AllMoves.add(Temp);
			return true;
		}
		return false;
	}
	
	public boolean L2(Vet v, ArrayList<Vet> AllMoves, int Mx, int My) //
	{
		Vet Temp = new Vet(v);

		Temp.add(2*Mx, My);
		if(Temp.getX() <= Consts.xyFin
		&& Temp.getX() >= Consts.xyIni
		&& Temp.getY() <= Consts.xyFin
		&& Temp.getY() >= Consts.xyIni
		&& !tab.perguntaCasaPeca(Temp))
		{
			AllMoves.add(Temp);
			return true;
		}
		return false;
	}

	public boolean Lmoves(Vet v, ArrayList<Vet> AllMoves) //TODOS OS MOVIMENTOS EM "L" - CAVALO
	{
		int Mx = 1;
		int My = 1;
		for(int i = 0; i < 2; i++)
		{
			L1(v, AllMoves, Mx, My);
			L1(v, AllMoves, Mx, -My);
			L2(v, AllMoves, Mx, My);
			L2(v, AllMoves, Mx, -My);
			Mx *= -1;
			My *= -1;
		}

		return false;
	}
}
