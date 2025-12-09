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