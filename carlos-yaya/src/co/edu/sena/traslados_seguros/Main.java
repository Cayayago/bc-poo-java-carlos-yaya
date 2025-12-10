package co.edu.sena.traslados_seguros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nTRASLADOS SEGUROS - SEMANA 5: POLIMORFISMO AVANZADO");
        System.out.println("Estudiante: Carlos Javier Yaya Gomez");
        System.out.println("Ficha: 3228973A\n");

        GestorMudanzas gestor = new GestorMudanzas();

        // Semana 1-4: Crear recursos
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

        // Semana 1: Crear servicios
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

        // Semana 5: EJERCICIO 1 - SOBRECARGA
        System.out.println("\nEJERCICIO 1: SOBRECARGA DE METODOS\n");

        // Sobrecarga: buscarServicio()
        MovingService servicioEncontrado = gestor.buscarServicio("MOV-001");
        System.out.println("Busqueda por codigo: " +
                (servicioEncontrado != null ? servicioEncontrado.getServiceCode() : "No encontrado"));

        List<MovingService> serviciosCliente = gestor.buscarServicio(cliente1);
        System.out.println("Busqueda por cliente: " + serviciosCliente.size() + " servicio(s)");

        LocalDate hoy = LocalDate.now();
        LocalDate manana = hoy.plusDays(1);
        List<MovingService> serviciosFecha = gestor.buscarServicio(hoy, manana);
        System.out.println("Busqueda por fecha: " + serviciosFecha.size() + " servicio(s)");

        // Sobrecarga: calcularTarifa()
        System.out.println("\nTarifa por capacidad 8m3: $" + gestor.calcularTarifa(8.0));
        System.out.println("Tarifa por vehiculo: $" + gestor.calcularTarifa(vehiculo1));
        System.out.println("Tarifa vehiculo + 50km: $" + gestor.calcularTarifa(vehiculo1, 50));

        // Semana 5: EJERCICIO 2 - SOBRESCRITURA
        System.out.println("\nEJERCICIO 2: SOBRESCRITURA DE METODOS\n");

        System.out.println("Tipo Cliente: " + cliente1.obtenerTipoPersona());
        System.out.println("Tipo Empleado: " + empleado1.obtenerTipoPersona());

        System.out.println();
        cliente1.mostrarInformacionBasica();
        System.out.println();
        empleado1.mostrarInformacionBasica();

        // Semana 5: EJERCICIO 3 - METODOS POLIMORFICOS
        System.out.println("\nEJERCICIO 3: METODOS POLIMORFICOS\n");

        gestor.mostrarDetallesPersona(cliente2);
        gestor.mostrarDetallesPersona(empleado2);

        gestor.validarPersona(cliente3);
        gestor.validarPersona(empleado3);

        // Semana 5: EJERCICIO 4 - ARRAYLIST POLIMORFICO
        System.out.println("\nEJERCICIO 4: ARRAYLIST POLIMORFICO\n");

        // ArrayList polimorfico
        List<Persona> todasLasPersonas = new ArrayList<>();
        todasLasPersonas.add(cliente1);
        todasLasPersonas.add(empleado1);
        todasLasPersonas.add(cliente2);
        todasLasPersonas.add(empleado2);
        todasLasPersonas.add(cliente3);
        todasLasPersonas.add(empleado3);
        todasLasPersonas.add(cliente4);
        todasLasPersonas.add(empleado4);
        todasLasPersonas.add(cliente5);

        // Dynamic Binding
        System.out.println("Dynamic Binding:");
        for (Persona p : todasLasPersonas) {
            System.out.println(p.obtenerTipoPersona() + ": " + p.obtenerNombreCorto());
        }

        gestor.procesarPersonas(todasLasPersonas);
        gestor.contarPorTipo(todasLasPersonas);

        // instanceof
        System.out.println("\nUso de instanceof:");
        for (Persona p : todasLasPersonas) {
            if (p instanceof Cliente) {
                Cliente c = (Cliente) p;
                System.out.println("Cliente: " + c.getNombre() + " - Servicios: " + c.contarServicios());
            } else if (p instanceof Empleado) {
                Empleado e = (Empleado) p;
                System.out.println("Empleado: " + e.getNombre() + " - Cargo: " + e.getCargo());
            }
        }

        // Sobrecarga con lista
        System.out.println("\nRegistro multiple:");
        List<Persona> nuevasPersonas = new ArrayList<>();
        nuevasPersonas.add(new Cliente("Luis Gomez", "3201112233", "1098765432"));
        nuevasPersonas.add(new Empleado("EMP-005", "Sandra Paz", "Supervisora", 90000));
        gestor.registrar(nuevasPersonas);

        // Reporte final
        System.out.println();
        gestor.generarReporteGeneral();

        System.out.println("\nPrograma finalizado.\n");
    }
}