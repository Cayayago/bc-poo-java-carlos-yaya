# Semana 01 - Introducción al Paradigma Orientado a Objetos

**Estudiante:** Carlos Javier Yaya Gomez  
**Ficha:** 3228973A  
**Dominio Asignado:** Empresa de Mudanzas "Traslados Seguros"

---

## 📋 Contexto del Dominio

**Tipo de Negocio:** Empresa de Mudanzas  
**Nombre Comercial:** Traslados Seguros  
**Ubicación:** Bogotá, Fontibón  
**Especialidad:** Mudanzas residenciales, corporativas, embalaje, almacenamiento temporal

### Descripción Breve
Traslados Seguros es una empresa especializada en servicios de mudanzas locales, nacionales e internacionales. Ofrece empaque profesional, desmontaje y montaje de muebles, transporte asegurado y almacenamiento temporal. Cuenta con 8 camiones de diferentes tamaños, 25 operarios y realiza aproximadamente 100 mudanzas mensuales.

---

## 🎯 Objetivos de la Semana 01

Al finalizar esta semana, deberás ser capaz de:

1. Identificar objetos del mundo real en el contexto de una empresa de mudanzas
2. Comprender las diferencias entre programación estructurada y POO
3. Reconocer los conceptos fundamentales: clase, objeto, atributo, método
4. Crear tu primera clase simple en Java aplicada al dominio

---

## 📝 Actividades Obligatorias

### Actividad 1: Identificación de Objetos (Ejercicio 01)

**Instrucciones:**
- Lee el material teórico de la semana sobre conceptos fundamentales de POO
- Identifica **5 objetos principales** que existen en una empresa de mudanzas
- Para cada objeto, describe:
    - ¿Qué es? (definición)
    - ¿Qué características tiene? (atributos)
    - ¿Qué puede hacer? (comportamientos/métodos)

**Ejemplo:**
```
Objeto: Servicio de Mudanza
- ¿Qué es?: Una solicitud de traslado de bienes de un lugar a otro
- Características: código, cliente, origen, destino, fecha, tipo mudanza, precio
- Comportamientos: cotizar, programar, asignar equipo, ejecutar, entregar, facturar
```

**Entregable:** Documento con la identificación de 5 objetos del dominio de la empresa de mudanzas.

---

### Actividad 2: Comparación de Paradigmas (Ejercicio 02)

**Instrucciones:**
- Investiga las diferencias entre programación estructurada y POO
- Escribe un ejemplo conceptual de cómo se manejaría la información de una mudanza en:
    1. **Programación estructurada** (usando variables sueltas y funciones)
    2. **Programación orientada a objetos** (usando una clase)

**Entregable:** Documento comparativo con ejemplos explicados.

---

### Actividad 3: Primera Clase Simple (Ejercicio 03)

**Instrucciones:**
Crea tu primera clase en Java llamada `MovingService` (Servicio de Mudanza) con:
- **3 atributos** (ej: `serviceCode`, `origin`, `destination`)
- **1 constructor** que inicialice los atributos
- **1 método** que muestre la información del servicio

**Código de ejemplo:**

```java
public class MovingService {
    // Atributos
    String serviceCode;
    String origin;
    String destination;
    
    // Constructor
    public MovingService(String serviceCode, String origin, String destination) {
        this.serviceCode = serviceCode;
        this.origin = origin;
        this.destination = destination;
    }
    
    // Método para mostrar información
    public void showInfo() {
        System.out.println("Código: " + serviceCode);
        System.out.println("Origen: " + origin);
        System.out.println("Destino: " + destination);
    }
}
```

**Instrucciones adicionales:**
1. Crea una clase `Main` con el método `main`
2. Instancia **3 objetos diferentes** de tipo `MovingService`
3. Llama al método `showInfo()` para cada objeto

**Entregable:** Archivo `MovingService.java` y `Main.java` funcionando correctamente.

---

### Actividad 4: Múltiples Objetos (Ejercicio 04)

**Instrucciones:**
Amplía el ejercicio anterior:
- Crea al menos **5 objetos** de tipo `MovingService` con datos diferentes
- Cada servicio debe tener información coherente con una empresa de mudanzas real
- Muestra la información de todos los servicios

**Ejemplo de datos:**
- MOV-001, Bogotá - Chapinero, Bogotá - Suba
- MOV-002, Bogotá, Medellín
- MOV-003, Bogotá - Usaquén, Bogotá - Kennedy
- MOV-004, Bogotá, Cali
- MOV-005, Bogotá - Centro, Chía

**Entregable:** Código Java con 5 instancias de `MovingService` y su salida en consola.

---

## 🎓 Criterios de Evaluación

| Criterio | Peso | Descripción |
|----------|------|-------------|
| **Identificación de objetos** | 25% | Objetos identificados son relevantes al dominio de la empresa de mudanzas |
| **Comprensión conceptual** | 25% | Demuestra entender diferencias entre paradigmas |
| **Implementación de clase** | 30% | Clase `MovingService` implementada correctamente con atributos, constructor y método |
| **Instanciación de objetos** | 20% | Crea múltiples objetos con datos coherentes |

---

## 📚 Recursos de Apoyo

### Material Teórico (Carpeta `1-teoria/`)
- `01-historia-evolucion-poo.md`
- `02-paradigmas-programacion.md`
- `03-conceptos-fundamentales-poo.md`
- `04-primer-programa-poo.md`

### Ejercicios Guiados (Carpeta `2-practica/`)
- `ejercicio-01-comparacion-paradigmas/`
- `ejercicio-02-primera-clase/`
- `ejercicio-03-multiples-objetos/`
- `ejercicio-04-modelado-mundo-real/`

### Glosario
Revisa el archivo `3-recursos/glosario.md` para términos clave de esta semana.

---

## 💡 Consejos

1. **No te compliques:** Esta semana es sobre conceptos básicos, no sobre código complejo
2. **Piensa en objetos reales:** Visualiza cómo funciona una empresa de mudanzas real
3. **Pregunta:** Si tienes dudas sobre el dominio o los conceptos, consulta con el instructor
4. **Compila y prueba:** Asegúrate de que tu código compile antes de entregar

# Semana 02: Clases y Objetos

## 🎯 Objetivo

Expandir tu sistema agregando más clases, creando relaciones entre objetos y usando colecciones básicas (ArrayList).

---

## 📦 Estructura de Entrega

```
bc-oop-java-[ficha]-[apellido]/
├── semana-01/
└── semana-02/
    ├── README.md
    ├── [ClaseNueva1].java
    ├── [ClaseNueva2].java
    ├── [ClaseGestora].java
    └── Main.java
```

---

## 📝 Ejercicio 1: Crear Nuevas Clases (30 puntos)

Agrega **2 nuevas clases** relacionadas con tu dominio.

**Requisitos:**
- Mínimo 3 atributos cada clase
- Constructor completo
- Getters y setters
- Al menos 1 método de negocio
- Relación con clases existentes

