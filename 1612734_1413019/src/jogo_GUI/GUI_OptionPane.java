package jogo_GUI;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import tabuleiro.Consts;

public class GUI_OptionPane {
	
	/**
	 * 	Menu de inicialização do jogo
	 * */
	public int loadGame ()
	{
		ImageIcon img = new ImageIcon("Assets\\Chess_Icon2.png");

		return JOptionPane.showConfirmDialog(null,"Deseja carregar um jogo salvo?", "Xadrez", 0, 0, img);
	}
	
	/**
	 * 	Menu de Game Over
	 * */
	public static int gameOver (char vencedor)
	{
		ImageIcon img;
		
		switch(vencedor)
		{
			case Consts.branca:
			{
				img = new ImageIcon("Assets\\xeque_mate.png");
				JOptionPane.showMessageDialog(null, "Vencedor:  jogador branco!", "Xeque-Mate", 0, img);
				break;
			}
			case Consts.preta:
			{
				img = new ImageIcon("Assets\\xeque_mate.png");
				JOptionPane.showMessageDialog(null, "Vencedor:  jogador preto!", "Xeque-Mate", 0, img);
				break;
			}
			default:
				img = new ImageIcon("Assets\\game_over.png");
				JOptionPane.showMessageDialog(null, "Não há vencedor\r\nFim de Jogo!", "Empate", 0, img);
				break;
			}

		return JOptionPane.showConfirmDialog(null,"Deseja começar uma nova partida ou carregar uma?", "Xadrez", 0, 0, img);
	}
}