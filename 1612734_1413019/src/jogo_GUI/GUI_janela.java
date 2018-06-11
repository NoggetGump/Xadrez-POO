package jogo_GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

import pecas.Peca;
import tabuleiro.Consts;
import tabuleiro.Tabuleiro;

public class GUI_janela extends JFrame {
	
	Peca pecaSelecionada;
	
		public GUI_janela(GUI_main a, Tabuleiro tab)
		{
			addMouseListener(new MouseAdapter() 
			{
				public void mouseClicked(MouseEvent e)
				{
					int x = (e.getX()-4)/100;
					int y = (e.getY()-26)/100;
					Peca temp = tab.buscaPeca(x, y);
					if(temp != null)
					{
						pecaSelecionada = temp;
						a.selecPeca(pecaSelecionada);
					}
					
				}
			});
			
			/*ImageIcon img = new ImageIcon("Assets\\Chess_Icon2.png");
			this.setIconImage(img.getImage());*/
			this.setTitle("Xadrez");
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setSize(8 * Consts.tamC, 8 * Consts.tamC + 35);
		    getContentPane().add(a);
		    setLocationRelativeTo(null);
		    setResizable(false);
		    setVisible(true);
			System.out.println("Janela inicializada com sucesso!");
		}
}