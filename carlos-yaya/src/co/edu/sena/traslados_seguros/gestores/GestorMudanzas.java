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
import java.util.HashMap;
import java.util.Map;

public class GestorMudanzas {

    // Semana 1-7: ArrayList con Generics
    private List<Cliente> clientes;
    private List<Vehiculo> vehiculos;
    private List<Empleado> empleados;
    private List<MovingService> servicios;

    // Semana 8: HashMaps para busqueda rapida O(1)
    private HashMap<String, Cliente> clientesPorId;
    private HashMap<String, Empleado> empleadosPorCodigo;
    private HashMap<String, Vehiculo> vehiculosPorPlaca;
    private HashMap<String, MovingService> serviciosPorCodigo;

    public GestorMudanzas() {
        this.clientes = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.servicios = new ArrayList<>();

        // Semana 8: Inicializar HashMaps
        this.clientesPorId = new HashMap<>();
        this.empleadosPorCodigo = new HashMap<>();
        this.vehiculosPorPlaca = new HashMap<>();
        this.serviciosPorCodigo = new HashMap<>();
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

        // Semana 8: Verificar duplicado usando HashMap
        if (clientesPorId.containsKey(cliente.getIdentificacion())) {
            throw new DatosInvalidosException("Cliente con ID " + cliente.getIdentificacion() + " ya existe");
        }

        clientes.add(cliente);
        clientesPorId.put(cliente.getIdentificacion(), cliente); // Semana 8: Agregar a HashMap
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

        // Semana 8: Verificar duplicado usando HashMap
        if (vehiculosPorPlaca.containsKey(vehiculo.getPlaca())) {
            throw new DatosInvalidosException("Vehiculo con placa " + vehiculo.getPlaca() + " ya existe");
        }

        vehiculos.add(vehiculo);
        vehiculosPorPlaca.put(vehiculo.getPlaca(), vehiculo); // Semana 8: Agregar a HashMap
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

        // Semana 8: Verificar duplicado usando HashMap
        if (empleadosPorCodigo.containsKey(empleado.getCodigoEmpleado())) {
            throw new DatosInvalidosException("Empleado con codigo " + empleado.getCodigoEmpleado() + " ya existe");
        }

        empleados.add(empleado);
        empleadosPorCodigo.put(empleado.getCodigoEmpleado(), empleado); // Semana 8: Agregar a HashMap
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

        // Semana 8: Verificar duplicado usando HashMap
        if (serviciosPorCodigo.containsKey(servicio.getServiceCode())) {
            throw new DatosInvalidosException("Servicio con codigo " + servicio.getServiceCode() + " ya existe");
        }

        servicios.add(servicio);
        serviciosPorCodigo.put(servicio.getServiceCode(), servicio); // Semana 8: Agregar a HashMap
        System.out.println("Servicio " + servicio.getServiceCode() + " registrado exitosamente");
    }

