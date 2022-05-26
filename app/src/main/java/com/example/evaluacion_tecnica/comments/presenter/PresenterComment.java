package com.example.evaluacion_tecnica.comments.presenter;

import com.example.evaluacion_tecnica.comments.interfaces.InterfaceComments;
import com.example.evaluacion_tecnica.comments.iterator.IteratorComment;
import com.example.evaluacion_tecnica.comments.model.Comments;

import java.util.List;

public class PresenterComment implements InterfaceComments.presenter {

    InterfaceComments.view view;
    InterfaceComments.iterator iterator;

    public PresenterComment(InterfaceComments.view view) {
        this.view = view;
        this.iterator = new IteratorComment(this);
    }

    @Override
    public void responseComment(List<Comments> comments) {
        view.responseComment(comments);
    }

    @Override
    public void getComments(int id) {
    iterator.getComments(id);
    }
}
