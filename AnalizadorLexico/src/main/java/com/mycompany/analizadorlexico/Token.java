/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico;

/**
 *
 * @author sebas
 */
/**
 * La clase `Token` representa un elemento léxico identificado durante el análisis léxico.
 * 
 * Cada token contiene información sobre el lexema (valor), número de token, posición en la fila y columna,
 * así como el tipo del token.
 * 
 * Esta clase proporciona métodos para acceder y modificar cada uno de estos atributos, así como un método
 * `toString` para generar una representación de cadena del token.
 * 
 * Ejemplo de uso:
 * 
 * Token token = new Token("cadena", 1, 1, 1, "cadena");
 * 
 * @author 
 */
public class Token {
    
    // Atributos de la clase Token
    private String lexema;
    private int numero_token;
    private int fila;
    private int columna;
    private String tipo;

    /**
     * Constructor por defecto de la clase `Token`.
     * 
     * Crea un nuevo token con valores predeterminados para sus atributos.
     */
    public Token() {
    }

    /**
     * Constructor parametrizado de la clase `Token`.
     * 
     * Crea un nuevo token con los valores proporcionados para cada uno de sus atributos.
     * 
     * @param lexema El lexema (valor) del token.
     * @param numero_token El número identificador del token.
     * @param fila La posición de la fila en la que se encuentra el token.
     * @param columna La posición de la columna en la que se encuentra el token.
     * @param tipo El tipo del token.
     */
    public Token(String lexema, int numero_token, int fila, int columna, String tipo) {
        this.lexema = lexema;
        this.numero_token = numero_token;
        this.fila = fila;
        this.columna = columna;
        this.tipo = tipo;
    }

    // Métodos de acceso y modificación para los atributos de la clase Token

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getNumero_token() {
        return numero_token;
    }

    public void setNumero_token(int numero_token) {
        this.numero_token = numero_token;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método para generar una representación de cadena del objeto `Token`.
     * 
     * Genera y devuelve una cadena que representa el objeto `Token`, incluyendo
     * todos sus atributos.
     * 
     * @return Una cadena que representa el objeto `Token`.
     */
    @Override
    public String toString() {
        return "Token{" + "lexema=" + lexema + ", numero_token=" + numero_token + ", fila=" + fila + ", columna=" + columna + ", tipo=" + tipo + '}';
    }
    
}
