# 📱 Agenda de Contactos con HashMap - Solución

## 📝 Descripción

Sistema completo de gestión de contactos que demuestra el uso de **HashMap** para almacenamiento eficiente y búsqueda rápida por ID, junto con otras estructuras de datos de Java Collections.

---

## 🏗️ Arquitectura del Proyecto

```
solucion/
└── src/
    ├── modelo/
    │   └── Contacto.java          # Clase de dominio
    ├── servicio/
    │   └── AgendaContactos.java   # Lógica de negocio
    ├── util/
    │   └── Validador.java         # Utilidades de validación
    └── Main.java                  # Punto de entrada con menú interactivo
```

---

## 🔑 Características Implementadas

### Operaciones Básicas
- ✅ Agregar contacto con validaciones
- ✅ Buscar por ID (O(1) - eficiencia HashMap)
- ✅ Buscar por nombre (búsqueda parcial, case-insensitive)
- ✅ Actualizar contacto existente
- ✅ Eliminar contacto con confirmación
- ✅ Listar todos los contactos

### Operaciones Avanzadas
- ✅ Buscar por categoría
- ✅ Validar email duplicado
- ✅ Contar contactos por categoría
- ✅ Estadísticas de la agenda
- ✅ Listar categorías disponibles

### Validaciones
- ✅ Formato de ID (C001, C002, etc.)
- ✅ Email único y con formato válido
- ✅ Teléfono con formato correcto
- ✅ Campos obligatorios no vacíos

---

## 💻 Compilación y Ejecución

### Opción 1: Línea de Comandos

```bash
# Compilar (desde la carpeta src/)
javac -d ../bin modelo/*.java servicio/*.java util/*.java Main.java

# Ejecutar (desde la carpeta que contiene bin/)
java -cp bin Main
```

### Opción 2: IntelliJ IDEA

1. Abrir el proyecto en IntelliJ
2. Clic derecho en `Main.java` → Run 'Main.main()'

### Opción 3: VS Code

1. Instalar Java Extension Pack
2. Abrir `Main.java`
3. Presionar `F5` o clic en "Run"

---

## 📊 Estructuras de Datos Utilizadas

### HashMap (Principal)

```java
private Map<String, Contacto> contactosPorId;
```

**Ventajas:**
- Búsqueda por ID en tiempo constante O(1)
- Inserción y eliminación eficientes
- Clave única (ID) garantizada

### ArrayList (Auxiliar)

```java
public List<Contacto> listarTodos() {
    return new ArrayList<>(contactosPorId.values());
}
```

**Uso:**
- Retornar listas de resultados
- Búsquedas que retornan múltiples elementos

### HashSet (Implícito)

```java
public Set<String> obtenerCategorias() {
    Set<String> categorias = new HashSet<>();
    // ...
}
```

**Uso:**
- Obtener categorías únicas

---

## 🔍 Análisis de Complejidad

| Operación | Complejidad | Justificación |
|-----------|-------------|---------------|
| `agregarContacto()` | O(1) | Put en HashMap |
| `buscarPorId()` | O(1) | Get en HashMap |
| `buscarPorNombre()` | O(n) | Iteración sobre valores |
| `actualizarContacto()` | O(1)* | Put + verificación email O(n) |
| `eliminarContacto()` | O(1) | Remove en HashMap |
| `listarTodos()` | O(n) | Copiar valores del Map |
| `buscarPorCategoria()` | O(n) | Filtrado sobre valores |
| `existeEmail()` | O(n) | Iteración sobre valores |

*La actualización es O(1) para el HashMap, pero O(n) si verificamos email duplicado.

---

## 📚 Conceptos de POO Aplicados

### Encapsulación
- Atributos privados en `Contacto` y `AgendaContactos`
- Métodos getters/setters controlados

### Abstracción
- Interfaz `Map<K, V>` usada en lugar de `HashMap` directamente
- Separación de responsabilidades (modelo, servicio, util)

### Reutilización
- Clase `Validador` con métodos estáticos reutilizables
- Métodos auxiliares en `AgendaContactos`

---

