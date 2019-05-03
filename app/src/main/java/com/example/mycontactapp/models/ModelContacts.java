package com.example.mycontactapp.models;

public class ModelContacts {

    private String name, phone, email, pic;


    public ModelContacts(String name, String phone, String email, String pic) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
