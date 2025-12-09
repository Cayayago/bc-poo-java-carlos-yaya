**Empresa:** Traslados Seguros  
**Estudiante:** Carlos Javier Yaya Gomez  
**Ficha:** 3228973A
# Actividad 1 - Identificación de Objetos del Dominio

## Objeto 1: Servicio de Mudanza

### ¿Qué es?
Una solicitud formal de traslado de bienes y enseres desde un punto de origen hasta un destino específico, que incluye todo el proceso logístico desde la cotización hasta la entrega final.

### Características (Atributos)
- `codigoServicio`: Identificador único del servicio (ej: "MOV-001")
- `clienteNombre`: Nombre completo del cliente solicitante
- `direccionOrigen`: Dirección completa del punto de partida
- `direccionDestino`: Dirección completa del punto de llegada
- `fechaProgramada`: Fecha en que se realizará la mudanza
- `tipoMudanza`: Clasificación (residencial, corporativa, internacional)
- `precioTotal`: Costo total del servicio en COP
- `estadoServicio`: Estado actual (cotizado, programado, en proceso, completado)

### Comportamientos (Métodos)
- `cotizarServicio()`: Calcula el precio basado en distancia, volumen y servicios adicionales
- `programarFecha()`: Asigna una fecha disponible en el calendario
- `asignarEquipo()`: Designa vehículo y operarios necesarios
- `iniciarServicio()`: Marca el inicio de la mudanza
- `completarServicio()`: Finaliza el servicio y actualiza el estado
- `generarFactura()`: Emite la factura del servicio prestado
- `mostrarDetalles()`: Muestra toda la información del servicio

## Objeto 2: Vehículo

### ¿Qué es?
Unidad de transporte utilizada para el traslado de los bienes del cliente, caracterizada por su capacidad de carga y estado de disponibilidad.

### Características (Atributos)
- `placa`: Placa única del vehículo (ej: "ABC-123")
- `tipoVehiculo`: Categoría (camioneta, camión pequeño, camión grande)
- `capacidadM3`: Capacidad en metros cúbicos
- `estadoVehiculo`: Condición actual (disponible, en servicio, mantenimiento)
- `conductor`: Nombre del conductor asignado
- `kilometraje`: Kilometraje actual del vehículo
- `anioModelo`: Año de fabricación

### Comportamientos (Métodos)
- `verificarDisponibilidad()`: Consulta si el vehículo está disponible
- `asignarServicio()`: Vincula el vehículo a una mudanza específica
- `registrarMantenimiento()`: Programa mantenimiento preventivo/correctivo
- `calcularCapacidadDisponible()`: Calcula el espacio restante
- `actualizarKilometraje()`: Registra nuevos kilómetros recorridos
- `mostrarInformacion()`: Despliega los datos del vehículo


## Objeto 3: Cliente

### ¿Qué es?
Persona natural o jurídica que solicita los servicios de mudanza de la empresa Traslados Seguros.

### Características (Atributos)
- `identificacion`: Número de cédula o NIT
- `nombreCompleto`: Nombre del cliente o razón social
- `telefono`: Número de contacto principal
- `correoElectronico`: Email para notificaciones
- `direccion`: Dirección de contacto principal
- `tipoCliente`: Clasificación (residencial, corporativo)
- `serviciosContratados`: Cantidad de mudanzas realizadas
- `esClienteFrecuente`: Indicador de fidelidad

### Comportamientos (Métodos)
- `solicitarCotizacion()`: Inicia una solicitud de presupuesto
- `contratarServicio()`: Formaliza la contratación de la mudanza
- `consultarHistorial()`: Revisa servicios anteriores
- `actualizarDatos()`: Modifica información de contacto
- `calificarServicio()`: Proporciona retroalimentación
- `aplicarDescuento()`: Calcula descuento por fidelidad
- `mostrarPerfil()`: Muestra toda la información del cliente


## Objeto 4: Operario

### ¿Qué es?
Empleado especializado de Traslados Seguros encargado del empaque, carga, transporte, descarga y ubicación de los enseres durante el proceso de mudanza.

### Características (Atributos)
- `codigoEmpleado`: Identificador único del operario (ej: "OP-015")
- `nombreCompleto`: Nombre del empleado
- `cedula`: Número de identificación
- `especialidad`: Función principal (embalador, cargador, conductor)
- `experienciaAnios`: Años de experiencia en mudanzas
- `disponibilidad`: Estado actual (disponible, ocupado, descanso)
- `certificaciones`: Capacitaciones completadas
- `calificacionPromedio`: Valoración de desempeño

