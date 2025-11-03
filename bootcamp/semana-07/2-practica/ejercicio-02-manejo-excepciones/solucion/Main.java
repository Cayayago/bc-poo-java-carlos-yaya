import java.io.*;
import java.util.Scanner;

/**
 * Ejercicio 02: Manejo Básico de Excepciones
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== Ejercicio 02: Manejo de Excepciones ===\n");
        
        // 1. División segura
        divisionSegura(10, 2);
        divisionSegura(10, 0);  // Lanzará excepción
        
        // 2. Null safety
        procesarTexto("Hola Mundo");
        procesarTexto(null);  // Lanzará excepción
        
        // 3. Lectura de archivo
        leerArchivo("datos.txt");
        
        // 4. Múltiples catch
        procesarDatos("123");
        procesarDatos("abc");
        
        System.out.println("\n✅ Ejercicio 02 completado");
    }
    
    /**
     * 1. Manejo de ArithmeticException
     */
    public static void divisionSegura(int a, int b) {
        try {
            int resultado = a / b;
            System.out.println("✅ División: " + a + " / " + b + " = " + resultado);
        } catch (ArithmeticException e) {
            System.err.println("❌ Error de división: " + e.getMessage());
        }
    }
    
    /**
     * 2. Manejo de NullPointerException
     */
    public static void procesarTexto(String texto) {
        try {
            System.out.println("✅ Longitud del texto: " + texto.length());
        } catch (NullPointerException e) {
            System.err.println("❌ Texto es null");
        }
    }
    
    /**
     * 3. Manejo de IOException con finally
     */
    public static void leerArchivo(String ruta) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(ruta));
            String linea = reader.readLine();
            System.out.println("✅ Primera línea: " + linea);
        } catch (FileNotFoundException e) {
            System.err.println("❌ Archivo no encontrado: " + ruta);
        } catch (IOException e) {
            System.err.println("❌ Error de lectura: " + e.getMessage());
        } finally {
            System.out.println("🧹 Limpieza de recursos");
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("❌ Error al cerrar archivo");
                }
            }
        }
    }
    
    /**
     * 4. Múltiples catch blocks
     */
    public static void procesarDatos(String valor) {
        try {
            int numero = Integer.parseInt(valor);
            int resultado = 100 / numero;
            System.out.println("✅ Resultado: " + resultado);
        } catch (NumberFormatException e) {
            System.err.println("❌ Formato inválido: " + valor);
        } catch (ArithmeticException e) {
            System.err.println("❌ División por cero");
        } catch (Exception e) {
            System.err.println("❌ Error genérico: " + e.getMessage());
        }
    }
}
