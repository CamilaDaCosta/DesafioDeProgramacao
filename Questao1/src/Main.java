import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author camila da costa
 */
public class Main {

    public static void main(String[] args) {
        int qtdDegraus;
        List<String> degraus = new ArrayList<>();

        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o Valor: ");
        qtdDegraus = leitor.nextInt();

        for (int i = 0; i < qtdDegraus; i++) {
            /**
             * Adiciona a lista da escada os espaços e os *
             * o repeat faz com que não seja necessário repetir o código
             */
            degraus.add(" ".repeat(qtdDegraus - i) + "*".repeat(i + 1));
        }
        /**
         * For each para exibir todos os elementos da List escada
         */
        for (String d : degraus ) {
            System.out.println(d);
        }
    }
}