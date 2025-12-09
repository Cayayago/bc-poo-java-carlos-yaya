package co.edu.sena.traslados_seguros;


import java.util.ArrayList;
import java.util.List;

public class Vehiculo {

    private String placa;
    private String tipoVehiculo;
    private double capacidadM3;
    private int anioFabricacion;
    private boolean disponible;
    private List<MovingService> serviciosRealizados;

    public Vehiculo(String placa, String tipoVehiculo, double capacidadM3) {
        this(placa, tipoVehiculo, capacidadM3, 0);
    }

    public Vehiculo(String placa, String tipoVehiculo, double capacidadM3, int anioFabricacion) {
        setPlaca(placa);
        setTipoVehiculo(tipoVehiculo);
        setCapacidadM3(capacidadM3);
        setAnioFabricacion(anioFabricacion);
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

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public List<MovingService> getServiciosRealizados() {
        return new ArrayList<>(serviciosRealizados);
    }

    public void setPlaca(String placa) {
        if (validarStringNoVacio(placa) && validarPlaca(placa)) {
            this.placa = placa.toUpperCase().trim();
        } else {
            throw new IllegalArgumentException("Placa invalida: formato debe ser ABC-123 o ABC123");
        }
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        if (validarStringNoVacio(tipoVehiculo) && validarTipoVehiculo(tipoVehiculo)) {
            this.tipoVehiculo = tipoVehiculo.trim();
        } else {
            throw new IllegalArgumentException("Tipo de vehiculo invalido: debe tener entre 3 y 50 caracteres");
        }
    }

    public void setCapacidadM3(double capacidadM3) {
        if (validarCapacidad(capacidadM3)) {
            this.capacidadM3 = capacidadM3;
        } else {
            throw new IllegalArgumentException("Capacidad invalida: debe estar entre 1 y 100 m3");
        }
    }

    public void setAnioFabricacion(int anioFabricacion) {
        if (anioFabricacion == 0) {
            this.anioFabricacion = 0;
        } else if (validarAnio(anioFabricacion)) {
            this.anioFabricacion = anioFabricacion;
        } else {
            throw new IllegalArgumentException("Anio invalido: debe estar entre 1990 y 2025");
        }
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    private boolean validarStringNoVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    private boolean validarPlaca(String placa) {
        String placaLimpia = placa.trim().toUpperCase();
        return placaLimpia.matches("[A-Z]{3}-?\\d{3}");
    }

    private boolean validarTipoVehiculo(String tipo) {
        int longitud = tipo.trim().length();
        return longitud >= 3 && longitud <= 50;
    }

    private boolean validarCapacidad(double capacidad) {
        return capacidad >= 1 && capacidad <= 100;
    }

    private boolean validarAnio(int anio) {
        return anio >= 1990 && anio <= 2025;
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
        if (this.disponible && servicio != null) {
            this.disponible = false;
            agregarServicioAlHistorial(servicio);
        } else if (!this.disponible) {
            System.out.println("ERROR: Vehiculo " + placa + " no disponible");
        }
    }

    public void liberarVehiculo() {
        this.disponible = true;
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
        String anioInfo = anioFabricacion > 0 ? " | Año: " + anioFabricacion : "";
        return "Vehiculo " + placa + " | " + tipoVehiculo +
                " | " + capacidadM3 + "m3" + anioInfo + " | " + estado +
                " | Tarifa: $" + calcularTarifaBase() +
                " | Servicios: " + serviciosRealizados.size();
    }
}
