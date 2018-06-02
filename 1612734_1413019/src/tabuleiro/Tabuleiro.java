package tabuleiro;

import pecas.*;

import java.util.ArrayList;

public class Tabuleiro 
{
	private ArrayList<Casa> tab = new ArrayList<Casa>();
	
	private Peca addPeca(int i, int j)
	{//adiciona uma peça a uma casa
		switch(j)
		{//pecas pretas
		case 0:
			if(i==0||i==7)
				return new Torre(i, j, 'p');
			if(i==1||i==6)
				return new Cavalo(i, j, 'p');
			if(i==2||i==5)
				return new Bispo(i, j, 'p');
			if(i==3)
				return new Rei(i, j, 'p');
			if(i==4)
				return new Rainha(i, j, 'p');
			
		case 1:
			return new Peao(i, j, 'p');
		
		//pecas brancas
		case 6:
			return new Peao(i, j, 'b');

		case 7:
			if(i==0||i==7)
				return new Torre(i, j, 'b');
			if(i==1||i==6)
				return new Cavalo(i, j, 'b');
			if(i==2||i==5)
				return new Bispo(i, j, 'b');
			if(i==3)
				return new Rei(i, j, 'b');
			if(i==4)
				return new Rainha(i, j, 'b');
		}
		
		return null;
	}
	
	public Tabuleiro() 
	{
		for(int j = 0 ; j < 8 ; j++)
		{
			for(int i = 0 ; i < 8 ; i++)
			{
				tab.add(new Casa(i,j, addPeca(i,j)));
			}
		}
	}
}