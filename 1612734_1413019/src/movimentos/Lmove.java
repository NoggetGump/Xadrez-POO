package movimentos;

import java.util.ArrayList;
import tabuleiro.Consts;
import vetor.*;

public class Lmove {

	public boolean L1(Vet v, ArrayList<Vet> AllMoves, int Mx, int My) //
	{
		Vet Temp = new Vet(v);

		Temp.add(Mx, 2*My);
		if(java.lang.Math.abs(Temp.getX()) <= Consts.xyFin
		&& java.lang.Math.abs(Temp.getX()) >= Consts.xyIni
		&& java.lang.Math.abs(Temp.getY()) <= Consts.xyFin
		&& java.lang.Math.abs(Temp.getY()) >= Consts.xyIni)
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
		if(java.lang.Math.abs(Temp.getX()) <= Consts.xyFin
		&& java.lang.Math.abs(Temp.getX()) >= Consts.xyIni
		&& java.lang.Math.abs(Temp.getY()) <= Consts.xyFin
		&& java.lang.Math.abs(Temp.getY()) >= Consts.xyIni)
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
