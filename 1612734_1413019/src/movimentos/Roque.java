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

	public void roqueEsquerdaB(Peca rei, Peca torre, Vet temp, ArrayList<Vet> AllMoves, Vet roque)
	{
		temp.addX(1);
		if(!tab.perguntaCasaPeca(temp))
		{
			temp.addX(1);
			if(!tab.perguntaCasaPeca(temp))
			{
				temp.addX(1);
				if(!tab.perguntaCasaPeca(temp))
					if(torre instanceof Torre
					&& rei.getCor() == torre.getCor()
					&& ((Rei)rei).getJaMoveu() == false
					&& ((Torre)rei).getJaMoveu() == false)
					{
						((Rei)rei).toogleJaMoveu();
						((Torre)torre).toogleJaMoveu();
						temp.addX(1);
						AllMoves.add(temp);
					}
			}
		}
	}

	public boolean roqueDireitaB(Peca rei, Peca torre, ArrayList<Vet> AllMoves)
	{
		if(rei instanceof Rei && torre instanceof Torre
		&& rei.getCor() == torre.getCor()
		&& ((Rei)rei).getJaMoveu() == false
		&& ((Torre)rei).getJaMoveu() == false)
		{
			((Rei)rei).toogleJaMoveu();
			((Torre)torre).toogleJaMoveu();
			return true;
		}
		return false;
	}
	
	public boolean roqueEsquerdaP(Peca rei, Peca torre, ArrayList<Vet> AllMoves)
	{
		if(rei instanceof Rei && torre instanceof Torre
		&& rei.getCor() == torre.getCor()
		&& ((Rei)rei).getJaMoveu() == false
		&& ((Torre)rei).getJaMoveu() == false)
		{
			((Rei)rei).toogleJaMoveu();
			((Torre)torre).toogleJaMoveu();
			return true;
		}
		return false;
	}

	public boolean roqueDireitaP(Peca rei, Peca torre, ArrayList<Vet> AllMoves)
	{
		if(rei instanceof Rei && torre instanceof Torre
		&& rei.getCor() == torre.getCor()
		&& ((Rei)rei).getJaMoveu() == false
		&& ((Torre)rei).getJaMoveu() == false)
		{
			((Rei)rei).toogleJaMoveu();
			((Torre)torre).toogleJaMoveu();
			return true;
		}
		return false;
	}
}
