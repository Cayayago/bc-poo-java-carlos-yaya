package co.edu.sena.traslados_seguros;

// Semana 7: Imports de otros paquetes
import co.edu.sena.traslados_seguros.modelos.Cliente;
import co.edu.sena.traslados_seguros.modelos.Empleado;
import co.edu.sena.traslados_seguros.modelos.MovingService;
import co.edu.sena.traslados_seguros.modelos.Persona;
import co.edu.sena.traslados_seguros.modelos.Vehiculo;
import co.edu.sena.traslados_seguros.gestores.GestorMudanzas;
import co.edu.sena.traslados_seguros.interfaces.Calificable;
import co.edu.sena.traslados_seguros.interfaces.Notificable;
import co.edu.sena.traslados_seguros.excepciones.DatosInvalidosException;
import co.edu.sena.traslados_seguros.excepciones.EntidadNoEncontradaException;
import co.edu.sena.traslados_seguros.excepciones.OperacionInvalidaException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nTRASLADOS SEGUROS - SEMANA 7: PAQUETES Y EXCEPCIONES");
        System.out.println("Estudiante: Carlos Javier Yaya Gomez");
        System.out.println("Ficha: 3228973A\n");

        GestorMudanzas gestor = new GestorMudanzas();

        // SEMANA 7: EJERCICIO 2 Y 3 - MANEJO DE EXCEPCIONES
        System.out.println("EJERCICIO 2 Y 3: MANEJO DE EXCEPCIONES\n");

        // Ejemplo 1: DatosInvalidosException - Registrar cliente duplicado
        System.out.println("--- Ejemplo 1: Intentar registrar cliente duplicado ---");
        try {
            Cliente cliente1 = new Cliente("Ana Garcia", "3001234567", "1012345678", "ana@email.com");
            gestor.registrarCliente(cliente1);

            // Intentar registrar el mismo cliente
            Cliente clienteDuplicado = new Cliente("Ana Garcia", "3001234567", "1012345678");
            gestor.registrarCliente(clienteDuplicado);

        } catch (DatosInvalidosException e) {
            System.out.println("ERROR CAPTURADO: " + e.getMessage());
        }

        // Ejemplo 2: EntidadNoEncontradaException - Buscar cliente inexistente
        System.out.println("\n--- Ejemplo 2: Buscar cliente inexistente ---");
        try {
            gestor.buscarClientePorIdOError("999999999");
        } catch (EntidadNoEncontradaException e) {
            System.out.println("ERROR CAPTURADO: " + e.getMessage());
        }

        // Ejemplo 3: OperacionInvalidaException - Calcular tarifa con valor negativo
        System.out.println("\n--- Ejemplo 3: Calcular tarifa con distancia negativa ---");
        try {
            Vehiculo vehiculo1 = new Vehiculo("ABC-123", "Camioneta", 8.0);
            gestor.registrarVehiculo(vehiculo1);
            gestor.calcularTarifa(vehiculo1, -50); // Distancia negativa
        } catch (DatosInvalidosException | OperacionInvalidaException e) {
            System.out.println("ERROR CAPTURADO: " + e.getMessage());
        }

        // Ejemplo 4: Try-catch-finally - Limpieza de recursos
        System.out.println("\n--- Ejemplo 4: Try-catch-finally con limpieza ---");
        Vehiculo vehiculoTemp = null;
        try {
            System.out.println("Intentando crear vehiculo con capacidad invalida...");
            vehiculoTemp = new Vehiculo("XYZ-999", "Camion", 150.0); // Capacidad > 100
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR CAPTURADO: " + e.getMessage());
        } finally {
            System.out.println("FINALLY: Limpieza de recursos - vehiculo temporal: " +
                    (vehiculoTemp != null ? "creado" : "no creado"));
        }

        // Ejemplo 5: Multiples excepciones en una operacion
        System.out.println("\n--- Ejemplo 5: Operacion compleja con multiples validaciones ---");
        try {
            // Buscar vehiculo que no existe
            Vehiculo vehiculoBuscado = gestor.buscarVehiculoPorPlacaOError("XXX-000");

            // Si llega aqui, intentar calcular tarifa
            double tarifa = gestor.calcularTarifa(vehiculoBuscado, 100);
            System.out.println("Tarifa calculada: $" + tarifa);

        } catch (EntidadNoEncontradaException e) {
            System.out.println("ERROR ENTIDAD: " + e.getMessage());
        } catch (OperacionInvalidaException e) {
            System.out.println("ERROR OPERACION: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR INESPERADO: " + e.getMessage());
        }

        // CONTINUAR CON FUNCIONALIDAD NORMAL (Semanas anteriores)
        System.out.println("\n\n=== FUNCIONALIDAD NORMAL DEL SISTEMA ===\n");

        try {
            // Crear recursos adicionales
            Cliente cliente2 = new Cliente("Roberto Sanchez", "3109876543", "1087654321");
            Cliente cliente3 = new Cliente("Maria Sanchez", "3109963587", "7258986");
            Cliente cliente4 = new Cliente("Nicolas Matti", "3215698456", "52896245");
            Cliente cliente5 = new Cliente("Agustin Safatle", "3204525896", "1024234252");

            gestor.registrarCliente(cliente2);
            gestor.registrarCliente(cliente3);
            gestor.registrarCliente(cliente4);
            gestor.registrarCliente(cliente5);

            Vehiculo vehiculo2 = new Vehiculo("XYZ-789", "Camion Grande", 30.0);
            Vehiculo vehiculo3 = new Vehiculo("DEF-456", "Camion Mediano", 20.0);

            gestor.registrarVehiculo(vehiculo2);
            gestor.registrarVehiculo(vehiculo3);

            Empleado empleado1 = new Empleado("EMP-001", "Juan Rojas", "Conductor", 80000);
            Empleado empleado2 = new Empleado("EMP-002", "Maria Lopez", "Cargadora", 60000);
            Empleado empleado3 = new Empleado("EMP-003", "Pedro Martinez", "Cargador", 60000);
            Empleado empleado4 = new Empleado("EMP-004", "Carlos Diaz", "Conductor", 80000);

            gestor.registrarEmpleado(empleado1);
            gestor.registrarEmpleado(empleado2);
            gestor.registrarEmpleado(empleado3);
            gestor.registrarEmpleado(empleado4);

            // Obtener cliente ya registrado
            Cliente cliente1 = gestor.buscarClientePorIdOError("1012345678");
            Vehiculo vehiculo1 = gestor.buscarVehiculoPorPlacaOError("ABC-123");

            // Crear servicios CON DETALLES COMPLETOS
            System.out.println("\n=== CREANDO SERVICIOS CON DETALLES ===\n");

            MovingService servicio1 = new MovingService("MOV-001", "Bogota - Chapinero", "Bogota - Suba");
            servicio1.asignarCliente(cliente1);
            servicio1.asignarVehiculo(vehiculo1);
            servicio1.asignarEmpleado(empleado1);
            servicio1.asignarEmpleado(empleado2);
            gestor.registrarServicio(servicio1);
            System.out.println(servicio1);

            vehiculo1.liberarVehiculo();
            empleado1.completarServicio();
            empleado2.completarServicio();

            MovingService servicio2 = new MovingService("MOV-002", "Bogota - Fontibon", "Medellin - Poblado");
            servicio2.asignarCliente(cliente2);
            servicio2.asignarVehiculo(vehiculo1);
            servicio2.asignarEmpleado(empleado1);
            servicio2.asignarEmpleado(empleado3);
            gestor.registrarServicio(servicio2);
            System.out.println(servicio2);

            MovingService servicio3 = new MovingService("MOV-003", "Bogota - Usaquen", "Cali - Norte");
            servicio3.asignarCliente(cliente3);
            servicio3.asignarVehiculo(vehiculo2);
            servicio3.asignarEmpleado(empleado2);
            gestor.registrarServicio(servicio3);
            System.out.println(servicio3);

            vehiculo1.liberarVehiculo();
            empleado1.completarServicio();
            empleado3.completarServicio();

            MovingService servicio4 = new MovingService("MOV-004", "Bogota - Kennedy", "Bogota - Teusaquillo");
            servicio4.asignarCliente(cliente4);
            servicio4.asignarVehiculo(vehiculo3);
            servicio4.asignarEmpleado(empleado4);
            gestor.registrarServicio(servicio4);
            System.out.println(servicio4);

            vehiculo2.liberarVehiculo();
            empleado2.completarServicio();

            MovingService servicio5 = new MovingService("MOV-005", "Chia - Centro", "Bogota - Suba");
            servicio5.asignarCliente(cliente5);
            servicio5.asignarVehiculo(vehiculo2);
            servicio5.asignarEmpleado(empleado2);
            servicio5.asignarEmpleado(empleado3);
            gestor.registrarServicio(servicio5);
            System.out.println(servicio5);

            // SEMANA 6: CLASE ABSTRACTA
            System.out.println("\n=== SEMANA 6: CLASE ABSTRACTA ===\n");

            List<Persona> personas = new ArrayList<>();
            personas.add(cliente1);
            personas.add(empleado1);
            personas.add(cliente2);
            personas.add(empleado2);
            personas.add(cliente3);

            System.out.println("Metodo abstracto calcularCostoOperacional():");
            for (Persona p : personas) {
                System.out.println(p.getNombre() + " (" + p.obtenerTipoPersona() + "): $" +
                        p.calcularCostoOperacional());
            }

            // SEMANA 6: INTERFACES
            System.out.println("\n=== SEMANA 6: INTERFACES ===\n");

            System.out.println("Interface Calificable:");
            cliente1.agregarCalificacion(5);
            cliente1.agregarCalificacion(4);
            cliente1.agregarCalificacion(5);

            System.out.println("Calificaciones de " + cliente1.getNombre() + ":");
            System.out.println("  Promedio: " + cliente1.obtenerPromedioCalificaciones());
            System.out.println("  Total: " + cliente1.obtenerTotalCalificaciones());
            System.out.println("  Nivel: " + cliente1.obtenerNivelCalidad());

            System.out.println("\nInterface Notificable:");
            cliente1.enviarNotificacion("Su servicio ha sido confirmado");
            empleado1.enviarNotificacionUrgente("Reporte inmediato a oficina");

            // SEMANA 5: POLIMORFISMO
            System.out.println("\n=== SEMANA 5: POLIMORFISMO ===\n");

            List<Notificable> notificables = new ArrayList<>();
            notificables.add(cliente1);
            notificables.add(empleado1);

            System.out.println("Notificaciones pendientes:");
            for (Notificable n : notificables) {
                String nombre = "";
                if (n instanceof Cliente) {
                    nombre = ((Cliente) n).getNombre();
                } else if (n instanceof Empleado) {
                    nombre = ((Empleado) n).getNombre();
                }
                System.out.println(nombre + ": " +
                        (n.tieneNotificacionesPendientes() ? "SI tiene notificaciones" : "NO tiene notificaciones"));
            }

            // Sobrecarga de metodos
            System.out.println("\n=== SOBRECARGA DE METODOS ===\n");

            System.out.println("Busqueda por codigo: " + gestor.buscarServicio("MOV-001").getServiceCode());
            System.out.println("Busqueda por cliente: " + gestor.buscarServicio(cliente1).size() + " servicio(s)");
            System.out.println("Tarifa por capacidad: $" + gestor.calcularTarifa(8.0));
            System.out.println("Tarifa por vehiculo: $" + gestor.calcularTarifa(vehiculo1));
            System.out.println("Tarifa vehiculo + distancia: $" + gestor.calcularTarifa(vehiculo1, 50));

            // Reporte final
            System.out.println();
            gestor.generarReporteGeneral();

        } catch (DatosInvalidosException e) {
            System.err.println("ERROR DE DATOS: " + e.getMessage());
        } catch (EntidadNoEncontradaException e) {
            System.err.println("ERROR DE BUSQUEDA: " + e.getMessage());
        } catch (OperacionInvalidaException e) {
            System.err.println("ERROR DE OPERACION: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("ERROR INESPERADO: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("\n=== FINALIZACION DEL SISTEMA ===");
            System.out.println("Recursos liberados correctamente");
        }

        System.out.println("\nPrograma finalizado.\n");
    }
}