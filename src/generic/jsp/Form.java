package generic.jsp;

import java.util.List;

public class Form {
    



    public String getHTMLForm (String css ,String form ,String formElements)
    {

        form = form.replaceFirst("<!-- Ajoutez ici les éléments de votre formulaire -->", formElements);
        return css + form ;
    }



    public String getFormElements(String[] labelNames, String[] inputNames,Object[] defaultValue) 
    {
        if ( labelNames.length != inputNames.length) 
        {
            throw new IllegalArgumentException("Les tableaux de paramètres doivent avoir la même longueur.");
        }
    
        StringBuilder formElements = new StringBuilder();
    
        for (int i = 0; i < labelNames.length; i++) 
        {
            formElements.append(getFormElement(labelNames[i],  inputNames[i],defaultValue[i]));
        }
    
        return formElements.toString();
    }
    


    public String getFormElement(String labelName, String inputName, Object defaultValue) 
    {
        StringBuilder formElement = new StringBuilder();
    
        formElement.append("<div class=\"form-group-generated\">\n");
        formElement.append("    <label class=\"form-label-generated\" for=\"").append(inputName).append("\">").append(labelName).append(":</label>\n");
    
        if (defaultValue instanceof List) 
        {
            List<?> defaultList = (List<?>) defaultValue;
            formElement.append("    <select class=\"form-input-generated\" id=\"").append(inputName).append("\" name=\"").append(inputName).append("\" required>\n");
            
            for (Object optionValue : defaultList) 
            {
                formElement.append("        <option value=\"").append(optionValue.toString()).append("\">").append(optionValue.toString()).append("</option>\n");
            }
            formElement.append("    </select>\n");
        
        } 
        else if (defaultValue instanceof Boolean) 
        {

            formElement.append("    <select class=\"form-input-generated\" id=\"").append(inputName).append("\" name=\"").append(inputName).append("\" required>\n");
            formElement.append("        <option value=\"true\"").append((defaultValue != null && defaultValue.equals(true)) ? " selected" : "").append(">True</option>\n");
            formElement.append("        <option value=\"false\"").append((defaultValue != null && defaultValue.equals(false)) ? " selected" : "").append(">False</option>\n");
            formElement.append("    </select>\n");

        } else 
        {
            formElement.append("    <input class=\"form-input-generated\" type=\"").append(getTypeForHTML(defaultValue)).append("\" id=\"").append(inputName).append("\" name=\"").append(inputName).append("\"");
         
            if (defaultValue != null) 
            {
                formElement.append(" value=\"").append(defaultValue.toString()).append("\"");
            }
            
            formElement.append(" required>\n");
        }
    
        formElement.append("</div>\n\n");
        return formElement.toString();
    }
            
    
    

    public String getForm(String action, String method, String btnValue) 
    {
        return 
            "<div class=\"form-container-generated\">\n" +
            "    <form action=\"" + action + "\" method=\"" + method + "\">\n" +
            "\n" +
            "        <!-- Ajoutez ici les éléments de votre formulaire -->\n" +
            "\n" +
            "        <input class=\"form-submit-generated\" type=\"submit\" value=\"" + btnValue + "\">\n" +
            "    </form>\n" +
            "</div>";
    }
    

    public String getCSS() 
    {
        return 
        "<style>\n" +
        "    body {\n" +
        "        font-family: Arial, sans-serif;\n" +
        "        background-color: #f2f2f2;\n" +
        "        margin: 0;\n" +
        "        padding: 0;\n" +
        "    }\n" +
        "\n" +
        "    .form-container-generated {\n" +
        "        max-width: 400px;\n" +
        "        margin: 0 auto;\n" +
        "        padding: 20px;\n" +
        "        background-color: #fff;\n" +
        "        border-radius: 5px;\n" +
        "        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
        "    }\n" +
        "\n" +
        "    .form-group-generated {\n" +
        "        margin-bottom: 20px;\n" +
        "    }\n" +
        "\n" +
        "    .form-label-generated {\n" +
        "        display: block;\n" +
        "        margin-bottom: 8px;\n" +
        "    }\n" +
        "\n" +
        "    .form-input-generated {\n" +
        "        width: 100%;\n" +
        "        padding: 10px;\n" +
        "        border: 1px solid #ccc;\n" +
        "        border-radius: 4px;\n" +
        "        box-sizing: border-box;\n" +
        "    }\n" +
        "\n" +
        "    .form-textarea-generated {\n" +
        "        width: 100%;\n" +
        "        padding: 10px;\n" +
        "        border: 1px solid #ccc;\n" +
        "        border-radius: 4px;\n" +
        "        resize: vertical;\n" +
        "        box-sizing: border-box;\n" +
        "    }\n" +
        "\n" +
        "    .form-submit-generated {\n" +
        "        background-color: #333;\n" +
        "        color: #fff;\n" +
        "        border: none;\n" +
        "        padding: 10px 20px;\n" +
        "        border-radius: 4px;\n" +
        "        cursor: pointer;\n" +
        "    }\n" +
        "\n" +
        "    .form-submit-generated:hover {\n" +
        "        background-color: #555;\n" +
        "    }\n" +
        "</style>";
    }
    

    public String getTypeForHTML(Object defaultValue) 
    {
        if (defaultValue instanceof List) 
        {
            List<?> defaultList = (List<?>) defaultValue;
            if (!defaultList.isEmpty()) 
            {
                Object firstElement = defaultList.get(0);
                if (firstElement instanceof String || firstElement instanceof Number) 
                {
                    return "select";
                }
            }
        }
         else if (defaultValue instanceof Boolean) 
        {
            return "select";
        } 
        else if (defaultValue instanceof Number) 
        {
            return "number";
        }
        else if (defaultValue instanceof java.util.Date){

            return "date";

        }

        // Par défaut, retourne "text" pour les autres types non spécifiés
        return "text";
    }
}
