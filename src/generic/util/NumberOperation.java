package generic.util;

public class NumberOperation {

    public static Object castNumber(String o, Class<?> clazz) 
    {
        if (clazz.getSimpleName().equals("int")) 
        {
            if (o.contains(".")) {
                o = o.substring(0,o.indexOf(".")) ;
            }
            return Integer.parseInt(o);
        }
        else if (clazz.getSimpleName().equals("double")) 
        {
            return Double.parseDouble(o);
        } 
        else if (clazz.getSimpleName().equals("long")) 
        {
            return Long.parseLong(o);
        } 
        else if (clazz.getSimpleName().equals("float")) 
        {
            return Float.parseFloat(o);
        } 
        else if (clazz.getSimpleName().equals("short")) 
        {
            return Short.parseShort(o);
        } 
        else if (clazz.getSimpleName().equals("byte")) 
        {
            return Byte.parseByte(o);
        } 
        else if (clazz.getSimpleName().equals("Integer") )
        {
            if (o.contains(".")) {
                o = o.substring(0,o.indexOf(".")) ;
            }
            return Integer.valueOf(o);
        }
        else if (clazz.getSimpleName().equals("Double")) 
        {
            return Double.valueOf(o);
        }
         else if (clazz.getSimpleName().equals("Long")) 
        {
            return Long.valueOf(o);
        } 
        else if (clazz.getSimpleName().equals("Float")) 
        {
            return Float.valueOf(o);
        } 
        else if (clazz.getSimpleName().equals("Short")) 
        {
            return Short.valueOf(o);
        } else if (clazz.getSimpleName().equals("Byte")) 
        {
            return Byte.valueOf(o);
        }
        else 
        {
            throw new IllegalArgumentException("Invalid class for the cast to a number");
        }
    }
}
