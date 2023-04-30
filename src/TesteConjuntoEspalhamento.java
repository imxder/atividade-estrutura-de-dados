public class TesteConjuntoEspalhamento {

	public static void main(String[] args) {
	    ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();
	    conjunto.adiciona("abacate");
	    conjunto.adiciona("banana");
	    conjunto.adiciona("caqui");
	    conjunto.adiciona("damasco");
	    conjunto.adiciona("figo");
	    conjunto.adiciona("goiaba");
	    conjunto.adiciona("laranja");

	    System.out.println("Tamanho do conjunto: " + conjunto.tamanho());
	    System.out.println("Contém a palavra 'abacate'? " + conjunto.contem("abacate"));
	    System.out.println("Contém a palavra 'laranja'? " + conjunto.contem("laranja"));

	    System.out.println("\nOlhando todas as letras da palavra 'abacate':");
	    for (char letra = 'a'; letra <= 'z'; letra++) {
	        if (conjunto.olhaTodasAsLetras("abacate", letra)) {
	            System.out.println("A palavra 'abacate' contém a letra '" + letra + "'");
	        }
	    }
	}
}