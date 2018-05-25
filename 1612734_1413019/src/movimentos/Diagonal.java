package movimentos;

import java.util.ArrayList;
import tabuleiro.Consts;

// ATENÇÃO, TODAS AS FUNÇÕES DESTA CLASSE MODIFICAM O VETOR V!!! 

public class Diagonal {		
	
	public static boolean DPPmove(int v[])	//NA DIREÇÃO PP
	{
		if(v[Consts.x] < Consts.xyFin && v[Consts.y] < Consts.xyFin)
		{
			MovUtil.movePP(v);
			return true;
		}
		
		return false;
	}
	
	public static boolean DNPmove(int v[])	//NA DIREÇÃO NP
	{
		if(v[Consts.x] > Consts.xyIni && v[Consts.y] < Consts.xyFin)
		{
			MovUtil.moveNP(v);
			return true;
		}
		
		return false;
	}

	public static boolean DNNmove(int v[])	//NA DIREÇÃO NN
	{
		if(v[Consts.x] > Consts.xyIni && v[Consts.y] > Consts.xyIni)
		{
			MovUtil.movePP(v);
			return true;
		}
		
		return false;
	}

	public static boolean DPNmove(int v[])	//DIREÇÃO PN
	{
		if(v[Consts.x] < Consts.xyFin && v[Consts.y] > Consts.xyIni)
		{
			MovUtil.movePP(v);
			return true;
		}
		return false;
	}


	public static ArrayList<int[]> movDiag(int r, int[] v)	// MOVIMENTO DIAGONAL EM UMA DIREÇÃO E SENTIDO. Não modifica v.
	{														// r = região (direção e sentido) em relação ao eixo cartesiano
		ArrayList<int[]> AllMoves = new ArrayList<int[]>();

		switch (r) {
		case 1: // Região 1 dos eixos cartesianos
			while (DPPmove(v))
				AllMoves.add(v);
			break;

		case 2: // Região 2 dos eixos cartesianos
			while (DNPmove(v))
				AllMoves.add(v);
			break;

		case 3: // Região 3 dos eixos cartesianos
			while (DNNmove(v))
				AllMoves.add(v);
			break;

		case 4: // Região 4 dos eixos cartesianos
			while (DPNmove(v))
				AllMoves.add(v);
			break;
		}
		if (AllMoves.isEmpty())
			return null;

		else
			return AllMoves;
	}
	
	public static ArrayList<int[]> allMovDiag(int[] v) {	//RETORNA TODOS OS MOVIMENTOS VALIDOS PARA AS DIREÇÕES DIAGONAIS.
		ArrayList<int[]> AllMoves = new ArrayList<int[]>();

		MovUtil.addAllINN(AllMoves, movDiag(1, v));
		MovUtil.addAllINN(AllMoves, movDiag(1, v));
		MovUtil.addAllINN(AllMoves, movDiag(1, v));
		MovUtil.addAllINN(AllMoves, movDiag(1, v));

		if (AllMoves.isEmpty())
			return null;
		else
			
			return AllMoves;
	}
}
