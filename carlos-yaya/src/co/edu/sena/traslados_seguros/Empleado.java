package co.edu.sena.traslados_seguros;

import java.util.ArrayList;
import java.util.List;

public class Empleado {

    private String codigoEmpleado;
    private String nombreCompleto;
    private String cargo;
    private double salarioDiario;
    private String telefono;
    private boolean ocupado;
    private List<MovingService> serviciosRealizados;

    public Empleado(String codigoEmpleado, String nombreCompleto, String cargo, double salarioDiario) {
        this(codigoEmpleado, nombreCompleto, cargo, salarioDiario, null);
    }

    public Empleado(String codigoEmpleado, String nombreCompleto, String cargo, double salarioDiario, String telefono) {
        setCodigoEmpleado(codigoEmpleado);
        setNombreCompleto(nombreCompleto);
        setCargo(cargo);
        setSalarioDiario(salarioDiario);
        setTelefono(telefono);
        this.ocupado = false;
        this.serviciosRealizados = new ArrayList<>();
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalarioDiario() {
        return salarioDiario;
    }

    public String getTelefono() {
        return telefono;
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
        } else {
            throw new IllegalArgumentException("Codigo invalido: formato debe ser EMP-### donde ### son 3 digitos");
        }
    }

    public void setNombreCompleto(String nombreCompleto) {
        if (validarStringNoVacio(nombreCompleto) && validarNombre(nombreCompleto)) {
            this.nombreCompleto = nombreCompleto.trim();
        } else {
            throw new IllegalArgumentException("Nombre invalido: debe tener entre 3 y 100 caracteres");
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

    public void setTelefono(String telefono) {
        if (telefono != null && !telefono.trim().isEmpty()) {
            if (validarTelefono(telefono)) {
                this.telefono = telefono.trim();
            } else {
                throw new IllegalArgumentException("Telefono invalido: debe tener 10 digitos");
            }
        } else {
            this.telefono = null;
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

    private boolean validarNombre(String nombre) {
        int longitud = nombre.trim().length();
        return longitud >= 3 && longitud <= 100;
    }

    private boolean validarCargo(String cargo) {
        int longitud = cargo.trim().length();
        return longitud >= 3 && longitud <= 50;
    }

    private boolean validarSalario(double salario) {
        return salario >= 50000 && salario <= 1000000;
    }

    private boolean validarTelefono(String telefono) {
        return telefono.matches("\\d{10}");
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
        System.out.println("Bonificacion aplicada: $50,000");
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
        System.out.println("\n=== HISTORIAL EMPLEADO " + nombreCompleto + " ===");
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

    @Override
    public String toString() {
        String estado = ocupado ? "OCUPADO" : "DISPONIBLE";
        String telInfo = telefono != null ? " | Tel: " + telefono : "";
        return "Empleado " + codigoEmpleado + " | " + nombreCompleto +
                " | " + cargo + " | $" + salarioDiario + "/dia" + telInfo + " | " + estado +
                " | Servicios: " + serviciosRealizados.size();
    }
}