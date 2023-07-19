package generic.util.genericComparator;

public class DeepField 
{
 
    String field;
    DeepField deepField;

 
    public DeepField(String field) 
    {
        this.field = field;
    }

    public DeepField (String[] fields )
    {
        this(fields ,0);

    }

    private DeepField (String[] fields ,int begin)
    {

        this(fields[begin]) ;
        try 
        {
            setDeepField(new DeepField(fields[begin+1]));
        } 
        catch (Exception e) 
        {
            return ;
        }

    }

    public DeepField(String field, DeepField deepField) 
    {
        this.field = field;
        this.deepField = deepField;
    }

    public String getField() 
    {
        return field;
    }

    public void setField(String field) 
    {
        this.field = field;
    }

    public DeepField getDeepField() 
    {
        return deepField;
    }

    public void setDeepField(DeepField deepField) 
    {
        this.deepField = deepField;
    }

    
    
    
}
