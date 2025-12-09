package co.edu.sena.traslados_seguros;

public class MovingService {
    // Atributos del servicio
    String serviceCode;
    String origin;
    String destination;

    // Constructor
    public MovingService(String serviceCode, String origin, String destination) {
        this.serviceCode = serviceCode;
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "========================================\n" +
                "Codigo: " + serviceCode + "\n" +
                "Origen: " + origin + "\n" +
                "Destino: " + destination + "\n" +
                "========================================";
    }
    public void showInfo() {
        System.out.println(this.toString());
    }
}
