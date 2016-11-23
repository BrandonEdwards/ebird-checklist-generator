package ebirdlistgenerator;

import java.util.ArrayList;

public class Checklist 
{
    private String subID, state_prov, county, location, latitude, longitude,
            date, time, duration, distance, area, numObservers, comments;
    ArrayList <Bird> bird;
    
    public Checklist ()
    {
        subID = state_prov = county = location = latitude = longitude = 
            date = time = duration = distance = area = numObservers = comments = "";
        bird = new ArrayList<>();
    }
    
    public Checklist (String subID)
    {
        this.subID = subID;
        state_prov = county = location = latitude = longitude = 
            date = time = duration = distance = area = numObservers = comments = "";
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
        header = "**********************************************************\r\n";
        header = header + "\t\t\t\t\t\t" + subID + "\r\n";
        header = header + location + " (" + latitude + " " + longitude +  ")\r\n";
        header = header + state_prov + " " + county + "\r\n";
        header = header + date + " " + time + " (" + duration + " minutes)\r\n";
        header = header + "Distance Travelled: " + distance + "km\r\n";
        header = header + numObservers + " observers\r\n";
        header = header + comments + "\r\n";
        header = header + 
                "**********************************************************\r\n";
        
        for (int j = 0; j < bird.size(); j++)
        {
            header = header + bird.get(j).toFile();
        }
        
        return header;
    }
    
    public String toHTMLFile ()
    {
        String output;
        //setup table styling for bird species
        output = "<style>\n" +
                "table {\n" +
                "    font-family: arial, sans-serif;\n" +
                "    border-collapse: collapse;\n" +
                "    width: 100%;\n" +
                "}\n" +
                "\n" +
                "td, th {\n" +
                "    border: 1px solid #dddddd;\n" +
                "    text-align: left;\n" +
                "    padding: 8px;\n" +
                "}\n" +
                "\n" +
                "th {\n" +
                "    background-color: #dddddd;\n" +
                "}\n" +
                "</style>\n\n";
        //Output location
        output = output + "<h2>" + location + " (" + latitude + " " + longitude
                + ") " + state_prov + " " + county + "</h2>\n";
        
        //Output submission ID and link to the ebird checklist
        output = output + "<p><b>Submission ID: </b><a href=\"http://ebird.org/ebird/view/checklist/" + 
        subID + "\">" + subID + "</a></p>\n";
        
        //Output date and time
        output = output + "<p><b>Date and Time:</b> " + date + " " + time + " (" 
                + duration + " minutes)</p>\n";
        
        if (distance.isEmpty())
            distance = "0";
        //Output distance travelled
        output = output + "<p><b>Distance Travelled:</b> " + distance + " km</p>\n";
        
        //Output number of observers
        output = output + "<p><b>Number of Observers: </b>" + numObservers + "</p>\n";
        
        if (!comments.isEmpty())
        {
            //Output checklist comments
            output = output + "<p><b>Comments/Notes: </b>" + comments + "</p>\n";                
        }
    
        
        //Set up table headers
        output = output + "<hr />\n" +
                            "\n" +
                            "<table>\n" +
                            "	<tr>\n" +
                            "		<th>Common Name</th>\n" +
                            "		<th>Scientific Name</th>\n" +
                            "		<th>Count</th>\n" +
                            "		<th>Breeding Code</th>\n" +
                            "		<th>Additional Comments</th>\n" +
                            "	</tr>\n";
        
        for (int j = 0; j < bird.size(); j++)
        {
            output = output + "    <tr>\n";
            output = output + bird.get(j).toHTMLFile();
            output = output + "    </tr>\n";
        }
        
        output = output + "</table>\n";
        
        return output;
    }
}
