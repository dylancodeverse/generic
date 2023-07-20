package generic.maths;

import java.lang.reflect.InvocationTargetException;

public class Math <T> {
    
    @SuppressWarnings("unchecked")
    public T sum (T [] list , String[] fields ,Class <?> precision ) throws InstantiationException , IllegalAccessException , InvocationTargetException , NoSuchMethodException , SecurityException , IllegalArgumentException ,NoSuchFieldException

    {
        try 
        {

            T response = ((T)list[0].getClass().getConstructor().newInstance());
            
            for (int i = 0; i < fields.length; i++) 
            {
                response.getClass().getDeclaredField(fields[i]).setAccessible(true);  
            }

            return response;
        } 
        catch (NoSuchMethodException e2) 
        {
            throw new IllegalAccessException("You must have a constructor with no args if you want to use Math.sum ");
        }
        catch (InstantiationException | IllegalAccessException | InvocationTargetException | IllegalArgumentException
                    | SecurityException |NoSuchFieldException e) 
        {
            throw e ;
        }         
    }
}
