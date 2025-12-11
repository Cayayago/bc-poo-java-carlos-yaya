¡PERFECTO! 🚀 Aquí está tu README.md para la Semana 7:

# Sistema de Gestion de Mudanzas - Traslados Seguros

**Estudiante:** Carlos Javier Yaya Gomez  
**Ficha:** 3228973A  
**Semana:** 7 - Paquetes y Excepciones


## DESCRIPCION DEL DOMINIO


TRASLADOS SEGUROS es un sistema de gestion para una empresa de mudanzas que
administra servicios de traslado de bienes y pertenencias.

### ENTIDADES PRINCIPALES:

1. Persona (Clase Abstracta)
    - Representa cualquier persona en el sistema
    - Subclases: Cliente y Empleado

2. Cliente
    - Personas que contratan servicios de mudanza
    - Pueden recibir calificaciones de satisfaccion
    - Reciben notificaciones sobre sus servicios

3. Empleado
    - Personal que realiza las mudanzas
    - Tienen codigos, cargos y salarios
    - Reciben notificaciones de asignaciones

4. Vehiculo
    - Camiones y camionetas para transportar
    - Capacidades variables (m3)
    - Tarifas segun capacidad

5. MovingService
    - Servicio de mudanza especifico
    - Origen y destino
    - Cliente, vehiculo y equipo asignado

6. GestorMudanzas
    - Administra todas las entidades del sistema
    - Registro, busqueda y reportes


### ESTRUCTURA DE PAQUETES


    co.edu.sena.traslados_seguros/
    ├── modelos/
    │   ├── Persona.java (abstracta)
    │   ├── Cliente.java
    │   ├── Empleado.java
    │   ├── Vehiculo.java
    │   └── MovingService.java
    │
    ├── interfaces/
    │   ├── Calificable.java
    │   └── Notificable.java
    │
    ├── gestores/
    │   └── GestorMudanzas.java
    │
    ├── excepciones/
    │   ├── DatosInvalidosException.java
    │   ├── EntidadNoEncontradaException.java
    │   └── OperacionInvalidaException.java
    │
    └── Main.java

JUSTIFICACION DE ORGANIZACION:

- modelos/: Contiene las clases de dominio del negocio
- interfaces/: Agrupa capacidades compartidas entre clases
- gestores/: Logica de administracion y operaciones CRUD
- excepciones/: Manejo de errores especificos del dominio


## EXCEPCIONES PERSONALIZADAS

1. DatosInvalidosException
    - Extends: Exception (Checked Exception)
    - Uso: Validacion de datos de entrada

   CUANDO SE LANZA:
    - Intentar registrar entidad con datos invalidos
    - Registrar entidad duplicada (mismo ID/codigo/placa)
    - Valores fuera de rangos permitidos
    - Formato incorrecto de datos

   EJEMPLOS:
    * "Cliente con ID 1012345678 ya existe"
    * "Vehiculo con placa ABC-123 ya existe"
    * "Empleado no puede ser nulo"



2. EntidadNoEncontradaException
    - Extends: Exception (Checked Exception)
    - Uso: Busqueda de entidades inexistentes

   CUANDO SE LANZA:
    - Buscar cliente por ID que no existe
    - Buscar empleado por codigo inexistente
    - Buscar vehiculo por placa no registrada
    - Buscar servicio por codigo invalido

   EJEMPLOS:
    * "Cliente con ID 999999999 no encontrado"
    * "Vehiculo con placa XXX-000 no encontrado"
    * "Empleado con codigo EMP-999 no encontrado"



3. OperacionInvalidaException
    - Extends: Exception (Checked Exception)
    - Uso: Operaciones que violan reglas de negocio

   CUANDO SE LANZA:
    - Asignar vehiculo que no esta disponible
    - Asignar empleado que ya esta ocupado
    - Calcular tarifa con valores negativos
    - Operaciones sobre entidades nulas

   EJEMPLOS:
    * "Vehiculo ABC-123 no esta disponible"
    * "Empleado ya esta ocupado"
    * "Distancia no puede ser negativa"
    * "Capacidad debe ser mayor a 0"


## OPERACIONES CRITICAS CON EXCEPCIONES


OPERACION 1: Registro de Entidades

public void registrarCliente(Cliente cliente) throws DatosInvalidosException {
if (cliente == null) {
throw new DatosInvalidosException("Cliente no puede ser nulo");
}
if (buscarClientePorId(cliente.getIdentificacion()) != null) {
throw new DatosInvalidosException("Cliente ya existe");
}
clientes.add(cliente);
}

VALIDACIONES:
- Entidad no nula
- No duplicados
- Datos validos segun reglas de negocio


OPERACION 2: Busqueda con Error

public Cliente buscarClientePorIdOError(String id)
throws EntidadNoEncontradaException {
Cliente cliente = buscarClientePorId(id);
if (cliente == null) {
throw new EntidadNoEncontradaException("Cliente con ID " + id +
" no encontrado");
}
return cliente;
}

VALIDACIONES:
- ID no nulo
- Entidad existe en sistema
- Retorna entidad o lanza excepcion


OPERACION 3: Calculo de Tarifas

public double calcularTarifa(Vehiculo vehiculo, double distanciaKm)
throws OperacionInvalidaException {
if (vehiculo == null) {
throw new OperacionInvalidaException("Vehiculo no puede ser nulo");
}
if (distanciaKm < 0) {
throw new OperacionInvalidaException("Distancia no puede ser negativa");
}
return vehiculo.calcularTarifaBase() + (distanciaKm * 2000);
}

