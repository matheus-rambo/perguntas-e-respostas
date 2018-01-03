package back.funcoes;

public class ValidaNome {

    /**
     * Verifica o nome do usuário! O mesmo deve ter a 1º letra maiuscula e o
     * restante minuscula! com no minimo 3 caracteres
     */
    public static boolean nomeValido(String nome) {

        char primeiraLetra;

        if (nome.length() < 3) {

            return false;

        } else {

            // pega a primeira letra!
            primeiraLetra = nome.charAt(0);

            // converte para maiuscula
            primeiraLetra = (char) ((int) primeiraLetra & 65503);

            // verifica se a primeira letra é maiuscula!
            if (primeiraLetra == nome.charAt(0)) {

                String invalidos = "1234567890()_+-=!@#$%&*<>:?,.;/°º}][{ª'~^|\\";

                for (int i = 0; i < nome.length(); i++) {

                    for (int z = 0; z < invalidos.length(); z++) {

                        if (nome.charAt(i) == invalidos.charAt(z)) {

                            return false;

                        }

                    }

                }

            } else {

                return false;
            }

            return true;

        }
    }
    
}