**Ejemplo (Agencia de Viajes):**
```java
public class Destino {
    private String nombre;
    private String pais;
    private double costoPromedio;
    private String temporada;
    
    public Destino(String nombre, String pais, double costo, String temporada) {
        this.nombre = nombre;
        this.pais = pais;
        this.costoPromedio = costo;
        this.temporada = temporada;
    }
    
    public String obtenerInformacion() {
        return nombre + ", " + pais + " - $" + costoPromedio;
    }
    
    // getters y setters...
}
```

---

## 📝 Ejercicio 2: Implementar Relaciones (25 puntos)

Crea relaciones entre tus objetos (composición/agregación).

**Ejemplo:**
```java
public class Reserva {
    private Cliente cliente;        // Relación con Cliente
    private Destino destino;        // Relación con Destino
    private String fechaViaje;
    private int numeroPasajeros;
    
    public Reserva(Cliente cliente, Destino destino, String fecha, int pasajeros) {
        this.cliente = cliente;
        this.destino = destino;
        this.fechaViaje = fecha;
        this.numeroPasajeros = pasajeros;
    }
    
    public double calcularTotal() {
        return destino.getCostoPromedio() * numeroPasajeros;
    }
}
```

---

## 📝 Ejercicio 3: Usar ArrayList (20 puntos)

Crea una clase gestora que use ArrayList para manejar colecciones.

**Ejemplo:**
```java
import java.util.ArrayList;

public class AgenciaViajes {
    private String nombre;
    private ArrayList<Reserva> reservas;
    
    public AgenciaViajes(String nombre) {
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
    }
    
    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }
    
    public void mostrarTodasReservas() {
        for (Reserva reserva : reservas) {
            System.out.println(reserva.obtenerResumen());
        }
    }
    
    public int contarReservas() {
        return reservas.size();
    }
}
```

---

## 📝 Ejercicio 4: Main Completo (25 puntos)

```java
public class Main {
    public static void main(String[] args) {
        // Crear objetos
        Cliente cliente1 = new Cliente("Juan Pérez", "juan@email.com");
        Destino cartagena = new Destino("Cartagena", "Colombia", 800000, "Verano");
        
        // Crear relación
        Reserva reserva1 = new Reserva(cliente1, cartagena, "2025-12-15", 2);
        
        // Usar ArrayList
        AgenciaViajes agencia = new AgenciaViajes("Viajes Colombia");
        agencia.agregarReserva(reserva1);
        
        // Mostrar resultados
        agencia.mostrarTodasReservas();
        System.out.println("Total reservas: " + agencia.contarReservas());
    }
}
```
# Semana 03: Encapsulación y Constructores

## 📝 Ejercicio 1: Encapsulación Completa (30 puntos)

Refactoriza TODAS tus clases aplicando encapsulación completa.

**Requisitos:**
- Todos los atributos `private`
- Getters para todos los atributos
- Setters con validaciones
- Métodos auxiliares privados

**Ejemplo:**
```java
public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    
    // Getters
    public String getCodigo() { return codigo; }
    public double getPrecio() { return precio; }
    
    // Setters con validación
    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        } else {
            throw new IllegalArgumentException("Precio debe ser positivo");
        }
    }
    
    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }
    }
    
    // Método privado auxiliar
    private boolean validarCodigo(String codigo) {
        return codigo != null && codigo.length() >= 3;
    }
}
```

---

## 📝 Ejercicio 2: Sobrecarga de Constructores (25 puntos)

Implementa mínimo **2 constructores** en cada clase principal.

**Ejemplo:**
```java
public class Cliente {
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    
    // Constructor completo
    public Cliente(String nombre, String email, String telefono, String direccion) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    // Constructor básico (llama al completo)
    public Cliente(String nombre, String email) {
        this(nombre, email, "Sin teléfono", "Sin dirección");
    }
    
    // Constructor mínimo
    public Cliente(String nombre) {
        this(nombre, nombre.toLowerCase() + "@example.com");
    }
}
```

---

## 📝 Ejercicio 3: Validaciones (25 puntos)

Implementa validaciones en constructores y setters.

**Validaciones comunes:**
- Strings no nulos ni vacíos
- Números positivos
- Rangos válidos
- Formatos correctos (email, teléfono)

**Ejemplo:**
```java
public void setEmail(String email) {
    if (email == null || !email.contains("@")) {
        throw new IllegalArgumentException("Email inválido");
    }
    this.email = email;
}

public void setEdad(int edad) {
    if (edad < 0 || edad > 120) {
        throw new IllegalArgumentException("Edad fuera de rango");
    }
    this.edad = edad;
}
```

---

## 📝 Ejercicio 4: Documento MEJORAS.md (20 puntos)

Documenta las mejoras realizadas.

**Contenido:**
```markdown
# Mejoras - Semana 03

## Encapsulación Aplicada

### Clase: [NombreClase]
- Atributos encapsulados: [lista]
- Validaciones agregadas: [descripción]

## Constructores Sobrecargados

### Clase: [NombreClase]
- Constructor 1: [descripción]
- Constructor 2: [descripción]

## Beneficios Logrados
- [Beneficio 1]
- [Beneficio 2]
```
# Semana 04: Herencia

## 📝 Ejercicio 1: Crear Clase Padre (25 puntos)

Identifica una jerarquía en tu dominio y crea la clase padre.

**Requisitos:**
- Atributos `protected` (compartidos con subclases)
- Constructor completo
- Al menos 2 métodos que puedan ser heredados

**Ejemplo:**
```java
public class Empleado {
    protected String nombre;
    protected String identificacion;
    protected double salarioBase;
    
    public Empleado(String nombre, String id, double salario) {
        this.nombre = nombre;
        this.identificacion = id;
        this.salarioBase = salario;
    }
    
    public void mostrarInfo() {
        System.out.println("Empleado: " + nombre);
        System.out.println("ID: " + identificacion);
    }
    
    public double calcularSalario() {
        return salarioBase;
    }
}
```

---

## 📝 Ejercicio 2: Crear Subclases (30 puntos)

Crea mínimo **2 subclases** que hereden de la clase padre.

**Ejemplo:**
```java
public class EmpleadoPlanta extends Empleado {
    private int anosAntiguedad;
    
    public EmpleadoPlanta(String nombre, String id, double salario, int anos) {
        super(nombre, id, salario);  // Llamar constructor padre
        this.anosAntiguedad = anos;
    }
    
    @Override
    public double calcularSalario() {
        double bono = salarioBase * 0.05 * anosAntiguedad;
        return salarioBase + bono;
    }
}

public class EmpleadoContrato extends Empleado {
    private int mesesContrato;
    
    public EmpleadoContrato(String nombre, String id, double salario, int meses) {
        super(nombre, id, salario);
        this.mesesContrato = meses;
    }
    
    @Override
    public double calcularSalario() {
        return salarioBase;  // Sin bonos
    }
}
```

---

## 📝 Ejercicio 3: Implementación Correcta (25 puntos)

