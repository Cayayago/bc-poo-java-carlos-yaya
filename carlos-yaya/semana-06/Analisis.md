# Analisis de Diseno - Semana 06: Sistema de Gestion de Mudanzas


## 1. IDENTIFICACION DE ABSTRACCIONES
   
### CLASE ABSTRACTA: Persona

POR QUE ES ABSTRACTA?

- Representa un concepto general: cualquier persona en el sistema (cliente o
  empleado) comparte caracteristicas basicas pero tiene comportamientos
  operacionales diferentes.

- Comportamiento comun: Todos tienen nombre, telefono, identificacion y pueden
  mostrar su informacion basica.

- Comportamiento variable: El costo operacional se calcula de manera diferente:
    * Clientes: Costo basado en servicios contratados ($5000 por servicio)
    * Empleados: Costo basado en salario diario

- No tiene sentido instanciar "Persona" directamente, solo sus
  especializaciones concretas.

### JERARQUIA:

        <<abstract>>
           Persona
              |
        +-----+-----+
        |           |
    Cliente     Empleado


### METODO ABSTRACTO:

public abstract double calcularCostoOperacional();

Razon: Cada tipo de persona tiene una forma diferente de calcular su costo
operacional para el negocio, pero todas deben proveer este calculo.

METODOS CONCRETOS:

- mostrarInformacionBasica(): Implementacion compartida por todas las personas
- obtenerNombreCorto(): Utilidad comun reutilizable
- obtenerTipoPersona(): Metodo base sobrescribible


## 2. INTERFACES IMPLEMENTADAS

INTERFACE 1: Calificable

CAPACIDAD QUE DEFINE:
Representa la capacidad de una entidad para recibir calificaciones de
satisfaccion y calcular su nivel de calidad.

### CLASES QUE LA IMPLEMENTAN:

- Cliente:
  Tiene sentido porque los clientes reciben calificaciones despues de cada
  servicio. Esto permite medir su satisfaccion y nivel de fidelidad.

  Metodos implementados:
    * agregarCalificacion(int puntos): Registra calificacion de 1-5 estrellas
    * obtenerPromedioCalificaciones(): Calcula promedio de satisfaccion
    * obtenerTotalCalificaciones(): Cuenta servicios calificados
    * obtenerNivelCalidad(): Clasifica cliente (EXCELENTE, BUENO, REGULAR, MALO)

### JUSTIFICACION:
Los clientes que califican bien sus servicios pueden recibir descuentos o
promociones. Los que califican mal requieren atencion especial.


### INTERFACE 2: Notificable

CAPACIDAD QUE DEFINE:
Representa la capacidad de una entidad para recibir notificaciones del sistema,
tanto normales como urgentes.

CLASES QUE LA IMPLEMENTAN:

- Cliente:
  Necesita recibir notificaciones sobre confirmaciones de servicio, cambios de
  fecha, llegada de empleados, facturacion, etc.

  Metodos implementados:
    * enviarNotificacion(String): Envia mensaje normal
    * enviarNotificacionUrgente(String): Envia mensaje urgente
    * tieneNotificacionesPendientes(): Verifica si hay mensajes sin leer

- Empleado:
  Necesita recibir notificaciones sobre asignacion de servicios, cambios de
  ruta, pagos, urgencias operacionales, etc.

  Metodos implementados:
    * enviarNotificacion(String): Notifica asignaciones normales
    * enviarNotificacionUrgente(String): Notifica emergencias
    * tieneNotificacionesPendientes(): Verifica mensajes pendientes

### JUSTIFICACION:
Ambas clases necesitan comunicacion con el sistema, pero no estan relacionadas
jerarquicamente. La interface permite tratarlas de forma uniforme para el
envio de notificaciones.


## 3. DECISIONES DE DISENO
   

### POR QUE CLASE ABSTRACTA VS INTERFACE?

ELEGI CLASE ABSTRACTA PARA Persona PORQUE:

- Relacion "es-un" clara: Cliente ES UNA Persona, Empleado ES UNA Persona
- Necesitaba compartir estado (atributos): nombre, telefono, identificacion
- Habia comportamiento comun implementable: mostrarInformacionBasica(),
  obtenerNombreCorto()
- Habia un constructor comun que inicializa atributos compartidos
- Las validaciones de datos personales son identicas para ambas subclases

ELEGI INTERFACE PARA Calificable PORQUE:

- Define una capacidad independiente de jerarquia
- Solo los clientes necesitan calificaciones (no los empleados)
- No requiere estado compartido (cada clase maneja sus propias calificaciones)
- Solo define contrato de comportamiento, no implementacion
- Permite extension futura: Vehiculo podria implementar Calificable tambien

 
ELEGI INTERFACE PARA Notificable PORQUE:

