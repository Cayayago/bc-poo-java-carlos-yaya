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

---

## 📅 Fecha de Entrega

**Entrega:** Según calendario definido por el instructor  
**Formato:** Código fuente (.java) y documentos en formato Markdown o PDF

---

**Nota Importante:** Este es tu dominio personal para todo el bootcamp. Todas las actividades futuras seguirán en el contexto de la empresa de mudanzas Traslados Seguros. No compartas tu código directamente con otros estudiantes, ya que cada uno tiene un dominio diferente.