### Comportamientos (Métodos)
- `asignarServicio()`: Se vincula a una mudanza específica
- `registrarAsistencia()`: Marca entrada y salida
- `embalarArticulos()`: Empaca los bienes del cliente
- `cargarVehiculo()`: Sube los artículos al transporte
- `descargarVehiculo()`: Baja los artículos en destino
- `reportarIncidente()`: Notifica cualquier novedad
- `mostrarPerfil()`: Despliega información del operario


## Objeto 5: Paquete

### ¿Qué es?
Unidad de empaque que contiene uno o varios artículos del cliente, identificado y catalogado para su trazabilidad durante el proceso de mudanza.

### Características (Atributos)
- `numeroPaquete`: Identificador secuencial (ej: "PKG-001")
- `descripcionContenido`: Detalle de lo que contiene
- `pesoKg`: Peso aproximado en kilogramos
- `volumenM3`: Volumen ocupado en metros cúbicos
- `esFragil`: Indicador de mercancía delicada
- `ubicacionOrigen`: Habitación o área de origen
- `ubicacionDestino`: Habitación o área de destino
- `estadoEmpaque`: Condición (sin empacar, empacado, en tránsito, entregado)

### Comportamientos (Métodos)
- `embalar()`: Empaca el contenido de forma segura
- `etiquetarPaquete()`: Asigna identificación visible
- `registrarContenido()`: Lista los artículos incluidos
- `verificarIntegridad()`: Inspecciona estado del empaque
- `asignarUbicacion()`: Define dónde debe colocarse
- `marcarComoEntregado()`: Confirma recepción en destino
- `mostrarDetalles()`: Muestra información completa del paquete

# Actividad 2 - Comparación de Paradigmas
### Programación Estructurada
- **Organización:** El programa se divide en funciones / procedimientos
- **Datos:** Variables sueltas (globales o locales)
- **Enfoque:** Se centra en las acciones (¿qué hace el programa?)
- **Separación:** Los datos y las funciones están separados

### Programación Orientada a Objetos (POO)
- **Organización:** El programa se divide en clases y objetos
- **Datos:** Atributos encapsulados dentro de objetos
- **Enfoque:** Se centra en los objetos (¿qué cosas existen?)
- **Integración:** Los datos y los métodos están unidos en una clase




### Versión Estructurada (Variables sueltas + Funciones)
```java
public class MudanzaEstructurada {
    
    // Variables globales
    static String codigoServicio;
    static String cliente;
    static String origen;
    static String destino;
    static double precio;
    
    // Funcion para registrar una mudanza
    static void registrarMudanza(String codigo, String nombreCliente, 
                                 String dirOrigen, String dirDestino) {
        codigoServicio = codigo;
        cliente = nombreCliente;
        origen = dirOrigen;
        destino = dirDestino;
        precio = 0.0;
        System.out.println("Mudanza registrada");
    }
    
    // Funcion para calcular el precio
    static void calcularPrecio(double distanciaKm) {
        precio = 150000 + (distanciaKm * 2500);
        System.out.println("Precio calculado: $" + precio);
    }
    
    // Funcion para mostrar informacion
    static void mostrarMudanza() {
        System.out.println("\n=== INFORMACION DE LA MUDANZA ===");
        System.out.println("Codigo: " + codigoServicio);
        System.out.println("Cliente: " + cliente);
        System.out.println("Origen: " + origen);
        System.out.println("Destino: " + destino);
        System.out.println("Precio: $" + precio);
    }
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  PROGRAMACION ESTRUCTURADA");
        System.out.println("========================================\n");
        
        // Primera mudanza
        registrarMudanza("MOV-001", "Juan Perez", 
                        "Bogota Chapinero", "Bogota Suba");
        calcularPrecio(15.0);
        mostrarMudanza();
        
        System.out.println("\n--- Registrando segunda mudanza ---");
        
        // Segunda mudanza - los datos anteriores se pierden
        registrarMudanza("MOV-002", "Maria Gonzalez", 
                        "Bogota Usaquen", "Medellin");
        calcularPrecio(280.0);
        mostrarMudanza();
        
        System.out.println("\nPROBLEMA: Los datos de Juan Perez desaparecieron!");
        System.out.println("Solo podemos manejar UNA mudanza a la vez.");
    }
}
```

### Explicación del Código Estructurado

**Variables Globales:**
- Se declaran 5 variables con `static` que son accesibles desde todas las funciones
- Solo existe **un conjunto** de estas variables en todo el programa
- Cuando registramos una nueva mudanza, los valores anteriores se sobrescriben

**Función `registrarMudanza()`:**
- Recibe los datos de una mudanza como parámetros
- Asigna esos valores a las variables globales
- Si se llama otra vez, los datos anteriores desaparecen

