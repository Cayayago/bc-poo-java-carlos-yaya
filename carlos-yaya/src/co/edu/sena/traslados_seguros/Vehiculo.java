package co.edu.sena.traslados_seguros;

import java.util.ArrayList;
import java.util.List;

public class Vehiculo {

    private String placa;
    private String tipoVehiculo;
    private double capacidadM3;
    private boolean disponible;
    private List<MovingService> serviciosRealizados;

    public Vehiculo(String placa, String tipoVehiculo, double capacidadM3) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.capacidadM3 = capacidadM3;
        this.disponible = true;
        this.serviciosRealizados = new ArrayList<>();
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public double getCapacidadM3() {
        return capacidadM3;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public List<MovingService> getServiciosRealizados() {
        return serviciosRealizados;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public void setCapacidadM3(double capacidadM3) {
        this.capacidadM3 = capacidadM3;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double calcularTarifaBase() {
        if (capacidadM3 <= 10) {
            return 150000;
        } else if (capacidadM3 <= 25) {
            return 300000;
        } else {
            return 500000;
        }
    }

    public void asignarServicio(MovingService servicio) {
        if (this.disponible) {
            this.disponible = false;
            if (!serviciosRealizados.contains(servicio)) {
                serviciosRealizados.add(servicio);
            }
            System.out.println("Vehiculo " + placa + " asignado al servicio " + servicio.getServiceCode());
        } else {
            System.out.println("ERROR: Vehiculo " + placa + " no disponible");
        }
    }

    public void liberarVehiculo() {
        this.disponible = true;
        System.out.println("Vehiculo " + placa + " liberado");
    }

    public int contarServiciosRealizados() {
        return serviciosRealizados.size();
    }

    public void mostrarHistorial() {
        System.out.println("\n=== HISTORIAL VEHICULO " + placa + " ===");
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
        String estado = disponible ? "DISPONIBLE" : "EN SERVICIO";
        return "Vehiculo " + placa + " | " + tipoVehiculo +
                " | " + capacidadM3 + "m3 | " + estado +
                " | Tarifa: $" + calcularTarifaBase() +
                " | Servicios: " + serviciosRealizados.size();
    }
}
