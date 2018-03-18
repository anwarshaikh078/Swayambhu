package com.jnec.techfest.swayambhu;

/**
 * Created by Imroz Quazi on 08-03-2018.
 */

public class ECT_EVENT_1 {

    private String Name , Pathofimage;


    public ECT_EVENT_1(String name , String path)
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
