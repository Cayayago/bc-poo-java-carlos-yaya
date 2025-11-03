import modelo.Contacto;
import servicio.AgendaContactos;
import util.Validador;

import java.util.*;

/**
 * Programa principal con menú interactivo para gestionar la agenda de contactos.
 * Demuestra el uso de HashMap y operaciones sobre colecciones.
 * 
 * @author SENA - Bootcamp POO Java
 * @version 1.0
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static AgendaContactos agenda = new AgendaContactos();
    
    public static void main(String[] args) {
        // Cargar datos de prueba
        cargarDatosPrueba();
        
        boolean continuar = true;
        
        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    buscarPorId();
                    break;
                case 3:
                    buscarPorNombre();
                    break;
                case 4:
                    actualizarContacto();
                    break;
                case 5:
                    eliminarContacto();
                    break;
                case 6:
                    listarTodos();
                    break;
                case 7:
                    buscarPorCategoria();
                    break;
                case 8:
                    mostrarEstadisticas();
                    break;
                case 9:
                    continuar = false;
                    System.out.println("\n👋 ¡Hasta pronto! Agenda cerrada.");
                    break;
                default:
                    System.out.println("❌ Opción inválida. Intente nuevamente.");
            }
            
            if (continuar) {
                esperarEnter();
            }
        }
        
        scanner.close();
    }
    
    /**
     * Muestra el menú principal de opciones.
     */
    private static void mostrarMenu() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║    📱 AGENDA DE CONTACTOS - MENU     ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║ 1. 📝 Agregar contacto               ║");
        System.out.println("║ 2. 🔍 Buscar por ID                  ║");
        System.out.println("║ 3. 🔎 Buscar por nombre              ║");
        System.out.println("║ 4. ✏️  Actualizar contacto            ║");
        System.out.println("║ 5. 🗑️  Eliminar contacto              ║");
        System.out.println("║ 6. 📋 Listar todos                   ║");
        System.out.println("║ 7. 🏷️  Buscar por categoría          ║");
        System.out.println("║ 8. 📊 Estadísticas                   ║");
        System.out.println("║ 9. 🚪 Salir                          ║");
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.print("Seleccione una opción: ");
    }
    
    /**
     * Lee una opción numérica del usuario.
     */
    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    /**
     * Opción 1: Agregar un nuevo contacto.
     */
    private static void agregarContacto() {
        System.out.println("\n═══ AGREGAR NUEVO CONTACTO ═══");
        
        System.out.print("ID (formato: C001): ");
        String id = scanner.nextLine();
        
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Categoría (Familia/Trabajo/Amigos/Otro): ");
        String categoria = scanner.nextLine();
        
        // Validar datos
        if (!Validador.validarContactoCompleto(id, nombre, telefono, email, categoria)) {
            return;
        }
        
        // Crear y agregar contacto
        Contacto contacto = new Contacto(id, nombre, telefono, email, categoria);
        agenda.agregarContacto(contacto);
    }
    
    /**
     * Opción 2: Buscar un contacto por su ID.
     */
    private static void buscarPorId() {
        System.out.println("\n═══ BUSCAR POR ID ═══");
        System.out.print("Ingrese el ID a buscar: ");
        String id = scanner.nextLine();
        
        Contacto contacto = agenda.buscarPorId(id);
        
        if (contacto != null) {
            System.out.println("\n✅ Contacto encontrado:");
            System.out.println(contacto);
        } else {
            System.out.println("❌ No se encontró ningún contacto con el ID: " + id);
        }
    }
    
    /**
     * Opción 3: Buscar contactos por nombre.
     */
    private static void buscarPorNombre() {
        System.out.println("\n═══ BUSCAR POR NOMBRE ═══");
        System.out.print("Ingrese el nombre a buscar: ");
        String nombre = scanner.nextLine();
        
        List<Contacto> resultados = agenda.buscarPorNombre(nombre);
        
        if (resultados.isEmpty()) {
            System.out.println("❌ No se encontraron contactos con el nombre: " + nombre);
        } else {
            System.out.println("\n✅ Se encontraron " + resultados.size() + " contacto(s):");
            for (Contacto contacto : resultados) {
                System.out.println(contacto.toStringCompacto());
            }
        }
    }
    
    /**
     * Opción 4: Actualizar un contacto existente.
     */
    private static void actualizarContacto() {
        System.out.println("\n═══ ACTUALIZAR CONTACTO ═══");
        System.out.print("Ingrese el ID del contacto a actualizar: ");
        String id = scanner.nextLine();
        
        Contacto contactoActual = agenda.buscarPorId(id);
        
        if (contactoActual == null) {
            System.out.println("❌ No existe un contacto con el ID: " + id);
            return;
        }
        
        System.out.println("\nContacto actual:");
        System.out.println(contactoActual.toStringCompacto());
        System.out.println("\nIngrese los nuevos datos (presione Enter para mantener el valor actual):");
        
        System.out.print("Nombre [" + contactoActual.getNombre() + "]: ");
        String nombre = scanner.nextLine();
        if (nombre.trim().isEmpty()) nombre = contactoActual.getNombre();
        
        System.out.print("Teléfono [" + contactoActual.getTelefono() + "]: ");
        String telefono = scanner.nextLine();
        if (telefono.trim().isEmpty()) telefono = contactoActual.getTelefono();
        
        System.out.print("Email [" + contactoActual.getEmail() + "]: ");
        String email = scanner.nextLine();
        if (email.trim().isEmpty()) email = contactoActual.getEmail();
        
        System.out.print("Categoría [" + contactoActual.getCategoria() + "]: ");
        String categoria = scanner.nextLine();
        if (categoria.trim().isEmpty()) categoria = contactoActual.getCategoria();
        
        // Crear contacto actualizado
        Contacto contactoActualizado = new Contacto(id, nombre, telefono, email, categoria);
        agenda.actualizarContacto(id, contactoActualizado);
    }
    
    /**
     * Opción 5: Eliminar un contacto.
     */
    private static void eliminarContacto() {
        System.out.println("\n═══ ELIMINAR CONTACTO ═══");
        System.out.print("Ingrese el ID del contacto a eliminar: ");
        String id = scanner.nextLine();
        
        Contacto contacto = agenda.buscarPorId(id);
        
        if (contacto != null) {
            System.out.println("\nContacto a eliminar:");
            System.out.println(contacto.toStringCompacto());
            System.out.print("\n¿Está seguro de eliminar este contacto? (S/N): ");
            String confirmacion = scanner.nextLine();
            
            if (confirmacion.equalsIgnoreCase("S")) {
                agenda.eliminarContacto(id);
            } else {
                System.out.println("❌ Operación cancelada");
            }
        } else {
            System.out.println("❌ No existe un contacto con el ID: " + id);
        }
    }
    
    /**
     * Opción 6: Listar todos los contactos.
     */
    private static void listarTodos() {
        System.out.println("\n═══ LISTADO DE TODOS LOS CONTACTOS ═══");
        
        List<Contacto> contactos = agenda.listarTodos();
        
        if (contactos.isEmpty()) {
            System.out.println("📭 La agenda está vacía");
            return;
        }
        
        System.out.println("Total de contactos: " + contactos.size());
        System.out.println();
        
        for (Contacto contacto : contactos) {
            System.out.println(contacto.toStringCompacto());
        }
    }
    
    /**
     * Opción 7: Buscar contactos por categoría.
     */
    private static void buscarPorCategoria() {
        System.out.println("\n═══ BUSCAR POR CATEGORÍA ═══");
        
        // Mostrar categorías disponibles
        Set<String> categorias = agenda.obtenerCategorias();
        if (!categorias.isEmpty()) {
            System.out.println("Categorías disponibles:");
            for (String cat : categorias) {
                System.out.println("  - " + cat);
            }
            System.out.println();
        }
        
        System.out.print("Ingrese la categoría a buscar: ");
        String categoria = scanner.nextLine();
        
        List<Contacto> resultados = agenda.buscarPorCategoria(categoria);
        
        if (resultados.isEmpty()) {
            System.out.println("❌ No se encontraron contactos en la categoría: " + categoria);
        } else {
            System.out.println("\n✅ Se encontraron " + resultados.size() + " contacto(s):");
            for (Contacto contacto : resultados) {
                System.out.println(contacto.toStringCompacto());
            }
        }
    }
    
    /**
     * Opción 8: Mostrar estadísticas de la agenda.
     */
    private static void mostrarEstadisticas() {
        agenda.mostrarEstadisticas();
    }
    
    /**
     * Espera que el usuario presione Enter para continuar.
     */
    private static void esperarEnter() {
        System.out.print("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
    
    /**
     * Carga datos de prueba en la agenda para facilitar las pruebas.
     */
    private static void cargarDatosPrueba() {
        System.out.println("📦 Cargando datos de prueba...\n");
        
        agenda.agregarContacto(new Contacto("C001", "Carlos Pérez", "555-1234", 
                                            "carlos@email.com", "Trabajo"));
        agenda.agregarContacto(new Contacto("C002", "Ana García", "555-5678", 
                                            "ana@email.com", "Familia"));
        agenda.agregarContacto(new Contacto("C003", "Luis Martínez", "555-9012", 
                                            "luis@email.com", "Amigos"));
        agenda.agregarContacto(new Contacto("C004", "María López", "555-3456", 
                                            "maria@email.com", "Trabajo"));
        agenda.agregarContacto(new Contacto("C005", "Pedro Sánchez", "555-7890", 
                                            "pedro@email.com", "Familia"));
    }
}
