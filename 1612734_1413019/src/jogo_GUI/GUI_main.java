 package jogo_GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

import tabuleiro.*;
import vetor.Vet;
import pecas.Peca;

public class GUI_main extends JComponent{

	GUI_janela j;
	private static final int tamY = 2 * Consts.tamC;
	private static final int tamTab = 8 * Consts.tamC;
	private static Tabuleiro tab;
	private static Peca p = null;

	private void paintPecas(Graphics2D g2)
	{
		for(Peca peca : tab.getPecas())
		{
				g2.drawImage(Toolkit.getDefaultToolkit().getImage(peca.imgPeca()), peca.getVet().convCoorX(), peca.getVet().convCoorY(), this);
			    g2.finalize();
		}
	}

    private void highlightPeca(Graphics2D g2)
    {
    	if(p!=null)
    	{
	    	g2.setColor(new Color(255, 255, 0, 80));
	    	g2.draw(new Rectangle2D.Double(p.getX() * Consts.tamC, p.getY() * Consts.tamC, Consts.tamC, Consts.tamC));
			g2.fill(new Rectangle2D.Double(p.getX() * Consts.tamC, p.getY() * Consts.tamC, Consts.tamC, Consts.tamC));
			g2.setColor(new Color(0, 125, 125, 125));
			for(Vet move : p.getAllMoves())
			{
				g2.draw(new Rectangle2D.Double(move.getX() * Consts.tamC, move.getY() * Consts.tamC, Consts.tamC, Consts.tamC));
				g2.fill(new Rectangle2D.Double(move.getX() * Consts.tamC, move.getY() * Consts.tamC, Consts.tamC, Consts.tamC));
			}
			g2.setColor(new Color(125, 0, 0, 125));
			for(Vet come : p.getComiveis())
			{
				g2.draw(new Rectangle2D.Double(come.getX() * Consts.tamC, come.getY() * Consts.tamC, Consts.tamC, Consts.tamC));
				g2.fill(new Rectangle2D.Double(come.getX() * Consts.tamC, come.getY() * Consts.tamC, Consts.tamC, Consts.tamC));
			}
		    g2.finalize();
    	}
    }

    @Override
    public void paint(Graphics g)
	{
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setPaint(Color.black);

	    int x = 0, y = 0;

	    while(y<tamTab)
	    {
	    	if(y%tamY == 0)
	    	{
		    	g2.draw(new Rectangle2D.Double(x, y, Consts.tamC, Consts.tamC));
		    	x = x + Consts.tamC;
		    	g2.draw(new Rectangle2D.Double(x, y, Consts.tamC, Consts.tamC));
		    	g2.fill(new Rectangle2D.Double(x, y, Consts.tamC, Consts.tamC));
		    	x = x + Consts.tamC;
	    	}
	    	else
	    	{
	    		g2.draw(new Rectangle2D.Double(x, y, Consts.tamC, Consts.tamC));
		    	g2.fill(new Rectangle2D.Double(x, y, Consts.tamC, Consts.tamC));
		    	x = x + Consts.tamC;
		    	g2.draw(new Rectangle2D.Double(x, y, Consts.tamC, Consts.tamC));
		    	x = x + Consts.tamC;
	    	}
	    	if(x == tamTab)
	    	{
	    		y = y + Consts.tamC;
	    		x = 0;
	    	}
	    }

	    paintPecas(g2);

	    highlightPeca(g2);
	}

	public void inicializaTabuleiro(Tabuleiro tab)
	{
		GUI_main.tab = tab;
		j = new GUI_janela(this, tab);
	}

	public void selecPeca(Peca p)
	{
		System.out.println("\tVocê selecionou " + p.nomePeca());
		GUI_main.p = p;
		repaint();
	}

	public boolean movPeca(Peca p, int x, int y)
	{
		if(tab.movePeca(p, x, y))
		{
			tab.AtualizaMovPecas();
			GUI_main.p = null;
			repaint();
			System.out.println("\tVocê moveu " + p.nomePeca() + " para a casa ( " + x + " , " + y + " )");
			return true;
		}
		System.out.println("\tMovimento ilegal! Selecione outra peça");
		GUI_main.p = null;
		repaint();		// Se movimento for ilegal os movimentos possiveis são apagados e a peca é desselecionada
		return false;
	}
	
	public boolean comePeca(Peca selecionada, Peca comida)
	{
		if(tab.comePeca(selecionada, comida))
		{
			System.out.println("\tVocê comeu o(a) " + comida.nomePeca() + " inimigo(a)!");
			tab.AtualizaMovPecas();
			GUI_main.p = null;
			repaint();
			
			return true;
		}
		
		repaint();
		return false;
	}
}
