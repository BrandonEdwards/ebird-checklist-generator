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
    
    public Checklist (String subID)
    {
        this.subID = subID;
        bird = new ArrayList<>();
    }
    
    public String getSubID ()
    {
        return this.subID;
    }
    
    public void setStateProv (String state_prov)
    {
        this.state_prov = state_prov;
    }
    
    public void setCounty (String county)
    {
        this.county = county;
    }
    
    public void setLocation (String location)
    {
        this.location = location;
    }
    
    public void setLatLong (String latitude, String longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public void setDateTime (String date, String time, String duration)
    {
        this.date = date;
        this.time = time;
        this.duration = duration;
    }
    
    public void setDistArea (String distance, String area)
    {
        this.distance = distance;
        this.area = area;
    }
    
    public void setNumObservers (String numObservers)
    {
        this.numObservers = numObservers;
    }
    
    public void setComments (String comments)
    {
        this.comments = comments;
    }
    
    public String toFile ()
    {
        String header;
        header = "**********************************************************\n";
        header = header + "\t\t\t\t\t\t" + subID + "\n";
        header = header + location + " (" + latitude + " " + longitude +  ")\n";
        header = header + state_prov + " " + county + "\n\n";
        header = header + date + " " + time + " (" + duration + " minutes)\n";
        header = header + "Distance Travelled: " + distance + "km\n";
        header = header + numObservers + " observers\n";
        header = header + comments + "\n";
        header = header + 
                "**********************************************************\n";       
        
        return header;
    }
}
