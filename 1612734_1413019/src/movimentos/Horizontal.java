package movimentos;

import java.util.ArrayList;
import tabuleiro.Consts;
import vetor.*;

public class Horizontal {
	
	public static boolean hUnitP(Vet v)	// 		ATENÇÃO, MODIFICA V!!! RETORNA TRUE SE O MOVIMENTO UNITARIO POSITIVO SE POSSÍVEL
	{
		if(v.getX() < Consts.xyFin)
		{
			v.addX(1);
			return true;
		}
		
	return false;
	}

	public static boolean hUnitN(Vet v)	// ATENÃ‡ÃƒO, MODIFICA V!!! RETORNA TRUE SE O MOVIMENTO UNITARIO NEGATIVO SE POSSÍVEL
	{
		if(v.getX() > Consts.xyIni)
		{
			v.addX(-1);
			return true;
		}
		
		return false;
	}
	
	public static ArrayList<Vet> horP(Vet v) 			  //RETORNA TODOS OS MOVIMENTOS POSSIVEIS PARA EIXO x POSITIVO A PARTIR DA PECA.
	{														  //RETORNA NULL CASO NÃƒO HAJA MOVIMENTOS POSSIVEIS NO SENTIDO ESCOLHIDO.
		ArrayList<Vet> AllMoves = new ArrayList<Vet>();
		Vet Temp = VetUtil.cpyV(v);
		
		while(hUnitP(Temp))
			AllMoves.add(Temp);
		
		if(AllMoves.isEmpty())
			return null;
		else 
			
			return AllMoves;
	}
	
	public static ArrayList<Vet> horN(Vet v)	//RETORNA TODOS OS MOVIMENTOS POSSIVEIS PARA EIXO x NEGATIVO A PARTIR DA PECA.
	{												//RETORNA NULL CASO NÃƒO HAJA MOVIMENTOS POSSIVEIS NO SENTIDO ESCOLHIDO.
		ArrayList<Vet> AllMoves = new ArrayList<Vet>();
		Vet Temp = VetUtil.cpyV(v);
		
		while(hUnitN(Temp))
			AllMoves.add(Temp);
		
		if(AllMoves.isEmpty())
			return null;
		else 
			
			return AllMoves;
	}
	
	public static ArrayList<Vet>  allHorMov(Vet v)	//RETORNA TODOS OS MOVIMENTOS POSSIVEIS PARA EIXO X A PARTIR DA PECA.
	{
		ArrayList<Vet> AllMoves = new ArrayList<Vet>();
		
		VetUtil.addAllINN(AllMoves, horP(v));
		VetUtil.addAllINN(AllMoves, horN(v));
			
			return AllMoves;
	}
}
