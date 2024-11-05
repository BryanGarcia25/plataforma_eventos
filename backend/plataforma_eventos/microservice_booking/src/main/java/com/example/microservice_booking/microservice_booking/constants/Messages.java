package com.example.microservice_booking.microservice_booking.constants;

public class Messages {
    
    // Previniendo que se realice una instancia a esta clase de constantes
    private Messages() {
        throw new IllegalStateException("Esto es una clase de constantes por lo tanto no se debe realizar instancias");
    }

    public static final String BOOKING_CREATED = "La reserva del evento se ha creado exitosamente";
    public static final String BOOKING_UPDATED = "La reserva del evento se ha actualizado exitosamente";
    public static final String BOOKING_DELETED = "La reserva del evento se ha eliminado exitosamente";
    public static final String BOOKING_NOTFOUND = "La reserva del evento no se encuentra registrado en la base de datos";

}
