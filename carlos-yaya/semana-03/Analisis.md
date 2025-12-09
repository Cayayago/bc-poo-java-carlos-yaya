# Mejoras semana 3
## Encapsulación Completa
### Cambios Realizados

- Todos los atributos cambiados de public a private
- Implementados getters para acceso de lectura
- Implementados setters con validación para escritura
- Colecciones retornan copias defensivas

### Por Clase

- Cliente: 5 atributos privados, 5 getters, 4 setters
- Vehiculo: 6 atributos privados, 6 getters, 5 setters
- Empleado: 7 atributos privados, 7 getters, 6 setters
- MovingService: 7 atributos privados, 7 getters, 5 setters

## Multiples constructores

En la realización de constructores se realizarón los siguientes cambios:


**Cliente**
```java
Cliente(nombre, telefono, identificacion);
Cliente(nombre, telefono, identificacion, email);
```

**Vehiculo**
```java
Vehiculo(placa, tipo, capacidad);
Vehiculo(placa, tipo, capacidad, anioFabricacion);
```

**Empleado**
```java
Empleado(codigo, nombre, cargo, salario);
Empleado(codigo, nombre, cargo, salario, telefono);
```
**MovingService**
```java
MovingService(codigo, origen, destino);
MovingService(codigo, origen, destino, fecha);
```
## Validaciones implementadas
### Validaciones de formato

- Nombre: 3-100 caracteres
- Teléfono: 10 dígitos exactos
- Email: formato usuario@dominio.com
- Placa: ABC-123 o ABC123
- Códigos: EMP-### o MOV-###
- Identificación: Solo números, 5-15 caracteres

### Validaciones de Rango

- Salario: $50,000 - $1,000,000
- Capacidad: 1-100 m³
- Año Fabricación: 1990-2025
- Fecha Servicio: No puede ser pasada

## Beneficios
### Seguridad

- Datos siempre válidos
- Estado interno protegido
- Detección temprana de errores

### Flexibilidad

- Múltiples formas de crear objetos
- Atributos opcionales

### Mantenibilidad

- Código limpio y organizado
- Validaciones centralizadas

### Confiabilidad

- Prevención de estados inválidos
- Mensajes de error descriptivos