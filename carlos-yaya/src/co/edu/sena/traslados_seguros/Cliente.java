package co.edu.sena.traslados_seguros;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private String telefono;
    private String identificacion;
    private String email;
    private List<MovingService> historialServicios;

    public Cliente(String nombre, String telefono, String identificacion) {
        this(nombre, telefono, identificacion, null);
    }

    public Cliente(String nombre, String telefono, String identificacion, String email) {
        setNombre(nombre);
        setTelefono(telefono);
        setIdentificacion(identificacion);
        setEmail(email);
        this.historialServicios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getEmail() {
        return email;
    }

    public List<MovingService> getHistorialServicios() {
        return new ArrayList<>(historialServicios);
    }

    public void setNombre(String nombre) {
        if (validarStringNoVacio(nombre) && validarNombre(nombre)) {
            this.nombre = nombre.trim();
        } else {
            throw new IllegalArgumentException("Nombre invalido: debe tener al menos 3 caracteres");
        }
    }

    public void setTelefono(String telefono) {
        if (validarStringNoVacio(telefono) && validarTelefono(telefono)) {
            this.telefono = telefono.trim();
        } else {
            throw new IllegalArgumentException("Telefono invalido: debe tener 10 digitos");
        }
    }

    public void setIdentificacion(String identificacion) {
        if (validarStringNoVacio(identificacion) && validarIdentificacion(identificacion)) {
            this.identificacion = identificacion.trim();
        } else {
            throw new IllegalArgumentException("Identificacion invalida: debe tener entre 5 y 15 caracteres");
        }
    }

    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            if (validarEmail(email)) {
                this.email = email.trim().toLowerCase();
            } else {
                throw new IllegalArgumentException("Email invalido: formato incorrecto");
            }
        } else {
            this.email = null;
        }
    }

    private boolean validarStringNoVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    private boolean validarNombre(String nombre) {
        return nombre.trim().length() >= 3 && nombre.trim().length() <= 100;
    }

    private boolean validarTelefono(String telefono) {
        return telefono.matches("\\d{10}");
    }

    private boolean validarIdentificacion(String identificacion) {
        String id = identificacion.trim();
        return id.length() >= 5 && id.length() <= 15 && id.matches("\\d+");
    }

    private boolean validarEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    public void agregarServicio(MovingService servicio) {
        if (servicio != null && !historialServicios.contains(servicio)) {
            historialServicios.add(servicio);
        }
    }

    public int contarServicios() {
        return historialServicios.size();
    }

    public void mostrarHistorial() {
        System.out.println("\n=== HISTORIAL DE " + nombre + " ===");
        if (historialServicios.isEmpty()) {
            System.out.println("No hay servicios registrados");
        } else {
            for (int i = 0; i < historialServicios.size(); i++) {
                MovingService s = historialServicios.get(i);
                System.out.println((i + 1) + ". " + s.getServiceCode() +
                        " | " + s.getOrigin() + " -> " + s.getDestination());
            }
        }
        System.out.println("Total servicios: " + historialServicios.size());
    }

    @Override
    public String toString() {
        String emailInfo = email != null ? " | Email: " + email : "";
        return "Cliente: " + nombre + " | Tel: " + telefono +
                " | ID: " + identificacion + emailInfo + " | Servicios: " + historialServicios.size();
    }
}