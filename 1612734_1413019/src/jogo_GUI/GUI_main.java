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

	private static final int tam = 75;
	private static final int tamTab = 8 * tam;
	private static ArrayList<Peca> pecas = new ArrayList<Peca>();

	public void paintPecas(Graphics2D g2)
	{
		for(Peca peca : pecas)
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
	    	if(y%150 == 0) 
	    	{
		    	g2.draw(new Rectangle2D.Double(x, y, tam, tam));
		    	x = x + tam;
		    	g2.draw(new Rectangle2D.Double(x, y, tam, tam));
		    	g2.fill(new Rectangle2D.Double(x, y, tam, tam));
		    	x = x + tam;
	    	}
	    	else
	    	{
	    		g2.draw(new Rectangle2D.Double(x, y, tam, tam));
		    	g2.fill(new Rectangle2D.Double(x, y, tam, tam));
		    	x = x + tam;
		    	g2.draw(new Rectangle2D.Double(x, y, tam, tam));
		    	x = x + tam;
	    	}
	    	if(x == tamTab)
	    	{
	    		y = y + tam;
	    		x = 0;
	    	}
	    }
	    
	    paintPecas(g2);
	} 

	public void inicializaTabuleiro(Tabuleiro tab)
	{
		JFrame janela = new JFrame("Xadrez");
	    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    janela.setSize(600, 600);
	    janela.getContentPane().add(new GUI_main());
	    janela.setLocationRelativeTo(null);
	    janela.setResizable(false);
	    janela.setVisible(true);

	    pecas = tab.getPecas();
	    System.out.println("Janela inicializada com sucesso!");
	}
}