    // Semana 8: Busqueda O(1) usando HashMap
    public Cliente buscarClientePorId(String identificacion) {
        return clientesPorId.get(identificacion);
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

    // Semana 8: Busqueda O(1) usando HashMap
    public Vehiculo buscarVehiculoPorPlaca(String placa) {
        return vehiculosPorPlaca.get(placa.toUpperCase());
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

    // Semana 8: Busqueda O(1) usando HashMap
    public Empleado buscarEmpleadoPorCodigo(String codigo) {
        return empleadosPorCodigo.get(codigo.toUpperCase());
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

    // Semana 8: Busqueda O(1) usando HashMap
    public MovingService buscarServicioPorCodigo(String codigo) {
        return serviciosPorCodigo.get(codigo.toUpperCase());
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

    // ============================================
    // SEMANA 8: FILTRADO Y ESTADISTICAS
    // ============================================

    /**
     * Filtra clientes por nivel de calidad.
     *
     * @param nivelMinimo Nivel minimo (EXCELENTE, BUENO, REGULAR, MALO)
     * @return Lista de clientes que cumplen el criterio
     */
    public List<Cliente> filtrarClientesPorCalidad(String nivelMinimo) {
        List<Cliente> resultado = new ArrayList<>();

        for (Cliente cliente : clientes) {
            String nivel = cliente.obtenerNivelCalidad();
            if (cumpleNivelMinimo(nivel, nivelMinimo)) {
                resultado.add(cliente);
            }
        }

        return resultado;
    }

    private boolean cumpleNivelMinimo(String nivelActual, String nivelMinimo) {
        int valorActual = obtenerValorNivel(nivelActual);
        int valorMinimo = obtenerValorNivel(nivelMinimo);
        return valorActual >= valorMinimo;
    }

    private int obtenerValorNivel(String nivel) {
        switch (nivel.toUpperCase()) {
            case "EXCELENTE": return 4;
            case "BUENO": return 3;
            case "REGULAR": return 2;
            case "MALO": return 1;
            default: return 0;
        }
    }

    /**
     * Filtra empleados por rango de salario.
     *
     * @param salarioMinimo Salario minimo
     * @param salarioMaximo Salario maximo
     * @return Lista de empleados en el rango
     */
    public List<Empleado> filtrarEmpleadosPorSalario(double salarioMinimo, double salarioMaximo) {
        List<Empleado> resultado = new ArrayList<>();

        for (Empleado empleado : empleados) {
            double salario = empleado.getSalarioDiario();
            if (salario >= salarioMinimo && salario <= salarioMaximo) {
                resultado.add(empleado);
            }
        }

        return resultado;
    }

    /**
     * Filtra vehiculos por capacidad minima.
     *
     * @param capacidadMinima Capacidad minima en m3
     * @return Lista de vehiculos con capacidad suficiente
     */
    public List<Vehiculo> filtrarVehiculosPorCapacidad(double capacidadMinima) {
        List<Vehiculo> resultado = new ArrayList<>();

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getCapacidadM3() >= capacidadMinima) {
                resultado.add(vehiculo);
            }
        }

        return resultado;
    }

    /**
     * Filtra servicios por fecha.
     *
     * @param fechaInicio Fecha inicial
     * @param fechaFin Fecha final
     * @return Lista de servicios en el rango
     */
    public List<MovingService> filtrarServiciosPorFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        List<MovingService> resultado = new ArrayList<>();

        for (MovingService servicio : servicios) {
            LocalDate fecha = servicio.getFechaServicio();
            if (fecha != null && !fecha.isBefore(fechaInicio) && !fecha.isAfter(fechaFin)) {
                resultado.add(servicio);
            }
        }

        return resultado;
    }

    /**
     * Calcula el salario promedio de todos los empleados.
     *
     * @return Salario promedio
     */
    public double calcularSalarioPromedio() {
        if (empleados.isEmpty()) {
            return 0.0;
        }

        double suma = 0;
        for (Empleado empleado : empleados) {
            suma += empleado.getSalarioDiario();
        }

        return suma / empleados.size();
    }

    /**
     * Calcula el promedio de calificaciones de todos los clientes.
     *
     * @return Promedio general de calificaciones
     */
    public double calcularPromedioCalificacionesGeneral() {
        double sumaPromedios = 0;
        int clientesConCalificaciones = 0;

        for (Cliente cliente : clientes) {
            if (cliente.obtenerTotalCalificaciones() > 0) {
                sumaPromedios += cliente.obtenerPromedioCalificaciones();
                clientesConCalificaciones++;
            }
        }

        return clientesConCalificaciones > 0 ? sumaPromedios / clientesConCalificaciones : 0.0;
    }

    /**
     * Calcula la capacidad total disponible de vehiculos.
     *
     * @return Capacidad total en m3
     */
    public double calcularCapacidadTotalDisponible() {
        double capacidadTotal = 0;

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.isDisponible()) {
                capacidadTotal += vehiculo.getCapacidadM3();
            }
        }

