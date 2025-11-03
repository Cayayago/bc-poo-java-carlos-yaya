package com.agencia.util;

/**
 * Utilidades de validación
 */
public class Validador {

  /**
   * Valida formato básico de email
   */
  public static boolean validarEmail(String email) {
    return email != null && email.contains("@") && email.contains(".");
  }

  /**
   * Valida que un código tenga formato correcto
   */
  public static boolean validarCodigo(String codigo) {
    return codigo != null && codigo.matches("R\\d{3}");
  }
}
