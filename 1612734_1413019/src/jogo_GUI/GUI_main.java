package jogo_GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import tabuleiro.Tabuleiro;

public class GUI_main {
	
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
	
	public void desenhaCasa(Graphics g) 
    {
		
    }

	public static void main(String[] args)
	{
		janelaPrincipal();
	}
}
