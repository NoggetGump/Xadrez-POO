package movimentos;

import java.util.ArrayList;

import tabuleiro.Consts;
import tabuleiro.Tabuleiro;

import vetor.*;

public class Diagonal {
	
	private static Tabuleiro tab;
	
	public Diagonal(Tabuleiro tab)
	{
		Diagonal.tab = tab;
	}package movimentos;

import java.util.ArrayList;

import tabuleiro.Consts;
import tabuleiro.Tabuleiro;

import vetor.*;

public class Diagonal {

	private static Tabuleiro tab;
	private Vet coorPeca;

	public Diagonal(Tabuleiro tab, Vet v)
	{
		Diagonal.tab = tab;
		this.coorPeca = v;
	}

	public boolean DPPmove(Vet v, ArrayList<Vet> AllMoves, ArrayList<Vet> comiveis)	//MODIFICA V NA DIRECAO PP
	{
		VetUtil.movePP(v);
		if(v.getX() <= Consts.xyFin && v.getY() <= Consts.xyFin
		&& !tab.perguntaCasaPeca(v) && AllMoves != null)
		{
			AllMoves.add(v);
			return true;
		}

		if(v.getX() <= Consts.xyFin && v.getY() <= Consts.xyFin
		&& tab.perguntaComivel(coorPeca, v))
			comiveis.add(v);

		return false;
	}

	public boolean DNPmove(Vet v, ArrayList<Vet> AllMoves, ArrayList<Vet> comiveis)	//MODIFICA V NA DIRECAO NP
	{
		VetUtil.moveNP(v);
		if(v.getX() >= Consts.xyIni && v.getY() <= Consts.xyFin
		&& !tab.perguntaCasaPeca(v) && AllMoves != null)
		{
			AllMoves.add(v);
			return true;
		}
		
		if(v.getX() >= Consts.xyIni && v.getY() <= Consts.xyFin
		&& tab.perguntaComivel(coorPeca, v))
			comiveis.add(v);
		
		return false;
	}

	public boolean DNNmove(Vet v, ArrayList<Vet> AllMoves, ArrayList<Vet> comiveis)	//MODIFICA V NA DIRECAO NN
	{
		VetUtil.moveNN(v);
		if(v.getX() >= Consts.xyIni && v.getY() >= Consts.xyIni
		&& !tab.perguntaCasaPeca(v) && AllMoves != null)
		{
			AllMoves.add(v);
			return true;
		}

		if(v.getX() >= Consts.xyIni && v.getY() >= Consts.xyIni
		&& tab.perguntaComivel(coorPeca, v))
			comiveis.add(v);

		return false;
	}

	public boolean DPNmove(Vet v, ArrayList<Vet> AllMoves, ArrayList<Vet> comiveis)	//MODIFICA V DIRECAO PN
	{
		VetUtil.movePN(v);
		if(v.getX() <= Consts.xyFin && v.getY() >= Consts.xyIni
		&& !tab.perguntaCasaPeca(v) && AllMoves != null)
		{
			AllMoves.add(v);
			return true;
		}

		if(v.getX() <= Consts.xyFin && v.getY() >= Consts.xyIni
		&& tab.perguntaComivel(coorPeca, v))
			comiveis.add(v);

		return false;
	}

	private boolean addIfTrue(Vet v, Vet Temp, ArrayList<Vet> AllMoves, int sentido, ArrayList<Vet> comiveis)
	{

		switch(sentido)
		{
		case 1:
			if(DPPmove(v, AllMoves, comiveis))
			{
				VetUtil.movePP(Temp);
				return true;
			}
			return false;

		case 2:
			if(DNPmove(v, AllMoves, comiveis))
			{
				VetUtil.moveNP(Temp);
				return true;
			}
			return false;
			
		case 3:
			if(DNNmove(v, AllMoves, comiveis))
			{
				VetUtil.moveNN(Temp);
				return true;
			}
			return false;

		case 4:
			if(DPNmove(v, AllMoves, comiveis))
			{
				VetUtil.movePN(Temp);
				return true;
			}
			return false;
		default:
			return false;
		}
	}

	public boolean movDiag(int sentido, ArrayList<Vet> AllMoves, ArrayList<Vet> comiveis) // MOVIMENTO DIAGONAL EM UMA DIRECAO E SENTIDO.
	{ // sentido = regiao (direcao e sentido) em relacao ao (0,0) do eixo cartesiano
		Vet Temp = new Vet(coorPeca);
		
		while(addIfTrue(new Vet(Temp), Temp, AllMoves, sentido, comiveis));

		if (AllMoves.isEmpty())
			return false;
		else
			return true;
	}

	public boolean allMovDiag(ArrayList<Vet> AllMoves, ArrayList<Vet> comiveis)	//RETORNA TODOS OS MOVIMENTOS VALIDOS PARA AS DIRECOES DIAGONAIS.
	{
		for(int sentido = 1; sentido < 5; sentido++)
			movDiag(sentido, AllMoves, comiveis);
		
		if (AllMoves.isEmpty())
			return false;
		else
			return true;
	}
}


	public boolean DPPmove(Vet v)	//MODIFICA V NA DIRECAO PP
	{
		VetUtil.movePP(v);
		if(v.getX() <= Consts.xyFin && v.getY() <= Consts.xyFin && !tab.perguntaCasaPeca(v))
			return true;
		return false;
	}

	public boolean DNPmove(Vet v)	//MODIFICA V NA DIRECAO NP
	{
		VetUtil.moveNP(v);
		if(v.getX() >= Consts.xyIni && v.getY() <= Consts.xyFin && !tab.perguntaCasaPeca(v))
			return true;
		
		return false;
	}

	public boolean DNNmove(Vet v)	//MODIFICA V NA DIRECAO NN
	{
		VetUtil.moveNN(v);
		if(v.getX() >= Consts.xyIni && v.getY() >= Consts.xyIni && !tab.perguntaCasaPeca(v))
			return true;
		
		return false;
	}

	public boolean DPNmove(Vet v)	//MODIFICA V DIRECAO PN
	{
		VetUtil.movePN(v);
		if(v.getX() <= Consts.xyFin && v.getY() >= Consts.xyIni && !tab.perguntaCasaPeca(v))
			return true;
		
		return false;
	}
	
	private boolean addIfTrue(Vet v, Vet Temp, ArrayList<Vet> AllMoves, int r)
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

	public boolean movDiag(int r, Vet v, ArrayList<Vet> AllMoves) // MOVIMENTO DIAGONAL EM UMA DIRECAO E SENTIDO.
	{ // r = regiao (direcao e sentido) em relacao ao eixo cartesiano
		Vet Temp = new Vet(v);
		
		while(addIfTrue(new Vet(Temp), Temp, AllMoves, r));

		if (AllMoves.isEmpty())
			return false;
		else
			return true;
	}

	public boolean allMovDiag(Vet v, ArrayList<Vet> AllMoves)	//RETORNA TODOS OS MOVIMENTOS VALIDOS PARA AS DIRECOES DIAGONAIS.
	{
		for(int r = 1; r < 5; r++)
			movDiag(r, v, AllMoves);
		
		if (AllMoves.isEmpty())
			return false;
		else
			return true;
	}
}
