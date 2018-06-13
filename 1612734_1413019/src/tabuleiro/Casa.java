package tabuleiro;

import vetor.Vet;
import pecas.*;

public class Casa
{
	private Vet v;
	private Peca peca = null;
	private boolean casaOcupada = false;
	
	/**
	 * 
	 *	Construtor Casa
	 * 
	 * */
	public Casa(final int x, final int y, Peca p)
	{
		this.v = new Vet(x,y);
		if(p!=null)
		{
			peca = p;
			casaOcupada = true;
		}
	}
	/**
	 * 
	 *  Getters e Setters Casa
	 * 
	 * */
	public int getX()
	{
		return v.getX();
	}

	public int getY()
	{
		return v.getY();
	}

	public boolean getO()
	{
		return casaOcupada;
	}

	public Vet getVet()
	{
		return v;
	}

	public Peca getPeca()
	{
		if(casaOcupada == true)
			return this.peca;
		else
		{
			System.out.println("Casa Vazia");
			return null;
		}
	}

	public void setPeca(Peca p)
	{
			peca = p;
	}
	
	public void toogleO()
	{
		if(this.casaOcupada)
			casaOcupada = false;
		else
			casaOcupada = true;
			
	}

	public void printCasa()
	{
		if(casaOcupada = false)
		{
			System.out.print("-");
		}
		else 
		{
			
		}
	}
}