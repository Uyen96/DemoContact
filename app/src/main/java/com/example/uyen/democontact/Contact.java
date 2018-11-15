package com.example.uyen.democontact;

public class Contact {

    private int mId;
    private String mName;
    private String mPhone;

    public Contact() {
    }

    public Contact(int id, String name, String phone) {
        mId = id;
        mName = name;
        mPhone = phone;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }
}
