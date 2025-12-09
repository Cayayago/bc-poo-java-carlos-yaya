package co.edu.sena.traslados_seguros;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nTRASLADOS SEGUROS");
        System.out.println("Sistema de Gestion con Relaciones");
        System.out.println("Estudiante: Carlos Javier Yaya Gomez");
        System.out.println("Ficha: 3228973A\n");

        GestorMudanzas gestor = new GestorMudanzas();

        System.out.println("=== REGISTRANDO RECURSOS ===\n");

        Cliente cliente1 = new Cliente("Ana Garcia", "3001234567", "1012345678");
        Cliente cliente2 = new Cliente("Roberto Sanchez", "3109876543", "1087654321");
        Cliente cliente3 = new Cliente("Maria Sanchez", "3109963587", "7258986");
        Cliente cliente4 = new Cliente("Nicolas Matti", "3215698456", "52896245");
        Cliente cliente5 = new Cliente("Agustin Safatle", "3204525896", "1024234252");

        gestor.registrarCliente(cliente1);
        gestor.registrarCliente(cliente2);
        gestor.registrarCliente(cliente3);
        gestor.registrarCliente(cliente4);
        gestor.registrarCliente(cliente5);

        System.out.println();

        Vehiculo vehiculo1 = new Vehiculo("ABC-123", "Camioneta", 8.0);
        Vehiculo vehiculo2 = new Vehiculo("XYZ-789", "Camion Grande", 30.0);
        Vehiculo vehiculo3 = new Vehiculo("DEF-456", "Camion Mediano", 20.0);

        gestor.registrarVehiculo(vehiculo1);
        gestor.registrarVehiculo(vehiculo2);
        gestor.registrarVehiculo(vehiculo3);

        System.out.println();

        Empleado empleado1 = new Empleado("EMP-001", "Juan Rojas", "Conductor", 80000);
        Empleado empleado2 = new Empleado("EMP-002", "Maria Lopez", "Cargadora", 60000);
        Empleado empleado3 = new Empleado("EMP-003", "Pedro Martinez", "Cargador", 60000);
        Empleado empleado4 = new Empleado("EMP-004", "Carlos Diaz", "Conductor", 80000);

        gestor.registrarEmpleado(empleado1);
        gestor.registrarEmpleado(empleado2);
        gestor.registrarEmpleado(empleado3);
        gestor.registrarEmpleado(empleado4);

        System.out.println("\n=== CREANDO SERVICIOS ===\n");

        MovingService servicio1 = new MovingService("MOV-001", "Bogota - Chapinero", "Bogota - Suba");
        servicio1.asignarCliente(cliente1);
        servicio1.asignarVehiculo(vehiculo1);
        servicio1.asignarEmpleado(empleado1);
        servicio1.asignarEmpleado(empleado2);
        gestor.registrarServicio(servicio1);

        vehiculo1.liberarVehiculo();
        empleado1.completarServicio();
        empleado2.completarServicio();

        MovingService servicio2 = new MovingService("MOV-002", "Bogota - Fontibon", "Medellin - Poblado");
        servicio2.asignarCliente(cliente2);
        servicio2.asignarVehiculo(vehiculo1);
        servicio2.asignarEmpleado(empleado1);
        servicio2.asignarEmpleado(empleado3);
        gestor.registrarServicio(servicio2);

        MovingService servicio3 = new MovingService("MOV-003", "Bogota - Usaquen", "Cali - Norte");
        servicio3.asignarCliente(cliente3);
        servicio3.asignarVehiculo(vehiculo2);
        servicio3.asignarEmpleado(empleado2);
        gestor.registrarServicio(servicio3);

        vehiculo1.liberarVehiculo();
        empleado1.completarServicio();
        empleado3.completarServicio();

        MovingService servicio4 = new MovingService("MOV-004", "Bogota - Kennedy", "Bogota - Teusaquillo");
        servicio4.asignarCliente(cliente4);
        servicio4.asignarVehiculo(vehiculo3);
        servicio4.asignarEmpleado(empleado4);
        gestor.registrarServicio(servicio4);

        vehiculo2.liberarVehiculo();
        empleado2.completarServicio();

        MovingService servicio5 = new MovingService("MOV-005", "Chia - Centro", "Bogota - Suba");
        servicio5.asignarCliente(cliente5);
        servicio5.asignarVehiculo(vehiculo2);
        servicio5.asignarEmpleado(empleado2);
        servicio5.asignarEmpleado(empleado3);
        gestor.registrarServicio(servicio5);

        System.out.println("\n=== USANDO EL GESTOR ===");

        gestor.listarServicios();

        System.out.println("\n=== BUSQUEDAS ===\n");

        Cliente clienteBuscado = gestor.buscarClientePorId("1012345678");
        if (clienteBuscado != null) {
            System.out.println("Cliente encontrado: " + clienteBuscado.getNombre());
        }

        Vehiculo vehiculoBuscado = gestor.buscarVehiculoPorPlaca("ABC-123");
        if (vehiculoBuscado != null) {
            System.out.println("Vehiculo encontrado: " + vehiculoBuscado.getPlaca());
        }

        Empleado empleadoBuscado = gestor.buscarEmpleadoPorCodigo("EMP-001");
        if (empleadoBuscado != null) {
            System.out.println("Empleado encontrado: " + empleadoBuscado.getNombreCompleto());
        }

        System.out.println("\n=== VEHICULOS DISPONIBLES ===");
        List<Vehiculo> disponibles = gestor.obtenerVehiculosDisponibles();
        for (Vehiculo v : disponibles) {
            System.out.println("  - " + v.getPlaca() + " (" + v.getTipoVehiculo() + ")");
        }

        System.out.println("\nPrograma finalizado.\n");
    }
}