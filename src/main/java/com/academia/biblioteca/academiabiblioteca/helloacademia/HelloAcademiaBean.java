package com.academia.biblioteca.academiabiblioteca.helloacademia;

public class HelloAcademiaBean {
    private String text;

    public HelloAcademiaBean(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}