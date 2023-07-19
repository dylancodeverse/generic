package generic.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class GenericComparator implements Comparator<Object>
{

    String [] defaultFieldsReference ;
    HashMap<String ,String[] > deeperField ;

    public GenericComparator(Object objectInstance, String[] defaultFieldsReference , HashMap<String,String[]> deepFields) throws IllegalArgumentException 
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

        this.deeperField = deepFields;
    }

    
    @Override
    public int compare(Object o1, Object o2) 
    {
        int response =0;
        for (int i = 0; i < defaultFieldsReference.length; i++) 
        {
            try 
            {
                Object o1Value = Reflect.getValue(o1, deeperField.get(defaultFieldsReference[i]) ,0) ;
                Object o2Value = Reflect.getValue(o2, deeperField.get(defaultFieldsReference[i]),0);

                response = Reflect.compare(o1Value, o2Value) ;
                if (response!=0) 
                {
                    return response;
                }           
            } 
            catch (Exception e) 
            {
                return response;
            }
 
        }
        return response ;
 
    }

    public void setDefaultFieldsReference(String [] defaultFieldsReference) 
    {


        this.defaultFieldsReference = defaultFieldsReference;
    }
    
}
