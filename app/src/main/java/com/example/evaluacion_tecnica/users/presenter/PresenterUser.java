package com.example.evaluacion_tecnica.users.presenter;

import com.example.evaluacion_tecnica.users.interfaces.InterfacesUser;
import com.example.evaluacion_tecnica.users.iterator.IteratorUser;
import com.example.evaluacion_tecnica.users.model.Users;

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
