package co.edu.sena.traslados_seguros;

public class Cliente {
    // Atributos del cliente
    String nombre;           // Nombre completo del cliente
    String telefono;         // Telefono de contacto
    String identificacion;   // Numero de cedula o NIT

    // Constructor
    public Cliente(String nombre, String telefono, String identificacion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return "- INFORMACION DEL CLIENTE -\n" +
                "Nombre: " + nombre + "\n" +
                "Telefono: " + telefono + "\n" +
                "Identificacion: " + identificacion + "\n" +
                "--";
    }

    public void mostrarInfo() {
        System.out.println(this.toString());
    }
}