package jogo_GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class GUI_main extends JComponent{

	private final int tam = 100;
	
	public void paint(Graphics g) 
	{
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setPaint(Color.black);
	   
	    int i, j, x = 0, y = 0, ctrl = 2;
	    
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
	    
	    /*
	     * 
	     * 	Desenha Peças Pretas no Tabuleiro
	     * 
	     * */
	    x = 19;
	    y = 14;
	    
	    Image torreP1 = Toolkit.getDefaultToolkit().getImage("Assets\\Torre_P.png");
	    g2.drawImage(torreP1, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image cavaloP1 = Toolkit.getDefaultToolkit().getImage("Assets\\Cavalo_P.png");
	    g2.drawImage(cavaloP1, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image bispoP1 = Toolkit.getDefaultToolkit().getImage("Assets\\Bispo_P.png");
	    g2.drawImage(bispoP1, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image rainhaP = Toolkit.getDefaultToolkit().getImage("Assets\\Rainha_P.png");
	    g2.drawImage(rainhaP, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image reiP = Toolkit.getDefaultToolkit().getImage("Assets\\Rei_P.png");
	    g2.drawImage(reiP, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image bispoP2 = Toolkit.getDefaultToolkit().getImage("Assets\\Bispo_P.png");
	    g2.drawImage(bispoP2, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image cavaloP2 = Toolkit.getDefaultToolkit().getImage("Assets\\Cavalo_P.png");
	    g2.drawImage(cavaloP2, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image torreP2 = Toolkit.getDefaultToolkit().getImage("Assets\\Torre_P.png");
	    g2.drawImage(torreP2, x, y, this);
	    g2.finalize();
	    x = 17;	// Reajusta x
	    y = y + tam; // Reajusta y
	    
	    Image peaoP1 = Toolkit.getDefaultToolkit().getImage("Assets\\Peao_P.png");
	    g2.drawImage(peaoP1, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image peaoP2 = Toolkit.getDefaultToolkit().getImage("Assets\\Peao_P.png");
	    g2.drawImage(peaoP2, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image peaoP3 = Toolkit.getDefaultToolkit().getImage("Assets\\Peao_P.png");
	    g2.drawImage(peaoP3, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image peaoP4 = Toolkit.getDefaultToolkit().getImage("Assets\\Peao_P.png");
	    g2.drawImage(peaoP4, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image peaoP5 = Toolkit.getDefaultToolkit().getImage("Assets\\Peao_P.png");
	    g2.drawImage(peaoP5, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image peaoP6 = Toolkit.getDefaultToolkit().getImage("Assets\\Peao_P.png");
	    g2.drawImage(peaoP6, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image peaoP7 = Toolkit.getDefaultToolkit().getImage("Assets\\Peao_P.png");
	    g2.drawImage(peaoP7, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image peaoP8 = Toolkit.getDefaultToolkit().getImage("Assets\\Peao_P.png");
	    g2.drawImage(peaoP8, x, y, this);
	    g2.finalize();
	    x = 17;
	    y = 14;
	    
	    /*
	     * 
	     * 	Desenha peças brancas no tabuleiro
	     * 
	     * */
	    y = y + tam*6;
	    
	    Image peaoB1 = Toolkit.getDefaultToolkit().getImage("Assets\\Peao_B.png");
	    g2.drawImage(peaoB1, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image peaoB2 = Toolkit.getDefaultToolkit().getImage("Assets\\Peao_B.png");
	    g2.drawImage(peaoB2, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image peaoB3 = Toolkit.getDefaultToolkit().getImage("Assets\\Peao_B.png");
	    g2.drawImage(peaoB3, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image peaoB4 = Toolkit.getDefaultToolkit().getImage("Assets\\Peao_B.png");
	    g2.drawImage(peaoB4, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image peaoB5 = Toolkit.getDefaultToolkit().getImage("Assets\\Peao_B.png");
	    g2.drawImage(peaoB5, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image peaoB6 = Toolkit.getDefaultToolkit().getImage("Assets\\Peao_B.png");
	    g2.drawImage(peaoB6, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image peaoB7 = Toolkit.getDefaultToolkit().getImage("Assets\\Peao_B.png");
	    g2.drawImage(peaoB7, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image peaoB8 = Toolkit.getDefaultToolkit().getImage("Assets\\Peao_B.png");
	    g2.drawImage(peaoB8, x, y, this);
	    g2.finalize();
	    x = 17;
	    y = 14;
	    y = y + tam*7;
	    
	    Image torreB1 = Toolkit.getDefaultToolkit().getImage("Assets\\Torre_B.png");
	    g2.drawImage(torreB1, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image cavaloB1 = Toolkit.getDefaultToolkit().getImage("Assets\\Cavalo_B.png");
	    g2.drawImage(cavaloB1, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image bispoB1 = Toolkit.getDefaultToolkit().getImage("Assets\\Bispo_B.png");
	    g2.drawImage(bispoB1, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image rainhaB = Toolkit.getDefaultToolkit().getImage("Assets\\Rainha_B.png");
	    g2.drawImage(rainhaB, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image reiB = Toolkit.getDefaultToolkit().getImage("Assets\\Rei_B.png");
	    g2.drawImage(reiB, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image bispoB2 = Toolkit.getDefaultToolkit().getImage("Assets\\Bispo_B.png");
	    g2.drawImage(bispoB2, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image cavaloB2 = Toolkit.getDefaultToolkit().getImage("Assets\\Cavalo_B.png");
	    g2.drawImage(cavaloB2, x, y, this);
	    g2.finalize();
	    x = x + tam;
	    
	    Image torreB2 = Toolkit.getDefaultToolkit().getImage("Assets\\Torre_B.png");
	    g2.drawImage(torreB2, x, y, this);
	    g2.finalize();
	    
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
