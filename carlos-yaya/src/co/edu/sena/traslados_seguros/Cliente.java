package co.edu.sena.traslados_seguros;

import java.util.ArrayList;
import java.util.List;

// Semana 4: Cliente hereda de Persona
public class Cliente extends Persona {

    // Semana 1: Atributos especificos de Cliente
    private String email;
    private List<MovingService> historialServicios;

    // Semana 4: Constructor 1 - llama a super()
    public Cliente(String nombre, String telefono, String identificacion) {
        this(nombre, telefono, identificacion, null);
    }

    // Semana 4: Constructor 2 - llama a super()
    public Cliente(String nombre, String telefono, String identificacion, String email) {
        super(nombre, telefono, identificacion); // Semana 4: Llamada al constructor padre
        setEmail(email);
        this.historialServicios = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public List<MovingService> getHistorialServicios() {
        return new ArrayList<>(historialServicios);
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

    // Semana 4: Override del metodo heredado
    @Override
    public void mostrarInformacionBasica() {
        System.out.println("=== INFORMACION DEL CLIENTE ===");
        super.mostrarInformacionBasica(); // Semana 4: Llamada al metodo padre
        if (email != null) {
            System.out.println("Email: " + email);
        }
        System.out.println("Servicios contratados: " + historialServicios.size());
    }

    // Semana 4: Override de toString
    @Override
    public String toString() {
        String emailInfo = email != null ? " | Email: " + email : "";
        return "Cliente: " + nombre + " | Tel: " + telefono +
                " | ID: " + identificacion + emailInfo + " | Servicios: " + historialServicios.size();
    }
    // Semana 5: Override - obtenerTipoPersona
    @Override
    public String obtenerTipoPersona() {
        return "Cliente";
    }
}