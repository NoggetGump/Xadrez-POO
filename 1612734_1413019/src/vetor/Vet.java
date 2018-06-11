package vetor;

import tabuleiro.Consts;

public class Vet {

	private int[] v;

	public Vet(){
		v = new int[2];
	}
	
	public Vet(int x, int y){
		v = new int[2];
		this.set(x,  y);
	}

	public Vet(Vet v){
		this.v = new int[2];
		this.set(v.getX(), v.getY());
	}

	public int getX(){
		return v[0];
	}

	public void setX(int x){
		this.v[0] = x;
	}

	public int getY(){
		return v[1];
	}

	public void setY(int y) {
		this.v[1] = y;
	}

	public void set(int x, int y){
		this.v[0] = x;
		this.v[1] = y;
	}

	public void cpyVet(Vet v){
		this.set(v.getX(), v.getY());
	}

	public void addX(int x){
		this.setX(this.getX()+x);
	}

	public void addY(int y){
		this.setY(this.getY()+y);
	}

	public void add(int x, int y){
		this.set(this.getX() + x , this.getY() + y);	
	}

	public void add(Vet v){
		this.set(this.getX() + v.getX() , this.getY() + v.getY());
	}

	public int convCoorX()
	{ //converte as coordenadas cartesianas em coordenada User Space
		int coordenadaX = (this.getX() * Consts.tamC) + Consts.ajuste;
		return coordenadaX;
	}
	
	public int convCoorY()
	{ //converte as coordenadas cartesianas em coordenada User Space
		int coordenadaY =  (this.getY() * Consts.tamC) + Consts.ajuste;
		return coordenadaY;
	}
	
}
