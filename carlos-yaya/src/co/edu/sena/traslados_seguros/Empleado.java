package co.edu.sena.traslados_seguros;

import java.util.ArrayList;
import java.util.List;

public class Empleado {

    private String codigoEmpleado;
    private String nombreCompleto;
    private String cargo;
    private double salarioDiario;
    private boolean ocupado;
    private List<MovingService> serviciosRealizados;

    public Empleado(String codigoEmpleado, String nombreCompleto, String cargo, double salarioDiario) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombreCompleto = nombreCompleto;
        this.cargo = cargo;
        this.salarioDiario = salarioDiario;
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

    public boolean isOcupado() {
        return ocupado;
    }

    public List<MovingService> getServiciosRealizados() {
        return serviciosRealizados;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalarioDiario(double salarioDiario) {
        this.salarioDiario = salarioDiario;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public double calcularPagoSemanal(int diasTrabajados) {
        if (diasTrabajados < 0 || diasTrabajados > 7) {
            System.out.println("ERROR: Dias debe estar entre 0 y 7");
            return 0;
        }

        double pagoTotal = salarioDiario * diasTrabajados;

        if (diasTrabajados == 6) {
            pagoTotal += 50000;
            System.out.println("Bonificacion aplicada: $50,000");
        }

        return pagoTotal;
    }

    public void asignarServicio(MovingService servicio) {
        if (!this.ocupado) {
            this.ocupado = true;
            if (!serviciosRealizados.contains(servicio)) {
                serviciosRealizados.add(servicio);
            }
        }
    }

    public void completarServicio() {
        this.ocupado = false;
        System.out.println("Empleado " + nombreCompleto + " ha completado servicio");
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
        return "Empleado " + codigoEmpleado + " | " + nombreCompleto +
                " | " + cargo + " | $" + salarioDiario + "/dia | " + estado +
                " | Servicios: " + serviciosRealizados.size();
    }
}
