package modelo;

/**
 * Representa una motocicleta.
 */
public class Moto extends Vehiculo {
    private int cilindraje;
    
    public Moto(String placa, String marca, int año, int cilindraje) {
        super(placa, marca, año);
        setCilindraje(cilindraje);
    }
    
    @Override
    public double calcularCostoMantenimiento() {
        // Motos pequeñas: 80k, grandes: 120k
        return (cilindraje < 250) ? 80000 : 120000;
    }
    
    public int getCilindraje() {
        return cilindraje;
    }
    
    public void setCilindraje(int cilindraje) {
        if (cilindraje < 50 || cilindraje > 2000) {
            throw new IllegalArgumentException("Cilindraje debe estar entre 50cc y 2000cc");
        }
        this.cilindraje = cilindraje;
    }
    
    @Override
    public String toString() {
        return "[MOTO] " + super.toString() + " | Cilindraje: " + cilindraje + "cc";
    }
}
