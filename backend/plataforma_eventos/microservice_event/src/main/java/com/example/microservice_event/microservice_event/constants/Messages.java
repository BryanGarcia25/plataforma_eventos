package com.example.microservice_event.microservice_event.constants;

public class Messages {

    // Previniendo que se realice una instancia a esta clase de constantes
    private Messages() {
        throw new IllegalStateException("Esto es una clase de constantes por lo tanto no se debe realizar instancias");
    }
    
    public static final String EVENT_PUBLISHED = "El evento ha sido publicado en la página oficial";
    public static final String EVENT_UPDATED = "El evento ha sido actualizado en la página oficial";
    public static final String EVENT_DELETED = "El evento ha sido eliminado en la página oficial";
    public static final String EVENT_NOTFOUND = "El evento no se encuentra registrado en la base de datos";

}
