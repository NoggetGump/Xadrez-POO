package tabuleiro;

import java.io.File;

public final class Consts 
{
	public static final int xyIni = 0;
	public static final int xyFin = 7;
	public static final int tamC= 100;
	public static final int ajuste = 17;
	public static final File root = new File(System.getProperty("user.dir"));
	public static final File assets = new File(root, "Assets");
	public static final File torreP = new File(assets, "Torre_P.png");
	public static final File torreB = new File(assets, "Torre_B.png");
	public static final File cavaloP = new File(assets, "Cavalo_P.png");
	public static final File cavaloB = new File(assets, "Cavalo_B.png");
	public static final File bispoP = new File(assets, "Bispo_P.png");
	public static final File bispoB = new File(assets, "Bispo_B.png");
	public static final File reiP = new File(assets, "Rei_P.png");
	public static final File reiB = new File(assets, "Rei_B.png");
	public static final File rainhaP = new File(assets, "Rainha_P.png");
	public static final File rainhaB = new File(assets, "Rainha_B.png");
	public static final File peaoP = new File(assets, "Peao_P.png");
	public static final File peaoB = new File(assets, "Peao_B.png");
}
