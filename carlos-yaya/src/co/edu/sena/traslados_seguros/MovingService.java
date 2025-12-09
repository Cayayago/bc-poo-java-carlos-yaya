package co.edu.sena.traslados_seguros;

import java.util.ArrayList;
import java.util.List;

public class MovingService {

    private String serviceCode;
    private String origin;
    private String destination;
    private Vehiculo vehiculoAsignado;
    private List<Empleado> equipoTrabajo;
    private Cliente cliente;

    public MovingService(String serviceCode, String origin, String destination) {
        this.serviceCode = serviceCode;
        this.origin = origin;
        this.destination = destination;
        this.vehiculoAsignado = null;
        this.equipoTrabajo = new ArrayList<>();
        this.cliente = null;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Vehiculo getVehiculoAsignado() {
        return vehiculoAsignado;
    }

    public List<Empleado> getEquipoTrabajo() {
        return equipoTrabajo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setVehiculoAsignado(Vehiculo vehiculoAsignado) {
        this.vehiculoAsignado = vehiculoAsignado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void asignarVehiculo(Vehiculo vehiculo) {
        this.vehiculoAsignado = vehiculo;
        vehiculo.asignarServicio(this);
    }

    public void asignarEmpleado(Empleado empleado) {
        if (!equipoTrabajo.contains(empleado)) {
            equipoTrabajo.add(empleado);
            empleado.asignarServicio(this);
            System.out.println("Empleado " + empleado.getNombreCompleto() + " agregado al equipo");
        }
    }

    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
        cliente.agregarServicio(this);
        System.out.println("Cliente asignado al servicio " + serviceCode);
    }

    public int obtenerTamanoEquipo() {
        return equipoTrabajo.size();
    }

    @Override
    public String toString() {
        String info = "========================================\n" +
                "Codigo: " + serviceCode + "\n" +
                "Origen: " + origin + "\n" +
                "Destino: " + destination + "\n";

        if (cliente != null) {
            info += "Cliente: " + cliente.getNombre() + "\n";
        }

        if (vehiculoAsignado != null) {
            info += "Vehiculo: " + vehiculoAsignado.getPlaca() + "\n";
        }

        if (!equipoTrabajo.isEmpty()) {
            info += "Equipo de trabajo (" + equipoTrabajo.size() + "):\n";
            for (Empleado emp : equipoTrabajo) {
                info += "  - " + emp.getNombreCompleto() + " (" + emp.getCargo() + ")\n";
            }
        }

        info += "========================================";
        return info;
    }
}
