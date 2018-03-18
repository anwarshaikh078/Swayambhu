package com.jnec.techfest.swayambhu;

/**
 * Created by hp on 3/4/2018.
 */

public class StudentInfo {

    static String name;
    static String email;
    static String contact;

    public StudentInfo() {
    }

    public StudentInfo(String Name, String Email, String Contact) {
        this.name = Name;
        this.email = Email;
        this.contact = Contact;
    }
    public static String getname() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public static String getContact() {
        return contact;
    }

    public void setContact(String Contact) {
        this.contact = Contact;
    }

}
