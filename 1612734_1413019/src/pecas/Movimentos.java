package pecas;

import java.util.ArrayList;

import tabuleiro.Consts;

/* Retorna todos os movimentos, dado que o usuário
 * tenha chamado a função correta e tenha passado
 * seu sentido e direção da maneira correta - int
 * r (diagonal) ou int a (vert/horizontal).******/

class Movimentos {
	
	static void addIfNotNull(ArrayList<int[]> to, int[] from) // autoexplicativo
	{
		if(from != null)
			to.add(from);
	}
	
	static void addAllIfNotNull(ArrayList<int[]> to, ArrayList<int[]> from ) // autoexplicativo
	{
		if(from != null)
			to.addAll(from);
	}
	
	static ArrayList<int []> allMovDiag(int[] v)
	{
		int [] Temp = new int[2];
		Temp[0] = v[0];
		Temp[1] = v[1];
		ArrayList<int[]> AllMoves = new ArrayList<int[]>();	// TODOS os movimentos validos para as diagonais.
		
		while(Temp[0] < Consts.xyFin && Temp[1] < Consts.xyFin)
		{
			Temp[0]++;
			Temp[1]++;
			addIfNotNull(AllMoves, Temp);
		}
		Temp[0] = v[0];
		Temp[1] = v[1];
		
		while(Temp[0] > Consts.xyIni && Temp[1] < Consts.xyFin)
		{
			Temp[0]--;
			Temp[1]++;
			addIfNotNull(AllMoves, Temp);
		}
		Temp[0] = v[0];
		Temp[1] = v[1];
		
		while(Temp[0] > Consts.xyIni && Temp[1] > Consts.xyIni)
		{
			Temp[0]--;
			Temp[1]--;
			addIfNotNull(AllMoves, Temp);
		}
		Temp[0] = v[0];
		Temp[1] = v[1];
		
		while(Temp[0] < Consts.xyFin || Temp[1] > Consts.xyIni)
		{
			Temp[0]++;
			Temp[1]--;
			addIfNotNull(AllMoves, Temp);
		}
		Temp[0] = v[0];
		Temp[1] = v[1];
		
		if(AllMoves.isEmpty())
			return null;
		else
			
			return AllMoves;
	}

	static ArrayList<int []> movDiag(int r, int[] v) // MOVIMENTO DIAGONAL EM UMA DIRECAO E SENTIDO - n�o sabemos ainda se ser� �til.
	{
		int [] Temp = new int[2];
		Temp[0] = v[0];
		Temp[1] = v[1];
		ArrayList<int[]> AllMoves = new ArrayList<int[]>();	// Todos os movimentos validos para a direcao e sentido requisitados 
		
		switch(r)
		{
			case 1:	// Região 1 dos eixos cartesianos
				while(Temp[0] < Consts.xyFin && Temp[1] < Consts.xyFin)
				{
					
					Temp[0]++;
					Temp[1]++;
					AllMoves.add(Temp);
				}
				break;
			
			case 2:	// Região 2 dos eixos cartesianos
				while(Temp[0] > Consts.xyIni && Temp[1] < Consts.xyFin)
				{
					Temp[0]--;
					Temp[1]++;
					AllMoves.add(Temp);
				}
				break;
			
			case 3:	// Região 3 dos eixos cartesianos
				while(Temp[0] > Consts.xyIni && Temp[1] > Consts.xyIni)
				{
					Temp[0]--;
					Temp[1]--;
					AllMoves.add(Temp);
					break;
				}
				break;
				
			case 4:	// Região 4 dos eixos cartesianos
				while(Temp[0] < Consts.xyFin || Temp[1] > Consts.xyIni)
				{
					Temp[0]++;
					Temp[1]--;
					AllMoves.add(Temp);
					break;
				}
				break;
		}
		if(AllMoves.isEmpty())
			return null;
		else
			return AllMoves;
	}
	
	private static int[]  LmovBasiCase(int[] v, boolean r, boolean xM, boolean yM)// xM = true se espelhado em X,
	{																			  // yM = true se espelhado em Y
		int[] Temp = new int[2];												  // r=false:x+2,y+1;r=true: x+1,y+2
		Temp[0] = v[0];
		Temp[1] = v[1];
		
		if(r)
		{
			if(xM)
				Temp[0]--;
			else
				Temp[0]++;
			if(yM)
				Temp[1]-=2;
			else
				Temp[1]+=2;			
		}
		
		else
		{
			if(xM)
				Temp[0]-=2;
			else
				Temp[0]+=2;
			if(yM)
				Temp[1]--;
			else
				Temp[1]++;
		}
	
		if(Temp[0] > Consts.xyFin || Temp[1] > Consts.xyFin
		|| Temp[0] < Consts.xyIni || Temp[1] < Consts.xyIni)
			return null;
		
		return Temp;
	}
	
	static ArrayList<int[]> movL(int[] v)
	{	// MOVIMENTO EM "L" - CAVALO
		int [] Temp = new int[2];
		Temp[0] = v[0];
		Temp[1] = v[1];
		ArrayList<int[]> AllMoves = new ArrayList<int[]>();	// Todos os movimentos validos de um cavalo
		
		addIfNotNull(AllMoves, LmovBasiCase(v, false, false, false));
		addIfNotNull(AllMoves, LmovBasiCase(v, false, true, false));
		addIfNotNull(AllMoves, LmovBasiCase(v, false, false, true));
		addIfNotNull(AllMoves, LmovBasiCase(v, false, true, true));
		addIfNotNull(AllMoves, LmovBasiCase(v, true, false, false));
		addIfNotNull(AllMoves, LmovBasiCase(v, true, true, false));
		addIfNotNull(AllMoves, LmovBasiCase(v, true, false, true));
		addIfNotNull(AllMoves, LmovBasiCase(v, true, true, true));
		
		return AllMoves;
	}
}
