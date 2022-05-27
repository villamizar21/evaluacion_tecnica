package com.example.evaluacion_tecnica.photos.interfaces;

import com.example.evaluacion_tecnica.photos.model.PhotosModel;

import java.util.List;

public interface InterfacePhoto {

    interface view {
        void responsePhoto(List<PhotosModel> photos);

        void respuestaErronea(String message);
    }

    interface presenter {
        void responsePhoto(List<PhotosModel> photos);

        void respuestaErronea(String message);

        void getPhotos(int id);
    }

    interface iterator {
        void getPhotos(int id);
    }
}
