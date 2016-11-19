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
        
        bird = commonName + " (" + scientificName + ")\t\t" + count + "\n";
        bird = bird + "\t\t" + comments + "\n";
        
        return bird;
    }
}
