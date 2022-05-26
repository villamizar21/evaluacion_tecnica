package com.example.evaluacion_tecnica.photos.presenter;

import com.example.evaluacion_tecnica.photos.interfaces.InterfacePhoto;
import com.example.evaluacion_tecnica.photos.iterator.IteratorPhoto;
import com.example.evaluacion_tecnica.photos.model.PhotosModel;

import java.util.List;

public class PresenterPhoto implements InterfacePhoto.presenter {

    InterfacePhoto.view view;
    InterfacePhoto.iterator iterator;

    public PresenterPhoto(InterfacePhoto.view view) {
        this.view = view;
        this.iterator = new IteratorPhoto(this);
    }


    @Override
    public void responsePhoto(List<PhotosModel> photos) {
        view.responsePhoto(photos);
    }

    @Override
    public void getPhotos(int id) {
        iterator.getPhotos(id);
    }
}
