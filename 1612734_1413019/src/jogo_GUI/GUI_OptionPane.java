package jogo_GUI;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GUI_OptionPane {
	
	public int loadGame ()
	{
		int resposta;
		ImageIcon img = new ImageIcon("Assets\\Chess_Icon2.png");
		
		resposta = JOptionPane.showConfirmDialog(null,"Deseja carregar um jogo salvo?", "Xadrez", 0, 0, img);
		
		return resposta;
	}
}
