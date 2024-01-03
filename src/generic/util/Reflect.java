package generic.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Reflect {
    
    public static String[] getAttributeName(Object obj , String ... ignore)
    {
        List<String> attributeNames = new ArrayList<>();

        Class<?> objClass = obj.getClass();


        Field[] fields = objClass.getDeclaredFields();

        for (Field field : fields) 
        {
            if (!isIgnored(field.getName(), ignore)) 
            {
                attributeNames.add(field.getName());
            }
        }

        while (objClass.getSuperclass() != null) {
            objClass = objClass.getSuperclass();
            fields = objClass.getDeclaredFields();

            for (Field field : fields) 
            {
                if (!isIgnored(field.getName(), ignore)) 
                {
                    attributeNames.add(field.getName());
                }
            }

        }

        return attributeNames.toArray(new String [attributeNames.size()]);

    }

    public static String [] getMethodsName(Object ob ,String ... ignore){
        List<String> methodsName = new ArrayList<>();

        Class<?> objClass = ob.getClass();


        Method[] methods = objClass.getDeclaredMethods();

        for (Method method : methods) 
        {
            if (!isIgnored(method.getName(), ignore)) 
            {
                methodsName.add(method.getName());
            }
        }

        while (objClass.getSuperclass() != null) {
            objClass = objClass.getSuperclass();
            methods = objClass.getDeclaredMethods();

            for (Method method : methods) 
            {
                if (!isIgnored(method.getName(), ignore)) 
                {
                    methodsName.add(method.getName());
                }
            }

        }

        return methodsName.toArray(new String [methodsName.size()]);
    }


    public Object[] getAttributeValue(Object obj, String... ignore) 
    {
        List<Object> attributeValues = new ArrayList<>();
    
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();
    
        for (Field field : fields) 
        {
            if (!isIgnored(field.getName(), ignore)) 
            {
                field.setAccessible(true);
                try 
                {
                    Object value = field.get(obj);
                    attributeValues.add(value);
                } 
                catch (IllegalAccessException e) 
                {
                    attributeValues.add(null);
                }
            }
        }
    
        return attributeValues.toArray();
    }

    public Class<?>[] getAttributeType(Object obj, String... ignore) 
    {
        List<Class<?>> attributeTypes = new ArrayList<>();
    
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();
    
        for (Field field : fields) 
        {
            if (!isIgnored(field.getName(), ignore)) 
            {
                Class<?> type = field.getType();
                attributeTypes.add(type);
            }
        }
    
        return attributeTypes.toArray(new Class<?>[attributeTypes.size()]);
    }


    private static boolean isIgnored(String fieldName, String... ignore) 
    {
        for (String ignoredField : ignore) 
        {
            if (fieldName.equals(ignoredField)) 
            {
                return true;
            }
        }
        return false;
    }


    public static int compare(Object o1, Object o2){
        if (o1 instanceof String && o2 instanceof String) 
        {
            return ((String)o1).compareToIgnoreCase(((String)o2)) ;
        }
        else if (o1 instanceof Number && o2 instanceof Number) 
        {
            return Double.compare(Double.valueOf(o1.toString()), Double.valueOf(o2.toString()));
        }
        else if (o1 instanceof java.util.Date && o2 instanceof java.util.Date) 
        {
            return ((java.util.Date)o1).compareTo((java.util.Date)o2);
        }
        else 
        {
            return 0 ; // ni un nombre ni un string
        }
    }

    public static void setValue (Object o , String fieldName ,Object value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
    {
        Field o1Field = o.getClass().getDeclaredField(fieldName);
        o1Field.setAccessible(true);
        o1Field.set(o, value);
    }

    public static Object getValue(Object o , String fieldName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
    {

        Field o1Field = o.getClass().getDeclaredField(fieldName);
        o1Field.setAccessible(true);
        return o1Field.get(o);

    }

    public static Object getValueFromMethod(Object o , String methodName) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException{
        Method o1Method = null;
        try {
            o1Method =  o.getClass().getDeclaredMethod(methodName);
        } catch (NoSuchMethodException e) {
            Class<?> t = o.getClass();
            while (t.getSuperclass()!=null) {
                t = o.getClass().getSuperclass();
                try {
                    o1Method = t.getDeclaredMethod(methodName);                           
                    break;
                } catch (NoSuchMethodException e2) {}
            }
            if (o1Method==null) {
                throw e;
            }
        }
        o1Method.setAccessible(true);
        Object value = o1Method.invoke(o);
        return value;        
    }


    /*
     * recursion pour eviter de faire une clone si iteration
     */

    public static Object getValue(Object o , DeepField deepField ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
    {
        Field o1Field = null;
        try {
            o1Field =  o.getClass().getDeclaredField(deepField.getField());
        } catch (NoSuchFieldException e) {
            Class<?> t = o.getClass();
            while (t.getSuperclass()!=null) {
                t = o.getClass().getSuperclass();
                try {
                    o1Field = t.getDeclaredField(deepField.getField());                           
                    break;
                } catch (NoSuchFieldException e2) {}
            }
            if (o1Field==null) {
                throw e;
            }
        }
        o1Field.setAccessible(true);
        Object value = o1Field.get(o);
        
        if (deepField.getDeepField()== null) 
        {
            return value ;
        }
        
        return getValue(o1Field.get(o), deepField.getDeepField()) ;

    }
    
}
