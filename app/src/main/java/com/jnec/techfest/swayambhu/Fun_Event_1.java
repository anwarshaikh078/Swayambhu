package com.jnec.techfest.swayambhu;

/**
 * Created by Imroz Quazi on 15-03-2018.
 */

public class Fun_Event_1 {


    private String Name , Pathofimage;


    public Fun_Event_1(String name , String path)
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
