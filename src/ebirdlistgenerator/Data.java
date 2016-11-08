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
                //parse
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Could not find file");
        }
    }
}
