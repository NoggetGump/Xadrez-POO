package tabuleiro;

import pecas.*;
import vetor.Vet;

import java.util.ArrayList;
import java.util.function.Function;

public class Tabuleiro 
{
	private ArrayList<Casa> tab = new ArrayList<Casa>();
	private ArrayList<Peca> pecas = new ArrayList<Peca>();

	/**
	 * 
	 *	Adiciona uma peca a uma casa
	 * 
	 * */

	private Function<Vet, Peca> addPeca = vet ->
	{
		int i = vet.getX();
		int j = vet.getY();
		Peca temp = null;

		switch(j)
		{//pecas pretas
		case 0:
			if(i==0||i==7)
			{
				temp = new Torre(vet, 'p');
				pecas.add(temp);
			}
			if(i==1||i==6)
			{
				temp = new Cavalo(vet, 'p');
				pecas.add(temp);
			}
			if(i==2||i==5)
			{
				temp = new Bispo(vet, 'p');
				pecas.add(temp);
			}
			if(i==3)
			{
				temp = new Rei(vet, 'p');
				pecas.add(temp);
			}
			if(i==4)
			{
				temp = new Rainha(vet, 'p');
				pecas.add(temp);
			}
			break;

		case 1:
			temp = new Peao(vet, 'p');
			pecas.add(temp);
			break;

		//pecas brancas
		case 6:
			temp = new Peao(vet, 'b');
			pecas.add(temp);
			break;

		case 7:
			if(i==0||i==7)
			{
				temp = new Torre(vet, 'b');
				pecas.add(temp);
			}
			if(i==1||i==6)
			{
				temp = new Cavalo(vet, 'b');
				pecas.add(temp);
			}
			if(i==2||i==5)
			{
				temp = new Bispo(vet, 'b');
				pecas.add(temp);
			}
			if(i==3)
			{
				temp = new Rei(vet, 'b');
				pecas.add(temp);
			}
			if(i==4)
			{
				temp = new Rainha(vet, 'b');
				pecas.add(temp);
			}
			break;
		}

		return temp;
	};

	/**
	 * 
	 *	Construtor Tabuleiro
	 * 
	 * */

	public Tabuleiro()
	{
		for(int j = 0 ; j <= Consts.xyFin; j++)
			for(int i = 0 ; i <= Consts.xyFin; i++)
				tab.add(new Casa(i, j, addPeca.apply(new Vet(i, j))));
	}

	/**
	 * 
	 *	Geters
	 * 
	 * */

	public Casa getCasa(int x, int y)
	{
	 	for(Casa casa : tab)
	 	{
	 		if(casa.getX() == x && casa.getY() == y)
	 			return casa;
	 	}
	 	return null;
	}
	
	public ArrayList<Peca> getPecas()
	{
		return pecas;
	}
}