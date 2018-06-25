package tabuleiro;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import pecas.Peca;

public class Arquivo {

	Tabuleiro tab = new Tabuleiro();
	
	private Scanner sc;
	
	/**
	 * 
	 * 	Lê o arquivo e retorna o conteudo
	 * 
	 * */
	public void openFile(String path)
	{
		try {
			sc = new Scanner(new File(path));
			
		}
		catch(Exception e){
			System.out.println("Erro! Arquivo não encontrado!");
		}
	}
	
	public void readFile()
	{
		
		while(sc.hasNext())
		{	
			Peca temp = null;
			
			String peca = sc.next();
			String c = sc.next();
			char cor = c.charAt(0);
			int x = Integer.parseInt(sc.next());
			int y = Integer.parseInt(sc.next());
		
			temp = tab.cnvrtPeca(peca, x, y, cor);
			temp.setCor(cor);
			//System.out.println(temp.nome() + " " + temp.getCor() + " " + x + " " + y);
			
		}	
		
		sc.close();
	}
 
    /**
     * 
     * 	Escreve no arquivo
     * 
     * */
    public static boolean writeFile(String path,String texto){
    	
        try {
        	
            FileWriter arq = new FileWriter(path);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(texto);
            gravarArq.close();
            return true;
            
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
