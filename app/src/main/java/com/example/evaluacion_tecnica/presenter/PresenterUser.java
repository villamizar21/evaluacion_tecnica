package com.example.evaluacion_tecnica.presenter;

import com.example.evaluacion_tecnica.interfaces.InterfacesUser;
import com.example.evaluacion_tecnica.iterator.IteratorUser;
import com.example.evaluacion_tecnica.model.Users;

import java.util.List;

public class PresenterUser implements InterfacesUser.presenter {

    InterfacesUser.view view;
    InterfacesUser.iterator iterator;

    public PresenterUser(InterfacesUser.view view) {
        this.view = view;
        this.iterator = new IteratorUser(this);
    }

    @Override
    public void getDatos() {
        iterator.getDatos();
    }

    @Override
    public void respuesta(List<Users> users) {
        view.respuesta(users);
    }
}
