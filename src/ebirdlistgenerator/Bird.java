package ebirdlistgenerator;

public class Bird 
{
    private String commonName, scientificName, count, breedingCode, comments;
    
    public Bird ()
    {
        this.commonName = "";
        this.scientificName = "";
        this.count = "";
        this.breedingCode = "";
        this.comments = "";
    }
    
    public Bird (String commonName, String scientificName, String count,
            String breedingCode, String comments)
    {
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.count = count;
        this.breedingCode = breedingCode;
        this.comments = comments;
    }
    
    public Bird (String commonName, String scientificName, String count)
    {
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.count = count;
        this.breedingCode = "";
        this.comments = "";
    }
    
    public Bird (String commonName, String scientificName, String count, 
            String breedingCode)
    {
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.count = count;
        this.breedingCode = breedingCode;
        this.comments = "";
    }
    
    public String toFile ()
    {
        String bird;
        
        bird = commonName + " (" + scientificName + ")\t\t" + count + "\r\n";
        bird = bird + "\t\t" + comments + "\r\n";
        
        return bird;
    }
    
    public String toHTMLFile ()
    {
        String output = "";
        
        output = output + "		<td>" + commonName + "</td>\n";
        output = output + "		<td><i>" + scientificName + "</i></td>\n";
        output = output + "		<td>" + count + "</td>\n";
        output = output + "		<td>" + breedingCode + "</td>\n";
        output = output + "		<td>" + comments + "</td>\n";
        
        return output;
    }
}
