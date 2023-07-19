package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import generic.jsp.Form;
import generic.util.GenericComparator;
import generic.util.Reflect;
import generic.util.SimpleGenericComparator;

public class Generic extends Reflect{
    
    protected String cssForm ;
    protected String actionForm;
    protected String methodForm;
    protected String btnValueForm ;


    public Generic()
    {
    
        Form form = new Form() ;
        cssForm = form.getCSS();
        btnValueForm ="Envoyer";
    
    }

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

    public static void sort(Object [] object , String [] defaultReference)
    {
        Arrays.sort(object, new SimpleGenericComparator(object[0], defaultReference));
    }

    public static void sort(Object [] object , String [] defaultReference ,HashMap<String,String[]> deepFields ) 
    {
        Arrays.sort(object ,new GenericComparator(object[0], defaultReference, deepFields));
    }



    // 
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
