import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        System.out.println("El resultado es: " + leerArchivo());


    }

    private static Integer leerArchivo() throws IOException {
        FileReader input = new FileReader("src/input.txt");
        BufferedReader br = new BufferedReader(input);
        String inputLine = br.readLine();
        int suma = 0;
        String mitad1;
        String mitad2;
        boolean resultado = false;

        while (inputLine != null) {
            // separa la línea en dos mitades

            mitad1 = inputLine.substring(0, (inputLine.length() / 2));
            mitad2 = inputLine.substring(inputLine.length() / 2);

            // convierte cada mitad a un array de chars

            char[] charMitad1 = mitad1.toCharArray();

            // recorre todas las letras de la primera mitad y comprueba si estan en la segunda mitad una a una

            for (int i = 0; i < mitad1.length(); i++) {

                // si encuentra una letra que coincide, escribe esa letra
                if (mitad2.indexOf(mitad1.charAt(i)) != -1 ) {
                    System.out.println(mitad1.charAt(i));

                    // al encontrar una letra, sale del loop (solo puede haber una letra repetida)
                suma += calcularPuntos(mitad1.charAt(i));
                    break;
                }

            }

            System.out.println("Mitad 1: " + new String(mitad1));
            System.out.println("Mitad 2: " + new String(mitad2));
            System.out.println("--------------");

            inputLine = br.readLine();
        }

        return suma;
    }

    private static int calcularPuntos(char c) {
        // Devuelve la posicion de un caracter en el abecedario
        int res = 0;
        String abecedario = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        res = abecedario.indexOf(c) + 1;

        return res;
    }

    // libreria de google para escribir objetos en json
    Gson g = new GsonBuilder().setPrettyPrinting().create();

}