Verifica:
- [ ] Uso correcto de `extends`
- [ ] `super()` en todos los constructores
- [ ] `@Override` en métodos sobrescritos
- [ ] Atributos `protected` en lugar de `private` donde apropiado

---

## 📝 Ejercicio 4: Demostración de Polimorfismo (20 puntos)

```java
public class Main {
    public static void main(String[] args) {
        // Array polimórfico
        Empleado[] empleados = new Empleado[3];
        
        empleados[0] = new EmpleadoPlanta("Ana", "E001", 2000000, 5);
        empleados[1] = new EmpleadoContrato("Luis", "E002", 1500000, 6);
        empleados[2] = new EmpleadoPlanta("María", "E003", 2500000, 3);
        
        // Polimorfismo en acción
        for (Empleado emp : empleados) {
            emp.mostrarInfo();
            System.out.println("Salario: $" + emp.calcularSalario());
            System.out.println("---");
        }
    }
}
```

---

## 📄 Documento JERARQUIA.md

```markdown
# Jerarquía de Clases - Semana 04

## Diagrama
```
      Empleado
         |
    +----+----+
    |         |
EmpleadoPlanta  EmpleadoContrato
```

## Justificación
[Explica por qué elegiste esta jerarquía]

## Atributos Heredados
- nombre (String)
- identificacion (String)
- salarioBase (double)

## Métodos Sobrescritos
- calcularSalario(): [Explicación de diferencias]
```
# Semana 05: Polimorfismo

## 🎯 Objetivo

Aplicar **sobrecarga** y **sobrescritura** de métodos para implementar polimorfismo en tu sistema.

**RECUERDA:** Continúas con tu dominio. Mejoras el código de la Semana 04 agregando polimorfismo.

---

## 📊 Ejercicios (100 puntos)

### **Ejercicio 1: Sobrecarga de Métodos (25 puntos)**

Implementa **sobrecarga** (overloading) en una o más clases.

**Requisitos:**
- Mínimo **2 métodos con el mismo nombre** pero diferentes parámetros
- Deben estar en clases lógicas (no forzados)
- Ejemplo: búsqueda por código, por nombre, por rango de fechas

**Ejemplo (Agencia de Viajes):**
```java
public class AgenciaViajes {
    private ArrayList<Reserva> reservas;
    
    // Sobrecarga: buscar por código
    public Reserva buscarReserva(String codigo) {
        for (Reserva r : reservas) {
            if (r.getCodigo().equals(codigo)) {
                return r;
            }
        }
        return null;
    }
    
    // Sobrecarga: buscar por cliente
    public ArrayList<Reserva> buscarReserva(Cliente cliente) {
        ArrayList<Reserva> resultado = new ArrayList<>();
        for (Reserva r : reservas) {
            if (r.getCliente().equals(cliente)) {
                resultado.add(r);
            }
        }
        return resultado;
    }
    
    // Sobrecarga: buscar por rango de fechas
    public ArrayList<Reserva> buscarReserva(LocalDate inicio, LocalDate fin) {
        ArrayList<Reserva> resultado = new ArrayList<>();
        for (Reserva r : reservas) {
            LocalDate fecha = r.getFecha();
            if (fecha.isAfter(inicio) && fecha.isBefore(fin)) {
                resultado.add(r);
            }
        }
        return resultado;
    }
}
```

**Otros ejemplos de sobrecarga:**
```java
// Restaurante: agregar platillo
public void agregarPlatillo(String nombre, double precio);
public void agregarPlatillo(String nombre, double precio, String categoria);

// Biblioteca: buscar material
public Material buscar(String codigo);
public ArrayList<Material> buscar(String campo, String valor);

// Tienda: aplicar descuento
public double aplicarDescuento(double monto);
public double aplicarDescuento(double monto, int porcentaje);
public double aplicarDescuento(Cliente cliente, double monto);  // descuento VIP
```

---

### **Ejercicio 2: Sobrescritura de Métodos con @Override (25 puntos)**

Sobrescribe métodos de la clase padre en las subclases.

**Requisitos:**
- Usa `@Override` correctamente
- Modifica el comportamiento según la subclase
- Mínimo **2 métodos sobrescritos** en diferentes subclases

**Ejemplo (Empleados):**
```java
public class Empleado {
    protected String nombre;
    protected String identificacion;
    protected double salarioBase;
    
    // Constructor
    public Empleado(String nombre, String identificacion, double salarioBase) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.salarioBase = salarioBase;
    }
    
    // Método base
    public double calcularSalario() {
        return salarioBase;
    }
    
    // Método base
    public String obtenerDescripcion() {
        return "Empleado: " + nombre;
    }
    
    // Getters...
}

public class EmpleadoPlanta extends Empleado {
    private int antiguedad;  // años
    
    public EmpleadoPlanta(String nombre, String identificacion, 
                          double salarioBase, int antiguedad) {
        super(nombre, identificacion, salarioBase);
        this.antiguedad = antiguedad;
    }
    
    @Override
    public double calcularSalario() {
        // Sobrescribe: bono por antigüedad
        double bono = salarioBase * (antiguedad * 0.05);  // 5% por año
        return salarioBase + bono;
    }
    
    @Override
    public String obtenerDescripcion() {
        return "Empleado de Planta: " + nombre + " (" + antiguedad + " años)";
    }
    
    // Getter
    public int getAntiguedad() { return antiguedad; }
}

public class EmpleadoContrato extends Empleado {
    private LocalDate fechaFinContrato;
    
    public EmpleadoContrato(String nombre, String identificacion, 
                           double salarioBase, LocalDate fechaFinContrato) {
        super(nombre, identificacion, salarioBase);
        this.fechaFinContrato = fechaFinContrato;
    }
    
    @Override
    public double calcularSalario() {
        // Sobrescribe: sin bonos
        return salarioBase;
    }
    
    @Override
    public String obtenerDescripcion() {
        return "Empleado por Contrato: " + nombre + 
               " (hasta " + fechaFinContrato + ")";
    }
    
    // Getter
    public LocalDate getFechaFinContrato() { return fechaFinContrato; }
}
```

**Otros ejemplos de sobrescritura:**
```java
// Agencia: ServicioTuristico
@Override
public double calcularCosto();  // Vuelo: precio base, Hotel: precio/noche, Tour: precio/persona

// Restaurante: Platillo
@Override
public int calcularTiempoPreparacion();  // Entrada: 10 min, Plato fuerte: 30 min

// Biblioteca: Material
@Override
public double calcularMulta(int diasRetraso);  // Libro: $5/día, DVD: $10/día
```

---

### **Ejercicio 3: Métodos Polimórficos (25 puntos)**

Crea métodos que acepten la clase **padre** y funcionen con cualquier **subclase**.

**Requisitos:**
- Métodos que aceptan clase padre como parámetro
- Funcionalidad que usa polimorfismo
- Demostración de **dynamic binding** (enlace dinámico)

