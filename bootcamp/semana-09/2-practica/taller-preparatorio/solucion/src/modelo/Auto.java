package modelo;

/**
 * Representa un automóvil.
 */
public class Auto extends Vehiculo {
  private int numeroPuertas;

  public Auto(String placa, String marca, int año, int numeroPuertas) {
    super(placa, marca, año);
    setNumeroPuertas(numeroPuertas);
  }

  @Override
  public double calcularCostoMantenimiento() {
    return 150000; // Costo base para autos
  }

  public int getNumeroPuertas() {
    return numeroPuertas;
  }

  public void setNumeroPuertas(int numeroPuertas) {
    if (numeroPuertas < 2 || numeroPuertas > 5) {
      throw new IllegalArgumentException("Número de puertas debe estar entre 2 y 5");
    }
    this.numeroPuertas = numeroPuertas;
  }

  @Override
  public String toString() {
    return "[AUTO] " + super.toString() + " | Puertas: " + numeroPuertas;
  }
}
