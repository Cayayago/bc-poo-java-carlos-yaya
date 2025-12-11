package co.edu.sena.traslados_seguros;

import java.util.ArrayList;
import java.util.List;

// Semana 4: Empleado hereda de Persona Empleado implementa Notificable
public class Empleado extends Persona implements Notificable {

    // Semana 1: Atributos especificos de Empleado
    private String codigoEmpleado;
    private String cargo;
    private double salarioDiario;
    private boolean ocupado;
    private List<MovingService> serviciosRealizados;
    // Semana 6: Atributos para Notificable
    private List<String> notificacionesPendientes;
    // Semana 4: Constructor 1
    public Empleado(String codigoEmpleado, String nombre, String cargo, double salarioDiario, String telefono) {
        super(nombre, telefono, codigoEmpleado);
        setCodigoEmpleado(codigoEmpleado);
        setCargo(cargo);
        setSalarioDiario(salarioDiario);
        this.ocupado = false;
        this.serviciosRealizados = new ArrayList<>();
        this.notificacionesPendientes = new ArrayList<>(); // Semana 6
    }
    // Semana 4: Constructor 2 simplificado
    public Empleado(String codigoEmpleado, String nombre, String cargo, double salarioDiario) {
        this(codigoEmpleado, nombre, cargo, salarioDiario, "0000000000");
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalarioDiario() {
        return salarioDiario;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public List<MovingService> getServiciosRealizados() {
        return new ArrayList<>(serviciosRealizados);
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        if (validarStringNoVacio(codigoEmpleado) && validarCodigo(codigoEmpleado)) {
            this.codigoEmpleado = codigoEmpleado.toUpperCase().trim();
            // Semana 4: Actualizar tambien la identificacion heredada
            this.identificacion = this.codigoEmpleado;
        } else {
            throw new IllegalArgumentException("Codigo invalido: formato debe ser EMP-###");
        }
    }

    public void setCargo(String cargo) {
        if (validarStringNoVacio(cargo) && validarCargo(cargo)) {
            this.cargo = cargo.trim();
        } else {
            throw new IllegalArgumentException("Cargo invalido: debe tener entre 3 y 50 caracteres");
        }
    }

    public void setSalarioDiario(double salarioDiario) {
        if (validarSalario(salarioDiario)) {
            this.salarioDiario = salarioDiario;
        } else {
            throw new IllegalArgumentException("Salario invalido: debe estar entre 50000 y 1000000");
        }
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    private boolean validarStringNoVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    private boolean validarCodigo(String codigo) {
        return codigo.matches("(?i)EMP-\\d{3}");
    }

    private boolean validarCargo(String cargo) {
        int longitud = cargo.trim().length();
        return longitud >= 3 && longitud <= 50;
    }

    private boolean validarSalario(double salario) {
        return salario >= 50000 && salario <= 1000000;
    }

    public double calcularPagoSemanal(int diasTrabajados) {
        if (!validarDiasTrabajados(diasTrabajados)) {
            throw new IllegalArgumentException("Dias trabajados invalido: debe estar entre 0 y 7");
        }

        double pagoTotal = salarioDiario * diasTrabajados;

        if (diasTrabajados == 6) {
            pagoTotal += aplicarBonificacion();
        }

        return pagoTotal;
    }

    private boolean validarDiasTrabajados(int dias) {
        return dias >= 0 && dias <= 7;
    }

    private double aplicarBonificacion() {
        return 50000;
    }

    public void asignarServicio(MovingService servicio) {
        if (!this.ocupado && servicio != null) {
            this.ocupado = true;
            agregarServicioAlHistorial(servicio);
        }
    }

    public void completarServicio() {
        this.ocupado = false;
    }

    private void agregarServicioAlHistorial(MovingService servicio) {
        if (!serviciosRealizados.contains(servicio)) {
            serviciosRealizados.add(servicio);
        }
    }

    public int contarServiciosRealizados() {
        return serviciosRealizados.size();
    }

    public void mostrarHistorial() {
        System.out.println("\n=== HISTORIAL EMPLEADO " + nombre + " ===");
        if (serviciosRealizados.isEmpty()) {
            System.out.println("No hay servicios registrados");
        } else {
            for (int i = 0; i < serviciosRealizados.size(); i++) {
                MovingService s = serviciosRealizados.get(i);
                System.out.println((i + 1) + ". " + s.getServiceCode() +
                        " | " + s.getOrigin() + " -> " + s.getDestination());
            }
        }
        System.out.println("Total servicios: " + serviciosRealizados.size());
    }

    // Semana 4: Override del metodo heredado
    @Override
    public void mostrarInformacionBasica() {
        System.out.println("=== INFORMACION DEL EMPLEADO ===");
        System.out.println("Codigo: " + codigoEmpleado);
        super.mostrarInformacionBasica(); // Semana 4: Llamada al metodo padre
        System.out.println("Cargo: " + cargo);
        System.out.println("Salario diario: $" + salarioDiario);
        System.out.println("Estado: " + (ocupado ? "OCUPADO" : "DISPONIBLE"));
    }

    // Semana 4: Override de toString
    @Override
    public String toString() {
        String estado = ocupado ? "OCUPADO" : "DISPONIBLE";
        return "Empleado " + codigoEmpleado + " | " + nombre +
                " | " + cargo + " | $" + salarioDiario + "/dia | " + estado +
                " | Servicios: " + serviciosRealizados.size();
    }
    // Semana 5: Override - obtenerTipoPersona
    @Override
    public String obtenerTipoPersona() {
        return "Empleado";
    }
    // Semana 6: Implementacion del metodo abstracto
    @Override
    public double calcularCostoOperacional() {
        // Costo operacional: salario diario
        return salarioDiario;
    }
    @Override
    public void enviarNotificacion(String mensaje) {
        notificacionesPendientes.add("[NORMAL] " + mensaje);
        System.out.println("Notificacion enviada a empleado " + nombre + ": " + mensaje);
    }

    @Override
    public void enviarNotificacionUrgente(String mensaje) {
        notificacionesPendientes.add("[URGENTE] " + mensaje);
        System.out.println("*** URGENTE *** Notificacion a empleado " + nombre + ": " + mensaje);
    }

    @Override
    public boolean tieneNotificacionesPendientes() {
        return !notificacionesPendientes.isEmpty();
    }

    public void mostrarNotificaciones() {
        System.out.println("\n=== NOTIFICACIONES DE " + nombre + " ===");
        if (notificacionesPendientes.isEmpty()) {
            System.out.println("No hay notificaciones pendientes");
        } else {
            for (int i = 0; i < notificacionesPendientes.size(); i++) {
                System.out.println((i + 1) + ". " + notificacionesPendientes.get(i));
            }
        }
    }
}