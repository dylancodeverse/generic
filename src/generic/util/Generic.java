package generic.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import generic.jsp.Form;
import generic.maths.Math;
import generic.sort.GenericComparator;
import generic.sort.SimpleGenericComparator;

public class Generic <T> extends Reflect{
    
    protected String cssForm =new Form().getCSS();
    protected String actionForm;
    protected String methodForm;
    protected String btnValueForm ="Envoyer";



// FORM  SECTION FOR JSP

    public String getFormHTML(String action , String method , String... ignore)
    {
        String [] fieldsName = getAttributeName(ignore);
        Object [] fildsValue = getAttributeValue(ignore);
        Class<?> [] clazz    = getAttributeClasses(ignore) ;


        Form formGeneric = new Form();
        String form = formGeneric.getForm(action, method ,getBtnValueForm());
        String formElements = formGeneric.getFormElements(fieldsName, fieldsName, clazz ,fildsValue);
    

        return formGeneric.getHTMLForm(getCssForm(), form, formElements) ;
    }

    public String getFormHTMLSpecified(String action ,String method ,String [] fieldsName , String ... ignore)
    {
        if (fieldsName==null) 
        {
            fieldsName= getAttributeName(ignore);
        }
        Object [] fildsValue = getAttributeValue(ignore);
        Class<?> [] clazz    = getAttributeClasses(ignore) ;


        Form formGeneric = new Form();
        String form = formGeneric.getForm(action, method ,getBtnValueForm());
        String formElements = formGeneric.getFormElements(fieldsName, fieldsName, clazz ,fildsValue);
    

        return formGeneric.getHTMLForm(getCssForm(), form, formElements) ;

    }

// SORT SECTION

    public static void sort(Object [] object , String [] defaultReference)
    {
        Arrays.sort(object, new SimpleGenericComparator(object[0], defaultReference));
    }

    public static void sort(Object [] object , String [] defaultReference ,HashMap<String, DeepField> deepFields ) 
    {
        Arrays.sort(object ,new GenericComparator(object[0], defaultReference, deepFields));
    }



// MATH SECTION

    public T sum( T[] array ,String []fieldsReferences) throws InstantiationException , IllegalAccessException , InvocationTargetException , NoSuchMethodException , SecurityException , IllegalArgumentException , NoSuchFieldException 
    {
        try 
        {
            return new Math<T>().sum(array, fieldsReferences);

        } 
        catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException
                | SecurityException | IllegalArgumentException | NoSuchFieldException e) 
        {
            throw e;
        }

    }

    public T average (T[] array ,String [] fieldsReferences) throws InstantiationException , IllegalAccessException , InvocationTargetException , NoSuchMethodException , SecurityException , IllegalArgumentException , NoSuchFieldException 
    {
        try 
        {
            return new Math<T>().average(array, fieldsReferences);
        } 
        catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException
                | SecurityException | IllegalArgumentException | NoSuchFieldException e) 
        {
            throw e;
        }


    }

    



// ALL PRIVATE FUNCTION

    private String [] getAttributeName(String... ignore)
    {
        ignore= getIgnore(ignore) ;
        return super.getAttributeName(this, ignore) ;
    }


    private Object [] getAttributeValue(String... ignore)
    {
        ignore = getIgnore(ignore);
        return super.getAttributeValue(this, ignore);
    }

    private Class<?> [] getAttributeClasses(String... ignore)
    {
        ignore=getIgnore(ignore);
        return super.getAttributeType(this, ignore);
    }

    private String [] getIgnore (String ... ignore)
    {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < ignore.length; i++) 
        {
            list.add(ignore[i]);
        }
        list.add(btnValueForm);
        list.add(actionForm);
        list.add(methodForm);
        list.add(cssForm);

        return list.toArray(new String [list.size()]);

    }



    // settes and getters

    public String getCssForm() 
    {
        return cssForm;
    }

    public void setCssForm(String cssForm) 
    {
        this.cssForm = cssForm;
    }

    public String getActionForm() {
        return actionForm;
    }

    public void setActionForm(String actionForm) 
    {
        this.actionForm = actionForm;
    }

    public String getMethodForm() 
    {
        return methodForm;
    }

    public void setMethodForm(String methodForm) 
    {
        this.methodForm = methodForm;
    }

    public String getBtnValueForm() 
    {
        return btnValueForm;
    }

    public void setBtnValueForm(String btnValueForm) 
    {
        this.btnValueForm = btnValueForm;
    }

    




}
