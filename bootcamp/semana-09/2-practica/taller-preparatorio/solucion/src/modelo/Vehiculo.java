package modelo;

/**
 * Clase abstracta que representa un vehículo genérico.
 * Base para Auto, Moto y Camion.
 */
public abstract class Vehiculo {
  private String placa;
  private String marca;
  private int año;

  /**
   * Constructor de Vehiculo.
   * 
   * @param placa Placa única del vehículo
   * @param marca Marca del vehículo
   * @param año   Año de fabricación
   */
  public Vehiculo(String placa, String marca, int año) {
    setPlaca(placa);
    setMarca(marca);
    setAño(año);
  }

  /**
   * Método abstracto para calcular el costo de mantenimiento.
   * Cada tipo de vehículo implementa su propio cálculo.
   * 
   * @return Costo de mantenimiento en pesos
   */
  public abstract double calcularCostoMantenimiento();

  // Getters con validación
  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    if (placa == null || placa.trim().isEmpty()) {
      throw new IllegalArgumentException("La placa no puede estar vacía");
    }
    this.placa = placa.toUpperCase();
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    if (marca == null || marca.trim().isEmpty()) {
      throw new IllegalArgumentException("La marca no puede estar vacía");
    }
    this.marca = marca;
  }

  public int getAño() {
    return año;
  }

  public void setAño(int año) {
    if (año < 1900 || año > 2025) {
      throw new IllegalArgumentException("Año inválido");
    }
    this.año = año;
  }

  @Override
  public String toString() {
    return String.format("Placa: %s | Marca: %s | Año: %d | Costo Mantenimiento: $%.2f",
        placa, marca, año, calcularCostoMantenimiento());
  }
}
