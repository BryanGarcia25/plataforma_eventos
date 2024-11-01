package com.example.microservice_users.microservice_users.constants;

public class Messages {
    
    // Previniendo que se realice una instancia a esta clase de constantes
    private Messages() {
        throw new IllegalStateException("Esto es una clase de constantes por lo tanto no se debe realizar instancias");
    }

    public static final String USER_CREATED = "Bienvenido, tu registro se ha completado con éxito. Gracias por unirte con nosotros, ahora puedes iniciar sesión y explorar nuestros servicios que tenemos para ti";
    public static final String USER_UPDATED = "Tu perfil se ha actualizado con éxito. Gracias por mantener tu información al día";
    public static final String USER_DELETED = "Tu perfil se ha eliminado correctamente. Gracias por confiar en nosotros para gestionar su información en nuestra base de datos";
    public static final String USER_NOTFOUND = "El usuario no se encuentra registrado en la base de datos";

}
