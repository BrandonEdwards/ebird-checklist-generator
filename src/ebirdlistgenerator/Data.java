package ebirdlistgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Brandon
 */
public class Data 
{
    ArrayList <Checklist> list;
    HashMap <String, Integer> subIDMap;
    public Data ()
    {
        list = new ArrayList<>();
        subIDMap = new HashMap<>();
    }
    
    public void loadData (String filename)
    {
        try
        {
            File f = new File(filename);
            Scanner file = new Scanner(f);
            while (file.hasNextLine())
            {
                parseLine(file.nextLine());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Could not find file");
        }
    }
    
    private void parseLine (String line)
    {
        //Regex from http://stackoverflow.com/questions/15738918/splitting-a-csv-file-with-quotes-as-text-delimiter-using-string-split
        String[] elements = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        
        if (subIDMap.get(elements[0]) == null) //if checklist does not exist
        {
            Checklist checklist = new Checklist(elements[0]);
            list.add(checklist);
            subIDMap.put(elements[0], list.size() - 1);
            //populate checklist information
        }
        else
        {
            parseBird(line, subIDMap.get(elements[0]));
        }
    }
    
    private void parseBird (String line, int listIndex)
    {
        String[] elements = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        
        Bird bird = new Bird(elements[1], elements[2], elements[4], elements[18],
        elements[19]);
        
        //Add this new bird to the checklist it came from
        list.get(listIndex).bird.add(bird);
    }
    
}