        return capacidadTotal;
    }

    /**
     * Encuentra el empleado con mayor numero de servicios realizados.
     *
     * @return Empleado mas activo o null si no hay empleados
     */
    public Empleado encontrarEmpleadoMasActivo() {
        if (empleados.isEmpty()) {
            return null;
        }

        Empleado masActivo = empleados.get(0);
        int maxServicios = masActivo.contarServiciosRealizados();

        for (Empleado empleado : empleados) {
            int servicios = empleado.contarServiciosRealizados();
            if (servicios > maxServicios) {
                maxServicios = servicios;
                masActivo = empleado;
            }
        }

        return masActivo;
    }

    /**
     * Encuentra el cliente con mas servicios contratados.
     *
     * @return Cliente mas frecuente o null si no hay clientes
     */
    public Cliente encontrarClienteMasFrecuente() {
        if (clientes.isEmpty()) {
            return null;
        }

        Cliente masFrecuente = clientes.get(0);
        int maxServicios = masFrecuente.contarServicios();

        for (Cliente cliente : clientes) {
            int servicios = cliente.contarServicios();
            if (servicios > maxServicios) {
                maxServicios = servicios;
                masFrecuente = cliente;
            }
        }

        return masFrecuente;
    }

    /**
     * Calcula estadisticas detalladas del sistema.
     */
    public void generarEstadisticasDetalladas() {
        System.out.println("\n=== ESTADISTICAS DETALLADAS DEL SISTEMA ===");

        System.out.println("\nEMPLEADOS:");
        System.out.println("  Total: " + empleados.size());
        System.out.println("  Disponibles: " + obtenerEmpleadosDisponibles().size());
        System.out.println("  Salario promedio: $" + String.format("%.2f", calcularSalarioPromedio()));

        Empleado masActivo = encontrarEmpleadoMasActivo();
        if (masActivo != null) {
            System.out.println("  Mas activo: " + masActivo.getNombre() +
                    " (" + masActivo.contarServiciosRealizados() + " servicios)");
        }

        System.out.println("\nCLIENTES:");
        System.out.println("  Total: " + clientes.size());
        System.out.println("  Promedio calificaciones: " +
                String.format("%.2f", calcularPromedioCalificacionesGeneral()));

        Cliente masFrecuente = encontrarClienteMasFrecuente();
        if (masFrecuente != null) {
            System.out.println("  Mas frecuente: " + masFrecuente.getNombre() +
                    " (" + masFrecuente.contarServicios() + " servicios)");
        }

        System.out.println("\nVEHICULOS:");
        System.out.println("  Total: " + vehiculos.size());
        System.out.println("  Disponibles: " + obtenerVehiculosDisponibles().size());
        System.out.println("  Capacidad total disponible: " +
                String.format("%.2f", calcularCapacidadTotalDisponible()) + " m3");

        System.out.println("\nSERVICIOS:");
        System.out.println("  Total registrados: " + servicios.size());
    }

    /**
     * Muestra distribucion de empleados por cargo.
     */
    public void mostrarDistribucionPorCargo() {
        HashMap<String, Integer> distribucion = new HashMap<>();

        for (Empleado empleado : empleados) {
            String cargo = empleado.getCargo();
            distribucion.put(cargo, distribucion.getOrDefault(cargo, 0) + 1);
        }

        System.out.println("\n=== DISTRIBUCION POR CARGO ===");
        for (Map.Entry<String, Integer> entry : distribucion.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " empleado(s)");
        }
    }

    /**
     * Muestra distribucion de vehiculos por tipo.
     */
    public void mostrarDistribucionPorTipoVehiculo() {
        HashMap<String, Integer> distribucion = new HashMap<>();

        for (Vehiculo vehiculo : vehiculos) {
            String tipo = vehiculo.getTipoVehiculo();
            distribucion.put(tipo, distribucion.getOrDefault(tipo, 0) + 1);
        }

        System.out.println("\n=== DISTRIBUCION POR TIPO DE VEHICULO ===");
        for (Map.Entry<String, Integer> entry : distribucion.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " vehiculo(s)");
        }
    }
}