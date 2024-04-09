package JogoForca;

import java.util.Scanner;

public class InicioForca {      
        
    
    
    public static void inicioJogo(Scanner scanner) {
        System.out.println("Seja Bem vindo(a) ao Jogo da Forca!!!");
        System.out.println("==========================================");
        System.out.println("Digite 'M' para jogar multiplayer: ");
        System.out.println("==========================================");
        char modoJogo = scanner.next().toUpperCase().charAt(0);

        // Número de jogadores e nomes dos jogadores
        String[] nomesJogadores;
        if (modoJogo == 'M') {
            nomesJogadores = obterNomesJogadores(scanner);
        } else {
            nomesJogadores = new String[]{"Jogador 1"};
        }

        // Iniciar jogo
        JogoForca jogo = new JogoForca(nomesJogadores);
        JogoForca.iniciarJogo(scanner); 
    }

    
    // Método para obter os nomes dos jogadores
    public static String[] obterNomesJogadores(Scanner scanner) {
        System.out.println("Iniciando...");
        System.out.println("Digite o número de jogadores (máximo 9): ");
        int numJogadores = scanner.nextInt();
        scanner.nextLine();

        String[] nomesJogadores = new String[numJogadores];
        for (int i = 0; i < numJogadores; i++) {
            System.out.println("Digite o nome do jogador " + (i + 1) + ": ");
            nomesJogadores[i] = scanner.nextLine();
        }
        return nomesJogadores;
    }
}
