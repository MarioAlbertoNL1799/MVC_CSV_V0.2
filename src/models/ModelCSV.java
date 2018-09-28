/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Spliterator;
import javax.swing.JOptionPane;
/**
 * Clase que permite realizar las acciones de la aplicacion
 * @author manl_
 */
public class ModelCSV {
    private String nombre;
    private String email;
    private int inicio = 0;
    private String path = "C:\\archivos\\datos.csv";
    ArrayList <String> contactos = new ArrayList <String>();


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPath() {
        return path;
    }

    private void setPath(String path) {
        this.path = path;
    }
    /**
     * metodo que permite leer un archivo y su contenido
     */
public void readFile(){
    try{
        String row;
        try(FileReader file = new FileReader(path)){
            BufferedReader bufferedReader = new BufferedReader(file);
            while ((row = bufferedReader.readLine()) != null){
                contactos.add(row);  //la lista contiene sublistas, tomando valores de ambos lados 
            }System.out.print(contactos);
            bufferedReader.close();
        }
    }
    catch(FileNotFoundException err){
        System.err.println("Archivo no encontrado: "+err.getMessage());
        }
    catch(IOException err){
        System.err.println("Errior en la operacion de entrada/salida: "+err.getMessage());
        }
    }
/**
 * metodo que permite ingresar un nuevo dato al archivo
 */
public void writeFile(){
        try{
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file,true);
            prueba();
            prueba2();
            String agregar = nombre + ',' + email;
            try (PrintWriter printWriter = new PrintWriter(fileWriter)){
                printWriter.println(agregar);
                printWriter.close();
                }
        }
        catch(FileNotFoundException err){
            System.err.println("Archivo no encontrado: "+err.getMessage());
        }
        catch(IOException err){
            System.err.println("Errior en la operacion de entrada/salida: "+err.getMessage());
        }
    }
/**
 * metodo que hace validacion de los caracteres igresados en el nombre y sustituye las comas por un espacio
 */
public void prueba(){
    char cadena [];
    cadena = nombre.toCharArray();
    for (int i= 0; i < nombre.length(); i++){
         if (cadena[i] == ',')
             cadena[i] = ' ';
    }
    nombre = String.valueOf(cadena);
    System.out.println(nombre);
}
/**
 * metodo que hace validacion de los caracteres del email y sustituye las comas por un guion bajo
 */
public void prueba2(){
    char[] probar;
    probar = email.toCharArray();
    for (int i= 0; i < email.length(); i++){
         if (probar[i] == ',')
             probar[i] = '_';
    }
    email = String.valueOf(probar);
    System.out.println(email);
}
/**
 * Este metodo permite abstraer datos de la lista de contactos de CSV, el cual podremos abstraer ambos datos
 * y posteriormente separarlos
 */
public void primero(){
    String uno = contactos.get(inicio);
    String Dato[] = uno.split(",");
    nombre = Dato[0];
    email = Dato[1];
    System.out.println(nombre);
    }
public void ultimo(){
    int fin = (contactos.size()- 1);
    String uno = contactos.get(fin);
    String Dato[] = uno.split(",");
    nombre = Dato[0];
    email = Dato[1];
    System.out.println(nombre);
    }
public void siguiente(){
    int continuar = inicio;
    String uno = contactos.get(continuar);
    String Dato[] = uno.split(",");
    nombre = Dato[0];
    email = Dato[1];
    System.out.println(nombre);
    }
}