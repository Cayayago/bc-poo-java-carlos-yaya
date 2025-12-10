# Polimorfismo

## SOBRECARGA (OVERLOADING)
  

### METODOS SOBRECARGADOS EN GestorMudanzas.java:

1. buscarServicio()
    - buscarServicio(String codigo)
    - buscarServicio(Cliente cliente)
    - buscarServicio(LocalDate fechaInicio, LocalDate fechaFin)

2. calcularTarifa()
    - calcularTarifa(double capacidadM3)
    - calcularTarifa(Vehiculo vehiculo)
    - calcularTarifa(Vehiculo vehiculo, double distanciaKm)

3. registrar()
    - registrar(Persona persona)
    - registrar(List<Persona> personas)

### JUSTIFICACION:

buscarServicio():
Los usuarios necesitan buscar servicios de diferentes maneras segun su necesidad:
- Por codigo: Cuando conocen el numero exacto del servicio
- Por cliente: Para ver historial completo de un cliente especifico
- Por fechas: Para reportes mensuales o analisis de periodos

calcularTarifa():
La tarifa se puede calcular en diferentes contextos:
- Por capacidad: Para cotizaciones rapidas sin vehiculo asignado
- Por vehiculo: Cuando ya hay un vehiculo seleccionado
- Por vehiculo + distancia: Para calculo final con ruta definida

registrar():
Flexibilidad en registro:
- Una persona: Registro individual normal
- Lista de personas: Importacion masiva o registro de equipos completos

Ventaja: El mismo nombre de metodo funciona para diferentes situaciones,
haciendo el codigo mas intuitivo.

## SOBRESCRITURA (OVERRIDING)


### METODOS SOBRESCRITOS CON @Override:

1. obtenerTipoPersona()

```java
Persona (padre):
public String obtenerTipoPersona() {
return "Persona generica";
}

Cliente (subclase):
@Override
public String obtenerTipoPersona() {
return "Cliente";
}

Empleado (subclase):
@Override
public String obtenerTipoPersona() {
return "Empleado";
}
```
2. mostrarInformacionBasica()
```java
Persona (padre):
public void mostrarInformacionBasica() {
System.out.println("Nombre: " + nombre);
System.out.println("Telefono: " + telefono);
System.out.println("ID: " + identificacion);
}

Cliente (subclase):
@Override
public void mostrarInformacionBasica() {
System.out.println("=== INFORMACION DEL CLIENTE ===");
super.mostrarInformacionBasica();
if (email != null) {
System.out.println("Email: " + email);
}
System.out.println("Servicios contratados: " + historialServicios.size());
}

Empleado (subclase):
@Override
public void mostrarInformacionBasica() {
System.out.println("=== INFORMACION DEL EMPLEADO ===");
System.out.println("Codigo: " + codigoEmpleado);
super.mostrarInformacionBasica();
System.out.println("Cargo: " + cargo);
System.out.println("Salario diario: $" + salarioDiario);
System.out.println("Estado: " + (ocupado ? "OCUPADO" : "DISPONIBLE"));
}
```

3. toString()
```java
Persona (padre):
@Override
public String toString() {
return nombre + " (ID: " + identificacion + ")";
}

Cliente (subclase):
@Override
public String toString() {
String emailInfo = email != null ? " | Email: " + email : "";
return "Cliente: " + nombre + " | Tel: " + telefono +
" | ID: " + identificacion + emailInfo +
" | Servicios: " + historialServicios.size();
}

Empleado (subclase):
@Override
public String toString() {
String estado = ocupado ? "OCUPADO" : "DISPONIBLE";
return "Empleado " + codigoEmpleado + " | " + nombre +
" | " + cargo + " | $" + salarioDiario + "/dia | " + estado +
" | Servicios: " + serviciosRealizados.size();
}
```

### TABLA COMPARATIVA:

Metodo                      | Persona (Padre)           | Cliente                              | Empleado
---------------------------|---------------------------|--------------------------------------|------------------------------------------
obtenerTipoPersona()       | "Persona generica"        | "Cliente"                            | "Empleado"
mostrarInformacionBasica() | nombre, telefono, ID      | Agrega: titulo, email, servicios     | Agrega: titulo, codigo, cargo, salario
toString()                 | nombre + ID               | Prefijo "Cliente:", email, servicios | Prefijo "Empleado", codigo, cargo, estado


## POLIMORFISMO DINAMICO (DYNAMIC BINDING)


### EJEMPLO DE CODIGO:
```java
// ArrayList polimorfico - almacena tipo Persona (padre)
List<Persona> todasLasPersonas = new ArrayList<>();
todasLasPersonas.add(new Cliente("Ana Garcia", "3001234567", "1012345678"));
todasLasPersonas.add(new Empleado("EMP-001", "Juan Rojas", "Conductor", 80000));
todasLasPersonas.add(new Cliente("Roberto Sanchez", "3109876543", "1087654321"));
todasLasPersonas.add(new Empleado("EMP-002", "Maria Lopez", "Cargadora", 60000));

// Dynamic Binding - el metodo correcto se llama segun el tipo real del objeto
for (Persona p : todasLasPersonas) {
System.out.println(p.obtenerTipoPersona()); // Llama a Cliente o Empleado
p.mostrarInformacionBasica();               // Llama a la version correcta
}
```

