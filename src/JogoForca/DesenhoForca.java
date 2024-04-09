package JogoForca;

public class DesenhoForca {
	
	
	public static void desenharForca(int tentativasRestantes) {
		// Parte fixa da forca
		System.out.println(" ");
        System.out.println(" _ _ _ __");
        System.out.println("|        |");

        // Desenha as partes do boneco conforme as tentativas restantes
        switch (tentativasRestantes) {
        
            case 4:
                // Nenhuma tentativa errada
                System.out.println("|           ");
                System.out.println("|           ");
                System.out.println("|           ");
                System.out.println("|           ");
                break;
                
            case 3:
                // Desenha a cabeça
                System.out.println("|        O   ");
                System.out.println("|           ");
                System.out.println("|           ");
                System.out.println("|           ");
                break;
                
            case 2:
                // Desenha o corpo
                System.out.println("|        O   ");
                System.out.println("|        |   ");
                System.out.println("|           ");
                System.out.println("|           ");
                break;
                
            case 1:
                // Desenha os braços
                System.out.println("|        O   ");
                System.out.println("|       -|-  ");
                System.out.println("|           ");
                System.out.println("|           ");
                break;
                
            case 0:
                // Corpo todo
                System.out.println("|        O   ");
                System.out.println("|       -|-  ");
                System.out.println("|       / \\ ");
                System.out.println("|           ");
                break;
                
            default:
                // Parte moldura inferior
                System.out.println("|          ");
                break;
        }
    }
}

