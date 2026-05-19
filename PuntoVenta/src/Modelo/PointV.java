/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Modelo;
import connection.MysqlDB;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PointV {

   
    public static void main(String[] args) {
        
        /* Crearemos el objeto Scanner para leer el teclado 
        
        estructura es 
        
        Scanner + nombre variable a otorgar el valor + = new Scanner (System.in);
        */
        Scanner entrada = new Scanner(System.in);
        
        System.out.println( "-----REGISTRO DE NUEVO ADMINISTRADOR------");
        
        // Empezamos a solicitar y capurar cada dato del usuario 
        
        /*
        La estructura es System.out.println(" TEXTO A PEDIR ");
        
        */
        System.out.println("NUMERO DE USUARIO(ENTERO MATRICULA:");
        
        //Estructura para capturar el dato ingresado
         /* 
        tipo de dato + variable_para_capturar_dato = entrada.next+Mayuscula
        tipo_de_dato();
        */
        
         int numUsuario = entrada.nextInt();
       //  System.out.println( "Hola" + numUsuario);
         
         /*importante limpiar el buffer despues de leer el numero solo aplica en numeros 
         int o double*/
         
         entrada.nextLine();
         
         System.out.println("Nombre :");
         String nombre = entrada.nextLine();
       
         
         System.out.println( "Apellido Paterno:");
         String apellidoPaterno = entrada.nextLine();
         
         // marcamos esta linea extra para quitar la advertencia de varable no usada 
         //System.out.println( "Hola" + apellidoPaterno);
         
         System.out.println("Apellido Materno:");
         String apellidoMaterno = entrada.nextLine();
         
         System.out.println("COrreo Electronico");
         String correo = entrada.nextLine();
         
         System.out.println("Password:");
         String contrasena = entrada.nextLine();
         
         System.out.println("Rol Asignado");
         String rolAsignado = entrada.nextLine();
         
         System.out.println("NIVEL DE ACCESO 1.Admin , 2. Vendedor y 3.Cajero");
         String nivelAcceso = entrada.nextLine();
         
         /* Estructura para instanciar el objeto con los datos de la consola 
         
         el nuevo objeto a instanciar ( Admin en este caso)+
         nueva variable para asignar = new admin ( todas las variables de usuario
         y nivelAcceso);
         */
         
         Admin nuevoAdmin = new Admin (numUsuario,nombre,apellidoPaterno,apellidoMaterno,
         correo,contrasena,rolAsignado,nivelAcceso);
         
         /* Estructura para mostrar los datos ingresados
         System.out.println ("ID(MATRICULA (numUsuario)"+ nuevoAdmin.getNumUsuario());
       
         */
         
         System.out.println("\n ----PERFIL ADMINISTRADOR CREADO EXITOSAMENTE----");
         System.out.println("Matricula" + nuevoAdmin.getNumUsuario());
         
         System.out.println("Nombre Completo:" +" "+ nuevoAdmin.getNombre()+" "+
                 nuevoAdmin.getApellidoPaterno()+ " "+
                 nuevoAdmin.getApellidoMaterno());
         
         System.out.println("Correo Electronico:" + " " + nuevoAdmin.getCorreo());
         System.out.println("Nivel de Acceso " + nuevoAdmin.getNivelAcceso());
         
         
         /* AQUI INSERTAREMOS EL CODIGO PARA LLENAR LA TABLA DE MYSQL
         
         */
         
                  // ... (Tus System.out.println anteriores) ...
         System.out.println("Nivel de Acceso " + nuevoAdmin.getNivelAcceso());
         
         
         // ---- NUEVO CÓDIGO PARA INSERTAR EN MYSQL ----
         
         // 1. Declaramos las variables de conexión de Java
         Connection conectar = null;
         PreparedStatement pst = null;
         
         // 2. Definimos la consulta SQL (Cambia "tu_tabla_administradores" por el nombre real)
         String sql = "INSERT INTO usuarios (num_usuario, nombre, apePaterno,"
                 + " apeMaterno, correo,"
                 + " contrasena, rol_asignado) VALUES (?, ?, ?, ?, ?, ?, ? )";
         // AGREGA ESTA LÍNEA AQUÍ PARA VER EL ERROR:
System.out.println("*** EL ROL ENVIADO ES: " + nuevoAdmin.getRolAsignado());
         try {
             // 3. Supongamos que tu clase MysqlDB tiene un método estático para obtener la conexión
             //(ej: .conectar() o .getConnection())
             // Ajusta "MysqlDB.conectar()" según cómo esté programada tu clase de conexión
             System.out.println("DEBUG: El rol que intentas insertar es: ->" + nuevoAdmin.getRolAsignado() + "<-");
             conectar = MysqlDB.conectar(); 
             
             if (conectar != null) {
                 pst = conectar.prepareStatement(sql);
                 
                 // 4. Pasamos los datos del objeto 'nuevoAdmin' a los signos de interrogación '?' del SQL
                 pst.setInt(1, nuevoAdmin.getNumUsuario());
                 pst.setString(2, nuevoAdmin.getNombre());
                 pst.setString(3, nuevoAdmin.getApellidoPaterno());
                 pst.setString(4, nuevoAdmin.getApellidoMaterno());
                 pst.setString(5, nuevoAdmin.getCorreo());
                 pst.setString(6, nuevoAdmin.getContrasena());
                 pst.setString(7, nuevoAdmin.getRolAsignado());
                 //pst.setString(8, nuevoAdmin.getNivelAcceso());
                 
                 // 5. Ejecutamos la consulta en la base de datos
                 int filasAfectadas = pst.executeUpdate();
                 
                 if (filasAfectadas > 0) {
                     System.out.println("¡Datos guardados en MySQL correctamente!");
                 }
             } else {
                 System.out.println("Error: No se pudo establecer la conexión a la base de datos.");
             }
             
         } catch (SQLException e) {
             System.out.println("Error al insertar los datos: " + e.getMessage());
         } finally {
             // 6. Cerramos los recursos de la base de datos (Buena práctica)
             try {
                 if (pst != null) pst.close();
                 if (conectar != null) conectar.close();
             } catch (SQLException ex) {
                 System.out.println("Error al cerrar conexión: " + ex.getMessage());
             }
         }
         
         // cerrar el objeto Scanner es buena practica
         entrada.close();
    }
}

         
         // cerrar el objeto Scanner es buena practica
         
        
         
         
         
         
        
         
         
    
    

