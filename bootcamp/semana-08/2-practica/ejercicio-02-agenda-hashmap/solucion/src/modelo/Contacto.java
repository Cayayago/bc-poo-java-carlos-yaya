package modelo;

import java.util.Objects;

/**
 * Representa un contacto en la agenda con información personal.
 * 
 * @author SENA - Bootcamp POO Java
 * @version 1.0
 */
public class Contacto {
    private String id;
    private String nombre;
    private String telefono;
    private String email;
    private String categoria;
    
    /**
     * Constructor completo para crear un contacto.
     * 
     * @param id Identificador único del contacto
     * @param nombre Nombre completo del contacto
     * @param telefono Número de teléfono
     * @param email Correo electrónico
     * @param categoria Categoría del contacto (Familia, Trabajo, Amigos, etc.)
     */
    public Contacto(String id, String nombre, String telefono, String email, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.categoria = categoria;
    }
    
    // Getters
    public String getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    // Setters
    public void setId(String id) {
        this.id = id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    /**
     * Compara dos contactos basándose en su ID.
     * Dos contactos son iguales si tienen el mismo ID.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacto contacto = (Contacto) o;
        return Objects.equals(id, contacto.id);
    }
    
    /**
     * Genera el código hash basado en el ID del contacto.
     * Esencial para el correcto funcionamiento en HashMap.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    /**
     * Representación en texto del contacto con formato legible.
     */
    @Override
    public String toString() {
        return String.format("┌────────────────────────────────────┐\n" +
                           "│ ID:        %-24s│\n" +
                           "│ Nombre:    %-24s│\n" +
                           "│ Teléfono:  %-24s│\n" +
                           "│ Email:     %-24s│\n" +
                           "│ Categoría: %-24s│\n" +
                           "└────────────────────────────────────┘",
                           id, nombre, telefono, email, categoria);
    }
    
    /**
     * Representación compacta del contacto en una línea.
     */
    public String toStringCompacto() {
        return String.format("[%s] %s | %s | %s | %s", 
                           id, nombre, telefono, email, categoria);
    }
}
