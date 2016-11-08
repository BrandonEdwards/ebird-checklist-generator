package ebirdlistgenerator;

import java.util.ArrayList;

public class Checklist 
{
    private String subID, state_prov, county, location, latitude, longitude,
            date, time, duration, distance, area, numObservers, comments;
    ArrayList <Bird> bird;
    
    public Checklist ()
    {
        bird = new ArrayList<>();
    }
    
    public String getSubID ()
    {
        return this.subID;
    }
    
    
}
