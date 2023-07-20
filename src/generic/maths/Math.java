package generic.maths;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import generic.util.reflect.Reflect;

public class Math <T> {
    
    @SuppressWarnings("unchecked")
    public T sum (T [] list , String[] fields) throws InstantiationException , IllegalAccessException , InvocationTargetException , NoSuchMethodException , SecurityException , IllegalArgumentException ,NoSuchFieldException
    {
        try 
        {

            T response = ((T) list[0].getClass().getConstructor().newInstance());

            for (int i = 0; i < fields.length; i++) 
            {
                
                Field target = response.getClass().getDeclaredField(fields[i]);  
                target.setAccessible(true) ;

                Class<?> targetClass = target.getType() ;

                Double initFieldValue = 0. ;

                for (int j = 0; j < list.length; j++) 
                {
                    Object oneListValue = Reflect.getValue(list[j], fields[i]) ;
                    initFieldValue = initFieldValue + Double.valueOf(oneListValue.toString());

                }
                
                target.set(response, targetClass.getConstructor(String.class).newInstance(initFieldValue.toString()));

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
