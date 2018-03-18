package com.jnec.techfest.swayambhu;

/**
 * Created by hp on 3/4/2018.
 */

public class StudentInfo {

    static String name;
    static String email;
    static String contact;
    static String college;
    public StudentInfo() {
    }

    public StudentInfo(String Name, String Email, String Contact,String College) {
        this.name = Name;
        this.email = Email;
        this.contact = Contact;
        this.college = College;
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

    public static String getCollege() {
        return college;
    }

    public static void setCollege(String college) {
        StudentInfo.college = college;
    }
}
