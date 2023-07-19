package generic;

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

}
