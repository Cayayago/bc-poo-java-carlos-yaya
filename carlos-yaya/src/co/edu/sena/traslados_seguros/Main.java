package co.edu.sena.traslados_seguros;

public class Main {
    public static void main(String[] args) {

        // Encabezado
        System.out.println("\n--- TRASLADOS SEGUROS ---");
        System.out.println("Sistema de Gestion de Mudanzas");
        System.out.println("Estudiante: Carlos Javier Yaya Gomez");
        System.out.println("Ficha: 3228973A\n");

        //5 servicios
        MovingService servicio1 = new MovingService(
                "MOV-001",
                "Bogota - Chapinero",
                "Bogota - Suba"
        );

        MovingService servicio2 = new MovingService(
                "MOV-002",
                "Bogota - Fontibon",
                "Medellin - Poblado"
        );

        MovingService servicio3 = new MovingService(
                "MOV-003",
                "Bogota - Usaquen",
                "Bogota - Kennedy"
        );

        MovingService servicio4 = new MovingService(
                "MOV-004",
                "Bogota - Centro",
                "Cali - Norte"
        );

        MovingService servicio5 = new MovingService(
                "MOV-005",
                "Bogota - Teusaquillo",
                "Chia - Centro"
        );

        // Mostrar servicios usando toString() (manera 1: directa)
        System.out.println("Servicio 1:");
        System.out.println(servicio1); // toString() se llama automaticamente
        System.out.println();

        System.out.println("Servicio 2:");
        System.out.println(servicio2);
        System.out.println();

        System.out.println("Servicio 3:");
        System.out.println(servicio3);
        System.out.println();

        System.out.println("Servicio 4:");
        System.out.println(servicio4);
        System.out.println();

        System.out.println("Servicio 5:");
        System.out.println(servicio5);
        System.out.println();

        System.out.println("\nPrograma finalizado.");

    }
}