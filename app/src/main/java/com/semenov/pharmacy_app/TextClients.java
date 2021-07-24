package com.semenov.pharmacy_app;

import com.semenov.pharmacy_app.clientsActivity.ClientsListActivity;

import java.util.List;

public class TextClients {

    public String name;
    public String phone_number;
    public String email;

    public TextClients(String name, String phone_number, String email) {
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
    }
}
