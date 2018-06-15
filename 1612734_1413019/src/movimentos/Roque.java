package movimentos;

import java.util.ArrayList;

import pecas.Peca;
import pecas.Rei;
import pecas.Torre;
import tabuleiro.Tabuleiro;
import vetor.Vet;



public class Roque {

	Tabuleiro tab;
	Vet coorPeca;

	public Roque(Tabuleiro tab, Vet v)	
	{
		this.tab = tab;
		coorPeca = v;
	}
	
	private boolean condicaoRoque(Peca rei, Peca torre)
	{
		if( torre instanceof Torre
		&& ((Rei)rei).getJaMoveu() == false
		&& ((Torre)rei).getJaMoveu() == false)
			return true;
		
		return false;
	}

	public void roqueEsquerdaB(Peca rei, Vet temp, ArrayList<Vet> AllMoves)
	{
		if(!tab.perguntaCasaPeca(temp))
			return;

		Peca torre = tab.getPeca(temp);

		temp.addX(1);
		if(!tab.perguntaCasaPeca(temp))
		{
			temp.addX(1);
			if(!tab.perguntaCasaPeca(temp))
			{
				temp.addX(1);
				if(!tab.perguntaCasaPeca(temp))
					if(condicaoRoque(rei, torre))
						AllMoves.add(new Vet(torre.getX(), torre.getY()));
			}
		}
	}

	public void roqueDireitaB(Peca rei, Vet temp, ArrayList<Vet> AllMoves)
	{
		if(!tab.perguntaCasaPeca(temp))
			return;

		Peca torre = tab.getPeca(temp);

		temp.addX(-1);
		if(!tab.perguntaCasaPeca(temp))
		{
		temp.addX(-1);
			if(!tab.perguntaCasaPeca(temp))
				if(condicaoRoque(rei, torre))
					AllMoves.add(new Vet(torre.getX(), torre.getY()));
		}
	}
	
	public void roqueEsquerdaP(Peca rei, Vet temp, ArrayList<Vet> AllMoves)
	{
		if(!tab.perguntaCasaPeca(temp))
			return;
		
		Peca torre = tab.getPeca(temp);
		
		temp.addX(-1);
		if(!tab.perguntaCasaPeca(temp))
		{
			temp.addX(-1);
			if(!tab.perguntaCasaPeca(temp))
				if(condicaoRoque(rei, torre))
					AllMoves.add(new Vet(torre.getX(), torre.getY()));
		}
	}

	public void roqueDireitaP(Peca rei, Vet temp, ArrayList<Vet> AllMoves)
	{
		if(!tab.perguntaCasaPeca(temp))
			return;

		Peca torre = tab.getPeca(temp);

		temp.addX(1);
		if(!tab.perguntaCasaPeca(temp))
		{
			temp.addX(1);
			if(!tab.perguntaCasaPeca(temp))
			{
				temp.addX(1);
				if(!tab.perguntaCasaPeca(temp))
					if(condicaoRoque(rei, torre))
						AllMoves.add(new Vet(torre.getX(), torre.getY()));
			}
		}
	}
}