VALIDACIONES:
- Vehiculo no nulo
- Distancia no negativa
- Calculo seguro


OPERACION 4: Asignacion de Servicios

public void asignarServicio(MovingService servicio) {
if (servicio == null) {
throw new IllegalArgumentException("Servicio no puede ser nulo");
}
if (this.ocupado) {
throw new IllegalArgumentException("Empleado ya esta ocupado");
}
this.ocupado = true;
agregarServicioAlHistorial(servicio);
}

VALIDACIONES:
- Servicio no nulo
- Empleado disponible
- Estado consistente


## MANEJO DE EXCEPCIONES EN MAIN


PATRON 1: Try-Catch Simple

try {
gestor.registrarCliente(cliente);
} catch (DatosInvalidosException e) {
System.out.println("ERROR: " + e.getMessage());
}


PATRON 2: Multiple Catch

try {
Vehiculo v = gestor.buscarVehiculoPorPlacaOError("ABC-123");
double tarifa = gestor.calcularTarifa(v, 100);
} catch (EntidadNoEncontradaException e) {
System.out.println("ERROR ENTIDAD: " + e.getMessage());
} catch (OperacionInvalidaException e) {
System.out.println("ERROR OPERACION: " + e.getMessage());
}


PATRON 3: Try-Catch-Finally (Limpieza de Recursos)

Vehiculo vehiculoTemp = null;
try {
vehiculoTemp = new Vehiculo("XYZ-999", "Camion", 150.0);
} catch (IllegalArgumentException e) {
System.out.println("ERROR: " + e.getMessage());
} finally {
System.out.println("FINALLY: Limpieza de recursos");
// Codigo de limpieza siempre se ejecuta
}

BENEFICIO: El bloque finally se ejecuta siempre, incluso si hay excepcion.
Util para: cerrar archivos, liberar recursos, logging.


PATRON 4: Multi-Catch con Exception General

try {
// Operaciones multiples
} catch (DatosInvalidosException | EntidadNoEncontradaException e) {
System.out.println("ERROR ESPECIFICO: " + e.getMessage());
} catch (Exception e) {
System.out.println("ERROR INESPERADO: " + e.getMessage());
}


## VALIDACIONES IMPLEMENTADAS


VALIDACIONES EN MODELOS:

Cliente:
- Nombre: 3-100 caracteres
- Telefono: 10 digitos exactos
- Email: formato usuario@dominio.com
- Identificacion: 5-15 caracteres numericos

Empleado:
- Codigo: formato EMP-### (3 digitos)
- Nombre: 3-100 caracteres
- Cargo: 3-50 caracteres
- Salario: $50,000 - $1,000,000

Vehiculo:
- Placa: formato ABC-123 o ABC123
- Tipo: 3-50 caracteres
- Capacidad: 1-100 m3
- Año: 1990-2025

MovingService:
- Codigo: formato MOV-### (3 digitos)
- Origen/Destino: 5-200 caracteres
- Fecha: no puede ser pasada

VALIDACIONES EN GESTOR:

- No registrar duplicados
- No buscar con IDs nulos
- No calcular con valores negativos
- No asignar entidades nulas
- No operar sobre entidades inexistentes

### FLUJO DE MANEJO DE ERRORES


    1. ENTRADA DE DATOS
       └─> Validacion en Setters
       └─> IllegalArgumentException (unchecked)
    
       2. REGISTRO EN SISTEMA
          └─> Validacion en Gestor
          └─> DatosInvalidosException (checked)
    
       3. BUSQUEDA DE ENTIDADES
          └─> Validacion de existencia
          └─> EntidadNoEncontradaException (checked)
    
       4. OPERACIONES DE NEGOCIO
          └─> Validacion de reglas
          └─> OperacionInvalidaException (checked)
    
       5. CAPTURA EN MAIN
          └─> Try-Catch especificos
          └─> Mensajes descriptivos al usuario


### BENEFICIOS DEL MANEJO DE EXCEPCIONES


1. ROBUSTEZ
    - Sistema no se cae ante datos invalidos
    - Errores controlados y descriptivos
    - Flujo predecible

2. MANTENIBILIDAD
    - Excepciones personalizadas facilitan debugging
    - Codigo mas limpio sin validaciones repetitivas
    - Separacion de logica de negocio y manejo de errores

3. EXPERIENCIA DE USUARIO
    - Mensajes de error claros y especificos
    - Sistema informa que salio mal
    - Usuario puede corregir errores facilmente

4. INTEGRIDAD DE DATOS
    - Imposible registrar datos invalidos
    - Estado consistente en todo momento
    - Validaciones garantizadas

5. DOCUMENTACION
    - Javadoc describe cuando se lanzan excepciones
    - Contratos claros en metodos
    - Codigo auto-documentado


### CONCLUSIONES

La implementacion de paquetes y excepciones en la Semana 7 logro:

1. ORGANIZACION PROFESIONAL
    - Codigo estructurado en paquetes logicos
    - Separacion de responsabilidades clara
    - Facil navegacion y mantenimiento

2. MANEJO ROBUSTO DE ERRORES
    - Tres excepciones personalizadas documentadas
    - Validaciones exhaustivas en operaciones criticas
    - Mensajes descriptivos y accionables

3. INTEGRIDAD DEL SISTEMA
    - Imposible crear estados invalidos
    - Datos siempre consistentes
    - Operaciones seguras

4. CODIGO PROFESIONAL
    - Javadoc completo en excepciones
    - Imports organizados
    - Cumple estandares de la industria
