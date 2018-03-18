package com.jnec.techfest.swayambhu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class General_Event_1 {


    private String Name , Pathofimage;


    public General_Event_1(String name , String path)
    {
        Name = name;

        Pathofimage = path;


    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPathofimage() {
        return Pathofimage;
    }

    public void setPathofimage(String pathofimage) {
        Pathofimage = pathofimage;
    }
}