- Define capacidad transversal: tanto Cliente como Empleado la necesitan
- No hay relacion jerarquica entre quien recibe notificaciones
- Permite multiple implementacion: Cliente implementa Calificable Y Notificable
- Separa responsabilidad de comunicacion del resto de la logica de negocio
- Facilita extension: Vehiculo o MovingService podrian notificarse en el futuro


### 4. PRINCIPIOS SOLID APLICADOS


SINGLE RESPONSIBILITY PRINCIPLE (SRP):

- Persona: Responsabilidad unica de gestionar datos basicos de personas
- Cliente: Responsabilidad de gestionar servicios contratados, calificaciones
  y notificaciones de clientes
- Empleado: Responsabilidad de gestionar servicios realizados, salarios y
  notificaciones de empleados
- Calificable: Responsabilidad unica de definir contrato de calificacion
- Notificable: Responsabilidad unica de definir contrato de notificaciones

Cada clase/interface tiene una razon clara para cambiar.



OPEN/CLOSED PRINCIPLE (OCP):

ABIERTO PARA EXTENSION:
- Puedo agregar nuevas subclases de Persona (ej: Proveedor, Administrador) sin
  modificar Persona
- Puedo hacer que nuevas clases implementen Calificable o Notificable sin
  modificar las interfaces
- Puedo agregar nuevos metodos concretos en Persona sin afectar subclases

CERRADO PARA MODIFICACION:
- El codigo existente en Cliente y Empleado no requiere cambios si agrego
  nuevas personas
- Los metodos abstractos garantizan que nuevas subclases cumplan el contrato
- Las interfaces definen contratos estables

Ejemplo: Si agrego clase Proveedor extends Persona, no necesito cambiar nada
en GestorMudanzas que use List<Persona>.


LISKOV SUBSTITUTION PRINCIPLE (LSP):

Las subclases pueden sustituir a Persona sin romper funcionalidad:

Ejemplo:
public void procesarPersona(Persona p) {
double costo = p.calcularCostoOperacional(); // Funciona con Cliente o Empleado
p.mostrarInformacionBasica();                // Funciona correctamente
}

Cliente cliente = new Cliente(...);
Empleado empleado = new Empleado(...);

procesarPersona(cliente);  // OK - se comporta como Persona
procesarPersona(empleado); // OK - se comporta como Persona

Ambas subclases cumplen el contrato de Persona sin violar expectativas.


INTERFACE SEGREGATION PRINCIPLE (ISP):

Las interfaces son especificas y no obligan a implementar metodos innecesarios:

- Calificable: Solo 4 metodos relacionados con calificaciones
    * No incluye metodos de notificaciones
    * Solo implementada por entidades que necesitan ser calificadas

- Notificable: Solo 3 metodos relacionados con notificaciones
    * No incluye metodos de calificaciones
    * Implementada por entidades que necesitan comunicacion

Si hubiera creado una interface gigante "Gestionable" con calificaciones Y
notificaciones, Empleado tendria que implementar metodos de calificacion que
no usa. ISP evita esto.


DEPENDENCY INVERSION PRINCIPLE (DIP):

El codigo depende de abstracciones, no de implementaciones concretas:

Ejemplo en GestorMudanzas:
public void procesarPersonas(List<Persona> personas) {
// Depende de la abstraccion Persona, no de Cliente o Empleado
for (Persona p : personas) {
p.calcularCostoOperacional();
}
}

Ejemplo con interfaces:
public void notificarTodos(List<Notificable> entidades, String mensaje) {
// Depende de la interface Notificable, no de clases concretas
for (Notificable n : entidades) {
n.enviarNotificacion(mensaje);
}
}

Esto permite cambiar implementaciones sin afectar el codigo de alto nivel.

## 5. MEJORAS LOGRADAS


ANTES (SEMANA 05):

- Persona era clase concreta normal
- Cliente y Empleado tenian codigo duplicado en validaciones
- No habia forma uniforme de calcular costos operacionales
- No existia sistema de calificaciones
- No existia sistema de notificaciones
- No se aprovechaba polimorfismo basado en capacidades

Problemas:
- Duplicacion de codigo
- Falta de flexibilidad para nuevas funcionalidades
- Dificil agregar nuevos tipos de personas
- No habia separacion de responsabilidades por capacidades



DESPUES (SEMANA 06):

- Persona es clase abstracta con comportamiento comun y metodo abstracto
- Cliente y Empleado heredan validaciones sin duplicacion
- Metodo abstracto calcularCostoOperacional() obliga implementacion especifica
- Sistema de calificaciones completo en Cliente via interface Calificable
- Sistema de notificaciones en Cliente y Empleado via interface Notificable
- Codigo mas organizado y extensible

