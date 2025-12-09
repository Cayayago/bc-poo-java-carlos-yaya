package co.edu.sena.traslados_seguros;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nTRASLADOS SEGUROS");
        System.out.println("Estudiante: Carlos Javier Yaya Gomez");
        System.out.println("Ficha: 3228973A\n");

        // Semana 4: Demostracion de herencia y polimorfismo

        System.out.println("=== DEMOSTRACION DE HERENCIA ===\n");

        // Semana 1-3: Creacion de objetos
        Cliente cliente1 = new Cliente("Ana Garcia", "3001234567", "1012345678", "ana@email.com");
        Empleado empleado1 = new Empleado("EMP-001", "Juan Rojas", "Conductor", 80000, "3009876543");

        // Semana 4: Metodos heredados de Persona
        System.out.println("--- Metodo heredado: mostrarInformacionBasica() ---\n");
        cliente1.mostrarInformacionBasica();
        System.out.println();
        empleado1.mostrarInformacionBasica();

        // Semana 4: Metodo heredado: obtenerNombreCorto()
        System.out.println("\n--- Metodo heredado: obtenerNombreCorto() ---");
        System.out.println("Nombre corto cliente: " + cliente1.obtenerNombreCorto());
        System.out.println("Nombre corto empleado: " + empleado1.obtenerNombreCorto());

        // Semana 4: Demostracion de polimorfismo
        System.out.println("\n=== DEMOSTRACION DE POLIMORFISMO ===\n");

        // Semana 4: Array polimorfico - Persona puede contener Cliente y Empleado
        Persona[] personas = new Persona[5];
        personas[0] = new Cliente("Maria Lopez", "3101234567", "1023456789");
        personas[1] = new Empleado("EMP-002", "Carlos Diaz", "Cargador", 60000);
        personas[2] = new Cliente("Pedro Martinez", "3112345678", "1034567890", "pedro@email.com");
        personas[3] = new Empleado("EMP-003", "Sofia Ruiz", "Conductora", 80000);
        personas[4] = cliente1;

        System.out.println("--- Array polimorfico de Personas ---\n");
        for (int i = 0; i < personas.length; i++) {
            System.out.println((i + 1) + ". " + personas[i].toString());
        }

        // Semana 4: Polimorfismo en accion - mismo metodo, comportamiento diferente
        System.out.println("\n--- Polimorfismo: mostrarInformacionBasica() ---\n");
        for (Persona p : personas) {
            p.mostrarInformacionBasica();
            System.out.println();
        }

        // Semana 4: instanceof para identificar tipo especifico
        System.out.println("--- Uso de instanceof ---\n");
        int contadorClientes = 0;
        int contadorEmpleados = 0;

        for (Persona p : personas) {
            if (p instanceof Cliente) {
                contadorClientes++;
            } else if (p instanceof Empleado) {
                contadorEmpleados++;
            }
        }

        System.out.println("Total Clientes en array: " + contadorClientes);
        System.out.println("Total Empleados en array: " + contadorEmpleados);
        System.out.println("Total Personas en array: " + personas.length);

        // Semana 1-3: Sistema completo con los 5 servicios
        System.out.println("\n=== CREACION DE LOS 5 SERVICIOS ===\n");

        GestorMudanzas gestor = new GestorMudanzas();

        // Semana 1: Crear todos los recursos
        Cliente cliente2 = new Cliente("Roberto Sanchez", "3109876543", "1087654321");
        Cliente cliente3 = new Cliente("Maria Sanchez", "3109963587", "7258986");
        Cliente cliente4 = new Cliente("Nicolas Matti", "3215698456", "52896245");
        Cliente cliente5 = new Cliente("Agustin Safatle", "3204525896", "1024234252");

        gestor.registrarCliente(cliente1);
        gestor.registrarCliente(cliente2);
        gestor.registrarCliente(cliente3);
        gestor.registrarCliente(cliente4);
        gestor.registrarCliente(cliente5);

        Vehiculo vehiculo1 = new Vehiculo("ABC-123", "Camioneta", 8.0);
        Vehiculo vehiculo2 = new Vehiculo("XYZ-789", "Camion Grande", 30.0);
        Vehiculo vehiculo3 = new Vehiculo("DEF-456", "Camion Mediano", 20.0);

        gestor.registrarVehiculo(vehiculo1);
        gestor.registrarVehiculo(vehiculo2);
        gestor.registrarVehiculo(vehiculo3);

        Empleado empleado2 = new Empleado("EMP-002", "Maria Lopez", "Cargadora", 60000);
        Empleado empleado3 = new Empleado("EMP-003", "Pedro Martinez", "Cargador", 60000);
        Empleado empleado4 = new Empleado("EMP-004", "Carlos Diaz", "Conductor", 80000);

        gestor.registrarEmpleado(empleado1);
        gestor.registrarEmpleado(empleado2);
        gestor.registrarEmpleado(empleado3);
        gestor.registrarEmpleado(empleado4);

        // Semana 1: Servicio 1
        MovingService servicio1 = new MovingService("MOV-001", "Bogota - Chapinero", "Bogota - Suba");
        servicio1.asignarCliente(cliente1);
        servicio1.asignarVehiculo(vehiculo1);
        servicio1.asignarEmpleado(empleado1);
        servicio1.asignarEmpleado(empleado2);
        gestor.registrarServicio(servicio1);
        System.out.println(servicio1);
        System.out.println();

        vehiculo1.liberarVehiculo();
        empleado1.completarServicio();
        empleado2.completarServicio();

        // Semana 1: Servicio 2
        MovingService servicio2 = new MovingService("MOV-002", "Bogota - Fontibon", "Medellin - Poblado");
        servicio2.asignarCliente(cliente2);
        servicio2.asignarVehiculo(vehiculo1);
        servicio2.asignarEmpleado(empleado1);
        servicio2.asignarEmpleado(empleado3);
        gestor.registrarServicio(servicio2);
        System.out.println(servicio2);
        System.out.println();

        // Semana 1: Servicio 3
        MovingService servicio3 = new MovingService("MOV-003", "Bogota - Usaquen", "Cali - Norte");
        servicio3.asignarCliente(cliente3);
        servicio3.asignarVehiculo(vehiculo2);
        servicio3.asignarEmpleado(empleado2);
        gestor.registrarServicio(servicio3);
        System.out.println(servicio3);
        System.out.println();

        vehiculo1.liberarVehiculo();
        empleado1.completarServicio();
        empleado3.completarServicio();

        // Semana 1: Servicio 4
        MovingService servicio4 = new MovingService("MOV-004", "Bogota - Kennedy", "Bogota - Teusaquillo");
        servicio4.asignarCliente(cliente4);
        servicio4.asignarVehiculo(vehiculo3);
        servicio4.asignarEmpleado(empleado4);
        gestor.registrarServicio(servicio4);
        System.out.println(servicio4);
        System.out.println();

        vehiculo2.liberarVehiculo();
        empleado2.completarServicio();

        // Semana 1: Servicio 5
        MovingService servicio5 = new MovingService("MOV-005", "Chia - Centro", "Bogota - Suba");
        servicio5.asignarCliente(cliente5);
        servicio5.asignarVehiculo(vehiculo2);
        servicio5.asignarEmpleado(empleado2);
        servicio5.asignarEmpleado(empleado3);
        gestor.registrarServicio(servicio5);
        System.out.println(servicio5);
        System.out.println();

        // Semana 3: Reporte general
        gestor.generarReporteGeneral();

        System.out.println("\nPrograma finalizado.\n");
    }
}