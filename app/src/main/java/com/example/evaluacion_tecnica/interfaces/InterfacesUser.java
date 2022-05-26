package com.example.evaluacion_tecnica.interfaces;

import com.example.evaluacion_tecnica.model.Users;

import java.util.List;

public interface InterfacesUser {

    interface view {
        void respuesta(List<Users> users);
    }

    interface presenter {
        void getDatos();

        void respuesta(List<Users> users);
    }

    interface iterator {
        void getDatos();
    }


}
