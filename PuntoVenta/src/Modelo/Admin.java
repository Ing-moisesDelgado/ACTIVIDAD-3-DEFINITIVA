/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Admin extends Usuarios {
    
    private String nivelAcceso;
    
    // 1. Constructor vacío
    public Admin() {
        super(); // Requiere que la clase 'Usuarios' tenga un constructor vacío
    }

    // 2. Constructor completo corregido
    public Admin(int numUsuario, String nombre, String apellidoPaterno,
                 String apellidoMaterno, String correo, String contrasena, 
                 String rolAsignado, String nivelAcceso) { // <--- Agregado aquí
        
        super(numUsuario, nombre, apellidoPaterno, apellidoMaterno, correo,
                contrasena, rolAsignado);
        this.nivelAcceso = nivelAcceso; // <--- Asignación corregida
    }

    // Getters y Setters
    public String getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(String nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }
}

