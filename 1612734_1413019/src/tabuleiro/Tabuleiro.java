package tabuleiro;

import pecas.Peca;
import vetor.Vet;

import java.util.ArrayList;

public class Tabuleiro 
{
	private ArrayList<Casa> tabuleiro = new ArrayList<Casa>();
	
	public Tabuleiro() 
	{
		for(int i = 0 ; i < 8 ; i++)
		{
			for(int j = 0 ; j < 8 ; j++)
			{
				tabuleiro.add(new Casa(i,j));
			}	
		}
	}
	
	public void printTabuleiro()
	{
		
	}
	
	
}
