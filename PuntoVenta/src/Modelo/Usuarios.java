/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/* Seria nuestra superclase */

public class Usuarios {
    // PASO 1 al crear un programa es declarar variables 
    /*Definimos clase privada para encapsular los atributos 
    y asi puedan ser heredados
    Estructura seria 
    palabrareservada + tipo_de_dato + nombre_variable ;
    */
    protected int numUsuario;
    protected String nombre;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected String correo;
    protected String contrasena;
    protected String rolAsignado;
    
    
    /* Siempre es importante crear el constructor vacio
    estructura constructor vacio 
    public nombre_clase (){
    }
    */
    public  Usuarios() {}

   
    /*Siempre fijamos los parametros para los atributos para las clases heredadas
    */
    public Usuarios(int numUsuario, String nombre, String apellidoPaterno,
            String apellidoMaterno,
            String correo, String contrasena, String rolAsignado) {
        this.numUsuario = numUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rolAsignado = rolAsignado;
    }

    public int getNumUsuario() {
        return numUsuario;
    }

    public void setNumUsuario(int numUsuario) {
        this.numUsuario = numUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRolAsignado() {
        return rolAsignado;
    }

    public void setRolAsignado(String rolAsignado) {
        this.rolAsignado = rolAsignado;
    }

    

    
    
    }
    
    
    


   
        
  