package generic.util;

import java.util.Arrays;
import java.util.Comparator;

public class GenericComparator implements Comparator<Object>
{

    public String [] defaultFieldsReference ;

    public GenericComparator(Object objectInstance, String[] defaultFieldsReference) throws IllegalArgumentException 
    {
        String[] fieldsName = Reflect.getAttributeName(objectInstance);

        // Vérifier que chaque élément de defaultFieldsReference est dans fieldsName
        for (String field : defaultFieldsReference) 
        {
            if (!Arrays.asList(fieldsName).contains(field)) 
            {
                throw new IllegalArgumentException("Le champ référencé par defaultFieldsReference n'existe pas dans l'objet.");
            }
        }

        // Si tous les champs de defaultFieldsReference sont valides, les assigner à l'attribut de classe
        this.defaultFieldsReference = defaultFieldsReference;
    }

    
    @Override
    public int compare(Object o1, Object o2) 
    {
        try 
        {
            Object o1Value = Reflect.getValue(o1, defaultFieldsReference ,0) ;
            Object o2Value = Reflect.getValue(o2, defaultFieldsReference,0);

            return Reflect.compare(o1Value, o2Value) ;           

        } 
        catch (Exception e) 
        {
            return 0;
        }
 
    }

    public void setDefaultFieldsReference(String [] defaultFieldsReference) 
    {


        this.defaultFieldsReference = defaultFieldsReference;
    }
    
}
