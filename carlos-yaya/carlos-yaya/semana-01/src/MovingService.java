public class MovingService {
    // Atributos del servicio
    String serviceCode;      // Codigo del servicio
    String origin;           // Direccion de origen
    String destination;      // Direccion de destino

    // Constructor - inicializa un servicio nuevo
    public MovingService(String serviceCode, String origin, String destination) {
        this.serviceCode = serviceCode;
        this.origin = origin;
        this.destination = destination;
    }

    // Metodo para mostrar la informacion del servicio
    public void showInfo() {
        System.out.println("========================================");
        System.out.println("Codigo: " + serviceCode);
        System.out.println("Origen: " + origin);
        System.out.println("Destino: " + destination);
        System.out.println("========================================");
    }
}
