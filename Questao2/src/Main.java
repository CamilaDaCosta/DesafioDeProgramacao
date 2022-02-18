/**
 * REQUISITOS
 * Possui no mínimo 6 caracteres.
 * Contém no mínimo 1 digito.
 * Contém no mínimo 1 letra em minúsculo.
 * Contém no mínimo 1 letra em maiúsculo.
 * Contém no mínimo 1 caractere especial. Os caracteres especiais são: !@#$%^&*()-+
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author camila da costa
 */
public class Main {
    public static void main(String[] args) {
        final int TAMANHO_SENHA = 6;
        Scanner leitor = new Scanner(System.in);
        String senha;

        System.out.print("Digite a senha que deseja verificar: ");
        senha = leitor.next();

        if (validaSenha(senha) == true){
            System.out.println("Senha Aceita!");
        }else if(validaSenha(senha) == false && (senha.length() < TAMANHO_SENHA)) {
            int caracteres = TAMANHO_SENHA - senha.length();
            System.out.println("Senha não aceita!\nFaltam " + caracteres + " caracters!");
        }else{
            System.out.println("Senha não aceita mas quantidade de caracteres está válida!");
        }
    }
    public static boolean validaSenha(String senha) {
        /**
         * String regex_requisitos utiliza de expressões regulares onde recebe toda sequência
         * de caracteres (os requisitos) que a senha deverá ter para ser considerada válida
         * a classe regex possui métodos que realizarão a busca nessa String.
         */
        String regex_requisitos = "^(?=.*[0-9])"
                                + "(?=.*[a-z])(?=.*[A-Z])"
                                + "(?=.*[!@#$%^&*()-+])"
                                + "(?=\\S+$).{6}$";

        /**
         * Obtendo a instância de Pattern que recebe a expressão regular (regex_requisitos)
         */
        Pattern pattern = Pattern.compile(regex_requisitos);
        if (senha == null) {
            return false;
        }

        /**
         * passando a a fonte de busca (senha) na expressão regular
         */
        Matcher matcher = pattern.matcher(senha);
        return matcher.matches();
    }
}
