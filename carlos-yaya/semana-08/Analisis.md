# Analisis de Colecciones - Semana 08


## RESUMEN

Semana 8 implemento HashMap para optimizar busquedas (O(1) vs O(n)) y agrego
metodos de filtrado y estadisticas para analisis del sistema.

## ARRAYLIST CON GENERICS


YA IMPLEMENTADO desde Semana 1:
```java
private List<Cliente> clientes = new ArrayList<>();
private List<Vehiculo> vehiculos = new ArrayList<>();
private List<Empleado> empleados = new ArrayList<>();
private List<MovingService> servicios = new ArrayList<>();
```

BENEFICIO: Type safety, sin casting, errores en tiempo de compilacion.

## HASHMAP PARA BUSQUEDAS O(1)


PROBLEMA: Busquedas en ArrayList son O(n) - recorren toda la lista.

SOLUCION: HashMap con claves unicas para busqueda directa O(1):
```java
private HashMap<String, Cliente> clientesPorId;           // ID
private HashMap<String, Empleado> empleadosPorCodigo;     // EMP-001
private HashMap<String, Vehiculo> vehiculosPorPlaca;      // ABC-123
private HashMap<String, MovingService> serviciosPorCodigo; // MOV-001
```

CLAVES UNICAS ELEGIDAS:

| Entidad | Clave | Justificacion |
|---------|-------|---------------|
| Cliente | identificacion | Cedula unica por ley |
| Empleado | codigoEmpleado | Sistema genera codigos unicos |
| Vehiculo | placa | Placa unica por normativa de transito |
| Servicio | serviceCode | Codigos secuenciales sin repeticion |

IMPLEMENTACION:
```java
public void registrarCliente(Cliente cliente) throws DatosInvalidosException {
    // Verificacion O(1)
    if (clientesPorId.containsKey(cliente.getIdentificacion())) {
        throw new DatosInvalidosException("Cliente ya existe");
    }
    
    clientes.add(cliente);                                    // ArrayList
    clientesPorId.put(cliente.getIdentificacion(), cliente); // HashMap
}

// Busqueda O(1)
public Cliente buscarClientePorId(String id) {
    return clientesPorId.get(id);
}
```

MEJORA: 100 elementos = 1 operacion vs 100 comparaciones (100x mas rapido).

SEGUNDO HASHMAP: Distribucion temporal para analisis:
```java
public void mostrarDistribucionPorCargo() {
    HashMap<String, Integer> distribucion = new HashMap<>();
    
    for (Empleado e : empleados) {
        String cargo = e.getCargo();
        distribucion.put(cargo, distribucion.getOrDefault(cargo, 0) + 1);
    }
    // Salida: Conductor: 2, Cargador: 2, etc.
}
```

## FILTRADO Y ESTADISTICAS


FILTRADO (4 METODOS):

1. filtrarClientesPorCalidad(nivel) - Clientes por satisfaccion
2. filtrarEmpleadosPorSalario(min, max) - Empleados por rango salarial
3. filtrarVehiculosPorCapacidad(minM3) - Vehiculos por capacidad
4. filtrarServiciosPorFecha(inicio, fin) - Servicios por periodo

ESTADISTICAS (6 METODOS):

1. calcularSalarioPromedio() - Costo laboral promedio
2. calcularPromedioCalificacionesGeneral() - KPI de satisfaccion
3. calcularCapacidadTotalDisponible() - Capacidad disponible en m3
4. encontrarEmpleadoMasActivo() - Empleado con mas servicios
5. encontrarClienteMasFrecuente() - Cliente con mas servicios
6. generarEstadisticasDetalladas() - Reporte completo consolidado

EJEMPLO DE USO:
```java
// Filtrado
List<Cliente> excelentes = gestor.filtrarClientesPorCalidad("EXCELENTE");
List<Empleado> rango = gestor.filtrarEmpleadosPorSalario(60000, 70000);

// Estadisticas
double promedio = gestor.calcularSalarioPromedio();
Empleado top = gestor.encontrarEmpleadoMasActivo();
```

## BENEFICIOS LOGRADOS


RENDIMIENTO:
- Busquedas 100x mas rapidas (O(1) vs O(n))
- Verificacion de duplicados instantanea

FUNCIONALIDAD:
- Filtros por calidad, salario, capacidad, fecha
- Estadisticas para toma de decisiones
- KPIs de negocio (satisfaccion, costos, eficiencia)

MANTENIBILIDAD:
- Codigo organizado por responsabilidad
- Metodos reutilizables
- Facil agregar nuevos filtros/estadisticas

NEGOCIO:
- Identificar clientes VIP (mas frecuentes)
- Reconocer empleados destacados
- Optimizar recursos (vehiculos disponibles)
- Medir satisfaccion general


## ESTRUCTURA FINAL

GestorMudanzas contiene:
- 4 ArrayList<E> (almacenamiento)
- 4 HashMap<K,V> (busqueda rapida)
- 4 metodos de filtrado
- 6 metodos de estadisticas
- 2 metodos de distribucion

COMPLEJIDAD ALGORITMICA:
- Registro: O(1) - HashMap.containsKey + ArrayList.add
- Busqueda: O(1) - HashMap.get
- Filtrado: O(n) - Recorre ArrayList una vez
- Estadisticas: O(n) - Recorre ArrayList una vez

## CONCLUSION

La implementacion de HashMap mejoro drasticamente el rendimiento de busquedas
y validaciones. Los metodos de filtrado y estadisticas proporcionan valor de
negocio real para toma de decisiones basada en datos.

El sistema ahora es mas rapido, mas funcional y mas util para operaciones
diarias de la empresa de mudanzas.