package servicio;

import modelo.*;
import excepciones.*;
import java.util.*;

/**
 * Servicio para gestionar vehículos.
 * Usa HashMap para almacenar y buscar vehículos por placa.
 */
public class VehiculoServicio {
  private Map<String, Vehiculo> vehiculos;

  public VehiculoServicio() {
    this.vehiculos = new HashMap<>();
  }

  /**
   * Agrega un vehículo al sistema.
   * 
   * @param vehiculo Vehículo a agregar
   * @throws PlacaDuplicadaException Si la placa ya existe
   */
  public void agregar(Vehiculo vehiculo) throws PlacaDuplicadaException {
    if (vehiculo == null) {
      throw new IllegalArgumentException("El vehículo no puede ser null");
    }

    String placa = vehiculo.getPlaca();
    if (vehiculos.containsKey(placa)) {
      throw new PlacaDuplicadaException(placa);
    }

    vehiculos.put(placa, vehiculo);
    System.out.println("✅ Vehículo agregado exitosamente");
  }

  /**
   * Busca un vehículo por placa.
   * 
   * @param placa Placa a buscar
   * @return Vehículo encontrado
   * @throws VehiculoNoEncontradoException Si no existe
   */
  public Vehiculo buscar(String placa) throws VehiculoNoEncontradoException {
    if (placa == null || placa.trim().isEmpty()) {
      throw new IllegalArgumentException("La placa no puede estar vacía");
    }

    Vehiculo vehiculo = vehiculos.get(placa.toUpperCase());
    if (vehiculo == null) {
      throw new VehiculoNoEncontradoException(placa);
    }

    return vehiculo;
  }

  /**
   * Lista todos los vehículos.
   */
  public void listar() {
    if (vehiculos.isEmpty()) {
      System.out.println("⚠️  No hay vehículos registrados");
      return;
    }

    System.out.println("\n📋 LISTADO DE VEHÍCULOS (" + vehiculos.size() + ")");
    System.out.println("=".repeat(80));

    for (Vehiculo v : vehiculos.values()) {
      System.out.println(v);
    }
  }

  /**
   * Actualiza un vehículo existente.
   * 
   * @param placa         Placa del vehículo a actualizar
   * @param nuevoVehiculo Nuevos datos del vehículo
   * @throws VehiculoNoEncontradoException Si no existe
   */
  public void actualizar(String placa, Vehiculo nuevoVehiculo)
      throws VehiculoNoEncontradoException {
    if (!vehiculos.containsKey(placa.toUpperCase())) {
      throw new VehiculoNoEncontradoException(placa);
    }

    vehiculos.put(placa.toUpperCase(), nuevoVehiculo);
    System.out.println("✅ Vehículo actualizado exitosamente");
  }

  /**
   * Elimina un vehículo.
   * 
   * @param placa Placa del vehículo a eliminar
   * @throws VehiculoNoEncontradoException Si no existe
   */
  public void eliminar(String placa) throws VehiculoNoEncontradoException {
    if (!vehiculos.containsKey(placa.toUpperCase())) {
      throw new VehiculoNoEncontradoException(placa);
    }

    vehiculos.remove(placa.toUpperCase());
    System.out.println("✅ Vehículo eliminado exitosamente");
  }

  /**
   * Retorna la cantidad de vehículos registrados.
   */
  public int cantidadVehiculos() {
    return vehiculos.size();
  }
}
