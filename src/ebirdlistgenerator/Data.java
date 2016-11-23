package ebirdlistgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
            boolean firstLine = true;
            while (file.hasNextLine())
            {
                if (firstLine)
                {
                    firstLine = false;
                }
                else
                {
                    parseLine(file.nextLine());                    
                }
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
            parseChecklist (line, subIDMap.get(elements[0]));
        }
        else
        {
            parseBird(line, subIDMap.get(elements[0]));
        }
    }
    
    private void parseChecklist (String line, int listIndex)
    {
        String[] elements = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        list.get(listIndex).setStateProv(elements[5]);
        list.get(listIndex).setCounty(elements[6]);
        list.get(listIndex).setLocation(elements[7]);
        list.get(listIndex).setLatLong(elements[8], elements[9]);
        list.get(listIndex).setDateTime(elements[10], elements[11], elements[13]);
        //This will have to be fixed later
        if (elements.length > 15)
        {
            list.get(listIndex).setDistArea(elements[15], elements[16]);
            list.get(listIndex).setNumObservers(elements[17]);            
        }

        if (elements.length == 21)
        {
            list.get(listIndex).setComments(elements[20]);            
        }

        parseBird(line, listIndex);
    }
    
    private void parseBird (String line, int listIndex)
    {
        String[] elements = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        Bird bird;
        
        if (elements.length <= 18)
        {
            bird = new Bird(elements[1], elements[2], elements[4]);
        }
        else if (elements.length == 19)
        {
            bird = new Bird(elements[1], elements[2], elements[4], elements[18]);
        }
        else
        {
            bird = new Bird(elements[1], elements[2], elements[4], elements[18],
            elements[19]);
                    
        }

        //Add this new bird to the checklist it came from
        list.get(listIndex).bird.add(bird);
    }
    
    public void outputChecklists ()
    {
        for (int i = 0; i < list.size(); i++)
        {
            try
            {
                String filename = "output\\" + list.get(i).getSubID() + ".txt";
                PrintWriter fileWriter = new PrintWriter(filename, "UTF-8");
                fileWriter.print(list.get(i).toFile());
                fileWriter.close();
            }catch (Exception e)
            {
                System.out.println("Failed to write.");
            }
        }
    }
    
    public void outputChecklists (String filetype)
    {
        filetype = filetype.toLowerCase();
        for (int i = 0; i < list.size(); i++)
        {
            try
            {
                String filename = "output\\" + list.get(i).getSubID() + "." + filetype;
                PrintWriter fileWriter = new PrintWriter(filename, "UTF-8");
                if (filetype.equals("html"))
                {
                    fileWriter.print(list.get(i).toHTMLFile());                    
                }
                else
                {
                    fileWriter.print(list.get(i).toFile());
                }

                fileWriter.close();
            }catch (Exception e)
            {
                System.out.println("Failed to write.");
            }
        }        
    }
    
}
