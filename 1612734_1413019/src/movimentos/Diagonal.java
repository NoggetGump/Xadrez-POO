package movimentos;

import java.util.ArrayList;
import tabuleiro.Consts;
import vetor.*;

public class Diagonal {
	
	public boolean DPPmove(Vet v)	//MODIFICA V NA DIREÇÃO PP
	{
		VetUtil.movePP(v);
		if(v.getX() <= Consts.xyFin && v.getY() <= Consts.xyFin)
			return true;
		return false;
	}

	public boolean DNPmove(Vet v)	//MODIFICA V NA DIREÇÃO NP
	{
		VetUtil.moveNP(v);
		if(v.getX() >= Consts.xyIni && v.getY() <= Consts.xyFin)
			return true;
		
		return false;
	}

	public boolean DNNmove(Vet v)	//MODIFICA V NA DIREÇÃO NN
	{
		VetUtil.movePP(v);
		if(v.getX() >= Consts.xyIni && v.getY() >= Consts.xyIni)
			return true;
		
		return false;
	}

	public boolean DPNmove(Vet v)	//MODIFICA V DIREÇÃO PN
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
		}
		return false;
	}

	public ArrayList<Vet> movDiag(int r, Vet v)	// MOVIMENTO DIAGONAL EM UMA DIREÇÃO E SENTIDO.
	{											// r = região (direção e sentido) em relação ao eixo cartesiano
		ArrayList<Vet> AllMoves = new ArrayList<Vet>();
		Vet Temp = new Vet(v);
		
		while(addIfTrue(new Vet(Temp), Temp, AllMoves, r));

		if (AllMoves.isEmpty())
			return null;
		else
			return AllMoves;
	}

	public ArrayList<Vet> allMovDiag(Vet v)	//RETORNA TODOS OS MOVIMENTOS VALIDOS PARA AS DIREÇÕES DIAGONAIS.
	{
		ArrayList<Vet> AllMoves = new ArrayList<Vet>();
	
		for(int r = 1; r < 5; r++)
			VetUtil.addAllINN(AllMoves, movDiag(r, v));
		
		if (AllMoves.isEmpty())
			return null;
		else
			return AllMoves;
	}
}
