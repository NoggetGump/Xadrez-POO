package movimentos;

import java.util.ArrayList;
import tabuleiro.Consts;

public class Horizontal {
	
	public static boolean hUnitP(int[] v)	// ATENÇÃO, MODIFICA V!!! RETORNA TRUE SE O MOVIMENTO UNITARIO POSITIVO É POSSÍVEL
	{
		if(v[Consts.x] < Consts.xyFin)
		{
			v[Consts.x]++;
			return true;
		}
		
	return false;
	}

	public static boolean hUnitN(int[] v)	// ATENÇÃO, MODIFICA V!!! RETORNA TRUE SE O MOVIMENTO UNITARIO NEGATIVO É POSSÍVEL
	{
		if(v[Consts.x] > Consts.xyIni)
		{
			v[Consts.x]--;
			return true;
		}
		
		return false;
	}
	
	public static ArrayList<int[]> horP(int[] v) 			  //RETORNA TODOS OS MOVIMENTOS POSSIVEIS PARA EIXO x POSITIVO A PARTIR DA PECA.
	{														  //RETORNA NULL CASO NÃO HAJA MOVIMENTOS POSSIVEIS NO SENTIDO ESCOLHIDO.
		ArrayList<int[]> AllMoves = new ArrayList<int[]>();
		int[] Temp = MovUtil.cpyArray(v);
		
		while(hUnitP(Temp))
			AllMoves.add(Temp);
		
		if(AllMoves.isEmpty())
			return null;
		else 
			
			return AllMoves;
	}
	
	public static ArrayList<int[]> horN(int[] v)	//RETORNA TODOS OS MOVIMENTOS POSSIVEIS PARA EIXO x NEGATIVO A PARTIR DA PECA.
	{												//RETORNA NULL CASO NÃO HAJA MOVIMENTOS POSSIVEIS NO SENTIDO ESCOLHIDO.
		ArrayList<int[]> AllMoves = new ArrayList<int[]>();
		int[] Temp = MovUtil.cpyArray(v);
		
		while(hUnitN(Temp))
			AllMoves.add(Temp);
		
		if(AllMoves.isEmpty())
			return null;
		else 
			
			return AllMoves;
	}
	
	public static ArrayList<int[]>  allHorMov(int[] v)	//RETORNA TODOS OS MOVIMENTOS POSSIVEIS PARA EIXO X A PARTIR DA PECA.
	{
		ArrayList<int[]> AllMoves = new ArrayList<int[]>();
		
		MovUtil.addAllINN(AllMoves, horP(v));
		MovUtil.addAllINN(AllMoves, horN(v));
			
			return AllMoves;
	}
}