## 🧪 Casos de Prueba Incluidos

### Datos Precargados

El sistema incluye 5 contactos de prueba:

| ID | Nombre | Teléfono | Email | Categoría |
|----|--------|----------|-------|-----------|
| C001 | Carlos Pérez | 555-1234 | carlos@email.com | Trabajo |
| C002 | Ana García | 555-5678 | ana@email.com | Familia |
| C003 | Luis Martínez | 555-9012 | luis@email.com | Amigos |
| C004 | María López | 555-3456 | maria@email.com | Trabajo |
| C005 | Pedro Sánchez | 555-7890 | pedro@email.com | Familia |

### Pruebas Recomendadas

1. **Agregar contacto con email duplicado** → Debe rechazar
2. **Buscar por nombre parcial** ("Mar") → Debe encontrar María y Luis Martínez
3. **Actualizar teléfono del contacto C001**
4. **Buscar por categoría "Trabajo"** → Debe retornar Carlos y María
5. **Ver estadísticas** → Debe mostrar conteo por categoría

---

## 🎯 Características Destacadas

### 1. Uso Efectivo de HashMap

```java
// Búsqueda O(1)
public Contacto buscarPorId(String id) {
    return contactosPorId.get(id);
}

// Prevención de duplicados
if (contactosPorId.containsKey(contacto.getId())) {
    System.out.println("Error: ID duplicado");
    return false;
}
```

### 2. Iteración Múltiple sobre Map

```java
// Sobre valores (para búsqueda)
for (Contacto contacto : contactosPorId.values()) {
    // Procesar contacto
}

// Sobre entradas (clave-valor)
for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

### 3. Generics con Type Safety

```java
// Type-safe: solo acepta String como clave y Contacto como valor
private Map<String, Contacto> contactosPorId = new HashMap<>();

// No compilaría:
// contactosPorId.put(123, "texto");  // Error de compilación
```

### 4. Validaciones Robustas

```java
public static boolean validarEmail(String email) {
    if (!email.contains("@")) return false;
    String[] partes = email.split("@");
    return partes.length == 2 && partes[1].contains(".");
}
```

---

## 🚀 Mejoras Opcionales Implementables

### Nivel Intermedio
1. **Persistencia**: Guardar/cargar desde archivo JSON o CSV
2. **Búsqueda avanzada**: Por múltiples criterios simultáneos
3. **Ordenamiento**: Ordenar lista por nombre, categoría, etc.

### Nivel Avanzado
4. **Índices secundarios**: HashMap adicional para buscar por email
5. **Historial de cambios**: LinkedList con registro de modificaciones
6. **Grupos de contactos**: Set de IDs para agrupar contactos
7. **Importar/Exportar**: Formatos CSV, JSON, vCard

---

## 📖 Aprendizajes Clave

### HashMap
- ✅ Uso correcto de `put()`, `get()`, `remove()`, `containsKey()`
- ✅ Iteración con `values()`, `keySet()`, `entrySet()`
- ✅ Método `getOrDefault()` para contadores

### Colecciones
- ✅ Conversión Map → List con `new ArrayList<>(map.values())`
- ✅ Uso de Set para elementos únicos (categorías)
- ✅ Listas para resultados de búsqueda

### Generics
- ✅ `Map<String, Contacto>` para type safety
- ✅ `List<Contacto>` en métodos de retorno
- ✅ Sin warnings de raw types

### Buenas Prácticas
- ✅ Separación de responsabilidades (MVC simplificado)
- ✅ Validaciones centralizadas
- ✅ Mensajes claros al usuario
- ✅ equals() y hashCode() implementados correctamente

---

## 📞 Soporte

Para dudas o sugerencias:
- Revisar el código comentado (Javadoc incluido)
- Consultar material teórico de la semana 8
- Preguntar en el foro del curso

---

## 👥 Autores

**SENA - Bootcamp POO Java**  
*Semana 8: Colecciones y Programación Genérica*

---

## 📄 Licencia

Material educativo del SENA - Uso libre para aprendizaje.

---

*Última actualización: Noviembre 2024*
