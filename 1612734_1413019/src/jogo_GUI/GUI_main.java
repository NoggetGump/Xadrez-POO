 package jogo_GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

import tabuleiro.*;
import vetor.Vet;
import pecas.*;

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
				g2.drawImage(Toolkit.getDefaultToolkit().getImage(peca.imgPeca()), peca.convCoorX(), peca.convCoorY(), this);
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
		tab.AtualizaMovPeca(p);
		GUI_main.p = p;
		repaint();
	}

	public boolean movPeca(Peca selecionada, int x, int y)
	{
		if(tab.movePeca(selecionada, x, y))
		{
			GUI_main.p = null;
			repaint();
			System.out.println("\tVocê moveu " + selecionada.nomePeca() + " para a casa ( " + x + " , " + y + " )");
			if(tab.promocao(selecionada, j)
				repaint();
			return true;
		}
		System.out.println("\tMovimento ilegal! Selecione outra peça");
		GUI_main.p = null;
		repaint();		// Se movimento for ilegal os movimentos possiveis são apagados e a peca é deselecionada
		return false;
	}

	public boolean comePecaOuRoque(Peca selecionada, Peca alvo)
	{
		if(tab.comePeca(selecionada, alvo))
		{
			System.out.println("\tVocê comeu o(a) " + alvo.nomePeca() + " inimigo(a)!");
			GUI_main.p = null;
			repaint();
			if(selecionada instanceof Peao)
			{
				if(tab.promocao(selecionada))
					repaint();
			}

			return true;
		}
		else
			if(selecionada instanceof Rei
			&& tab.roque(selecionada, alvo))
			{
				GUI_main.p = null;
				repaint();
				return true;
			}

		System.out.println("Movimento ilegal");
		repaint();

		return false;
	}
}