**Ejemplo (Sistema de RH):**
```java
public class SistemaRH {
    private ArrayList<Empleado> empleados;
    
    public SistemaRH() {
        this.empleados = new ArrayList<>();
    }
    
    // Método polimórfico: acepta cualquier Empleado
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        System.out.println("Empleado agregado: " + empleado.obtenerDescripcion());
    }
    
    // Método polimórfico: procesa nómina
    public void procesarNomina(Empleado empleado) {
        double salario = empleado.calcularSalario();  // Polimorfismo
        System.out.println("Procesando pago para: " + empleado.getNombre());
        System.out.println("Salario: $" + salario);
    }
    
    // Método polimórfico: procesa todos
    public void procesarNominaCompleta() {
        System.out.println("\n=== NÓMINA MENSUAL ===");
        double total = 0;
        for (Empleado emp : empleados) {
            procesarNomina(emp);  // Funciona con EmpleadoPlanta y EmpleadoContrato
            total += emp.calcularSalario();
            System.out.println("---");
        }
        System.out.println("TOTAL: $" + total);
    }
    
    // Método polimórfico: genera reporte
    public void generarReporte() {
        System.out.println("\n=== REPORTE DE EMPLEADOS ===");
        for (Empleado emp : empleados) {
            System.out.println(emp.obtenerDescripcion());  // Polimorfismo
            System.out.println("Salario: $" + emp.calcularSalario());
        }
    }
}
```

**Otros ejemplos de métodos polimórficos:**
```java
// Agencia: procesar servicios
public void facturar(ServicioTuristico servicio) {
    double costo = servicio.calcularCosto();  // Polimorfismo
    System.out.println("Factura: $" + costo);
}

// Restaurante: cocinar platillos
public void preparar(Platillo platillo) {
    int tiempo = platillo.calcularTiempoPreparacion();  // Polimorfismo
    System.out.println("Preparando " + platillo.getNombre() + " (" + tiempo + " min)");
}

// Biblioteca: calcular multas
public double aplicarMulta(Material material, int dias) {
    return material.calcularMulta(dias);  // Polimorfismo
}
```

---

### **Ejercicio 4: Demostración Completa en Main (25 puntos)**

Crea un `Main.java` que demuestre polimorfismo en acción.

**Requisitos:**
- Usa **ArrayList polimórfico** (almacena objetos de tipo padre)
- Demuestra **dynamic binding** (llamada a métodos sobrescritos)
- Incluye bucles que recorren la colección

**Ejemplo Completo:**
```java
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. Crear sistema de RH
        SistemaRH sistema = new SistemaRH();
        
        // 2. Crear empleados de diferentes tipos
        EmpleadoPlanta emp1 = new EmpleadoPlanta(
            "Ana García", "E001", 3000000, 5
        );
        
        EmpleadoContrato emp2 = new EmpleadoContrato(
            "Carlos Pérez", "E002", 2500000, 
            LocalDate.of(2024, 12, 31)
        );
        
        EmpleadoPlanta emp3 = new EmpleadoPlanta(
            "María López", "E003", 3500000, 10
        );
        
        // 3. Agregar empleados (método polimórfico)
        sistema.agregarEmpleado(emp1);
        sistema.agregarEmpleado(emp2);  // Diferentes subclases
        sistema.agregarEmpleado(emp3);
        
        // 4. Procesar nómina completa (polimorfismo)
        sistema.procesarNominaCompleta();
        
        // 5. Generar reporte (polimorfismo)
        sistema.generarReporte();
        
        // 6. Demostración de ArrayList polimórfico
        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(emp1);
        empleados.add(emp2);  // Mismo ArrayList para diferentes subclases
        empleados.add(emp3);
        
        System.out.println("\n=== DEMOSTRACIÓN POLIMORFISMO ===");
        for (Empleado e : empleados) {
            System.out.println(e.obtenerDescripcion());  // Dynamic binding
            System.out.println("Salario: $" + e.calcularSalario());  // Dynamic binding
            System.out.println("Tipo real: " + e.getClass().getSimpleName());
            System.out.println("---");
        }
        
        // 7. Demostración de sobrecarga
        AgenciaViajes agencia = new AgenciaViajes();
        
        System.out.println("\n=== DEMOSTRACIÓN SOBRECARGA ===");
        // Buscar por código
        Reserva r1 = agencia.buscarReserva("R001");
        
        // Buscar por cliente
        Cliente cliente = new Cliente("Juan", "juan@mail.com");
        ArrayList<Reserva> r2 = agencia.buscarReserva(cliente);
        
        // Buscar por rango de fechas
        ArrayList<Reserva> r3 = agencia.buscarReserva(
            LocalDate.now(), 
            LocalDate.now().plusDays(30)
        );
    }
}
```
## 📄 Documento POLIMORFISMO.md

Crea un archivo `POLIMORFISMO.md` con:

### 1. Sobrecarga (Overloading)
- **Métodos**: Lista de métodos sobrecargados
- **Justificación**: Por qué tiene sentido en tu dominio

### 2. Sobrescritura (Overriding)
- **Métodos**: Lista de métodos sobrescritos con `@Override`
- **Tabla comparativa**:

| Método | Clase Padre | Subclase 1 | Subclase 2 |
|--------|-------------|------------|------------|
| `calcularSalario()` | return salarioBase | return salarioBase + bono | return salarioBase |

### 3. Polimorfismo Dinámico
- **Ejemplo**: Código que demuestra dynamic binding
- **Explicación**: Cómo funciona en tu sistema

### 4. Beneficios
- ¿Qué ventajas obtienes con polimorfismo?
- ¿Qué sería difícil sin polimorfismo?

# Semana 06: Abstracción e Interfaces

## 📋 Información General


## 🎯 Objetivo General

Refactorizar y expandir tu sistema del dominio asignado aplicando **abstracción mediante clases abstractas e interfaces**, mejorando el diseño y aplicando principios SOLID.

---

## ⚠️ IMPORTANTE: Continuidad del Proyecto

**NO inicias un proyecto nuevo.**  
**Continúas trabajando con el MISMO dominio asignado en Semana 01.**

### Progresión de tu Proyecto

```
Semana 01 → Clases básicas con atributos y métodos
Semana 02 → Más objetos y relaciones
Semana 03 → Encapsulación y constructores
Semana 04 → Herencia y jerarquías
Semana 05 → Polimorfismo (sobrecarga/sobrescritura)
Semana 06 → Abstracción (clases abstractas + interfaces) ⬅️ ESTÁS AQUÍ
```

---

## 📦 Estructura de Entrega

Tu repositorio debe seguir esta estructura acumulativa:

