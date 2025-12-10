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


