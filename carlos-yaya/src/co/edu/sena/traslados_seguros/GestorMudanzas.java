package co.edu.sena.traslados_seguros;

import java.util.ArrayList;
import java.util.List;

public class GestorMudanzas {

    private List<Cliente> clientes;
    private List<Vehiculo> vehiculos;
    private List<Empleado> empleados;
    private List<MovingService> servicios;

    public GestorMudanzas() {
        this.clientes = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.servicios = new ArrayList<>();
    }

    public void registrarCliente(Cliente cliente) {
        if (buscarClientePorId(cliente.getIdentificacion()) != null) {
            System.out.println("ERROR: Cliente con ID " + cliente.getIdentificacion() + " ya existe");
            return;
        }
        clientes.add(cliente);
        System.out.println("Cliente " + cliente.getNombre() + " registrado exitosamente");
    }

    public void registrarVehiculo(Vehiculo vehiculo) {
        if (buscarVehiculoPorPlaca(vehiculo.getPlaca()) != null) {
            System.out.println("ERROR: Vehiculo con placa " + vehiculo.getPlaca() + " ya existe");
            return;
        }
        vehiculos.add(vehiculo);
        System.out.println("Vehiculo " + vehiculo.getPlaca() + " registrado exitosamente");
    }

    public void registrarEmpleado(Empleado empleado) {
        if (buscarEmpleadoPorCodigo(empleado.getCodigoEmpleado()) != null) {
            System.out.println("ERROR: Empleado con codigo " + empleado.getCodigoEmpleado() + " ya existe");
            return;
        }
        empleados.add(empleado);
        System.out.println("Empleado " + empleado.getNombreCompleto() + " registrado exitosamente");
    }

    public void registrarServicio(MovingService servicio) {
        if (buscarServicioPorCodigo(servicio.getServiceCode()) != null) {
            System.out.println("ERROR: Servicio con codigo " + servicio.getServiceCode() + " ya existe");
            return;
        }
        servicios.add(servicio);
        System.out.println("Servicio " + servicio.getServiceCode() + " registrado exitosamente");
    }

    public Cliente buscarClientePorId(String identificacion) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdentificacion().equals(identificacion)) {
                return cliente;
            }
        }
        return null;
    }

    public Vehiculo buscarVehiculoPorPlaca(String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                return vehiculo;
            }
        }
        return null;
    }

    public Empleado buscarEmpleadoPorCodigo(String codigo) {
        for (Empleado empleado : empleados) {
            if (empleado.getCodigoEmpleado().equals(codigo)) {
                return empleado;
            }
        }
        return null;
    }

    public MovingService buscarServicioPorCodigo(String codigo) {
        for (MovingService servicio : servicios) {
            if (servicio.getServiceCode().equals(codigo)) {
                return servicio;
            }
        }
        return null;
    }

    public List<Vehiculo> obtenerVehiculosDisponibles() {
        List<Vehiculo> disponibles = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.isDisponible()) {
                disponibles.add(vehiculo);
            }
        }
        return disponibles;
    }

    public List<Empleado> obtenerEmpleadosDisponibles() {
        List<Empleado> disponibles = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (!empleado.isOcupado()) {
                disponibles.add(empleado);
            }
        }
        return disponibles;
    }

    public void listarClientes() {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
        } else {
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println((i + 1) + ". " + clientes.get(i));
            }
        }
        System.out.println("Total: " + clientes.size());
    }

    public void listarVehiculos() {
        System.out.println("\n=== LISTA DE VEHICULOS ===");
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados");
        } else {
            for (int i = 0; i < vehiculos.size(); i++) {
                System.out.println((i + 1) + ". " + vehiculos.get(i));
            }
        }
        System.out.println("Total: " + vehiculos.size());
    }

    public void listarEmpleados() {
        System.out.println("\n=== LISTA DE EMPLEADOS ===");
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados");
        } else {
            for (int i = 0; i < empleados.size(); i++) {
                System.out.println((i + 1) + ". " + empleados.get(i));
            }
        }
        System.out.println("Total: " + empleados.size());
    }

    public void listarServicios() {
        System.out.println("\n=== LISTA DE SERVICIOS ===");
        if (servicios.isEmpty()) {
            System.out.println("No hay servicios registrados");
        } else {
            for (int i = 0; i < servicios.size(); i++) {
                System.out.println("\n" + (i + 1) + ". " + servicios.get(i));
            }
        }
        System.out.println("\nTotal: " + servicios.size());
    }

    public void generarReporteGeneral() {
        System.out.println("\n=== REPORTE GENERAL DEL SISTEMA ===");
        System.out.println("Total Clientes: " + clientes.size());
        System.out.println("Total Vehiculos: " + vehiculos.size() + " (Disponibles: " + obtenerVehiculosDisponibles().size() + ")");
        System.out.println("Total Empleados: " + empleados.size() + " (Disponibles: " + obtenerEmpleadosDisponibles().size() + ")");
        System.out.println("Total Servicios: " + servicios.size());
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVehiculos() {
        return vehiculos.size();
    }

    public int contarEmpleados() {
        return empleados.size();
    }

    public int contarServicios() {
        return servicios.size();
    }
}