```
bc-oop-java-[ficha]-[apellido]/
├── README.md (actualizado con descripción de semana 06)
├── semana-01/
├── semana-02/
├── semana-03/
├── semana-04/
├── semana-05/
└── semana-06/                              ⬅️ NUEVA CARPETA
    ├── README.md                           (Descripción de cambios)
    ├── abstractas/                         (Clases abstractas)
    │   ├── [TuClaseAbstracta1].java
    │   └── [TuClaseAbstracta2].java (opcional)
    ├── interfaces/                         (Interfaces)
    │   ├── [Interface1].java
    │   ├── [Interface2].java
    │   └── [Interface3].java (opcional)
    ├── implementaciones/                   (Clases concretas)
    │   ├── [ClaseConcreta1].java
    │   ├── [ClaseConcreta2].java
    │   └── [ClaseConcreta3].java
    ├── Main.java                           (Programa de demostración)
    ├── ANALISIS.md                         (Documento de diseño)
    └── diagramas/                          (Opcional)
        └── jerarquia.png/jpg
```

---

## 📝 Ejercicios Obligatorios

### Ejercicio 1: Crear Clase Abstracta (25 puntos)

#### 📌 Descripción

Identifica en tu dominio una clase que represente un concepto general con comportamiento común pero implementación variable. Conviértela en una **clase abstracta**.

#### ✅ Requisitos Técnicos

1. **Clase abstracta con:**
    - Palabra clave `abstract class`
    - Mínimo 2 atributos protegidos (`protected`)
    - Constructor que inicialice los atributos
    - Al menos 1 método abstracto
    - Al menos 1 método concreto (con implementación)

2. **Mínimo 2 subclases concretas que:**
    - Extiendan la clase abstracta con `extends`
    - Implementen TODOS los métodos abstractos
    - Usen `@Override` correctamente
    - Llamen al constructor padre con `super()`

#### 💡 Ejemplos por Dominio

<details>
<summary><strong>Agencia de Viajes</strong></summary>

```java
// Clase abstracta
public abstract class ServicioTuristico {
    protected String nombre;
    protected double precio;
    protected String proveedor;
    
    public ServicioTuristico(String nombre, double precio, String proveedor) {
        this.nombre = nombre;
        this.precio = precio;
        this.proveedor = proveedor;
    }
    
    // Método abstracto: cada servicio calcula costo diferente
    public abstract double calcularCostoTotal();
    
    // Método abstracto: cada servicio tiene descripción diferente
    public abstract String obtenerDescripcion();
    
    // Método concreto: común a todos los servicios
    public void mostrarInformacion() {
        System.out.println("=== " + nombre + " ===");
        System.out.println("Proveedor: " + proveedor);
        System.out.println("Costo: $" + calcularCostoTotal());
    }
}

// Subclase concreta 1
public class Vuelo extends ServicioTuristico {
    private String origen;
    private String destino;
    private int numeroEscalas;
    
    public Vuelo(String nombre, double precio, String aerolinea, 
                 String origen, String destino, int numeroEscalas) {
        super(nombre, precio, aerolinea);
        this.origen = origen;
        this.destino = destino;
        this.numeroEscalas = numeroEscalas;
    }
    
    @Override
    public double calcularCostoTotal() {
        // Costo base + impuestos 19% + cargo por escalas
        double impuestos = precio * 0.19;
        double cargoEscalas = numeroEscalas * 50000;
        return precio + impuestos + cargoEscalas;
    }
    
    @Override
    public String obtenerDescripcion() {
        return "Vuelo de " + origen + " a " + destino + 
               " con " + numeroEscalas + " escala(s)";
    }
}

// Subclase concreta 2
public class Hotel extends ServicioTuristico {
    private String ciudad;
    private int numeroNoches;
    private int estrellas;
    
    public Hotel(String nombre, double precioPorNoche, String cadena,
                 String ciudad, int numeroNoches, int estrellas) {
        super(nombre, precioPorNoche, cadena);
        this.ciudad = ciudad;
        this.numeroNoches = numeroNoches;
        this.estrellas = estrellas;
    }
    
    @Override
    public double calcularCostoTotal() {
        // Precio por noche * número de noches + IVA
        double subtotal = precio * numeroNoches;
        double iva = subtotal * 0.19;
        return subtotal + iva;
    }
    
    @Override
    public String obtenerDescripcion() {
        return "Hotel " + estrellas + " estrellas en " + ciudad + 
               " por " + numeroNoches + " noche(s)";
    }
}
```
</details>

<details>
<summary><strong>Restaurante</strong></summary>

```java
public abstract class Platillo {
    protected String nombre;
    protected double precioBase;
    protected String categoria;
    
    public Platillo(String nombre, double precioBase, String categoria) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.categoria = categoria;
    }
    
    public abstract double calcularPrecioFinal();
    public abstract int obtenerTiempoPreparacion();
    
    public void mostrarInfo() {
        System.out.println(nombre + " - $" + calcularPrecioFinal());
    }
}

public class PlatilloCaliente extends Platillo {
    private String temperatura;
    private boolean esGourmet;
    
    // Constructor, métodos @Override...
}

public class Postre extends Platillo {
    private boolean esFrio;
    private int calorias;
    
    // Constructor, métodos @Override...
}
```
</details>

<details>
<summary><strong>Biblioteca</strong></summary>

```java
public abstract class Material {
    protected String titulo;
    protected String codigo;
    protected boolean disponible;
    
    public Material(String titulo, String codigo) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.disponible = true;
    }
    
    public abstract int calcularDiasPrestamo();
    public abstract double calcularMultaPorDia();
    
    public void prestar() {
        if (disponible) {
            disponible = false;
            System.out.println(titulo + " prestado exitosamente");
        }
    }
}

public class Libro extends Material { /* ... */ }
public class Revista extends Material { /* ... */ }
public class DVD extends Material { /* ... */ }
```
</details>

#### 📊 Criterios de Evaluación

| Criterio | Puntos | Descripción |
|----------|--------|-------------|
| Identificación correcta | 5 | La abstracción es apropiada para el dominio |
| Métodos abstractos | 8 | Al menos 1 método abstracto bien definido |
| Métodos concretos | 5 | Al menos 1 método concreto reutilizable |
| Subclases | 5 | Mínimo 2 subclases correctamente implementadas |
| Uso de `super()` | 2 | Constructores usan `super()` apropiadamente |

---

### Ejercicio 2: Crear Interfaces (25 puntos)

#### 📌 Descripción

Define al menos **2 interfaces** que representen capacidades o comportamientos que pueden ser compartidos por clases no relacionadas jerárquicamente en tu dominio.

#### ✅ Requisitos Técnicos

1. **Mínimo 2 interfaces diferentes:**
    - Palabra clave `interface`
    - Nombres descriptivos (capacidad/comportamiento)
    - 2-4 métodos por interface
    - Sin atributos de instancia (solo constantes si necesario)

2. **Implementación:**
    - Al menos 1 clase debe implementar múltiples interfaces
    - Todas las clases deben implementar TODOS los métodos
    - Métodos `public` en implementaciones
    - Uso de `@Override`

#### 💡 Ejemplos por Dominio

<details>
<summary><strong>Agencia de Viajes</strong></summary>