### EXPLICACION:

Como funciona en el sistema:

1. Declaracion polimorfica:
    - Variable de tipo Persona (padre)
    - Puede almacenar objetos Cliente o Empleado (hijos)

2. Enlace dinamico (Dynamic Binding):
    - En tiempo de compilacion: Java sabe que p es tipo Persona
    - En tiempo de ejecucion: Java determina el tipo real (Cliente o Empleado)
    - Llama al metodo correcto segun el tipo real del objeto

3. Ejemplo practico:

Persona p1 = new Cliente("Ana", "3001234567", "123456");
Persona p2 = new Empleado("EMP-001", "Juan", "Conductor", 80000);

p1.obtenerTipoPersona(); // Retorna "Cliente" (no "Persona generica")
p2.obtenerTipoPersona(); // Retorna "Empleado" (no "Persona generica")

Resultado: Aunque ambos son tipo Persona, cada uno ejecuta su propia version
del metodo.

### METODOS POLIMORFICOS:
```java
// Metodo que acepta tipo padre (Persona)
public void mostrarDetallesPersona(Persona persona) {
persona.mostrarInformacionBasica(); // Dynamic binding aqui
System.out.println("Tipo: " + persona.obtenerTipoPersona());
}

// Funciona con cualquier subclase
mostrarDetallesPersona(cliente1);  // Llama a Cliente.mostrarInformacionBasica()
mostrarDetallesPersona(empleado1); // Llama a Empleado.mostrarInformacionBasica()
```
## BENEFICIOS
   

### VENTAJAS OBTENIDAS CON POLIMORFISMO:

1. Flexibilidad:
    - Un solo ArrayList puede almacenar diferentes tipos de personas
    - No necesito listas separadas para clientes y empleados

2. Codigo reutilizable:
```java
// Un metodo funciona para todos
   public void procesarPersonas(List<Persona> personas) {
   for (Persona p : personas) {
   p.mostrarInformacionBasica(); // Funciona para Cliente y Empleado
   }
   }
```
3. Extensibilidad:
    - Si agrego una nueva clase Proveedor extends Persona:
    - No necesito cambiar metodos existentes
    - Automaticamente funciona con List<Persona>

4. Mantenibilidad:
    - Cambios en comportamiento especifico se hacen solo en la subclase
    - No afecta codigo que usa polimorfismo

5. Abstraccion:
    - Puedo trabajar con "personas" sin importar si son clientes o empleados
    - Simplifica logica de negocio

### QUE SERIA DIFICIL SIN POLIMORFISMO:

### Sin polimorfismo tendriamos:

1. Duplicacion de codigo:
```java
// SIN polimorfismo - codigo duplicado
public void procesarClientes(List<Cliente> clientes) {
for (Cliente c : clientes) {
c.mostrarInformacionBasica();
    }
}

public void procesarEmpleados(List<Empleado> empleados) {
for (Empleado e : empleados) {
e.mostrarInformacionBasica();
    }
}

// CON polimorfismo - un solo metodo
public void procesarPersonas(List<Persona> personas) {
for (Persona p : personas) {
p.mostrarInformacionBasica();
    }
}
```
2. Condicionales complejos:
```java
// SIN polimorfismo
if (tipo.equals("Cliente")) {
Cliente c = (Cliente) obj;
c.mostrarInformacionCliente();
} else if (tipo.equals("Empleado")) {
Empleado e = (Empleado) obj;
e.mostrarInformacionEmpleado();
}

// CON polimorfismo
persona.mostrarInformacionBasica(); // El objeto sabe que hacer
```

3. Dificultad para extender:
    - Cada nueva clase requiere modificar todos los metodos existentes
    - Viola el principio Open/Closed

4. Codigo dificil de mantener:
    - Cambios en una clase requieren buscar todos los lugares donde se usa
    - Mayor riesgo de errores

5. Busquedas complicadas:
```java
// SIN polimorfismo - necesito multiples metodos
buscarServicioPorCodigoString(String codigo)
buscarServicioPorObjetoCliente(Cliente cliente)
buscarServicioPorRangoDeFechas(LocalDate inicio, LocalDate fin)

// CON polimorfismo (sobrecarga) - mismo nombre, diferentes parametros
buscarServicio(String codigo)
buscarServicio(Cliente cliente)
buscarServicio(LocalDate inicio, LocalDate fin)
```

## RESUMEN


El polimorfismo en el Sistema de Gestion de Mudanzas permite:

- Sobrecarga: Mismo metodo, multiples formas de usarlo segun parametros
- Sobrescritura: Comportamiento especializado en cada subclase
- Dynamic Binding: El metodo correcto se ejecuta segun el tipo real del objeto
- Codigo limpio: Menos duplicacion, mas reutilizacion
- Extensibilidad: Facil agregar nuevos tipos sin romper codigo existente

Resultado: Sistema flexible, mantenible y profesional que aprovecha los
principios de POO.
