package com.jnec.techfest.swayambhu;

/**
 * Created by Imroz Quazi on 26-01-2018.
 */

public class CSE_Event_1 {

    private String Name , Pathofimage;



    public CSE_Event_1(String name , String path)
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