```java
// Interface 1: Capacidad de ser reservado
public interface Reservable {
    boolean verificarDisponibilidad(String fecha);
    void realizarReserva(String cliente, String fecha);
    void cancelarReserva(String codigoReserva);
    String obtenerCodigoReserva();
}

// Interface 2: Capacidad de ser calificado
public interface Calificable {
    void agregarCalificacion(int estrellas, String comentario);
    double obtenerPromedioCalificaciones();
    int obtenerNumeroCalificaciones();
}

// Interface 3: Capacidad de tener descuentos
public interface Descuentable {
    double aplicarDescuento(double porcentaje);
    boolean esElegibleDescuento();
}

// Clase que implementa múltiples interfaces
public class PaqueteTuristico implements Reservable, Calificable, Descuentable {
    private String nombre;
    private double precio;
    private List<String> reservas;
    private List<Integer> calificaciones;
    
    @Override
    public boolean verificarDisponibilidad(String fecha) {
        // Implementación
        return true;
    }
    
    @Override
    public void realizarReserva(String cliente, String fecha) {
        // Implementación
    }
    
    @Override
    public void agregarCalificacion(int estrellas, String comentario) {
        calificaciones.add(estrellas);
    }
    
    @Override
    public double obtenerPromedioCalificaciones() {
        if (calificaciones.isEmpty()) return 0.0;
        int suma = calificaciones.stream().mapToInt(Integer::intValue).sum();
        return (double) suma / calificaciones.size();
    }
    
    @Override
    public double aplicarDescuento(double porcentaje) {
        return precio - (precio * porcentaje / 100);
    }
    
    // Implementar resto de métodos...
}
```
</details>

<details>
<summary><strong>Restaurante</strong></summary>

```java
public interface Preparable {
    void iniciarPreparacion();
    void finalizarPreparacion();
    int obtenerTiempoEstimado();
}

public interface Entregable {
    void prepararParaEntrega();
    boolean estaListoParaEntregar();
    String obtenerDireccionEntrega();
}

public interface Facturable {
    double calcularSubtotal();
    double calcularImpuestos();
    double calcularTotal();
    String generarFactura();
}

public class Pedido implements Preparable, Entregable, Facturable {
    // Implementación de todos los métodos...
}
```
</details>

<details>
<summary><strong>Tienda Online</strong></summary>

```java
public interface Vendible {
    double obtenerPrecio();
    boolean verificarStock();
    void reducirStock(int cantidad);
}

public interface Enviabl {
    double calcularCostoEnvio(String destino);
    int obtenerDiasEntrega(String destino);
    String obtenerNumeroRastreo();
}

public interface Retornable {
    boolean esRetornable();
    int obtenerDiasGarantia();
    double calcularCostoDevolucion();
}

public class ProductoFisico implements Vendible, Enviabl, Retornable {
    // Implementación completa...
}
```
</details>

#### 📊 Criterios de Evaluación

| Criterio | Puntos | Descripción |
|----------|--------|-------------|
| Número de interfaces | 5 | Mínimo 2 interfaces diferentes |
| Nombres apropiados | 5 | Nombres descriptivos de capacidades |
| Métodos coherentes | 8 | Métodos relacionados con la capacidad |
| Implementación múltiple | 5 | Al menos 1 clase con múltiples interfaces |
| Código sin errores | 2 | Compila y ejecuta correctamente |

---

### Ejercicio 3: Programa de Demostración (25 puntos)

#### 📌 Descripción

Crea un programa `Main.java` que demuestre el uso de abstracción, polimorfismo y las interfaces implementadas.

#### ✅ Requisitos Técnicos

1. **Demostrar polimorfismo con clase abstracta:**
    - Array/List de tipo abstracto
    - Almacenar diferentes subclases concretas
    - Invocar métodos polimórficos

2. **Demostrar interfaces:**
    - Usar referencias de tipo interface
    - Demostrar múltiple implementación
    - Invocar métodos de diferentes interfaces

3. **Salida clara:**
    - Imprimir información organizada
    - Mostrar resultados de métodos
    - Usar separadores visuales

#### 💡 Ejemplo Completo

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE AGENCIA DE VIAJES ===\n");
        
        // 1. Polimorfismo con clase abstracta
        System.out.println("--- Servicios Disponibles ---");
        ServicioTuristico[] servicios = new ServicioTuristico[3];
        
        servicios[0] = new Vuelo("Vuelo BOG-MDE", 250000, "Avianca", 
                                 "Bogotá", "Medellín", 0);
        servicios[1] = new Hotel("Hotel Dann Carlton", 180000, "Dann", 
                                 "Cartagena", 3, 5);
        servicios[2] = new Tour("City Tour", 120000, "Tours Colombia",
                               "Bogotá", 8);
        
        // Invocar método polimórfico
        for (ServicioTuristico servicio : servicios) {
            servicio.mostrarInformacion();
            System.out.println("Descripción: " + servicio.obtenerDescripcion());
            System.out.println("Costo Total: $" + servicio.calcularCostoTotal());
            System.out.println();
        }
        
        // 2. Demostrar interfaces
        System.out.println("--- Gestión de Reservas ---");
        
        // Usar referencia de tipo interface
        Reservable servicioReservable = new PaqueteTuristico(
            "Paquete Caribe", 1500000, 5);
        
        if (servicioReservable.verificarDisponibilidad("2025-12-15")) {
            servicioReservable.realizarReserva("Juan Pérez", "2025-12-15");
            System.out.println("Reserva exitosa. Código: " + 
                             servicioReservable.obtenerCodigoReserva());
        }
        
        // 3. Múltiple implementación
        System.out.println("\n--- Calificaciones ---");
        
        PaqueteTuristico paquete = new PaqueteTuristico(
            "Paquete Eje Cafetero", 800000, 3);
        
        // Usar como Calificable
        Calificable servicionCalificable = paquete;
        servicionCalificable.agregarCalificacion(5, "Excelente");
        servicionCalificable.agregarCalificacion(4, "Muy bueno");
        
        System.out.println("Promedio: " + 
                         servicionCalificable.obtenerPromedioCalificaciones() + 
                         " estrellas");
        
        // Usar como Descuentable
        Descuentable servicioDescuentable = paquete;
        if (servicioDescuentable.esElegibleDescuento()) {
            double precioConDescuento = servicioDescuentable.aplicarDescuento(15);
            System.out.println("Precio con descuento (15%): $" + 
                             precioConDescuento);
        }
        
        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
}
```

#### 📊 Criterios de Evaluación

| Criterio | Puntos | Descripción |
|----------|--------|-------------|
| Polimorfismo con abstracta | 10 | Array/List de tipo abstracto usado correctamente |
| Uso de interfaces | 8 | Referencias de tipo interface demostradas |
| Variedad de casos | 5 | Diferentes escenarios probados |
| Salida clara | 2 | Información bien presentada |

---

### Ejercicio 4: Documento de Análisis (25 puntos)

#### 📌 Descripción

Crea un archivo `ANALISIS.md` que explique tus decisiones de diseño y la aplicación de principios de POO.

#### ✅ Contenido Requerido

```markdown
# Análisis de Diseño - Semana 06: [Tu Dominio]

