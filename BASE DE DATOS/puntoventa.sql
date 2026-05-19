CREATE DATABASE puntoventa;
USE puntoventa;

/*
ESTRUCTURA PARA CREAR UNA TABLA EN LA BASE DE DATOS 

CREATE TABLE nombre_tabla(
	nombre_atributo  tipo  NOT NULL AUTO_INCREMENT,
		PRIMARY KEY ( nombre_atributo );
    )
			ENGINE = INNODB;*/
            
-- Crearemos tabla de roles 

CREATE TABLE roles (

	codigo_rol INT AUTO_INCREMENT , -- remplaza id 
    nombre_rol VARCHAR ( 50 ) NOT NULL UNIQUE, -- ADMINISTRADOR, VENDEDOR 
    
    PRIMARY KEY ( codigo_rol )
    
    )	
     ENGINE = INNODB;
     
     
     /* CREAREMOS la tabla administradores  */

CREATE TABLE usuarios (

	num_usuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR ( 100 ) NOT NULL,
	apePaterno VARCHAR ( 100 ) NOT NULL,
    apeMaterno VARCHAR ( 100 ) NOT NULL,
    correo VARCHAR ( 150 ) NOT NULL UNIQUE,
    contrasena VARCHAR ( 255 ) NOT NULL UNIQUE,
    rol_asignado INT NOT NULL, -- REMPLAZA A id_rol
    
    /* ESTRUCTURA PARA PONER EL ULTIMO ACCESO DEL USUARIO */
    
	ultimo_acceso DATETIME NULL,
    
    /* RELACION ENTRE AMBAS TABLAS 
    constraint = ES UNA RESTRICCIÓN 
    
    EStructura PARA UNA LLAVE FORANEA 
    
    CONSTRAINT fk_nombretablamaestra(en este caso usuario )_nombretabla_esclava(en este caso roles) 
    
		FOREING KEY ( VARIABLE rol asignado ) REFERENCES tabla_esclava ( variable id_rol) */
        
        CONSTRAINT FK_usuarios_roles FOREIGN KEY ( rol_asignado ) REFERENCES roles ( codigo_rol )
        
      

        
      
        
        )
			ENGINE = INNODB;
            
            
            /* ESTRUCTURA PARA MODIFICAR UNA TABLA
        PRIMERO QUITAMOS LA FOREIGN KEY 
        DESPUES ESCRIBIMOS NUEVAMENTE LA NUEVA REGLA*/
        
        ALTER TABLE usuarios
        DROP FOREIGN KEY FK_usuario_roles;
        
        /*  ASIGNAMOS NUEVA restriccion  */
        
        ALTER TABLE usuarios
        ADD CONSTRAINT FK_usuarios_roles FOREIGN KEY ( rol_asignado ) REFERENCES roles ( codigo_rol )
        ON DELETE RESTRICT
        ON UPDATE CASCADE;
        

 
        

        
         
    
    
    
  /*
   Estructura para enumerar el nivel de acceso
    palabra nivel_acceso ENUM ( ' los niveles que serán),
    
    
    nivel_acceso ENUM ( 'SuperAdmin', 'Vendedor', 'Cajero') NOT NULL,
    
    Vaidar que siempre este activo
    LA estructura es 
    
    activo TINYINT ( 1 ) DEFAULT ( 1 ),
    
    -- EStructura que almacena la fecha y hora exacta de la ultima actividad del usuario 
    -- Su estado inicial permite valores nulos si el usuario nunca a iniciado seción 
    */
    
    
    


 

