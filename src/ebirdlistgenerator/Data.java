package ebirdlistgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Brandon
 */
public class Data 
{
    ArrayList <Checklist> list;
    public Data ()
    {
        list = new ArrayList<>();
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
        
        if (checklistExists(elements[0]))
        {
            
        }

    }
    
    private boolean checklistExists (String subID)
    {
        if (list.isEmpty())
        {
            return false;
        }
        
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getSubID().equals(subID))
            {
                return true;
            }
        }
        
        return false;
    }
}
