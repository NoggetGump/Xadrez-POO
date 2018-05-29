package jogo_GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class GUI_main extends JComponent{

	private final int tam = 100;
	
	public void paint(Graphics g) 
	{
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setPaint(Color.black);
	   
	    int i, j, ctrl = 2;
	    int x = 0;
	    int y = 0;
	    
	    for(i = 0 ; i < 8 ; i++)
	    {
	    	for(j = 0 ; j < 8/2 ; j++)
	    	{
	    		if(ctrl % 2 == 0)
	    		{
	    			g2.draw(new Rectangle2D.Double(x, y, tam, tam));
	    			x = x + tam;
	    		    g2.fill(new Rectangle2D.Double(x, y, tam, tam));
	    		    x = x + tam;
	    		}
	    		else
	    		{
	    			g2.fill(new Rectangle2D.Double(x, y, tam, tam));
	    			x = x + tam;
	    		    g2.draw(new Rectangle2D.Double(x, y, tam, tam));
	    		    x = x + tam;
	    		}
	    	}
	    	x = 0;
	    	ctrl++;
	    	y = y + tam;
	    }            
	}
	
	public void inicializaTabuleiro()
	{
		JFrame janela = new JFrame("Xadrez");
	    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    janela.setSize(816, 839);
	    janela.getContentPane().add(new GUI_main());
	    janela.setLocationRelativeTo(null);
	    janela.setResizable(false);
	    janela.setVisible(true);
		System.out.println("Janela inicializada com sucesso!");
	}

}
