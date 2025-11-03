# Solución Taller Preparatorio - Gestión de Vehículos

## 🎯 Descripción

Sistema completo de gestión de vehículos que implementa todos los principios de POO.

## 📂 Estructura

```
src/
├── modelo/
│   ├── Vehiculo.java        (Clase abstracta)
│   ├── Auto.java
│   ├── Moto.java
│   └── Camion.java
├── servicio/
│   └── VehiculoServicio.java (CRUD + HashMap)
├── excepciones/
│   ├── VehiculoNoEncontradoException.java
│   └── PlacaDuplicadaException.java
└── Main.java (Menú interactivo)
```

## ✅ Conceptos Implementados

### Encapsulación
- Atributos privados en todas las clases
- Getters/setters con validaciones
- Ejemplo: `setNumeroPuertas()` valida rango 2-5

### Herencia
- `Vehiculo` (abstracta) → `Auto`, `Moto`, `Camion`
- Constructor `super()` en clases hijas
- Atributos compartidos en padre

### Polimorfismo
- Método abstracto `calcularCostoMantenimiento()`
- Cada clase calcula su costo específico
- Colecciones polimórficas `Map<String, Vehiculo>`

### Abstracción
- Clase abstracta `Vehiculo` define contrato
- Métodos concretos + abstractos
- toString() para representación común

### Colecciones
- `HashMap<String, Vehiculo>` para búsquedas O(1) por placa
- Métodos: put, get, containsKey, values()

### Excepciones
- `VehiculoNoEncontradoException` para búsquedas fallidas
- `PlacaDuplicadaException` para validar unicidad
- Try-catch en Main para manejo

## 🚀 Compilación y Ejecución

### Compilar
```bash
javac -d bin src/modelo/*.java src/excepciones/*.java src/servicio/*.java src/Main.java
```

### Ejecutar
```bash
java -cp bin Main
```

## 📝 Uso del Sistema

1. **Registrar**: Crea Auto, Moto o Camión con datos
2. **Buscar**: Encuentra vehículo por placa
3. **Listar**: Muestra todos los vehículos con costos
4. **Actualizar**: Modifica datos de vehículo existente
5. **Eliminar**: Borra vehículo con confirmación

## 💡 Observaciones Clave

- **HashMap** permite búsquedas rápidas vs ArrayList (iterar todo)
- **Validaciones** en setters previenen datos inválidos
- **Excepciones** distinguen errores de negocio vs técnicos
- **Abstracción** fuerza implementación de calcularCosto en hijas

## 🎓 Para tu Proyecto Final

Puedes reutilizar:
- ✅ Estructura de paquetes
- ✅ Manejo de excepciones
- ✅ Patrón de servicio con HashMap
- ✅ Menú interactivo con Scanner
- ✅ Validaciones en setters

Debes adaptar:
- 🔄 Dominio (Biblioteca, Hospital, Tienda, etc.)
- 🔄 Entidades específicas (Libro, Paciente, Producto, etc.)
- 🔄 Lógica de negocio (calcular multas, diagnósticos, etc.)
- 🔄 Atributos y métodos según tu contexto

---

**Próximo paso**: [Proyecto Final](../proyecto-final/enunciado/ENUNCIADO.md)
