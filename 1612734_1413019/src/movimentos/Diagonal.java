package movimentos;

import java.util.ArrayList;
import tabuleiro.Consts;
import vetor.*;

public class Diagonal {
	
	public boolean DPPmove(Vet v)	//MODIFICA V NA DIRE��O PP
	{
		VetUtil.movePP(v);
		if(v.getX() <= Consts.xyFin && v.getY() <= Consts.xyFin)
			return true;
		return false;
	}

	public boolean DNPmove(Vet v)	//MODIFICA V NA DIRE��O NP
	{
		VetUtil.moveNP(v);
		if(v.getX() >= Consts.xyIni && v.getY() <= Consts.xyFin)
			return true;
		
		return false;
	}

	public boolean DNNmove(Vet v)	//MODIFICA V NA DIRE��O NN
	{
		VetUtil.movePP(v);
		if(v.getX() >= Consts.xyIni && v.getY() >= Consts.xyIni)
			return true;
		
		return false;
	}

	public boolean DPNmove(Vet v)	//MODIFICA V DIRE��O PN
	{
		VetUtil.movePP(v);
		if(v.getX() <= Consts.xyFin && v.getY() >= Consts.xyIni)
			return true;
		
		return false;
	}
	
	private boolean addIfTrue(Vet v, Vet Temp, ArrayList<Vet> AllMoves, int r)	//autoexplicativo
	{
		
		switch(r)
		{
		case 1:
			if(DPPmove(v))
			{
				AllMoves.add(v);
				VetUtil.movePP(Temp);
				return true;
			}
			return false;
			
		case 2:
			if(DNPmove(v))
			{
				AllMoves.add(v);
				VetUtil.moveNP(Temp);
				return true;
			}
			return false;
			
		case 3:
			if(DNNmove(v))
			{
				AllMoves.add(v);
				VetUtil.moveNN(Temp);
				return true;
			}
			return false;

		case 4:
			if(DPNmove(v))
			{
				AllMoves.add(v);
				VetUtil.movePN(Temp);
				return true;
			}
			return false;
		default:
			return false;
		}
	}

	public boolean movDiag(int r, Vet v, ArrayList<Vet> AllMoves)	// MOVIMENTO DIAGONAL EM UMA DIRE��O E SENTIDO.
	{											// r = regi�o (dire��o e sentido) em rela��o ao eixo cartesiano
		Vet Temp = new Vet(v);
		
		while(addIfTrue(new Vet(Temp), Temp, AllMoves, r));

		if (AllMoves.isEmpty())
			return false;
		else
			return true;
	}

	public boolean allMovDiag(Vet v, ArrayList<Vet> AllMoves)	//RETORNA TODOS OS MOVIMENTOS VALIDOS PARA AS DIRE��ES DIAGONAIS.
	{
		for(int r = 1; r < 5; r++)
			movDiag(r, v, AllMoves);
		
		if (AllMoves.isEmpty())
			return false;
		else
			return true;
	}
}
