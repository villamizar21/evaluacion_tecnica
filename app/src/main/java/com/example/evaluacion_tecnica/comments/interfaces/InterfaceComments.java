package com.example.evaluacion_tecnica.comments.interfaces;

import com.example.evaluacion_tecnica.comments.model.Comments;

import java.util.List;

public interface InterfaceComments {

    interface view {
        void responseComment(List<Comments> comments);
    }

    interface presenter {
        void responseComment(List<Comments> comments);

        void getComments(int id);
    }

    interface iterator {
        void getComments(int id);
    }
}