## 1. Identificación de Abstracciones

### Clase(s) Abstracta(s)
**Nombre:** [NombreClaseAbstracta]

**¿Por qué es abstracta?**
- [Explica por qué elegiste hacer esta clase abstracta]
- [Qué comportamiento común tiene]
- [Qué comportamiento varía en las subclases]

**Jerarquía:**
```
[ClaseAbstracta]
├── [SubclaseConcreta1]
├── [SubclaseConcreta2]
└── [SubclaseConcreta3]
```

## 2. Interfaces Implementadas

### Interface 1: [NombreInterface]
**Capacidad que define:** [Descripción]

**Clases que la implementan:**
- [Clase1]: [Por qué tiene sentido que implemente esta interface]
- [Clase2]: [Por qué tiene sentido que implemente esta interface]

### Interface 2: [NombreInterface]
[Similar al anterior]

## 3. Decisiones de Diseño

### ¿Por qué Clase Abstracta vs Interface?

**Elegí clase abstracta para [X] porque:**
- Hay relación "es-un" clara
- Necesitaba compartir estado (atributos)
- Había comportamiento común implementable

**Elegí interface para [Y] porque:**
- Define una capacidad independiente de jerarquía
- Necesitaba múltiple implementación
- Solo define contrato, no implementación

## 4. Principios SOLID Aplicados

### Single Responsibility Principle (SRP)
[Explica cómo cada clase tiene una sola responsabilidad]

### Open/Closed Principle (OCP)
[Explica cómo tu diseño está abierto a extensión pero cerrado a modificación]

### Liskov Substitution Principle (LSP)
[Explica cómo las subclases pueden sustituir a la clase abstracta]

### Interface Segregation Principle (ISP)
[Explica cómo tus interfaces son específicas y no obligan a implementar métodos innecesarios]

### Dependency Inversion Principle (DIP)
[Si aplica, explica cómo dependes de abstracciones]

## 5. Mejoras Logradas

**Antes (Semana 05):**
- [Describe cómo estaba tu código]
- [Qué problemas tenía]

**Después (Semana 06):**
- [Describe cómo está ahora]
- [Qué mejoras lograste]
- [Qué ventajas tiene el nuevo diseño]

## 6. Diagrama de Clases

[Incluye un diagrama simple en texto o imagen]

```
        <<abstract>>
      ServicioTuristico
           |
    +------+------+
    |             |
Vuelo         Hotel
|
+-- implements Reservable
+-- implements Calificable
```

## 7. Desafíos y Soluciones

**Desafío 1:** [Describe un problema que enfrentaste]
**Solución:** [Cómo lo resolviste]

**Desafío 2:** [Otro desafío]
**Solución:** [Su solución]

## 8. Próximos Pasos

[Qué podrías mejorar o agregar en el futuro]
```
# Ejercicios Semanales - Semana 07

## 📊 Distribución de Puntos

| Ejercicio | Descripción | Puntos |
|-----------|-------------|--------|
| **Ejercicio 1** | Reorganizar código en paquetes | **25 pts** |
| **Ejercicio 2** | Agregar validaciones con excepciones | **30 pts** |
| **Ejercicio 3** | Crear excepciones personalizadas | **25 pts** |
| **Ejercicio 4** | Main con demostración completa | **20 pts** |
| **TOTAL** | | **100 pts** |

---

## 📝 Ejercicio 1: Reorganización en Paquetes (25 pts)

### Objetivo
Reorganizar tu código actual en una estructura de paquetes profesional.

### Tareas

#### 1.1 Crear estructura de paquetes (10 pts)
```
src/
└── com/
    └── [tudominio]/
        ├── modelo/
        ├── servicio/
        ├── excepciones/
        └── Main.java
```

#### 1.2 Mover clases a paquetes apropiados (10 pts)
- **modelo/**: Todas las clases de entidades (Reserva, Cliente, Producto, etc.)
- **servicio/**: Clases gestoras (GestorReservas, GestorInventario, etc.)
- **excepciones/**: (vacío por ahora, se llenará en ejercicio 3)

#### 1.3 Agregar declaraciones package e imports (5 pts)
- Cada archivo debe tener `package` al inicio
- Imports necesarios para usar clases de otros paquetes

### Criterios de Evaluación
- ✅ Estructura de carpetas coincide con paquetes (5 pts)
- ✅ Declaración `package` correcta en cada archivo (5 pts)
- ✅ Imports específicos (no wildcards innecesarios) (5 pts)
- ✅ Código compila sin errores (5 pts)
- ✅ Convención de nombres (com.dominio.modulo) (5 pts)

### Ejemplo: Agencia de Viajes

**Antes (Semana 06)**:
```
src/
├── Reserva.java
├── Cliente.java
├── GestorReservas.java
└── Main.java
```

**Después (Semana 07)**:
```
src/
└── com/
    └── agencia/
        ├── modelo/
        │   ├── Reserva.java
        │   └── Cliente.java
        ├── servicio/
        │   └── GestorReservas.java
        └── Main.java
```

**Reserva.java**:
```java
package com.agencia.modelo;

import java.time.LocalDate;

public class Reserva {
    private String codigo;
    private Cliente cliente;
    private LocalDate fecha;
    private double precio;
    
    // Constructor, getters, setters, toString
}
```

**GestorReservas.java**:
```java
package com.agencia.servicio;

import com.agencia.modelo.Reserva;
import com.agencia.modelo.Cliente;
import java.util.ArrayList;

public class GestorReservas {
    private ArrayList<Reserva> reservas = new ArrayList<>();
    
    public void agregarReserva(Reserva r) {
        reservas.add(r);
    }
}
```

---

## 📝 Ejercicio 2: Validaciones con Excepciones (30 pts)

### Objetivo
Agregar validaciones robustas usando excepciones de Java.

### Tareas

#### 2.1 Identificar operaciones críticas (5 pts)
Determina qué operaciones pueden fallar:
- Agregar entidad con datos inválidos
- Buscar entidad que no existe
- Operaciones con valores negativos o null

#### 2.2 Implementar validaciones (15 pts)
Agrega validaciones que lancen excepciones:

```java
// Ejemplo: Validar precio
public void setPrice(double precio) {
    if (precio <= 0) {
        throw new IllegalArgumentException("Precio debe ser mayor a 0");
    }
    this.precio = precio;
}

