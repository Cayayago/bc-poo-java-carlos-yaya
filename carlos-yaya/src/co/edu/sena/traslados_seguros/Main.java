package co.edu.sena.traslados_seguros;


// Semana 7-8: Imports necesarios
import co.edu.sena.traslados_seguros.modelos.Cliente;
import co.edu.sena.traslados_seguros.modelos.Empleado;
import co.edu.sena.traslados_seguros.modelos.MovingService;
import co.edu.sena.traslados_seguros.modelos.Persona;
import co.edu.sena.traslados_seguros.modelos.Vehiculo;
import co.edu.sena.traslados_seguros.gestores.GestorMudanzas;
import co.edu.sena.traslados_seguros.excepciones.DatosInvalidosException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nTRASLADOS SEGUROS - SEMANA 8: COLECCIONES AVANZADAS");
        System.out.println("Estudiante: Carlos Javier Yaya Gomez");
        System.out.println("Ficha: 3228973A\n");

        GestorMudanzas gestor = new GestorMudanzas();

        try {
            // ====================================
            // EJERCICIO 1: ArrayList con Generics
            // ====================================
            System.out.println("=== EJERCICIO 1: ArrayList<E> con Generics ===\n");
            System.out.println("El sistema usa ArrayList<E> desde Semana 1:");
            System.out.println("- List<Cliente> clientes");
            System.out.println("- List<Vehiculo> vehiculos");
            System.out.println("- List<Empleado> empleados");
            System.out.println("- List<MovingService> servicios");

            // Crear recursos
            Cliente cliente1 = new Cliente("Ana Garcia", "3001234567", "1012345678", "ana@email.com");
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

            Empleado empleado1 = new Empleado("EMP-001", "Juan Rojas", "Conductor", 80000);
            Empleado empleado2 = new Empleado("EMP-002", "Maria Lopez", "Cargadora", 60000);
            Empleado empleado3 = new Empleado("EMP-003", "Pedro Martinez", "Cargador", 60000);
            Empleado empleado4 = new Empleado("EMP-004", "Carlos Diaz", "Conductor", 80000);

            gestor.registrarEmpleado(empleado1);
            gestor.registrarEmpleado(empleado2);
            gestor.registrarEmpleado(empleado3);
            gestor.registrarEmpleado(empleado4);

            // Crear servicios
            System.out.println("\n=== CREANDO SERVICIOS CON DETALLES ===\n");

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

            // MOSTRAR DETALLES COMPLETOS DE LOS 5 SERVICIOS
            System.out.println("\n=== DETALLES COMPLETOS DE LOS 5 SERVICIOS ===");
            System.out.println("\nSERVICIO 1:");
            System.out.println(servicio1);
            System.out.println("\nSERVICIO 2:");
            System.out.println(servicio2);
            System.out.println("\nSERVICIO 3:");
            System.out.println(servicio3);
            System.out.println("\nSERVICIO 4:");
            System.out.println(servicio4);
            System.out.println("\nSERVICIO 5:");
            System.out.println(servicio5);

            // ====================================
            // EJERCICIO 2: HashMap para busquedas
            // ====================================
            System.out.println("\n\n=== EJERCICIO 2: HashMap<K,V> para Busquedas Rapidas ===\n");

            System.out.println("HashMaps implementados:");
            System.out.println("- HashMap<String, Cliente> clientesPorId");
            System.out.println("- HashMap<String, Empleado> empleadosPorCodigo");
            System.out.println("- HashMap<String, Vehiculo> vehiculosPorPlaca");
            System.out.println("- HashMap<String, MovingService> serviciosPorCodigo");

            System.out.println("\n--- Busquedas O(1) usando HashMap ---");

            // Busqueda por ID de cliente
            Cliente clienteBuscado = gestor.buscarClientePorId("1012345678");
            System.out.println("Cliente encontrado: " +
                    (clienteBuscado != null ? clienteBuscado.getNombre() : "No encontrado"));

            // Busqueda por codigo de empleado
            Empleado empleadoBuscado = gestor.buscarEmpleadoPorCodigo("EMP-001");
            System.out.println("Empleado encontrado: " +
                    (empleadoBuscado != null ? empleadoBuscado.getNombre() : "No encontrado"));

            // Busqueda por placa de vehiculo
            Vehiculo vehiculoBuscado = gestor.buscarVehiculoPorPlaca("ABC-123");
            System.out.println("Vehiculo encontrado: " +
                    (vehiculoBuscado != null ? vehiculoBuscado.getPlaca() : "No encontrado"));

            // Busqueda por codigo de servicio
            MovingService servicioBuscado = gestor.buscarServicioPorCodigo("MOV-001");
            System.out.println("Servicio encontrado: " +
                    (servicioBuscado != null ? servicioBuscado.getServiceCode() : "No encontrado"));

            System.out.println("\nVentaja: Busqueda directa en O(1) vs O(n) con ArrayList");

            // ====================================
            // EJERCICIO 3: Filtrado y Estadisticas
            // ====================================
            System.out.println("\n\n=== EJERCICIO 3: Filtrado y Estadisticas ===\n");

            // Agregar calificaciones para filtrado
            cliente1.agregarCalificacion(5);
            cliente1.agregarCalificacion(5);
            cliente1.agregarCalificacion(4);

            cliente2.agregarCalificacion(3);
            cliente2.agregarCalificacion(3);

            cliente3.agregarCalificacion(5);
            cliente3.agregarCalificacion(5);
            cliente3.agregarCalificacion(5);

            // Filtrado 1: Clientes por calidad
            System.out.println("--- Filtrado 1: Clientes EXCELENTES ---");
            List<Cliente> clientesExcelentes = gestor.filtrarClientesPorCalidad("EXCELENTE");
            System.out.println("Clientes con calificacion EXCELENTE o superior: " + clientesExcelentes.size());
            for (Cliente c : clientesExcelentes) {
                System.out.println("  - " + c.getNombre() + " (Promedio: " +
                        c.obtenerPromedioCalificaciones() + " - " + c.obtenerNivelCalidad() + ")");
            }

            // Filtrado 2: Empleados por salario
            System.out.println("\n--- Filtrado 2: Empleados por Salario ---");
            List<Empleado> empleadosRango = gestor.filtrarEmpleadosPorSalario(60000, 70000);
            System.out.println("Empleados con salario entre $60,000 y $70,000: " + empleadosRango.size());
            for (Empleado e : empleadosRango) {
                System.out.println("  - " + e.getNombre() + " (" + e.getCargo() +
                        ") - $" + e.getSalarioDiario());
            }

            // Filtrado 3: Vehiculos por capacidad
            System.out.println("\n--- Filtrado 3: Vehiculos por Capacidad ---");
            List<Vehiculo> vehiculosGrandes = gestor.filtrarVehiculosPorCapacidad(20.0);
            System.out.println("Vehiculos con capacidad >= 20m3: " + vehiculosGrandes.size());
            for (Vehiculo v : vehiculosGrandes) {
                System.out.println("  - " + v.getPlaca() + " (" + v.getTipoVehiculo() +
                        ") - " + v.getCapacidadM3() + "m3");
            }

            // Filtrado 4: Servicios por fecha
            System.out.println("\n--- Filtrado 4: Servicios por Fecha ---");
            LocalDate hoy = LocalDate.now();
            LocalDate manana = hoy.plusDays(1);
            List<MovingService> serviciosHoy = gestor.filtrarServiciosPorFecha(hoy, manana);
            System.out.println("Servicios para hoy: " + serviciosHoy.size());

            // Estadisticas 1: Salario promedio
            System.out.println("\n--- Estadistica 1: Salario Promedio ---");
            double salarioPromedio = gestor.calcularSalarioPromedio();
            System.out.println("Salario promedio: $" + String.format("%.2f", salarioPromedio));

            // Estadisticas 2: Promedio de calificaciones
            System.out.println("\n--- Estadistica 2: Promedio de Calificaciones ---");
            double promedioCalificaciones = gestor.calcularPromedioCalificacionesGeneral();
            System.out.println("Promedio general de calificaciones: " +
                    String.format("%.2f", promedioCalificaciones));

            // Estadisticas 3: Capacidad disponible
            System.out.println("\n--- Estadistica 3: Capacidad Disponible ---");
            double capacidadDisponible = gestor.calcularCapacidadTotalDisponible();
            System.out.println("Capacidad total disponible: " +
                    String.format("%.2f", capacidadDisponible) + " m3");

            // Estadisticas 4: Empleado mas activo
            System.out.println("\n--- Estadistica 4: Empleado Mas Activo ---");
            Empleado masActivo = gestor.encontrarEmpleadoMasActivo();
            if (masActivo != null) {
                System.out.println("Empleado mas activo: " + masActivo.getNombre() +
                        " (" + masActivo.contarServiciosRealizados() + " servicios)");
            }

            // Estadisticas 5: Cliente mas frecuente
            System.out.println("\n--- Estadistica 5: Cliente Mas Frecuente ---");
            Cliente masFrecuente = gestor.encontrarClienteMasFrecuente();
            if (masFrecuente != null) {
                System.out.println("Cliente mas frecuente: " + masFrecuente.getNombre() +
                        " (" + masFrecuente.contarServicios() + " servicios)");
            }

            // Estadisticas detalladas
            gestor.generarEstadisticasDetalladas();

            // Distribucion por cargo
            gestor.mostrarDistribucionPorCargo();

            // Distribucion por tipo de vehiculo
            gestor.mostrarDistribucionPorTipoVehiculo();

            // ====================================
            // EJERCICIO 4: Demostracion Completa
            // ====================================
            System.out.println("\n\n=== EJERCICIO 4: Demostracion Completa ===\n");

            System.out.println("--- Resumen de Colecciones Usadas ---");
            System.out.println("1. ArrayList<Cliente>: " + gestor.contarClientes() + " elementos");
            System.out.println("2. ArrayList<Empleado>: " + gestor.contarEmpleados() + " elementos");
            System.out.println("3. ArrayList<Vehiculo>: " + gestor.contarVehiculos() + " elementos");
            System.out.println("4. ArrayList<MovingService>: " + gestor.contarServicios() + " elementos");
            System.out.println("5. HashMap<String, Cliente>: Busqueda O(1)");
            System.out.println("6. HashMap<String, Empleado>: Busqueda O(1)");
            System.out.println("7. HashMap<String, Vehiculo>: Busqueda O(1)");
            System.out.println("8. HashMap<String, MovingService>: Busqueda O(1)");

            System.out.println("\n--- Operaciones Realizadas ---");
            System.out.println("1. Registro con validacion de duplicados usando HashMap");
            System.out.println("2. Busquedas rapidas O(1) por clave unica");
            System.out.println("3. Filtrado por multiples criterios");
            System.out.println("4. Calculo de estadisticas avanzadas");
            System.out.println("5. Analisis de distribucion con HashMap temporal");

            // Reporte final
            System.out.println();
            gestor.generarReporteGeneral();

            // Semanas anteriores (resumen)
            System.out.println("\n\n=== INTEGRACION CON SEMANAS ANTERIORES ===\n");

            System.out.println("Semana 6: Clase Abstracta y Polimorfismo");
            List<Persona> personas = new ArrayList<>();
            personas.add(cliente1);
            personas.add(empleado1);

            for (Persona p : personas) {
                System.out.println(p.getNombre() + " - Costo operacional: $" +
                        p.calcularCostoOperacional());
            }

            System.out.println("\nSemana 6: Interfaces");
            cliente1.enviarNotificacion("Recordatorio: Servicio programado para manana");
            empleado1.enviarNotificacionUrgente("Cambio de horario");

        } catch (DatosInvalidosException e) {
            System.err.println("ERROR DE DATOS: " + e.getMessage());
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