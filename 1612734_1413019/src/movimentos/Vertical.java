package movimentos;

import java.util.ArrayList;
import tabuleiro.Consts;
import tabuleiro.Tabuleiro;
import vetor.*;

public class Vertical {

	private static Tabuleiro tab;
	
	public Vertical(Tabuleiro tab)
	{
		Vertical.tab = tab;
	}

	public boolean vUnitP(Vet v) //ATENÇÃO, MODIFICA V!!!
	{ //RETORNA TRUE SE O MOVIMENTO UNITARIO POSITIVO É POSSÍVEL
		v.addY(1);
		if(v.getY() <= Consts.xyFin && !tab.perguntaCasaPeca(v))
			return true;

		if(v.getY() <= Consts.xyFin && tab.perguntaCasaPeca(v))
			v.addY(1);

	return false;
	}

	public boolean vUnitN(Vet v)	// ATENÇÃO, MODIFICA V!!!
	{ // RETORNA TRUE SE O MOVIMENTO UNITARIO NEGATIVO É POSSÍVEL
		v.addY(-1);
		if(v.getY() >= Consts.xyIni && !tab.perguntaCasaPeca(v))
			return true;

		if(v.getY() >= Consts.xyIni && tab.perguntaCasaPeca(v))
			v.addY(-1);

		return false;
	}

	public boolean addIfTrue(Vet v, Vet Temp, ArrayList<Vet> AllMoves, boolean r)
	{ //r = true, se movimento for positivo
		if(r)
		{
			if(vUnitP(v))
			{
				AllMoves.add(v);
				if(Temp!=null)
					Temp.addY(1);
				return true;
			}
		}
		else
			if(vUnitN(v))
			{
				AllMoves.add(v);
				if(Temp!=null)
					Temp.addY(-1);
				return true;
			}
		
		return false;
	}

	public boolean ver(Vet v, boolean r, ArrayList<Vet> AllMoves) //ATUALIZA TODOS OS MOVIMENTOS POSSIVEIS PARA EIXO Y POSITIVO A PARTIR DA PECA.
	{ //RETORNA FALSE CASO NÃO HAJA MOVIMENTOS POSSIVEIS NO SENTIDO ESCOLHIDO. r = true, se movimento for positivo. 
		Vet Temp = new Vet(v);

		while(addIfTrue(new Vet(Temp), Temp, AllMoves, r));
		if(AllMoves.isEmpty())
			return false;

		return true;
	}

	public boolean allVerMov(Vet v, ArrayList<Vet> AllMoves) //ATUALIZA TODOS OS MOVIMENTOS POSSIVEIS PARA EIXO Y A PARTIR DA PECA.
	{ //RETORNA FALSE CASO NÃO TENHA ADICIONADO NENHUM MOVIMENTO A LISTA.
		boolean b1 = ver(v, true, AllMoves);
		boolean b2 = ver(v, false, AllMoves);
		
		if(!b1 && !b2)
			return false;

		return true;
	}
}