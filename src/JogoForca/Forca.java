package JogoForca;

import java.util.Scanner;

public class Forca {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	
    	InicioForca.inicioJogo(scanner);
    	
    	
    	Scanner sc = new Scanner(System.in);
    	
    	
    	JogoForca.iniciarJogo(sc);
    	JogoForca.escolherPalavra();
    	JogoForca.inicializarLetrasDescobertas(0);
    	JogoForca.mostrarEstadoAtual(null, 0);
    	JogoForca.Escolha(scanner, null, false);
    	JogoForca.tentarAcertarLetra(scanner, null, null, null, 0);
    	JogoForca.tentarAcertarPalavra(scanner, null);
    	
    	
    	sc.close();
    	
    	
    	
    	
    	
    	

    }
}
