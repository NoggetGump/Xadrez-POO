package jogo_GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import pecas.Peca;
import tabuleiro.Consts;
import tabuleiro.Tabuleiro;

public class GUI_janela extends JFrame {

	Peca pecaSelecionada;
	boolean logicAssist = false;
	int turno = 1;
	JFileChooser fc = new JFileChooser();
	
		public GUI_janela(GUI_main a, Tabuleiro tab)
		{
			fc.setCurrentDirectory(new java.io.File("saves"));
			fc.setDialogTitle("Salvar Jogo - ESCREVA O NOME DO ARQUIVO DE SALVAMENTO");
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			addMouseListener(new MouseAdapter() 
			{
				public void mouseClicked(MouseEvent e)
				{
					// Mouse Esquerdo
					if(SwingUtilities.isLeftMouseButton(e))
					{
						int x = (e.getX()-4)/100;
						int y = (e.getY()-26)/100;
						Peca temp = tab.buscaPeca(x, y);
						
						if(temp != pecaSelecionada
						&& pecaSelecionada != null)
						{
							if(temp == null)
							{
								if(a.movPeca(pecaSelecionada, x, y))
								{
									turno ++;
									System.out.println("\r\n<< Turno " + turno + " >>\r\n");
								}
							}
							else
							{
								if(a.comePecaOuRoque(pecaSelecionada, temp))
								{
									turno++;
									System.out.println("\r\n<< Turno " + turno + " >>\r\n");
								}
							}
							pecaSelecionada = null;
						}
						else
							if(temp != null
							&& temp.turno(turno)) // Se houver peca na Casa clicada e se o turno do jogador for respeitado
							{
								pecaSelecionada = temp;
								a.selecPeca(pecaSelecionada);
							}
					}
					else
						// Mouse Direito
						if(SwingUtilities.isRightMouseButton(e))
						{
							int returnval = fc.showOpenDialog(getParent());
							if(returnval == JFileChooser.APPROVE_OPTION)
							{
								tab.salvaPartida(fc.getSelectedFile() + ".txt");	
							}
							else
							{
								System.out.println("Salvamento de partida cancelado pelo usuário");
							}
							
						}
				}
			});

			ImageIcon img = new ImageIcon("Assets\\Chess_Icon2.png");
			this.setIconImage(img.getImage());
			this.setTitle("Xadrez");
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setSize(8 * Consts.tamC, 8 * Consts.tamC + 35);
		    getContentPane().add(a);
		    setLocationRelativeTo(null);
		    setResizable(false);
		    setVisible(true);
			System.out.println("Janela inicializada com sucesso!\r\n");
			System.out.println("<< Turno " + turno + " >> - Jogador Branco começa!\r\n");
		}
}
