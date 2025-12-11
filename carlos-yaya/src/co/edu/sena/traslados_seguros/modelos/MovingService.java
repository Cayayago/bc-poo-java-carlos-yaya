package co.edu.sena.traslados_seguros.modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovingService {

    private String serviceCode;
    private String origin;
    private String destination;
    private LocalDate fechaServicio;
    private Vehiculo vehiculoAsignado;
    private List<Empleado> equipoTrabajo;
    private Cliente cliente;

    public MovingService(String serviceCode, String origin, String destination) {
        this(serviceCode, origin, destination, LocalDate.now());
    }

    public MovingService(String serviceCode, String origin, String destination, LocalDate fechaServicio) {
        setServiceCode(serviceCode);
        setOrigin(origin);
        setDestination(destination);
        setFechaServicio(fechaServicio);
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

    public LocalDate getFechaServicio() {
        return fechaServicio;
    }

    public Vehiculo getVehiculoAsignado() {
        return vehiculoAsignado;
    }

    public List<Empleado> getEquipoTrabajo() {
        return new ArrayList<>(equipoTrabajo);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setServiceCode(String serviceCode) {
        if (validarStringNoVacio(serviceCode) && validarCodigo(serviceCode)) {
            this.serviceCode = serviceCode.toUpperCase().trim();
        } else {
            throw new IllegalArgumentException("Codigo invalido: formato debe ser MOV-###");
        }
    }

    public void setOrigin(String origin) {
        if (validarStringNoVacio(origin) && validarDireccion(origin)) {
            this.origin = origin.trim();
        } else {
            throw new IllegalArgumentException("Origen invalido: debe tener entre 5 y 200 caracteres");
        }
    }

    public void setDestination(String destination) {
        if (validarStringNoVacio(destination) && validarDireccion(destination)) {
            this.destination = destination.trim();
        } else {
            throw new IllegalArgumentException("Destino invalido: debe tener entre 5 y 200 caracteres");
        }
    }

    public void setFechaServicio(LocalDate fechaServicio) {
        if (validarFecha(fechaServicio)) {
            this.fechaServicio = fechaServicio;
        } else {
            throw new IllegalArgumentException("Fecha invalida: no puede ser anterior a hoy");
        }
    }

    public void setVehiculoAsignado(Vehiculo vehiculoAsignado) {
        this.vehiculoAsignado = vehiculoAsignado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    private boolean validarStringNoVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    private boolean validarCodigo(String codigo) {
        return codigo.matches("(?i)MOV-\\d{3}");
    }

    private boolean validarDireccion(String direccion) {
        int longitud = direccion.trim().length();
        return longitud >= 5 && longitud <= 200;
    }

    private boolean validarFecha(LocalDate fecha) {
        return fecha != null && !fecha.isBefore(LocalDate.now());
    }

    /**
     * Asigna un vehiculo al servicio.
     *
     * @param vehiculo Vehiculo a asignar
     * @throws IllegalArgumentException si el vehiculo es nulo
     */
    public void asignarVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) {
            throw new IllegalArgumentException("Vehiculo no puede ser nulo");
        }
        this.vehiculoAsignado = vehiculo;
        vehiculo.asignarServicio(this);
    }

    /**
     * Asigna un empleado al equipo de trabajo.
     *
     * @param empleado Empleado a asignar
     * @throws IllegalArgumentException si el empleado es nulo
     */
    public void asignarEmpleado(Empleado empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("Empleado no puede ser nulo");
        }
        if (!equipoTrabajo.contains(empleado)) {
            equipoTrabajo.add(empleado);
            empleado.asignarServicio(this);
        }
    }

    /**
     * Asigna un cliente al servicio.
     *
     * @param cliente Cliente a asignar
     * @throws IllegalArgumentException si el cliente es nulo
     */
    public void asignarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente no puede ser nulo");
        }
        this.cliente = cliente;
        cliente.agregarServicio(this);
    }

    public int obtenerTamanoEquipo() {
        return equipoTrabajo.size();
    }

    @Override
    public String toString() {
        return construirInfoServicio();
    }

    private String construirInfoServicio() {
        StringBuilder info = new StringBuilder();

        info.append("========================================\n");
        info.append("Codigo: ").append(serviceCode).append("\n");
        info.append("Fecha: ").append(fechaServicio).append("\n");
        info.append("Origen: ").append(origin).append("\n");
        info.append("Destino: ").append(destination).append("\n");
        info.append("========================================\n");

        agregarInfoCliente(info);
        agregarInfoVehiculo(info);
        agregarInfoEquipo(info);

        info.append("========================================");

        return info.toString();
    }

    private void agregarInfoCliente(StringBuilder info) {
        if (cliente != null) {
            info.append("\nCLIENTE:\n");
            info.append("  Nombre: ").append(cliente.getNombre()).append("\n");
            info.append("  Telefono: ").append(cliente.getTelefono()).append("\n");
            info.append("  ID: ").append(cliente.getIdentificacion()).append("\n");
        }
    }

    private void agregarInfoVehiculo(StringBuilder info) {
        if (vehiculoAsignado != null) {
            info.append("\nVEHICULO:\n");
            info.append("  Placa: ").append(vehiculoAsignado.getPlaca()).append("\n");
            info.append("  Tipo: ").append(vehiculoAsignado.getTipoVehiculo()).append("\n");
            info.append("  Capacidad: ").append(vehiculoAsignado.getCapacidadM3()).append(" m3\n");
            info.append("  Tarifa base: $").append(vehiculoAsignado.calcularTarifaBase()).append("\n");
        }
    }

    private void agregarInfoEquipo(StringBuilder info) {
        if (!equipoTrabajo.isEmpty()) {
            info.append("\nEQUIPO DE TRABAJO (").append(equipoTrabajo.size()).append("):\n");
            for (Empleado emp : equipoTrabajo) {
                info.append("  - ").append(emp.getNombre())
                        .append(" (").append(emp.getCargo()).append(")")
                        .append(" - $").append(emp.getSalarioDiario()).append("/dia\n");
            }
        }
    }
}