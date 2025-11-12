public class main {
    public static void main(String[] args) {

        // Encabezado
        System.out.println("\n--- TRASLADOS SEGUROS ---");
        System.out.println("Sistema de Gestion de Mudanzas");
        System.out.println("Estudiante: Carlos Javier Yaya Gomez");
        System.out.println("Ficha: 3228973A\n");

        // Servicios de TRASLADOS SEGUROS PARA EL 11/11/2025

        MovingService servicio1 = new MovingService(
                "MOV-001",
                "Bogota - Chapinero",
                "Bogota - Suba"
        );
        System.out.println("Servicio 1:");
        servicio1.showInfo();
        System.out.println();

        MovingService servicio2 = new MovingService(
                "MOV-002",
                "Bogota - Fontibon",
                "Medellin - Poblado"
        );
        System.out.println("Servicio 2:");
        servicio2.showInfo();
        System.out.println();

        MovingService servicio3 = new MovingService(
                "MOV-003",
                "Bogota - Usaquen",
                "Bogota - Kennedy"
        );
        System.out.println("Servicio 3:");
        servicio3.showInfo();
        System.out.println();


        MovingService servicio4 = new MovingService(
                "MOV-004",
                "Bogota - Centro",
                "Cali - Norte"
        );
        System.out.println("Servicio 4:");
        servicio4.showInfo();
        System.out.println();

        MovingService servicio5 = new MovingService(
                "MOV-005",
                "Bogota - Teusaquillo",
                "Chia - Centro"
        );
        System.out.println("Servicio 5:");
        servicio5.showInfo();
        System.out.println();

        // Resumen
        System.out.println("--- RESUMEN ---");

        System.out.println("Listado completo:\n");
        System.out.println("1. " + servicio1.serviceCode);
        servicio1.showInfo();

        System.out.println("\n2. " + servicio2.serviceCode);
        servicio2.showInfo();

        System.out.println("\n3. " + servicio3.serviceCode);
        servicio3.showInfo();

        System.out.println("\n4. " + servicio4.serviceCode);
        servicio4.showInfo();

        System.out.println("\n5. " + servicio5.serviceCode);
        servicio5.showInfo();

        System.out.println("\nPrograma finalizado.");

    }
}
