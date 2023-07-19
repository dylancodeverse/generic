package test;
public class App {
    public static void main(String[] args) throws Exception {

        System.out.println(new Person().getFormHTMLSpecified("traitement", "get" , 
        new String[] { "Nom","Age"  } ,"dateDeNaissance" ));


    }


}

