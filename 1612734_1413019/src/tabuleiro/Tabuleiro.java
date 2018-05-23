package tabuleiro;

import java.awt.*;
import javax.swing.*;
import java.awt.Graphics2D;

public class Tabuleiro extends JComponent{
	
	private Object casa[][];
	
	private static void janelaPrincipal()
	{
		Tabuleiro tabuleiro = new Tabuleiro();
		
		JFrame janela = new JFrame ("Xadrez");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);
		janela.pack();
		janela.setVisible(true);
		
	}
	public void desenhaRetangulo(Graphics g) 
    {

		Graphics2D retangulo = (Graphics2D) g;
        super.paintComponent(g);
        retangulo.setColor(Color.black);   
        retangulo.drawRect(10,10,100,100);

    }
	
	public static void main (String[] args)
	{
		janelaPrincipal();
		
	}
}
