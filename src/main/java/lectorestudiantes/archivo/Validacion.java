/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectorestudiantes.archivo;
import exceptions.ArchivoException;
/**
 * Clase que valida las condiciones de una línea de una Archivo leído
 * @author Johan Samuel Marin Bañol
 * @version 1.1
 */
public class Validacion {
    
    private static int limite = 4;
    private static String extension = "txt";
    /**
     * Valida que la linea del archivo cumpla 
     * con las condiciones requeridas
     * @param linea línea leída del archivo
     * @param numeroLinea la posición de la línea en el archivo
     * @return true si la linea es correcta
     * @throws ArchivoException Si la línea no cumple con las condiciones
     */
    public static boolean validarLinea(String linea, int numeroLinea) 
                                    throws ArchivoException{
        
        boolean lineaCorrecta = true;
        
        String[] division = linea.split(",");
        if(division.length == 1){
            throw new ArchivoException("Sintaxis de línea no válida "+" numero de línea "+
                        numeroLinea+" contenido: "+linea);
        }
        if(division.length < limite){
            throw new ArchivoException("La cantidad de datos "
                    + "es inferior a la requerida "+" numero de línea "+
                        numeroLinea+" contenido: "+linea);
        }
        if(division.length > limite){
            throw new ArchivoException("La cantidad de datos "
                + "es superior a la requerida "+" numero de línea "+
                    numeroLinea+" contenido: "+linea);
        }
        return lineaCorrecta;
    }
    
    public static boolean validarFormato(String ruta) 
                                    throws ArchivoException{
        boolean rutaCorrecta = true;
        
        String[] division = ruta.split("\\.");
        int ultimaPos = division.length-1;
        if(!division[ultimaPos].equals(extension)){
            throw new ArchivoException("Formato no válido, debe ser "+extension);
        }
        return rutaCorrecta;
    }
}
