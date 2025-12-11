package co.edu.sena.traslados_seguros.gestores;

// Semana 7: Imports de otros paquetes
import co.edu.sena.traslados_seguros.modelos.Cliente;
import co.edu.sena.traslados_seguros.modelos.Empleado;
import co.edu.sena.traslados_seguros.modelos.MovingService;
import co.edu.sena.traslados_seguros.modelos.Persona;
import co.edu.sena.traslados_seguros.modelos.Vehiculo;
import co.edu.sena.traslados_seguros.excepciones.EntidadNoEncontradaException;
import co.edu.sena.traslados_seguros.excepciones.DatosInvalidosException;
import co.edu.sena.traslados_seguros.excepciones.OperacionInvalidaException;

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

    /**
     * Registra un cliente en el sistema.
     *
     * @param cliente Cliente a registrar
     * @throws DatosInvalidosException si el cliente es nulo o ya existe
     */
    public void registrarCliente(Cliente cliente) throws DatosInvalidosException {
        if (cliente == null) {
            throw new DatosInvalidosException("Cliente no puede ser nulo");
        }

        if (buscarClientePorId(cliente.getIdentificacion()) != null) {
            throw new DatosInvalidosException("Cliente con ID " + cliente.getIdentificacion() + " ya existe");
        }
        clientes.add(cliente);
        System.out.println("Cliente " + cliente.getNombre() + " registrado exitosamente");
    }

    /**
     * Registra un vehiculo en el sistema.
     *
     * @param vehiculo Vehiculo a registrar
     * @throws DatosInvalidosException si el vehiculo es nulo o ya existe
     */
    public void registrarVehiculo(Vehiculo vehiculo) throws DatosInvalidosException {
        if (vehiculo == null) {
            throw new DatosInvalidosException("Vehiculo no puede ser nulo");
        }

        if (buscarVehiculoPorPlaca(vehiculo.getPlaca()) != null) {
            throw new DatosInvalidosException("Vehiculo con placa " + vehiculo.getPlaca() + " ya existe");
        }
        vehiculos.add(vehiculo);
        System.out.println("Vehiculo " + vehiculo.getPlaca() + " registrado exitosamente");
    }

    /**
     * Registra un empleado en el sistema.
     *
     * @param empleado Empleado a registrar
     * @throws DatosInvalidosException si el empleado es nulo o ya existe
     */
    public void registrarEmpleado(Empleado empleado) throws DatosInvalidosException {
        if (empleado == null) {
            throw new DatosInvalidosException("Empleado no puede ser nulo");
        }

        if (buscarEmpleadoPorCodigo(empleado.getCodigoEmpleado()) != null) {
            throw new DatosInvalidosException("Empleado con codigo " + empleado.getCodigoEmpleado() + " ya existe");
        }
        empleados.add(empleado);
        System.out.println("Empleado " + empleado.getNombre() + " registrado exitosamente");
    }

    /**
     * Registra un servicio en el sistema.
     *
     * @param servicio Servicio a registrar
     * @throws DatosInvalidosException si el servicio es nulo o ya existe
     */
    public void registrarServicio(MovingService servicio) throws DatosInvalidosException {
        if (servicio == null) {
            throw new DatosInvalidosException("Servicio no puede ser nulo");
        }

        if (buscarServicioPorCodigo(servicio.getServiceCode()) != null) {
            throw new DatosInvalidosException("Servicio con codigo " + servicio.getServiceCode() + " ya existe");
        }
        servicios.add(servicio);
        System.out.println("Servicio " + servicio.getServiceCode() + " registrado exitosamente");
    }

    public Cliente buscarClientePorId(String identificacion) {
        return buscarEnLista(clientes, c -> c.getIdentificacion().equals(identificacion));
    }

    /**
     * Busca un cliente por ID y lanza excepcion si no existe.
     *
     * @param identificacion ID del cliente
     * @return Cliente encontrado
     * @throws EntidadNoEncontradaException si el cliente no existe
     */
    public Cliente buscarClientePorIdOError(String identificacion) throws EntidadNoEncontradaException {
        Cliente cliente = buscarClientePorId(identificacion);
        if (cliente == null) {
            throw new EntidadNoEncontradaException("Cliente con ID " + identificacion + " no encontrado");
        }
        return cliente;
    }

    public Vehiculo buscarVehiculoPorPlaca(String placa) {
        return buscarEnLista(vehiculos, v -> v.getPlaca().equalsIgnoreCase(placa));
    }

    /**
     * Busca un vehiculo por placa y lanza excepcion si no existe.
     *
     * @param placa Placa del vehiculo
     * @return Vehiculo encontrado
     * @throws EntidadNoEncontradaException si el vehiculo no existe
     */
    public Vehiculo buscarVehiculoPorPlacaOError(String placa) throws EntidadNoEncontradaException {
        Vehiculo vehiculo = buscarVehiculoPorPlaca(placa);
        if (vehiculo == null) {
            throw new EntidadNoEncontradaException("Vehiculo con placa " + placa + " no encontrado");
        }
        return vehiculo;
    }

    public Empleado buscarEmpleadoPorCodigo(String codigo) {
        return buscarEnLista(empleados, e -> e.getCodigoEmpleado().equalsIgnoreCase(codigo));
    }

    /**
     * Busca un empleado por codigo y lanza excepcion si no existe.
     *
     * @param codigo Codigo del empleado
     * @return Empleado encontrado
     * @throws EntidadNoEncontradaException si el empleado no existe
     */
    public Empleado buscarEmpleadoPorCodigoOError(String codigo) throws EntidadNoEncontradaException {
        Empleado empleado = buscarEmpleadoPorCodigo(codigo);
        if (empleado == null) {
            throw new EntidadNoEncontradaException("Empleado con codigo " + codigo + " no encontrado");
        }
        return empleado;
    }

    public MovingService buscarServicioPorCodigo(String codigo) {
        return buscarEnLista(servicios, s -> s.getServiceCode().equalsIgnoreCase(codigo));
    }

    /**
     * Busca un servicio por codigo y lanza excepcion si no existe.
     *
     * @param codigo Codigo del servicio
     * @return Servicio encontrado
     * @throws EntidadNoEncontradaException si el servicio no existe
     */
    public MovingService buscarServicioPorCodigoOError(String codigo) throws EntidadNoEncontradaException {
        MovingService servicio = buscarServicioPorCodigo(codigo);
        if (servicio == null) {
            throw new EntidadNoEncontradaException("Servicio con codigo " + codigo + " no encontrado");
        }
        return servicio;
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

    // ============================================
    // SEMANA 5: SOBRECARGA Y POLIMORFISMO
    // ============================================

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
    public void registrar(Persona persona) throws DatosInvalidosException {
        if (persona instanceof Cliente) {
            registrarCliente((Cliente) persona);
        } else if (persona instanceof Empleado) {
            registrarEmpleado((Empleado) persona);
        }
    }

    // Semana 5: Sobrecarga 5 - registrar multiple personas
    public void registrar(List<Persona> personas) throws DatosInvalidosException {
        for (Persona persona : personas) {
            registrar(persona);
        }
    }

    // Semana 5: Sobrecarga 6 - calcular tarifa por capacidad
    public double calcularTarifa(double capacidadM3) throws OperacionInvalidaException {
        if (capacidadM3 <= 0) {
            throw new OperacionInvalidaException("Capacidad debe ser mayor a 0");
        }
        if (capacidadM3 <= 10) {
            return 150000;
        } else if (capacidadM3 <= 25) {
            return 300000;
        } else {
            return 500000;
        }
    }

    // Semana 5: Sobrecarga 7 - calcular tarifa por vehiculo
    public double calcularTarifa(Vehiculo vehiculo) throws OperacionInvalidaException {
        if (vehiculo == null) {
            throw new OperacionInvalidaException("Vehiculo no puede ser nulo");
        }
        return vehiculo.calcularTarifaBase();
    }

    // Semana 5: Sobrecarga 8 - calcular tarifa por vehiculo y distancia
    public double calcularTarifa(Vehiculo vehiculo, double distanciaKm) throws OperacionInvalidaException {
        if (vehiculo == null) {
            throw new OperacionInvalidaException("Vehiculo no puede ser nulo");
        }
        if (distanciaKm < 0) {
            throw new OperacionInvalidaException("Distancia no puede ser negativa");
        }
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