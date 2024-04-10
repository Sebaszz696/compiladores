/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico;

import java.util.ArrayList;

/**
 *
 * @author sebas
 */

/**
 * La clase `analizador` proporciona funcionalidades para analizar una cadena de entrada
 * y generar una lista de tokens basados en los elementos léxicos encontrados.
 * 
 * Esta clase incluye métodos para llevar a cabo el análisis léxico, determinar los estados de transición
 * de los caracteres y separar una cadena de texto en líneas.
 * 
 * Los tokens generados se almacenan en un ArrayList< Token > que se puede pasar al constructor
 * de la clase para su inicialización.
 * 
 * Ejemplo de uso:
 * 
 * 
 * @author sebas
 */
public class analizador {
    
    // ArrayList para almacenar los tokens generados por el analizador
    ArrayList<Token> lista_token = new  ArrayList();

    /**
     * Constructor de la clase `analizador`.
     * 
     * Este constructor inicializa el analizador léxico con una lista de tokens.
     * 
     * @param lista_token ArrayList que contendrá los tokens generados por el analizador.
     */
    public analizador(ArrayList<Token> lista_token ) {
        this.lista_token = lista_token;
    }
    
    /**
     * Método para analizar una cadena de entrada y generar tokens correspondientes a los elementos léxicos encontrados.
     * 
     * Este método escanea la cadena de entrada y genera tokens basados en los elementos léxicos identificados.
     * Los tokens generados se agregan a la lista de tokens.
     * 
     * @param cadena La cadena de entrada a analizar.
     */
    public void analizar(String cadena){
        // Definición de variables para el análisis
        int estado = 0;
        int decimal = 0;
        int numero_token = 0;
        String lexema = "";
        String tipo = "";
        String [] lineas = separador(cadena, '\n');
        
        // Bucle para recorrer cada línea de la cadena de entrada
        for (int i = 0; i < lineas.length; i++) {
            // Bucle para recorrer cada carácter de la línea actual
            for (int j = 0; j < lineas[i].length(); j++) {
                int n_actual, n_siguiente = -1;
                
                // Obtener el valor entero del carácter actual
                n_actual = lineas[i].codePointAt(j);
                if (estado == 0) {
                    // Determinar el estado de transición del carácter actual
                    estado = estado_transicion(n_actual);
                }
                try{
                    // Obtener el valor entero del carácter siguiente
                    n_siguiente = lineas[i].codePointAt(j + 1);
                }catch(Exception e){
                    
                }
                // Lógica para generar tokens según el estado actual
                switch(estado){
                    case 1:
                        lexema = lexema + lineas [i].charAt(j);
                        if ((n_siguiente > 96 && n_siguiente < 123 ) 
                                || (n_siguiente > 64 && n_siguiente < 91)) {
                            estado = 1;
                       
                    }else{
                          numero_token = 1;
                          tipo = "cadena";
                          estado = 0;
                    }
                        break;
                    case 2:
                        lexema = lexema + lineas[i].charAt(j);
                        if (n_siguiente > 47 && n_siguiente < 58){
                                estado= 2;
                        }else{
                            numero_token = 2;
                                tipo = "entero";
                                estado = 0;
                        } 
                        break;
                    case 100:
                        estado = -2;
                        break;
                    case 999: 
                        lexema = String.valueOf(lineas[i].charAt(j));
                        numero_token =999;
                        tipo = "Error lexico";
                        estado = 0;
                        break;
                } 
                // Agregar tokens a la lista de tokens cuando se alcanza el estado final
                if (estado == 0) {
                    lista_token.add (new Token(lexema, numero_token, i +1, j +1, tipo));
                    lexema = "";
                    tipo = "";
                }
                if (estado == -2) {
                    estado = 0;
                    
                }
            }
        }
    }
    
    /**
     * Método para determinar el estado de transición según el valor entero del carácter.
     * 
     * Este método determina el estado de transición de un carácter basado en su valor entero.
     * 
     * @param n Valor entero del carácter.
     * @return El estado de transición correspondiente.
     */
    public int estado_transicion(int n){
        if ((n > 96 && n < 123 ) || (n > 64 && n < 91)) {
            return 1;
        } else if (n > 47 && n < 58){
            return 2;
        }
        else if (n == 32 || n == 13 || n == 9) { 
            return 100;
        }else{
            return 999;
        }
           
    }
    
    /**
     * Método para separar una cadena de texto en líneas según un carácter separador.
     * 
     * Este método divide una cadena de texto en líneas utilizando un carácter separador especificado.
     * 
     * @param texto La cadena de texto a separar.
     * @param separar El carácter separador.
     * @return Un array de Strings representando las líneas separadas.
     */
    public String[] separador(String texto, char separar){
        String linea = "";
        int contador = 0;
        // Contar la cantidad de separadores en el texto para determinar el tamaño del array
        for (int i = 0; i < texto.length(); i++) {
            if(texto.charAt(i) == separar){
                contador++;
            }
        }
        // Crear el array con el tamaño calculado
        String [] cadenas = new String[contador];
        contador = 0;
        // Recorrer el texto y separarlo en líneas
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) != separar) {
                linea = linea + String.valueOf(texto.charAt(i));
            } else {
                cadenas[contador] = linea;
                contador++;
                linea = "";
            }
        }
        return cadenas;
    }
}

