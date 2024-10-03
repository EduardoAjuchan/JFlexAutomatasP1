import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java_cup.runtime.Symbol;
import jflex.core.sym;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\eduar\\Desktop\\JFlex Automatas\\Automatas1\\input.txt";
        String outputFilePath = "C:\\Users\\eduar\\Desktop\\JFlex Automatas\\Automatas1\\output.txt";

        try {
            // Abrir el archivo de entrada
            FileReader reader = new FileReader(inputFilePath);

            // Crear el archivo de salida
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

            // Crear una instancia del lexer generado
            SimpleLexer lexer = new SimpleLexer(reader);

            // Leer y procesar los tokens
            Symbol token;
            while ((token = lexer.next_token()).sym != sym.EOF) {
                // Procesar el token devuelto por el lexer y escribir en el archivo
                if (token.sym == SimpleLexer.Token.ANIMAL) {
                    writer.write("Animal encontrado: " + token.value + "\n");
                } else if (token.sym == SimpleLexer.Token.OTRO) {
                    writer.write("Otro: " + token.value + "\n");
                }
            }

            // Cerrar el archivo de salida
            writer.close();

            // Mostrar un mensaje de éxito
            System.out.println("¡Análisis completado con éxito! Los resultados se han guardado en " + outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}