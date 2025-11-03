package modelo;

/**
 * Representa un camión.
 */
public class Camion extends Vehiculo {
  private double capacidadCarga; // toneladas

  public Camion(String placa, String marca, int año, double capacidadCarga) {
    super(placa, marca, año);
    setCapacidadCarga(capacidadCarga);
  }

  @Override
  public double calcularCostoMantenimiento() {
    // Costo base + adicional por capacidad
    return 200000 + (capacidadCarga * 10000);
  }

  public double getCapacidadCarga() {
    return capacidadCarga;
  }

  public void setCapacidadCarga(double capacidadCarga) {
    if (capacidadCarga <= 0 || capacidadCarga > 50) {
      throw new IllegalArgumentException("Capacidad debe estar entre 0 y 50 toneladas");
    }
    this.capacidadCarga = capacidadCarga;
  }

  @Override
  public String toString() {
    return "[CAMIÓN] " + super.toString() + " | Capacidad: " + capacidadCarga + " ton";
  }
}
