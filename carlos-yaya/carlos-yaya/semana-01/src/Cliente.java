public class Cliente {
    // Atributos del cliente
    String nombre;           // Nombre completo del cliente
    String telefono;         // Telefono de contacto
    String identificacion;   // Numero de cedula o NIT

    // Constructor - inicializa un cliente nuevo
    public Cliente(String nombre, String telefono, String identificacion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.identificacion = identificacion;
    }

    // Metodo para mostrar la informacion del cliente
    public void mostrarInfo() {
        System.out.println("--- INFORMACION DEL CLIENTE ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Telefono: " + telefono);
        System.out.println("Identificacion: " + identificacion);
        System.out.println("-------------------------------");
    }
}
