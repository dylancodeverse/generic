package generic.maths;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import generic.util.NumberOperation;
import generic.util.Reflect;

public class Math <T> {
    
    @SuppressWarnings("unchecked")
    public T sum (T [] list , String[] fields) throws InstantiationException , IllegalAccessException , InvocationTargetException , NoSuchMethodException , SecurityException , IllegalArgumentException ,NoSuchFieldException
    {
        try 
        {
            T response ;
            try 
            {
                
                 response = ((T) list[0].getClass().getConstructor().newInstance());
            } 
            catch (NoSuchMethodException e2) 
            {
                throw new NoSuchMethodException("You must have a constructor with no args if you want to use Math.sum ");
            }
    

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
                
                target.set(response, NumberOperation.castNumber(initFieldValue.toString(), targetClass));

            }

            return response;
        } 
        catch (InstantiationException | IllegalAccessException | InvocationTargetException | IllegalArgumentException
                    | SecurityException |NoSuchFieldException | NoSuchMethodException e) 
        {
            throw e ;
        }         
    }

    private T sumForAverage (T response , Field [] targets , Class<?> [] targetClasses,T [] list , String[] fields) throws InstantiationException , IllegalAccessException , InvocationTargetException , NoSuchMethodException , SecurityException , IllegalArgumentException ,NoSuchFieldException
    {
        try 
        {
            for (int i = 0; i < fields.length; i++) 
            {
                
                Class<?> targetClass = targets[i].getType() ;

                Double initFieldValue = 0. ;

                for (int j = 0; j < list.length; j++) 
                {
                    Object oneListValue = Reflect.getValue(list[j], fields[i]) ;
                    initFieldValue = initFieldValue + Double.valueOf(oneListValue.toString());

                }
                
                targets[i].set(response, NumberOperation.castNumber(initFieldValue.toString(), targetClass));

            }

            return response;
        } 
        catch ( IllegalAccessException  | IllegalArgumentException
                    | SecurityException |NoSuchFieldException  e) 
        {
            throw e ;
        }         
    }
 
    @SuppressWarnings("unchecked")
    public T average (T[] list ,String [] fields)throws InstantiationException , IllegalAccessException , InvocationTargetException , NoSuchMethodException , SecurityException , IllegalArgumentException ,NoSuchFieldException
    {
        T response ;
        try 
        {
             response = ((T) list[0].getClass().getConstructor().newInstance());
        } 
        catch (NoSuchMethodException e2) 
        {
            throw new NoSuchMethodException("You must have a constructor with no args if you want to use Math.sum ");
        }

        Field [] targets = new Field [fields.length];
        Class<?> [] targetClass = new Class<?>[targets.length] ;

        for (int i = 0; i < fields.length; i++) 
        {
            targets[i] = response.getClass().getDeclaredField(fields[i]);  
            targets[i].setAccessible(true) ;

            targetClass[i] = targets[i].getType() ;

            targets[i] = response.getClass().getDeclaredField(fields[i]);  
            targets[i].setAccessible(true) ;
        }

        response = sumForAverage(response, targets, targetClass, list, fields); 

        for (int i = 0; i < targets.length; i++) 
        {
            Double d= Double.valueOf(targets[i].get(response).toString());
            d = d/Double.valueOf(list.length);
            targets[i].set(response, NumberOperation.castNumber(d.toString(), targetClass[i]) );
        }

        return response;


    }

}
