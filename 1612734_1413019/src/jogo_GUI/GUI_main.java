package jogo_GUI;

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
	
	private static void desenhaTabuleiro()
	{
		
		
	}

	public static void main(String[] args)
	{
		janelaPrincipal();
	}
}
