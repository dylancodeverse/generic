package generic.sort;

import java.util.Arrays;
import java.util.Comparator;

import generic.util.Reflect;

public class MethodGenericComparator implements Comparator<Object>{
    String [] methodsReference ;

    int order=1;

    public MethodGenericComparator(Object objectInstance, String[] methodsReference ) throws IllegalArgumentException 
    {
        String[] methodsName = Reflect.getMethodsName(objectInstance);

        // Vérifier que chaque élément de methodsReference est dans methodsName
        for (String method : methodsReference) 
        {
            if (!Arrays.asList(methodsName).contains(method)) 
            {
                throw new IllegalArgumentException("Le champ référencé par methodsReference n'existe pas dans l'objet.");
            }
        }

        // Si tous les champs de methodsReference sont valides, les assigner à l'attribut de classe
        this.methodsReference = methodsReference;

    }

    
    @Override
    public int compare(Object o1, Object o2) 
    {
        int response =0;
        for (int i = 0; i < methodsReference.length; i++) 
        {
            try 
            {
                Object o1Value = Reflect.getValueFromMethod(o1, methodsReference[i] ) ;
                Object o2Value = Reflect.getValueFromMethod(o2, methodsReference[i]);

                response = Reflect.compare(o1Value, o2Value) ;
                if (response!=0) 
                {
                    return order*response;
                }           
            } 
            catch (Exception e) 
            {
                return response;
            }
 
        }
        return response ;
    }

    public void setmethodsReference(String [] methodsReference) 
    {
        this.methodsReference = methodsReference;
    }


    public void setOrderToAsc() {
        order=1;
    }


    public void setOrderToDESC() {
        order=-1;
    }
}
