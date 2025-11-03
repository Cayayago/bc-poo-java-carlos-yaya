package servicio;

import modelo.Contacto;
import java.util.*;

/**
 * Sistema de gestión de contactos utilizando HashMap para búsqueda eficiente.
 * 
 * @author SENA - Bootcamp POO Java
 * @version 1.0
 */
public class AgendaContactos {
    // HashMap principal: búsqueda rápida por ID en O(1)
    private Map<String, Contacto> contactosPorId;
    
    /**
     * Constructor que inicializa las estructuras de datos.
     */
    public AgendaContactos() {
        this.contactosPorId = new HashMap<>();
    }
    
    /**
     * Agrega un nuevo contacto a la agenda.
     * 
     * @param contacto El contacto a agregar
     * @return true si se agregó exitosamente, false si el ID ya existe
     */
    public boolean agregarContacto(Contacto contacto) {
        if (contacto == null) {
            System.out.println("❌ Error: El contacto no puede ser null");
            return false;
        }
        
        if (contactosPorId.containsKey(contacto.getId())) {
            System.out.println("❌ Error: Ya existe un contacto con el ID: " + contacto.getId());
            return false;
        }
        
        // Verificar email duplicado
        if (existeEmail(contacto.getEmail())) {
            System.out.println("❌ Error: El email ya está registrado: " + contacto.getEmail());
            return false;
        }
        
        contactosPorId.put(contacto.getId(), contacto);
        System.out.println("✅ Contacto agregado exitosamente: " + contacto.getNombre());
        return true;
    }
    
    /**
     * Busca un contacto por su ID.
     * 
     * @param id El ID del contacto a buscar
     * @return El contacto encontrado o null si no existe
     */
    public Contacto buscarPorId(String id) {
        return contactosPorId.get(id);  // O(1) - búsqueda eficiente
    }
    
    /**
     * Busca contactos cuyo nombre contenga el texto especificado.
     * 
     * @param nombre El nombre o parte del nombre a buscar (case-insensitive)
     * @return Lista de contactos que coinciden con el criterio
     */
    public List<Contacto> buscarPorNombre(String nombre) {
        List<Contacto> resultados = new ArrayList<>();
        
        if (nombre == null || nombre.trim().isEmpty()) {
            return resultados;
        }
        
        String nombreBusqueda = nombre.toLowerCase();
        
        // Iterar sobre todos los valores del Map
        for (Contacto contacto : contactosPorId.values()) {
            if (contacto.getNombre().toLowerCase().contains(nombreBusqueda)) {
                resultados.add(contacto);
            }
        }
        
        return resultados;
    }
    
    /**
     * Actualiza la información de un contacto existente.
     * 
     * @param id El ID del contacto a actualizar
     * @param nuevosDatos Objeto Contacto con la nueva información
     * @return true si se actualizó exitosamente, false si no existe
     */
    public boolean actualizarContacto(String id, Contacto nuevosDatos) {
        if (!contactosPorId.containsKey(id)) {
            System.out.println("❌ Error: No existe un contacto con el ID: " + id);
            return false;
        }
        
        // Verificar que el nuevo email no esté usado por otro contacto
        Contacto contactoActual = contactosPorId.get(id);
        if (!contactoActual.getEmail().equals(nuevosDatos.getEmail())) {
            if (existeEmail(nuevosDatos.getEmail())) {
                System.out.println("❌ Error: El email ya está en uso por otro contacto");
                return false;
            }
        }
        
        contactosPorId.put(id, nuevosDatos);
        System.out.println("✅ Contacto actualizado exitosamente: " + nuevosDatos.getNombre());
        return true;
    }
    
    /**
     * Elimina un contacto de la agenda por su ID.
     * 
     * @param id El ID del contacto a eliminar
     * @return true si se eliminó exitosamente, false si no existe
     */
    public boolean eliminarContacto(String id) {
        Contacto eliminado = contactosPorId.remove(id);
        
        if (eliminado != null) {
            System.out.println("✅ Contacto eliminado exitosamente: " + eliminado.getNombre());
            return true;
        } else {
            System.out.println("❌ Error: No existe un contacto con el ID: " + id);
            return false;
        }
    }
    
    /**
     * Retorna una lista con todos los contactos de la agenda.
     * 
     * @return Lista de todos los contactos (copia defensiva)
     */
    public List<Contacto> listarTodos() {
        return new ArrayList<>(contactosPorId.values());
    }
    
    /**
     * Busca todos los contactos de una categoría específica.
     * 
     * @param categoria La categoría a buscar
     * @return Lista de contactos de esa categoría
     */
    public List<Contacto> buscarPorCategoria(String categoria) {
        List<Contacto> resultados = new ArrayList<>();
        
        if (categoria == null || categoria.trim().isEmpty()) {
            return resultados;
        }
        
        for (Contacto contacto : contactosPorId.values()) {
            if (contacto.getCategoria().equalsIgnoreCase(categoria)) {
                resultados.add(contacto);
            }
        }
        
        return resultados;
    }
    
    /**
     * Verifica si un email ya está registrado en la agenda.
     * 
     * @param email El email a verificar
     * @return true si el email ya existe, false en caso contrario
     */
    public boolean existeEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        
        for (Contacto contacto : contactosPorId.values()) {
            if (contacto.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Cuenta cuántos contactos hay por cada categoría.
     * 
     * @return Map con la categoría como clave y la cantidad como valor
     */
    public Map<String, Integer> contarPorCategoria() {
        Map<String, Integer> conteo = new HashMap<>();
        
        for (Contacto contacto : contactosPorId.values()) {
            String categoria = contacto.getCategoria();
            // getOrDefault retorna 0 si la clave no existe, luego suma 1
            conteo.put(categoria, conteo.getOrDefault(categoria, 0) + 1);
        }
        
        return conteo;
    }
    
    /**
     * Retorna el número total de contactos en la agenda.
     * 
     * @return Cantidad de contactos
     */
    public int cantidadContactos() {
        return contactosPorId.size();
    }
    
    /**
     * Verifica si la agenda está vacía.
     * 
     * @return true si no hay contactos, false en caso contrario
     */
    public boolean estaVacia() {
        return contactosPorId.isEmpty();
    }
    
    /**
     * Obtiene todas las categorías únicas presentes en la agenda.
     * 
     * @return Set con las categorías únicas
     */
    public Set<String> obtenerCategorias() {
        Set<String> categorias = new HashSet<>();
        
        for (Contacto contacto : contactosPorId.values()) {
            categorias.add(contacto.getCategoria());
        }
        
        return categorias;
    }
    
    /**
     * Muestra estadísticas generales de la agenda.
     */
    public void mostrarEstadisticas() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("       📊 ESTADÍSTICAS DE LA AGENDA");
        System.out.println("═══════════════════════════════════════");
        System.out.println("Total de contactos: " + cantidadContactos());
        
        if (cantidadContactos() > 0) {
            System.out.println("\nContactos por categoría:");
            Map<String, Integer> conteo = contarPorCategoria();
            
            for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
                System.out.printf("  %-15s: %d contacto(s)\n", 
                                entry.getKey(), entry.getValue());
            }
        }
        
        System.out.println("═══════════════════════════════════════\n");
    }
}
