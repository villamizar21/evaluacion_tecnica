package com.example.evaluacion_tecnica.users.interfaces;

import com.example.evaluacion_tecnica.users.model.Users;

import java.util.List;

public interface InterfacesUser {

    interface view {
        void respuesta(List<Users> users);
        void respuestaErronea(String message);
    }

    interface presenter {
        void getDatos();
        void respuestaErronea(String message);
        void respuesta(List<Users> users);
    }

    interface iterator {
        void getDatos();
    }


}
