package util;

/**
 * Clase de utilidades para validar datos de contactos.
 * 
 * @author SENA - Bootcamp POO Java
 * @version 1.0
 */
public class Validador {

  /**
   * Valida que un String no sea null ni esté vacío.
   * 
   * @param valor       El String a validar
   * @param nombreCampo Nombre del campo para mensajes de error
   * @return true si es válido, false en caso contrario
   */
  public static boolean validarNoVacio(String valor, String nombreCampo) {
    if (valor == null || valor.trim().isEmpty()) {
      System.out.println("❌ Error: " + nombreCampo + " no puede estar vacío");
      return false;
    }
    return true;
  }

  /**
   * Valida el formato básico de un email.
   * Verifica que contenga @ y al menos un punto después del @.
   * 
   * @param email El email a validar
   * @return true si el formato es válido, false en caso contrario
   */
  public static boolean validarEmail(String email) {
    if (!validarNoVacio(email, "Email")) {
      return false;
    }

    if (!email.contains("@")) {
      System.out.println("❌ Error: Email inválido (debe contener @)");
      return false;
    }

    String[] partes = email.split("@");
    if (partes.length != 2 || !partes[1].contains(".")) {
      System.out.println("❌ Error: Formato de email inválido");
      return false;
    }

    return true;
  }

  /**
   * Valida el formato de un teléfono.
   * Permite solo números, espacios y guiones.
   * 
   * @param telefono El teléfono a validar
   * @return true si el formato es válido, false en caso contrario
   */
  public static boolean validarTelefono(String telefono) {
    if (!validarNoVacio(telefono, "Teléfono")) {
      return false;
    }

    // Permite números, espacios, guiones y paréntesis
    if (!telefono.matches("[0-9\\s\\-()]+")) {
      System.out.println("❌ Error: Teléfono debe contener solo números, espacios y guiones");
      return false;
    }

    // Extraer solo dígitos para validar longitud mínima
    String soloDigitos = telefono.replaceAll("[^0-9]", "");
    if (soloDigitos.length() < 7) {
      System.out.println("❌ Error: Teléfono debe tener al menos 7 dígitos");
      return false;
    }

    return true;
  }

  /**
   * Valida el formato de un ID de contacto.
   * Debe comenzar con 'C' seguido de números.
   * 
   * @param id El ID a validar
   * @return true si el formato es válido, false en caso contrario
   */
  public static boolean validarId(String id) {
    if (!validarNoVacio(id, "ID")) {
      return false;
    }

    if (!id.matches("C\\d+")) {
      System.out.println("❌ Error: ID debe tener formato C seguido de números (ej: C001)");
      return false;
    }

    return true;
  }

  /**
   * Valida todos los campos obligatorios de un contacto.
   * 
   * @param id        ID del contacto
   * @param nombre    Nombre del contacto
   * @param telefono  Teléfono del contacto
   * @param email     Email del contacto
   * @param categoria Categoría del contacto
   * @return true si todos los campos son válidos, false en caso contrario
   */
  public static boolean validarContactoCompleto(String id, String nombre,
      String telefono, String email,
      String categoria) {
    boolean valido = true;

    valido &= validarId(id);
    valido &= validarNoVacio(nombre, "Nombre");
    valido &= validarTelefono(telefono);
    valido &= validarEmail(email);
    valido &= validarNoVacio(categoria, "Categoría");

    return valido;
  }
}
