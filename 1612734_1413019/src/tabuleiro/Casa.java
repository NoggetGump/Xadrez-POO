package tabuleiro;

import vetor.Vet;
import pecas.*;

public class Casa {

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
	public int getX(Casa c)
	{
		return c.v.getX();
	}
	
	public int getY(Casa c) 
	{
		return c.v.getY();
	}
	
	/**
	 * 
	 *   Retorna uma pe�a dada uma casa do tabuleiro
	 *   
	 *   AE: Casa c
	 *   AS: Pe�a posicionada na casa
	 *   	 ou null se casa estiver vazia
	 * 
	 * */
	public Peca getPecaNaCasa(Casa c)
	{
		if(casaOcupada == true)
		{
			return c.peca;
		}
		else
		{
			System.out.println("Casa Vazia");
			return null;
		}
	}
	
	/**
	 * 
	 *  (Essa fun��o pode mudar de classe)
	 * 	Posiciona Pe�a na casa 
	 *  caso a casa esteja vazia
	 *  
	 *  AE: Casa c que se deseja posicionar a pe�a
	 *  	Pe�a p que se deseja movimentar
	 * 
	 * */
	public void posicionaPeca (Casa c_destino, Casa c_origem, Peca p)
	{
		if(c_destino.casaOcupada == false)
		{
			c_destino.peca = p; // Move pe�a p para a casa destino
			/*p.v*/
			c_destino.casaOcupada = true; // Casa destino passa estar ocupada
			c_origem.peca = null; // Casa origem n�o possui mais pe�a
			c_origem.casaOcupada = false; // Casa origem agora est� vazia
		}
		else
		{
			System.out.println("Casa ocupada! Tente posicionar pe�a em uma casa v�lida vazia!");
		}
	}
	
	public void printCasa(Casa c)
	{
		if(c.casaOcupada = false)
		{
			System.out.print("-");
		}
	}
}
