package pecas;

public abstract class Peca {

	protected int v[] = new int[2];
	protected char cor;
	protected boolean vivo;

	public Peca(int x, int y, char cor) {
		this.v[0] = x;
		this.v[1] = y;
		this.cor = cor;
	}

	public int getX() {
		return v[0];
	}

	public void setX(int x) {
		this.v[0] = x;
	}

	public int getY() {
		return v[1];
	}

	public void setY(int y) {
		this.v[1] = y;
	}

	public void setv(int x, int y) {
		this.v[0] = x;
		this.v[1] = y;
	}

	public char getCor() {
		return this.cor;
	}

	public abstract int[][] movimentoValido(int[] v);

}