**Función `calcularPrecio()`:**
- Calcula el precio usando la fórmula: 150,000 + (distancia × 2,500)
- Guarda el resultado en la variable global `precio`

**Función `mostrarMudanza()`:**
- Lee las variables globales y las imprime
- Solo puede mostrar la información que esté actualmente en las variables

**Problema demostrado:**
1. Se registra la mudanza de Juan Pérez → las variables contienen sus datos
2. Se muestra correctamente su información
3. Se registra la mudanza de María González → **las variables se sobrescriben**
4. Los datos de Juan Pérez **desaparecen** completamente



**MudanzaPOO.java** (Programa Principal)
```java
public class MudanzaPOO {
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  PROGRAMACION ORIENTADA A OBJETOS");
        System.out.println("========================================\n");
        
        // Crear primer objeto
        System.out.println("Creando primera mudanza...");
        Mudanza mudanza1 = new Mudanza(
            "MOV-001", 
            "Juan Perez",
            "Bogota Chapinero", 
            "Bogota Suba"
        );
        mudanza1.calcularPrecio(15.0);
        mudanza1.mostrarInformacion();
        
        // Crear segundo objeto
        System.out.println("\nCreando segunda mudanza...");
        Mudanza mudanza2 = new Mudanza(
            "MOV-002", 
            "Maria Gonzalez",
            "Bogota Usaquen", 
            "Medellin"
        );
        mudanza2.calcularPrecio(280.0);
        mudanza2.mostrarInformacion();
        
        // Verificar que ambos objetos existen
        System.out.println("\n========================================");
        System.out.println("  VERIFICACION: Ambas mudanzas existen");
        System.out.println("========================================");
        
        System.out.println("\nVerificando mudanza 1:");
        mudanza1.mostrarInformacion();
        
        System.out.println("\nVerificando mudanza 2:");
        mudanza2.mostrarInformacion();
        
        System.out.println("\nEXITO: Ambas mudanzas conservan su informacion!");
        System.out.println("Cada objeto tiene sus propios datos independientes.");
    }
}
```

### Explicación del Código

**Clase Mudanza (Archivo 1):**

**Atributos:**
- Son variables **privadas** que pertenecen a cada objeto
- Cada objeto creado tendrá su propia copia de estos atributos
- El modificador `private` protege los datos

**Constructor:**
- Es un método especial que se ejecuta al crear un objeto con `new`
- Recibe los datos iniciales y los guarda en los atributos
- `this.codigoServicio` se refiere al atributo del objeto
- `codigoServicio` (sin this) es el parámetro recibido

**Método `calcularPrecio()`:**
- Opera sobre `this.precio` (el precio de **este objeto específico**)
- No afecta el precio de otros objetos
- Cada objeto calcula su propio precio

**Método `mostrarInformacion()`:**
- Muestra los datos de **este objeto específico**
- Usa `this` para acceder a los atributos del objeto actual

**Programa Principal (Archivo 2):**

**Creación del primer objeto :**
```java
Mudanza mudanza1 = new Mudanza("MOV-001", "Juan Perez", ...);
```
- `new Mudanza(...)` crea un nuevo objeto en la memoria
- Se llama automáticamente al constructor
- `mudanza1` es una variable que guarda la referencia a ese objeto
- El objeto tiene su propia copia completa de todos los atributos

**Creación del segundo objeto:**
```java
Mudanza mudanza2 = new Mudanza("MOV-002", "Maria Gonzalez", ...);
```
- Se crea **otro objeto diferente** en la memoria
- `mudanza2` es independiente de `mudanza1`
- Los datos de `mudanza1` NO se pierden

**Verificación:**
- Volvemos a mostrar la información de `mudanza1`
- Demuestra que `mudanza1` **todavía existe** con sus datos intactos
- También mostramos `mudanza2` que conserva sus propios datos


### Ventaja Comprobada

**Podemos crear y mantener MÚLTIPLES mudanzas simultáneamente.** Cada objeto conserva sus propios datos de forma independiente. Este enfoque es ideal para Traslados Seguros.
## Tabla Comparativa

| Aspecto | Programación Estructurada | POO |
|---------|-------------------------|-----|
| **Datos** | Variables globales compartidas | Atributos privados por objeto |
| **Organización** | Funciones separadas de datos | Métodos y datos en la clase |
| **Múltiples entidades** |  Solo una a la vez | Múltiples objetos simultáneos |
| **Independencia** |  Datos se sobrescriben |  Cada objeto es independiente |
| **Ejemplo** | Solo una mudanza | Muchas mudanzas al mismo tiempo |
