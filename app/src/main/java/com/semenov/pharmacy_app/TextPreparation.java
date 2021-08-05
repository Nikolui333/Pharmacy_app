package com.semenov.pharmacy_app;

public class TextPreparation {

    int id;
    public String name;
    public String text;

    public TextPreparation(int id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public TextPreparation(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
