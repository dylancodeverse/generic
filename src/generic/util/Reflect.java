package generic.util;

import java.lang.reflect.Field;
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

        return attributeNames.toArray(new String [attributeNames.size()]);

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

    /*
     * recursion pour eviter de faire une clone si iteration
     */

    public static Object getValue(Object o , DeepField deepField ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
    {
        
        Field o1Field = o.getClass().getDeclaredField(deepField.getField());
        o1Field.setAccessible(true);
        Object value = o1Field.get(o);
        
        if (deepField.getDeepField()== null) 
        {
            return value ;
        }
        
        return getValue(o1Field.get(o), deepField.getDeepField()) ;

    }
    
}
