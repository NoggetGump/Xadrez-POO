package jogo_GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import jogo_Main.Facade;
import pecas.Peca;
import tabuleiro.Consts;

@SuppressWarnings("serial")
public class GUI_janela extends JFrame {

		public GUI_janela(Facade facade, GUI_main gm)
		{
			ImageIcon img = new ImageIcon("Assets\\Chess_Icon2.png");
			this.setIconImage(img.getImage());
			this.setTitle("Xadrez");
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setSize(8 * Consts.tamC, 8 * Consts.tamC + 35);
		    getContentPane().add(gm);
		    setLocationRelativeTo(null);
		    setResizable(false);
		    setVisible(true);
			System.out.println("Janela inicializada com sucesso!\r\n");

			addMouseListener(new MouseAdapter()
			{
				public void mouseClicked(MouseEvent e)
				{
					// Mouse Esquerdo
					if(SwingUtilities.isLeftMouseButton(e))
					{
						int x = (e.getX()-4)/100;
						int y = (e.getY()-26)/100;
						Peca temp = facade.buscaPecaTab(x, y);

						facade.logicaJanelaE(x, y, temp);
					}
					else
						// Mouse Direito
						if(SwingUtilities.isRightMouseButton(e))
						{
							facade.logicaJanelaD();
						}							
				}
			});
		}
}