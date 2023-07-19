package generic.util.genericComparator;
import java.util.Arrays;
import java.util.Comparator;

import generic.util.reflect.Reflect;

public class SimpleGenericComparator implements Comparator<Object>
{

    String [] defaultFieldsReference ;


    public SimpleGenericComparator(Object objectInstance, String[] defaultFieldsReference ) throws IllegalArgumentException 
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
        int response =0;
        for (int i = 0; i < defaultFieldsReference.length; i++) 
        {
            try 
            {
                Object o1Value = Reflect.getValue(o1, defaultFieldsReference[i] ) ;
                Object o2Value = Reflect.getValue(o2, defaultFieldsReference[i]);

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
