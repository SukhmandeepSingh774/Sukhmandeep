package com.example.register;


/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class Items {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    private String id;
    private String name;
    private String email;
    private String phone;
    private byte[] image;

    public Items()
    {
    }


    public Items(String name, String email, String phone, byte[] image) {
        this.name = name;
        this.email=email;
        this.phone = phone;
        this.image = image;
    }



}
