package movimentos;

import java.util.ArrayList;
import tabuleiro.Consts;
import tabuleiro.V;

public class Vertical {
	
	public static boolean vertUnitP(int[] v)	// RETORNA TRUE SE O MOVIMENTO POSITIVO FOR POSSÍVEL
	{
		if(v[V.y] < Consts.xyFin)
		{
			v[V.y]++;
			return true;
		}
		
	return false;
	}

	public static boolean vertUnitN(int[] v)	// RETORNA TRUE SE O MOVIMENTO NEGATIVO FOR POSSÍVEL
	{
		if(v[V.y] > Consts.xyIni)
		{
			v[V.y]--;
			return true;
		}
		
		return false;
	}
	
	public static ArrayList<int[]> vertP(int[] v)	//RETORNA TODOS OS MOVIMENTOS POSSIVEIS PARA EIXO Y POSITIVO A PARTIR DA PECA
	{											 	//RETORNA NULL CASO NÃO HAJA MOVIMENTOS POSSIVEIS NO SENTIDO ESCOLHIDO.
		ArrayList<int[]> AllMoves = new ArrayList<int[]>();
		int[] Temp = MovUtil.cpyArray(v);
		
		while(vertUnitP(Temp))
			AllMoves.add(Temp);
		
		if(AllMoves.isEmpty())
			return null;
		else 
			
			return AllMoves;
	}
	
	public static ArrayList<int[]> vertN(int[] v)	//RETORNA TODOS OS MOVIMENTOS POSSIVEIS PARA EIXO Y NEGATIVO A PARTIR DA PECA.
	{											 	//RETORNA NULL CASO NÃO HAJA MOVIMENTOS POSSIVEIS NO SENTIDO ESCOLHIDO.
		ArrayList<int[]> AllMoves = new ArrayList<int[]>();
		int[] Temp = MovUtil.cpyArray(v);
		
		while(vertUnitN(Temp))
			AllMoves.add(Temp);
		
		if(AllMoves.isEmpty())
			return null;
		else 
			
			return AllMoves;
	}
	
	public static ArrayList<int[]>  allVerMov(int[] v)
	{
		ArrayList<int[]> AllMoves = new ArrayList<int[]>();
		
		MovUtil.addAllINN(AllMoves, vertP(v));
		MovUtil.addAllINN(AllMoves, vertN(v));
			
			return AllMoves;
	}
}
