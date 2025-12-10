package co.edu.sena.traslados_seguros;

import java.time.LocalDate;
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
    // Semana 5: Sobrecarga 1 - buscar servicio por codigo
    public MovingService buscarServicio(String codigo) {
        return buscarServicioPorCodigo(codigo);
    }

    // Semana 5: Sobrecarga 2 - buscar servicios por cliente
    public List<MovingService> buscarServicio(Cliente cliente) {
        List<MovingService> resultado = new ArrayList<>();
        for (MovingService servicio : servicios) {
            if (servicio.getCliente() != null &&
                    servicio.getCliente().getIdentificacion().equals(cliente.getIdentificacion())) {
                resultado.add(servicio);
            }
        }
        return resultado;
    }

    // Semana 5: Sobrecarga 3 - buscar servicios por rango de fechas
    public List<MovingService> buscarServicio(LocalDate fechaInicio, LocalDate fechaFin) {
        List<MovingService> resultado = new ArrayList<>();
        for (MovingService servicio : servicios) {
            LocalDate fechaServicio = servicio.getFechaServicio();
            if (fechaServicio != null &&
                    !fechaServicio.isBefore(fechaInicio) &&
                    !fechaServicio.isAfter(fechaFin)) {
                resultado.add(servicio);
            }
        }
        return resultado;
    }

    // Semana 5: Sobrecarga 4 - registrar persona (Cliente o Empleado)
    public void registrar(Persona persona) {
        if (persona instanceof Cliente) {
            registrarCliente((Cliente) persona);
        } else if (persona instanceof Empleado) {
            registrarEmpleado((Empleado) persona);
        }
    }

    // Semana 5: Sobrecarga 5 - registrar multiple personas
    public void registrar(List<Persona> personas) {
        for (Persona persona : personas) {
            registrar(persona);
        }
    }

    // Semana 5: Sobrecarga 6 - calcular tarifa por capacidad
    public double calcularTarifa(double capacidadM3) {
        if (capacidadM3 <= 10) {
            return 150000;
        } else if (capacidadM3 <= 25) {
            return 300000;
        } else {
            return 500000;
        }
    }

    // Semana 5: Sobrecarga 7 - calcular tarifa por vehiculo
    public double calcularTarifa(Vehiculo vehiculo) {
        return vehiculo.calcularTarifaBase();
    }

    // Semana 5: Sobrecarga 8 - calcular tarifa por vehiculo y distancia
    public double calcularTarifa(Vehiculo vehiculo, double distanciaKm) {
        double tarifaBase = vehiculo.calcularTarifaBase();
        double costoDistancia = distanciaKm * 2000;
        return tarifaBase + costoDistancia;
    }

    // Semana 5: Metodo polimorfico - acepta Persona (padre)
    public void mostrarDetallesPersona(Persona persona) {
        System.out.println("\n=== DETALLES DE " + persona.obtenerTipoPersona().toUpperCase() + " ===");
        persona.mostrarInformacionBasica();
        System.out.println("Tipo: " + persona.obtenerTipoPersona());
    }

    // Semana 5: Metodo polimorfico - procesar multiples personas
    public void procesarPersonas(List<Persona> personas) {
        System.out.println("\n=== PROCESANDO PERSONAS ===");
        for (Persona p : personas) {
            System.out.println(p.obtenerTipoPersona() + ": " + p.getNombre());
        }
    }

    // Semana 5: Metodo polimorfico - contar por tipo
    public void contarPorTipo(List<Persona> personas) {
        int clientes = 0;
        int empleados = 0;

        for (Persona p : personas) {
            if (p instanceof Cliente) {
                clientes++;
            } else if (p instanceof Empleado) {
                empleados++;
            }
        }

        System.out.println("\n=== CONTEO POR TIPO ===");
        System.out.println("Total Clientes: " + clientes);
        System.out.println("Total Empleados: " + empleados);
        System.out.println("Total Personas: " + personas.size());
    }

    // Semana 5: Metodo polimorfico - validar persona
    public boolean validarPersona(Persona persona) {
        if (persona == null) {
            return false;
        }

        boolean esValido = persona.getNombre() != null &&
                persona.getTelefono() != null &&
                persona.getIdentificacion() != null;

        System.out.println("Validando " + persona.obtenerTipoPersona() + ": " +
                (esValido ? "VALIDO" : "INVALIDO"));

        return esValido;
    }
}