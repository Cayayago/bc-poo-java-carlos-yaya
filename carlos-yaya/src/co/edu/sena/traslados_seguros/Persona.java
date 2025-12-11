package co.edu.sena.traslados_seguros;

// Semana 6: Convertida en clase abstracta
public abstract class Persona {

    // Semana 4: Atributos protected para compartir con subclases
    protected String nombre;
    protected String telefono;
    protected String identificacion;

    // Semana 4: Constructor completo de la clase padre
    public Persona(String nombre, String telefono, String identificacion) {
        setNombre(nombre);
        setTelefono(telefono);
        setIdentificacion(identificacion);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setNombre(String nombre) {
        if (validarStringNoVacio(nombre) && validarNombre(nombre)) {
            this.nombre = nombre.trim();
        } else {
            throw new IllegalArgumentException("Nombre invalido: debe tener entre 3 y 100 caracteres");
        }
    }

    public void setTelefono(String telefono) {
        if (validarStringNoVacio(telefono) && validarTelefono(telefono)) {
            this.telefono = telefono.trim();
        } else {
            throw new IllegalArgumentException("Telefono invalido: debe tener 10 digitos");
        }
    }

    public void setIdentificacion(String identificacion) {
        if (validarStringNoVacio(identificacion) && validarIdentificacion(identificacion)) {
            this.identificacion = identificacion.trim();
        } else {
            throw new IllegalArgumentException("Identificacion invalida: debe tener entre 5 y 15 caracteres");
        }
    }

    private boolean validarStringNoVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    private boolean validarNombre(String nombre) {
        int longitud = nombre.trim().length();
        return longitud >= 3 && longitud <= 100;
    }

    private boolean validarTelefono(String telefono) {
        return telefono.matches("\\d{10}");
    }

    private boolean validarIdentificacion(String identificacion) {
        String id = identificacion.trim();
        return (id.length() >= 5 && id.length() <= 15) &&
                (id.matches("\\d+") || id.matches("(?i)EMP-\\d{3}"));
    }

    // Semana 6: Metodo abstracto - cada subclase debe implementar
    public abstract double calcularCostoOperacional();

    // Semana 4: Metodo concreto heredable 1
    public void mostrarInformacionBasica() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Telefono: " + telefono);
        System.out.println("ID: " + identificacion);
    }

    // Semana 4: Metodo concreto heredable 2
    public String obtenerNombreCorto() {
        String[] partes = nombre.split(" ");
        return partes.length > 0 ? partes[0] : nombre;
    }

    // Semana 5: Metodo concreto para sobrescribir en subclases
    public String obtenerTipoPersona() {
        return "Persona generica";
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + identificacion + ")";
    }
}