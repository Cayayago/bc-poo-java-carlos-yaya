package co.edu.sena.traslados_seguros;



import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nTRASLADOS SEGUROS - SEMANA 6: CLASES ABSTRACTAS E INTERFACES");
        System.out.println("Estudiante: Carlos Javier Yaya Gomez");
        System.out.println("Ficha: 3228973A\n");

        GestorMudanzas gestor = new GestorMudanzas();

        // Crear recursos
        Cliente cliente1 = new Cliente("Ana Garcia", "3001234567", "1012345678", "ana@email.com");
        Cliente cliente2 = new Cliente("Roberto Sanchez", "3109876543", "1087654321");
        Cliente cliente3 = new Cliente("Maria Sanchez", "3109963587", "7258986");
        Cliente cliente4 = new Cliente("Nicolas Matti", "3215698456", "52896245");
        Cliente cliente5 = new Cliente("Agustin Safatle", "3204525896", "1024234252");

        Empleado empleado1 = new Empleado("EMP-001", "Juan Rojas", "Conductor", 80000);
        Empleado empleado2 = new Empleado("EMP-002", "Maria Lopez", "Cargadora", 60000);
        Empleado empleado3 = new Empleado("EMP-003", "Pedro Martinez", "Cargador", 60000);
        Empleado empleado4 = new Empleado("EMP-004", "Carlos Diaz", "Conductor", 80000);

        Vehiculo vehiculo1 = new Vehiculo("ABC-123", "Camioneta", 8.0);
        Vehiculo vehiculo2 = new Vehiculo("XYZ-789", "Camion Grande", 30.0);
        Vehiculo vehiculo3 = new Vehiculo("DEF-456", "Camion Mediano", 20.0);

        gestor.registrarCliente(cliente1);
        gestor.registrarCliente(cliente2);
        gestor.registrarCliente(cliente3);
        gestor.registrarCliente(cliente4);
        gestor.registrarCliente(cliente5);

        gestor.registrarVehiculo(vehiculo1);
        gestor.registrarVehiculo(vehiculo2);
        gestor.registrarVehiculo(vehiculo3);

        gestor.registrarEmpleado(empleado1);
        gestor.registrarEmpleado(empleado2);
        gestor.registrarEmpleado(empleado3);
        gestor.registrarEmpleado(empleado4);

        // Crear servicios
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

        // SEMANA 6: EJERCICIO 1 - CLASE ABSTRACTA
        System.out.println("\nEJERCICIO 1: CLASE ABSTRACTA\n");

        // Array polimorfico de clase abstracta
        List<Persona> personas = new ArrayList<>();
        personas.add(cliente1);
        personas.add(empleado1);
        personas.add(cliente2);
        personas.add(empleado2);
        personas.add(cliente3);
        personas.add(empleado3);

        System.out.println("Metodo abstracto calcularCostoOperacional():");
        for (Persona p : personas) {
            System.out.println(p.getNombre() + " (" + p.obtenerTipoPersona() + "): $" +
                    p.calcularCostoOperacional());
        }

        // SEMANA 6: EJERCICIO 2 - INTERFACES
        System.out.println("\nEJERCICIO 2: INTERFACES\n");

        // Interface Calificable
        System.out.println("Interface Calificable:");
        cliente1.agregarCalificacion(5);
        cliente1.agregarCalificacion(4);
        cliente1.agregarCalificacion(5);

        cliente2.agregarCalificacion(3);
        cliente2.agregarCalificacion(4);

        cliente3.agregarCalificacion(5);
        cliente3.agregarCalificacion(5);
        cliente3.agregarCalificacion(5);
        cliente3.agregarCalificacion(4);

        List<Calificable> entidadesCalificables = new ArrayList<>();
        entidadesCalificables.add(cliente1);
        entidadesCalificables.add(cliente2);
        entidadesCalificables.add(cliente3);

        for (Calificable c : entidadesCalificables) {
            Cliente cliente = (Cliente) c;
            System.out.println(cliente.getNombre() + ":");
            System.out.println("  Promedio: " + c.obtenerPromedioCalificaciones());
            System.out.println("  Total: " + c.obtenerTotalCalificaciones());
            System.out.println("  Nivel: " + c.obtenerNivelCalidad());
        }

        // Interface Notificable
        System.out.println("\nInterface Notificable:");

        List<Notificable> entidadesNotificables = new ArrayList<>();
        entidadesNotificables.add(cliente1);
        entidadesNotificables.add(empleado1);
        entidadesNotificables.add(cliente2);
        entidadesNotificables.add(empleado2);

        // Enviar notificaciones
        cliente1.enviarNotificacion("Su servicio ha sido confirmado");
        cliente1.enviarNotificacionUrgente("Cambio de fecha del servicio");
        empleado1.enviarNotificacion("Nuevo servicio asignado para manana");
        empleado1.enviarNotificacionUrgente("Reporte de inmediato a la oficina");

        System.out.println("\nVerificando notificaciones pendientes:");
        for (Notificable n : entidadesNotificables) {
            String nombre = "";
            if (n instanceof Cliente) {
                nombre = ((Cliente) n).getNombre();
            } else if (n instanceof Empleado) {
                nombre = ((Empleado) n).getNombre();
            }
            System.out.println(nombre + ": " +
                    (n.tieneNotificacionesPendientes() ? "SI tiene notificaciones" : "NO tiene notificaciones"));
        }

        cliente1.mostrarNotificaciones();
        empleado1.mostrarNotificaciones();

        // SEMANA 6: EJERCICIO 3 - DEMOSTRACION MULTIPLE
        System.out.println("\nEJERCICIO 3: DEMOSTRACION COMPLETA\n");

        System.out.println("Cliente implementa multiples interfaces:");
        System.out.println("- Extends Persona (clase abstracta)");
        System.out.println("- Implements Calificable");
        System.out.println("- Implements Notificable");

        System.out.println("\nPrueba polimorfismo:");
        Persona p = cliente1;
        Calificable cal = cliente1;
        Notificable not = cliente1;

        System.out.println("Como Persona: " + p.calcularCostoOperacional());
        System.out.println("Como Calificable: " + cal.obtenerNivelCalidad());
        System.out.println("Como Notificable: " + (not.tieneNotificacionesPendientes() ? "Tiene notificaciones" : "Sin notificaciones"));

        // Reporte final
        System.out.println();
        gestor.generarReporteGeneral();

        System.out.println("\nPrograma finalizado.\n");
    }
}