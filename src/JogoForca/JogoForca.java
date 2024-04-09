package JogoForca;
import java.util.Scanner;

public class JogoForca {
	private static char[] palavraSecreta;
    private static char[] letrasDescobertas;
    private static boolean[] letrasErradas;
    private static int tentativasRestantes;
    private static String[] nomesJogadores;
    private static boolean vencedor;

    public JogoForca(String[] nomesJogadores) {
        JogoForca.nomesJogadores = nomesJogadores;
    }

    	public static void iniciarJogo(Scanner scanner) {
    	    palavraSecreta = escolherPalavra();
    	    letrasDescobertas = inicializarLetrasDescobertas(palavraSecreta.length);
    	    letrasErradas = new boolean[26];
    	    tentativasRestantes = 4;
    	    vencedor = false;
    	    
    	    int jogadorAtual = 0;
            boolean segundaRodada = false;

            while (tentativasRestantes > 0 && !vencedor) {
                for (String nomeJogador : nomesJogadores) {
                    mostrarEstadoAtual(nomeJogador, tentativasRestantes);

                char escolha;
                if (segundaRodada) {
                    escolha = Escolha(scanner, nomesJogadores[jogadorAtual], segundaRodada);
                    if (escolha == 'A') {
                        vencedor = tentarAcertarPalavra(scanner, palavraSecreta);
                        if (!vencedor) {
                            tentativasRestantes--;
                        }
                    } else if (escolha == 'L') {
                        tentativasRestantes = tentarAcertarLetra(scanner, palavraSecreta, letrasDescobertas, letrasErradas, tentativasRestantes);
                    }
                } else {
                    tentativasRestantes = tentarAcertarLetra(scanner, palavraSecreta, letrasDescobertas, letrasErradas, tentativasRestantes);
                }

                jogadorAtual = (jogadorAtual + 1) % nomesJogadores.length;

                // Atualiza para a segunda rodada após a primeira rodada
                if (jogadorAtual == 0 && !segundaRodada) {
                	segundaRodada = true;
                }
            }
           }
            
                //Verificar o vencedor
                if (vencedor) {
                    System.out.println("Parabéns, " + nomesJogadores[jogadorAtual] + ", você venceu! A palavra era: " + String.valueOf(palavraSecreta));
                } else {
                    System.out.println("Você foi enforcado! A palavra correta era: " + String.valueOf(palavraSecreta));
                    scanner.close();
                    System.exit(0);  
                }

                         
    	}
    	
    	

    // Métodos para escolher uma palavra secreta e inicializar letras descobertas
    static char[] escolherPalavra() {
        return "PROGRAMAÇÃO".toCharArray();
    }

    static char[] inicializarLetrasDescobertas(int tamanho) {
        char[] letrasDescobertas = new char[tamanho];
        for (int i = 0; i < tamanho; i++) {
            letrasDescobertas[i] = '_';
        }
        return letrasDescobertas;
    }

    // Métodos para mostrar o estado atual do jogo e pedir a escolha do jogador
    static void mostrarEstadoAtual(String nomeJogador, int tentativasRestantes) {
        System.out.println("\nPalavra: " + String.valueOf(letrasDescobertas));
        System.out.println("São 11 letras");
        System.out.println("\nLetras erradas: ");
        
        for (int i = 0; i < 26; i++) {
            if (letrasErradas[i]) {
                System.out.print((char) ('A' + i) + " ");
            }
        }
            System.out.print("\n" + nomeJogador + " ");
            DesenhoForca.desenharForca(tentativasRestantes);
        }
    
    
    // Método para pedir ao jogador sua escolha (acertar a palavra ou falar uma letra)
    static char Escolha(Scanner scanner, String nomeJogador, boolean segundoRound) {
    	System.out.print("\n" + nomeJogador + ", quer falar a palavra (A) ou digitar uma letra (L)? ");
        return scanner.next().toUpperCase().charAt(0);
    }
    
    // Método para tentar acertar a palavra
    static boolean tentarAcertarPalavra(Scanner scanner, char[] palavraSecreta) {
        System.out.print("Digite a palavra: ");
        String palavraTentativa = scanner.next().toUpperCase();
        return palavraTentativa.equals(String.valueOf(palavraSecreta));
    }
    
    static int tentarAcertarLetra(Scanner scanner, char[] palavraSecreta, char[] letrasDescobertas, boolean[] letrasErradas, int tentativasRestantes) {
	    System.out.print("Digite uma letra: ");
	    char letra = scanner.next().toUpperCase().charAt(0);

	    boolean letraDescoberta = false; 
	    
	    for (int i = 0; i < palavraSecreta.length; i++) {
	        if (palavraSecreta[i] == letra) { 
	            letrasDescobertas[i] = letra;
	            letraDescoberta = true; 
	        }
	    }

	   
	    if (!letraDescoberta) {
	        int indiceLetra = letra - 'A'; 
	        letrasErradas[indiceLetra] = true;
	        tentativasRestantes--; 
	    } else { 
	        
	        boolean palavraCompleta = true;
	     // verificar se ainda tem letras não descobertas
	        for (int i = 0; i < letrasDescobertas.length; i++) {
	            if (letrasDescobertas[i] == '_') {
	    
	                palavraCompleta = false;
	                break;
	            }
	        }
	        
	       
	        if (palavraCompleta) {
	            System.out.println("Você acertou a última letra! Parabéns!"); 
	            System.exit(0);  
	        }
	    }
	    return tentativasRestantes; 
	}
    
}

      

        
