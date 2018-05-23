package pecas;


public abstract class Peca{

	protected int x, y;
	protected char cor;
	protected boolean vivo;
	
	public Peca(int x, int y, char cor)
	{
		this.x = x;
		this.y = y;
		this.cor = cor;
	}
	
	public int getX() 
	{
		return x;
	}
	
	public void setX(int x) 
	{
		this.x = x;
	}
	
	public int getY() 
	{
		return y;
	}
	
	public void setY(int y) 
	{
		this.y = y;
	}
	
	public void setXY(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public char getCor()
	{
		return this.cor;
	}	
	
	public abstract int[][] movimentosPossiveis (int [] v);

}
