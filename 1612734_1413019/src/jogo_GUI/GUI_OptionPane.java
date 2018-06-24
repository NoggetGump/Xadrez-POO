package jogo_GUI;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GUI_OptionPane {
	
	/**
	 * 
	 * 	Menu de inicialização do jogo
	 * 
	 * */
	public int loadGame ()
	{
		int resposta;
		ImageIcon img = new ImageIcon("Assets\\Chess_Icon2.png");
		
		resposta = JOptionPane.showConfirmDialog(null,"Deseja carregar um jogo salvo?", "Xadrez", 0, 0, img);
		System.out.println(resposta);
		
		return resposta;
	}
	
	/**
	 * 
	 * 	Menu de Game Over
	 * 
	 * */
	public void gameOver (char vencedor)
	{
		ImageIcon img;
		
		switch(vencedor)
		{
		case 'b':
		{
			img = new ImageIcon("Assets\\Rainha_B.png");
			JOptionPane.showMessageDialog(null, "Vencedor:  jogador branco!", "Xeque-Mate", 0, img);
			break;
		}
		case 'p':
		{
			img = new ImageIcon("Assets\\Rainha_P.png");
			JOptionPane.showMessageDialog(null, "Vencedor:  jogador preto!", "Xeque-Mate", 0, img);
			break;
		}
		default:
			break;
		}
	}
}
