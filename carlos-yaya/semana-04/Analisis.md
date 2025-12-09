# Jerarquía de Clases - Semana 04

## Diagrama
         Persona
              |
        +-----+-----+
        |           |
    Cliente     Empleado

## Justificación
El motivo de haber escogido es porque  Cliente como Empleado comparten características comunes de una persona en el domino que estoy realizando. 

- Tienen nombre, teléfono e identificación
- Requieren validaciones similares para datos personales
- Comparten comportamientos básicos de información
## Atributos heredados
- nombre : (String)
- telefono: (String)
- identificacion : (String)

## Metodos Heredados
-  mostrarInformacionBasica(): Muestra datos básicos: nombre, teléfono e identificación.
- obtenerNombreCorto(): Retorna solo el primer nombre de la persona.

## Demostración de Polimorfismo
```java
Persona[] personas = new Persona[5];
personas[0] = new Cliente("Maria Lopez", "3101234567", "1023456789");
personas[1] = new Empleado("EMP-002", "Carlos Diaz", "Cargador", 60000);

// Mismo metodo, comportamiento diferente segun el tipo
for (Persona p : personas) {
    p.mostrarInformacionBasica(); // Llama a la version correcta
}
```
## Beneficios
- Reutilización: Validaciones escritas una sola vez.
- Mantenibilidad: Cambios en datos comunes solo en Persona.
- Polimorfismo: Tratar clientes y empleados como personas cuando sea necesario.
- Extensibilidad: Fácil agregar nuevos tipos de personas en el futuro.