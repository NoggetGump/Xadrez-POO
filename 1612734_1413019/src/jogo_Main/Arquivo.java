package jogo_Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import pecas.*;
import vetor.Vet;

public class Arquivo {

	private Scanner sc;
	private Facade facade;

	public Arquivo(Facade facade)
	{
		this.facade = facade;
	}

	/**
	 * 	Abre o arquivo e retorna o conteudo
	 * */

	public void openFile(String path)
	{
		try {
			sc = new Scanner(new File(path));

		}
		catch(Exception e){
			System.out.println("Erro! Arquivo nao encontrado!");
		}
	}
	
	/**
	 * 	Le o arquivo
	 * */

	public void readFile()
	{
		facade.setTurno(Integer.parseInt(sc.next()));
		while(sc.hasNext())
		{	
			Peca temp = null;

			String peca = sc.next();
			String c = sc.next();
			char cor = c.charAt(0);
			int x = Integer.parseInt(sc.next());
			int y = Integer.parseInt(sc.next());

			temp = cnvrtANDadd(peca, x, y, cor);
			temp.setCor(cor);
		}
		sc.close();
	}
	
	/**
	 * 	Abre e Le o arquivo.
	 * */

	public void carregaPartida(String arq)
	{
		openFile(arq);
		readFile();
	}
	
	/**
	 * 	Converte uma String que indica uma peca em um Objeto Peca
	 * 	e adiciona este objeto ao tabuleiro.
	 * */

	public Peca cnvrtANDadd(String nomePeca, int x, int y, char cor)
	{
		Peca temp = null;
		Vet v = new Vet(x, y);

		switch(nomePeca)
		{
			case "Bispo":
			{
				temp = new Bispo(v, cor);
				facade.addPecaTab(temp);

				break;
			}
			case "Cavalo":
			{
				temp = new Cavalo(v, cor);
				facade.addPecaTab(temp);

				break;
			}
			case "Peao":
			{
				temp = new Peao(v, cor);
				facade.addPecaTab(temp);

				break;
			}
			case "Rainha":
			{
				temp = new Rainha(v, cor);
				facade.addPecaTab(temp);

				break;
			}
			case "Rei":
			{
				temp = new Rei(v, cor);
				facade.addPecaTab(temp);

				break;
			}
			case "Torre":
			{
				temp = new Torre(v, cor);
				facade.addPecaTab(temp);

				break;
			}
			default:
			{
				break;
			}
		}

		System.out.println(temp.nome() + " " + temp.getCor() + " " + temp.getX() + " " + temp.getY()); // printa peca criada

		return temp;
}

	/**
	 * 	Escreve no arquivo.
	 * */

	public boolean writeFile(String path,String text){

       try{
           FileWriter arq = new FileWriter(path);
           PrintWriter gravarArq = new PrintWriter(arq);
           gravarArq.println(text);
           gravarArq.close();
           
           return true;
       }catch(IOException e){
           System.out.println(e.getMessage());

           return false;
        }
	}
	
	/**
	 * 	Salva a partida.
	 * */
	
	public void salvaPartida(String arq)
	{
		String texto = facade.getTurno().toString() + "\n"; // Conteudo que sera escrito no arquivo de salvamento

		for(Peca peca : facade.getPecasTab())
		{
			texto += peca.printSave() + "\r\n"; // Concatena o conteudo lido a medida que percorre ArrayList pecas
		}

        if(writeFile(arq, texto)) // Escreve no arquivo
            System.out.println("Jogo Salvo!");
        else
            System.out.println("Erro ao salvar o arquivo!");
	}
}
