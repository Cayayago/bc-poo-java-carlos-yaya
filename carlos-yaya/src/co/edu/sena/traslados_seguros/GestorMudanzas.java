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

    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }

    public List<Vehiculo> getVehiculos() {
        return new ArrayList<>(vehiculos);
    }

    public List<Empleado> getEmpleados() {
        return new ArrayList<>(empleados);
    }

    public List<MovingService> getServicios() {
        return new ArrayList<>(servicios);
    }

    public void registrarCliente(Cliente cliente) {
        if (cliente == null) {
            System.out.println("ERROR: Cliente no puede ser nulo");
            return;
        }

        if (buscarClientePorId(cliente.getIdentificacion()) != null) {
            System.out.println("ERROR: Cliente con ID " + cliente.getIdentificacion() + " ya existe");
            return;
        }
        clientes.add(cliente);
        System.out.println("Cliente " + cliente.getNombre() + " registrado exitosamente");
    }

    public void registrarVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) {
            System.out.println("ERROR: Vehiculo no puede ser nulo");
            return;
        }

        if (buscarVehiculoPorPlaca(vehiculo.getPlaca()) != null) {
            System.out.println("ERROR: Vehiculo con placa " + vehiculo.getPlaca() + " ya existe");
            return;
        }
        vehiculos.add(vehiculo);
        System.out.println("Vehiculo " + vehiculo.getPlaca() + " registrado exitosamente");
    }

    public void registrarEmpleado(Empleado empleado) {
        if (empleado == null) {
            System.out.println("ERROR: Empleado no puede ser nulo");
            return;
        }

        if (buscarEmpleadoPorCodigo(empleado.getCodigoEmpleado()) != null) {
            System.out.println("ERROR: Empleado con codigo " + empleado.getCodigoEmpleado() + " ya existe");
            return;
        }
        empleados.add(empleado);
        System.out.println("Empleado " + empleado.getNombre() + " registrado exitosamente");
    }

    public void registrarServicio(MovingService servicio) {
        if (servicio == null) {
            System.out.println("ERROR: Servicio no puede ser nulo");
            return;
        }

        if (buscarServicioPorCodigo(servicio.getServiceCode()) != null) {
            System.out.println("ERROR: Servicio con codigo " + servicio.getServiceCode() + " ya existe");
            return;
        }
        servicios.add(servicio);
        System.out.println("Servicio " + servicio.getServiceCode() + " registrado exitosamente");
    }

    public Cliente buscarClientePorId(String identificacion) {
        return buscarEnLista(clientes, c -> c.getIdentificacion().equals(identificacion));
    }

    public Vehiculo buscarVehiculoPorPlaca(String placa) {
        return buscarEnLista(vehiculos, v -> v.getPlaca().equalsIgnoreCase(placa));
    }

    public Empleado buscarEmpleadoPorCodigo(String codigo) {
        return buscarEnLista(empleados, e -> e.getCodigoEmpleado().equalsIgnoreCase(codigo));
    }

    public MovingService buscarServicioPorCodigo(String codigo) {
        return buscarEnLista(servicios, s -> s.getServiceCode().equalsIgnoreCase(codigo));
    }

    private <T> T buscarEnLista(List<T> lista, Predicado<T> condicion) {
        for (T elemento : lista) {
            if (condicion.evaluar(elemento)) {
                return elemento;
            }
        }
        return null;
    }

    @FunctionalInterface
    private interface Predicado<T> {
        boolean evaluar(T elemento);
    }

    public List<Vehiculo> obtenerVehiculosDisponibles() {
        return filtrarLista(vehiculos, Vehiculo::isDisponible);
    }

    public List<Empleado> obtenerEmpleadosDisponibles() {
        return filtrarLista(empleados, e -> !e.isOcupado());
    }

    private <T> List<T> filtrarLista(List<T> lista, Predicado<T> condicion) {
        List<T> resultado = new ArrayList<>();
        for (T elemento : lista) {
            if (condicion.evaluar(elemento)) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }

    public void listarClientes() {
        listarElementos("CLIENTES", clientes);
    }

    public void listarVehiculos() {
        listarElementos("VEHICULOS", vehiculos);
    }

    public void listarEmpleados() {
        listarElementos("EMPLEADOS", empleados);
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

    private <T> void listarElementos(String titulo, List<T> lista) {
        System.out.println("\n=== LISTA DE " + titulo + " ===");
        if (lista.isEmpty()) {
            System.out.println("No hay elementos registrados");
        } else {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println((i + 1) + ". " + lista.get(i));
            }
        }
        System.out.println("Total: " + lista.size());
    }

    public void generarReporteGeneral() {
        System.out.println("\n=== REPORTE GENERAL DEL SISTEMA ===");
        System.out.println("Total Clientes: " + contarClientes());
        System.out.println("Total Vehiculos: " + contarVehiculos() +
                " (Disponibles: " + obtenerVehiculosDisponibles().size() + ")");
        System.out.println("Total Empleados: " + contarEmpleados() +
                " (Disponibles: " + obtenerEmpleadosDisponibles().size() + ")");
        System.out.println("Total Servicios: " + contarServicios());
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