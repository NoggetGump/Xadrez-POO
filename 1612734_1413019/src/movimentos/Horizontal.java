package movimentos;

import java.util.ArrayList;
import tabuleiro.Consts;
import vetor.*;

public class Horizontal {

	public boolean hUnitP(Vet v) //ATEN��O, MODIFICA V!!!
	{ //RETORNA TRUE SE O MOVIMENTO UNITARIO POSITIVO � POSS�VEL
		v.addX(1);
		if(v.getX() <= Consts.xyFin)
			return true;
		
		return false;
	}

	public boolean hUnitN(Vet v)	// ATEN��O, MODIFICA V!!!
	{ // RETORNA TRUE SE O MOVIMENTO UNITARIO NEGATIVO � POSS�VEL
		v.addX(-1);
		if(v.getX() >= Consts.xyIni)
			return true;
		
		return false;
	}
	
	public boolean addIfTrue(Vet v, Vet Temp, ArrayList<Vet> AllMoves, boolean r) //autoexplicativo.
	{ //r = true, se movimento for positivo
		if(r)
		{
			if(hUnitP(v))
			{
				AllMoves.add(v);
				if(Temp!=null)
					Temp.addX(1);
				return true;
			}
		}
		else
			if(hUnitN(v))
			{
				AllMoves.add(v);
				if(Temp!=null)
					Temp.addX(-1);
				return true;
			}
		
		return false;
	}

	public boolean hor(Vet v, boolean r, ArrayList<Vet> AllMoves)	//RETORNA TODOS OS MOVIMENTOS POSSIVEIS PARA EIXO X POSITIVO A PARTIR DA PECA.
	{ //r = true, se movimento for positivo. RETORNA NULL CASO N�O HAJA MOVIMENTOS POSSIVEIS NO SENTIDO ESCOLHIDO.
		Vet Temp = new Vet(v);
		
		while(addIfTrue(new Vet(Temp), Temp, AllMoves, r));
		if(AllMoves.isEmpty())
			return false;
		else 
			
			return true;
	}

	public boolean  allHorMov(Vet v, ArrayList<Vet> AllMoves)	//RETORNA TODOS OS MOVIMENTOS POSSIVEIS PARA EIXO X A PARTIR DA PECA.
	{ //RETORNA FALSE CASO N�O TENHA ADICIONADO NENHUM MOVIMENTO A LISTA.
		boolean b1 = hor(v, true, AllMoves);
		boolean b2 = hor(v, false, AllMoves);
		
	if (!b1 && !b2)
		return false;
	else
		return true;
	}
}