// Ejemplo: Validar null
public void setCliente(Cliente cliente) {
    if (cliente == null) {
        throw new IllegalArgumentException("Cliente no puede ser null");
    }
    this.cliente = cliente;
}
```

#### 2.3 Agregar try-catch en servicio (10 pts)
Maneja excepciones en tu clase gestora:

```java
public void procesarReserva(String codigo, double precio) {
    try {
        if (precio <= 0) {
            throw new IllegalArgumentException("Precio inválido");
        }
        // Procesar reserva
        System.out.println("✅ Reserva procesada");
    } catch (IllegalArgumentException e) {
        System.err.println("❌ Error: " + e.getMessage());
    }
}
```

### Criterios de Evaluación
- ✅ Mínimo 3 validaciones con excepciones (10 pts)
- ✅ Uso de excepciones apropiadas (IllegalArgumentException, NullPointerException) (10 pts)
- ✅ Try-catch en método crítico (5 pts)
- ✅ Mensajes descriptivos en excepciones (5 pts)

---

## 📝 Ejercicio 3: Excepciones Personalizadas (25 pts)

### Objetivo
Crear excepciones específicas para tu dominio.

### Tareas

#### 3.1 Crear 2 excepciones personalizadas (10 pts)

**Ejemplo 1: Agencia de Viajes**
```java
package com.agencia.excepciones;

/**
 * Excepción lanzada cuando una reserva no cumple requisitos
 */
public class ReservaInvalidaException extends Exception {
    
    public ReservaInvalidaException(String mensaje) {
        super(mensaje);
    }
    
    public ReservaInvalidaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
```

```java
package com.agencia.excepciones;

/**
 * Excepción lanzada cuando no hay disponibilidad
 */
public class DisponibilidadException extends Exception {
    
    public DisponibilidadException(String mensaje) {
        super(mensaje);
    }
    
    public DisponibilidadException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
```

#### 3.2 Usar excepciones en servicio (10 pts)

```java
package com.agencia.servicio;

import com.agencia.modelo.*;
import com.agencia.excepciones.*;
import java.time.LocalDate;

public class GestorReservas {
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private int cupoMaximo = 10;
    
    public void agregarReserva(String codigo, Cliente cliente, LocalDate fecha, double precio)
            throws ReservaInvalidaException, DisponibilidadException {
        
        // Validar código
        if (!codigo.matches("R\\d{3}")) {
            throw new ReservaInvalidaException(
                "Código debe tener formato R### (ejemplo: R001)"
            );
        }
        
        // Validar precio
        if (precio <= 0) {
            throw new ReservaInvalidaException("Precio debe ser mayor a 0");
        }
        
        // Verificar disponibilidad
        long count = reservas.stream()
            .filter(r -> r.getFecha().equals(fecha))
            .count();
            
        if (count >= cupoMaximo) {
            throw new DisponibilidadException(
                "No hay cupo disponible para la fecha: " + fecha
            );
        }
        
        // Agregar reserva
        Reserva nueva = new Reserva(codigo, cliente, fecha, precio);
        reservas.add(nueva);
        System.out.println("✅ Reserva agregada: " + nueva);
    }
}
```

#### 3.3 Documentar con Javadoc (5 pts)
Agrega comentarios Javadoc a tus excepciones y métodos que las lanzan.

### Criterios de Evaluación
- ✅ Mínimo 2 excepciones personalizadas (checked) (10 pts)
- ✅ Nombres descriptivos terminan en "Exception" (3 pts)
- ✅ Constructores apropiados (mensaje, mensaje+causa) (5 pts)
- ✅ Uso correcto con `throw` y `throws` (5 pts)
- ✅ Documentación Javadoc (2 pts)

### Sugerencias por Dominio

| Dominio | Excepción 1 | Excepción 2 | Excepción 3 (opcional) |
|---------|-------------|-------------|------------------------|
| **Agencia Viajes** | ReservaInvalidaException | DisponibilidadException | PagoRechazadoException |
| **Restaurante** | MesaNoDisponibleException | PlatilloAgotadoException | PedidoInvalidoException |
| **Biblioteca** | LibroNoDisponibleException | PrestamoVencidoException | UsuarioSuspendidoException |
| **Tienda** | ProductoAgotadoException | CarritoVacioException | PagoInvalidoException |
| **Academia** | CupoLlenoException | MatriculaInvalidaException | NotaInvalidaException |
| **Veterinaria** | CitaNoDisponibleException | MascotaNoRegistradaException | TratamientoInvalidoException |
| **Gimnasio** | MembresiaVencidaException | ClaseLlenaException | SocioSuspendidoException |
| **Hotel** | HabitacionOcupadaException | ReservaInvalidaException | PagoIncompletoException |
| **Cine** | BoletosAgotadosException | FuncionCanceladaException | AsientoOcupadoException |
| **Transporte** | RutaNoDisponibleException | SaldoInsuficienteException | AutobusLlenoException |

---

## 📝 Ejercicio 4: Main de Demostración (20 pts)

### Objetivo
Crear un Main que demuestre el manejo completo de excepciones.

### Tareas

#### 4.1 Casos de prueba (15 pts)
Demuestra al menos 5 casos:
1. ✅ Operación exitosa
2. ❌ Excepción por validación (IllegalArgumentException)
3. ❌ Excepción personalizada 1
4. ❌ Excepción personalizada 2
5. ✅ Recuperación después de error

#### 4.2 Estructura del Main

```java
package com.agencia;

import com.agencia.modelo.*;
import com.agencia.servicio.GestorReservas;
import com.agencia.excepciones.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Gestión - Semana 07 ===\n");
        
        GestorReservas gestor = new GestorReservas();
        Cliente cliente = new Cliente("Ana García", "ana@mail.com");
        
        // Caso 1: Reserva válida ✅
        System.out.println("--- Caso 1: Reserva Válida ---");
        try {
            gestor.agregarReserva("R001", cliente, LocalDate.now(), 1500000);
        } catch (ReservaInvalidaException | DisponibilidadException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
        
        // Caso 2: Código inválido ❌
        System.out.println("\n--- Caso 2: Código Inválido ---");
        try {
            gestor.agregarReserva("ABC", cliente, LocalDate.now(), 2000000);
        } catch (ReservaInvalidaException e) {
            System.err.println("❌ Código incorrecto: " + e.getMessage());
        } catch (DisponibilidadException e) {
            System.err.println("❌ Sin disponibilidad: " + e.getMessage());
        }
        
        // Caso 3: Precio inválido ❌
        System.out.println("\n--- Caso 3: Precio Negativo ---");
        try {
            gestor.agregarReserva("R002", cliente, LocalDate.now(), -1000);
        } catch (ReservaInvalidaException e) {
            System.err.println("❌ Precio inválido: " + e.getMessage());
        } catch (DisponibilidadException e) {
            System.err.println("❌ Sin disponibilidad: " + e.getMessage());
        }
        
        // Caso 4 y 5: Demostrar más casos...
        
        System.out.println("\n✅ Semana 07 completada: Paquetes y Excepciones");
    }
}
```

#### 4.3 Finally para limpieza (5 pts)
Agrega al menos 1 ejemplo con finally:

```java
BufferedReader reader = null;
try {
    reader = new BufferedReader(new FileReader("config.txt"));
    // Leer archivo
} catch (IOException e) {
    System.err.println("Error leyendo archivo");
} finally {
    if (reader != null) {
        try {
            reader.close();
        } catch (IOException e) {
            System.err.println("Error cerrando archivo");
        }
    }
}
```