Ventajas del nuevo diseno:

1. REUTILIZACION: Codigo comun en Persona, especializado en subclases

2. FLEXIBILIDAD: Facil agregar Proveedor extends Persona sin tocar otras clases

3. CONTRATOS CLAROS: Metodos abstractos garantizan que subclases implementen
   comportamiento necesario

4. MULTIPLE CAPACIDADES: Cliente puede ser Calificable Y Notificable
   simultaneamente

5. POLIMORFISMO MEJORADO: Puedo usar referencias de tipo Persona, Calificable
   o Notificable segun necesidad

6. MANTENIBILIDAD: Cambios en Persona se heredan automaticamente

7. TESTABILIDAD: Interfaces facilitan crear mocks para pruebas

================================================================================
6. DIAGRAMA DE CLASES
   ================================================================================

        <<abstract>>
           Persona
        - nombre: String
        - telefono: String
        - identificacion: String
        + mostrarInformacionBasica(): void
        + obtenerNombreCorto(): String
        + calcularCostoOperacional(): double {abstract}
              |
        +-----+-----+
        |           |
   Cliente     Empleado
    - email          - codigoEmpleado
    - historial      - cargo
    - calificaciones - salarioDiario
    - notificaciones - ocupado
      - notificaciones
      |           |
      |           |
      |           +-- implements Notificable
      |
      +-- implements Calificable
      +-- implements Notificable


    <<interface>>         <<interface>>
    Calificable           Notificable
    + agregarCalificacion()    + enviarNotificacion()
    + obtenerPromedio()        + enviarNotificacionUrgente()
    + obtenerTotal()           + tieneNotificacionesPendientes()
    + obtenerNivelCalidad()


RELACIONES:

- Persona (abstracta) <|-- Cliente (concreta)
- Persona (abstracta) <|-- Empleado (concreta)
- Cliente ..|> Calificable (implementa)
- Cliente ..|> Notificable (implementa)
- Empleado ..|> Notificable (implementa)

LEYENDA:
<|--  : Herencia
..|>  : Implementacion de interface


## 7. DESAFIOS Y SOLUCIONES
   
DESAFIO 1: Decidir que deberia ser abstracto

Problema inicial: No estaba claro si Persona debia ser abstracta o si debia
crear otra abstraccion diferente.

Analisis:
- Persona es concepto general que nunca se instancia solo
- Cliente y Empleado siempre son especializaciones
- Necesitaba forzar implementacion de calcularCostoOperacional()

Solucion: Convertir Persona en abstracta con metodo abstracto
calcularCostoOperacional(). Esto obliga a cada subclase a definir su propia
logica de calculo de costos.


DESAFIO 2: Decidir que debia ser interface vs metodo en clase abstracta

Problema inicial: Podia poner agregarCalificacion() como metodo abstracto en
Persona, obligando a todos a implementarlo.

Analisis:
- Empleados NO necesitan calificaciones
- Obligar a Empleado a implementar metodos de calificacion violaria ISP
- Calificacion es una CAPACIDAD opcional, no parte esencial de ser Persona

Solucion: Crear interface Calificable separada. Solo Cliente la implementa.
Esto mantiene Persona limpia y permite que cada clase tenga solo las
capacidades que necesita.



DESAFIO 3: Evitar duplicacion en implementacion de Notificable

Problema inicial: Cliente y Empleado implementan Notificable de forma casi
identica. Parecia duplicacion de codigo.

Analisis:
- No puedo poner codigo de notificaciones en Persona (no todas las personas
  necesitan notificaciones)
- No puedo hacer herencia multiple en Java
- La logica de notificaciones es especifica de cada clase

Solucion: Aceptar cierta duplicacion porque:
1. Es codigo simple (3 metodos cortos)
2. Mantiene bajo acoplamiento
3. Cada clase puede personalizar notificaciones en el futuro
4. Interfaces definen COMPORTAMIENTO, no implementacion compartida

Alternativa futura: Crear clase NotificacionManager que ambas usen
(composition over inheritance).



DESAFIO 4: Mantener compatibilidad con codigo de semanas anteriores

Problema inicial: Convertir Persona en abstracta rompia instanciaciones
directas de Persona en Main (si existieran).

Analisis:
- Revise todo el codigo existente
- Persona solo se usaba como tipo de referencia, nunca se instanciaba
  directamente
- Todos los objetos eran Cliente o Empleado

Solucion: El cambio fue transparente. List<Persona> sigue funcionando porque
puede contener subclases concretas. No requirio cambios en codigo existente.

