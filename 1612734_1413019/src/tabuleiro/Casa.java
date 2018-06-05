package tabuleiro;

import vetor.Vet;
import pecas.*;

public class Casa
{
	private Vet v;
	private Peca peca;
	private boolean casaOcupada = false;
	
	/**
	 * 
	 *	Construtor Casa
	 * 
	 * */
	public Casa(final int x, final int y, Peca p)
	{
		this.v = new Vet(x,y);
		peca = p;
		if(p!=null)
		{
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
	
	/**
	 * 
	 *   Retorna uma peca dada uma casa do tabuleiro
	 *   
	 * AS: Peca posicionada na casa
	 * ou null se casa estiver vazia
	 * 
	 * */
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
	/**
	 * 
	 *  (Sim, deveria estar em tabuleiro)
	 * 	Posiciona Peca na casa 
	 *  caso a casa esteja vazia
	 *  
	 *  AE: Casa c que se deseja posicionar a peca
	 *  	Peca p que se deseja movimentar
	 * 
	 * */
	public void posicionaPeca (Casa c_destino, Casa c_origem, Peca p)
	{
		if(c_destino.casaOcupada == false)
		{
			c_destino.peca = p; // Move peca p para a casa destino
			/*p.v*/
			c_destino.casaOcupada = true; // Casa destino passa estar ocupada
			c_origem.peca = null; // Casa origem nao possui mais peca
			c_origem.casaOcupada = false; // Casa origem agora esta vazia
		}
		else
		{
			System.out.println("Casa ocupada! Tente posicionar peca em uma casa valida vazia!");
		}
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