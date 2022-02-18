import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author camila da costa
 */

public class Main {
    public static void main(String[] args) {
        String palavra;
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite a palavra: ");
        palavra = leitor.next();

        anagrama(palavra);
    }
    static void anagrama(String palavra) {
        int pares = 0;

        /**
         * Estrutura HashMap (lista) que utiliza chave e valor sendo String e Integer
         */
        HashMap<String, Integer> letrasPalava = new HashMap<>();

        for (int i = 0; i <= palavra.length(); i++) {
            for (int j = i; j < palavra.length(); j++) {
                /**
                 * Pegando todas as subletras da palavra digitada e transformando em um Array de character
                 */
                char[] letra = palavra.substring(i, j + 1).toCharArray();
                Arrays.sort(letra);
                String subletra = new String(letra);

                /**
                 * Verificando se contém a subletra e as colocando dentro do HashMap
                 */
                if (letrasPalava.containsKey(subletra)) {
                    letrasPalava.put(subletra, letrasPalava.get(subletra) + 1);
                } else {
                    letrasPalava.put(subletra, 1);
                }
            }
        }

        /**
         * Contando quantos anagramas pares existem
         */
        for (String cont : letrasPalava.keySet()) {
            int i = letrasPalava.get(cont);
            pares += (i * (i - 1)) / 2;
        }
        System.out.print("A quantidade anagramas pares são: " + pares);
    }
}
