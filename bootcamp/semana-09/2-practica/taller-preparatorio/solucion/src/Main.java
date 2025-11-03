import servicio.*;
import modelo.*;
import excepciones.*;
import java.util.Scanner;

/**
 * Clase principal con menú interactivo.
 * Sistema de gestión de vehículos - Taller Preparatorio Semana 9.
 */
public class Main {
    private static VehiculoServicio servicio = new VehiculoServicio();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║  SISTEMA DE GESTIÓN DE VEHÍCULOS    ║");
        System.out.println("║  Bootcamp POO Java - Semana 9       ║");
        System.out.println("╚══════════════════════════════════════╝\n");
        
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            
            try {
                switch (opcion) {
                    case 1: registrarVehiculo(); break;
                    case 2: buscarVehiculo(); break;
                    case 3: listarVehiculos(); break;
                    case 4: actualizarVehiculo(); break;
                    case 5: eliminarVehiculo(); break;
                    case 0: System.out.println("\n👋 ¡Hasta luego!"); break;
                    default: System.out.println("❌ Opción inválida");
                }
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
            
            if (opcion != 0) {
                System.out.println("\nPresiona Enter para continuar...");
                scanner.nextLine();
            }
            
        } while (opcion != 0);
        
        scanner.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║       MENÚ PRINCIPAL           ║");
        System.out.println("╠════════════════════════════════╣");
        System.out.println("║ 1. Registrar vehículo          ║");
        System.out.println("║ 2. Buscar vehículo             ║");
        System.out.println("║ 3. Listar vehículos            ║");
        System.out.println("║ 4. Actualizar vehículo         ║");
        System.out.println("║ 5. Eliminar vehículo           ║");
        System.out.println("║ 0. Salir                       ║");
        System.out.println("╚════════════════════════════════╝");
        System.out.print("Opción: ");
    }
    
    private static int leerOpcion() {
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            return opcion;
        } catch (Exception e) {
            scanner.nextLine(); // Limpiar buffer
            return -1;
        }
    }
    
    private static void registrarVehiculo() throws PlacaDuplicadaException {
        System.out.println("\n📝 REGISTRAR VEHÍCULO");
        System.out.println("Tipo: 1) Auto  2) Moto  3) Camión");
        System.out.print("Selecciona tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        
        System.out.print("Año: ");
        int año = scanner.nextInt();
        scanner.nextLine();
        
        Vehiculo vehiculo = null;
        
        switch (tipo) {
            case 1:
                System.out.print("Número de puertas: ");
                int puertas = scanner.nextInt();
                scanner.nextLine();
                vehiculo = new Auto(placa, marca, año, puertas);
                break;
                
            case 2:
                System.out.print("Cilindraje (cc): ");
                int cilindraje = scanner.nextInt();
                scanner.nextLine();
                vehiculo = new Moto(placa, marca, año, cilindraje);
                break;
                
            case 3:
                System.out.print("Capacidad de carga (ton): ");
                double capacidad = scanner.nextDouble();
                scanner.nextLine();
                vehiculo = new Camion(placa, marca, año, capacidad);
                break;
                
            default:
                System.out.println("❌ Tipo inválido");
                return;
        }
        
        servicio.agregar(vehiculo);
    }
    
    private static void buscarVehiculo() throws VehiculoNoEncontradoException {
        System.out.println("\n🔍 BUSCAR VEHÍCULO");
        System.out.print("Ingresa la placa: ");
        String placa = scanner.nextLine();
        
        Vehiculo vehiculo = servicio.buscar(placa);
        System.out.println("\n✅ Vehículo encontrado:");
        System.out.println(vehiculo);
    }
    
    private static void listarVehiculos() {
        servicio.listar();
    }
    
    private static void actualizarVehiculo() throws VehiculoNoEncontradoException {
        System.out.println("\n✏️  ACTUALIZAR VEHÍCULO");
        System.out.print("Ingresa la placa: ");
        String placa = scanner.nextLine();
        
        // Verificar que existe
        Vehiculo existente = servicio.buscar(placa);
        System.out.println("Vehículo actual: " + existente);
        
        System.out.println("\n(Simplificado: solo actualiza marca)");
        System.out.print("Nueva marca: ");
        String nuevaMarca = scanner.nextLine();
        
        existente.setMarca(nuevaMarca);
        servicio.actualizar(placa, existente);
    }
    
    private static void eliminarVehiculo() throws VehiculoNoEncontradoException {
        System.out.println("\n🗑️  ELIMINAR VEHÍCULO");
        System.out.print("Ingresa la placa: ");
        String placa = scanner.nextLine();
        
        System.out.print("¿Estás seguro? (S/N): ");
        String confirmacion = scanner.nextLine();
        
        if (confirmacion.equalsIgnoreCase("S")) {
            servicio.eliminar(placa);
        } else {
            System.out.println("❌ Operación cancelada");
        }
    }
}
