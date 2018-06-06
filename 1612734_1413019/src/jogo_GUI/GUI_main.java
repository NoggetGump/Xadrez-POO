package jogo_GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

import tabuleiro.*;
import pecas.*;

public class GUI_main extends JComponent{
	
	GUI_janela j;
	private static final int tamY = 2 * Consts.tamC;
	private static final int tamTab = 8 * Consts.tamC;
	private static Tabuleiro tab;

	public void paintPecas(Graphics2D g2)
	{
		for(Peca peca : tab.getPecas())
		{
			g2.drawImage(Toolkit.getDefaultToolkit().getImage(peca.imgPeca()), peca.convCoorX(), peca.convCoorY(), this);
		    g2.finalize();
		}
	}

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
	} 

	public void inicializaTabuleiro(Tabuleiro tab)
	{
		GUI_main.tab = tab;
		j = new GUI_janela(this, tab);
	}
	
	public void atualizaTab()
	{
	}
}