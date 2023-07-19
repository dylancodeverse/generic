package test;
public class App {
    public static void main(String[] args) throws Exception {

        // System.out.println(new Person().getFormHTMLSpecified("traitement", "get" , 
        // new String[] { "Nom","Age" , "Est disponible" } ,"dateDeNaissance" ));

        Person[] ps = new Person[]{
            new Person("Cocou", 19),
            new Person("Sab", 456),
            new Person("ali", 0),
            new Person("bbe", 0),
            new Person("John", 25),
            new Person("Alice", 30),
            new Person("Bob", 21)
        };
        Person.sort(ps, new String []{"age","name"});
        

        Person[] pss = new Person[]{
            new Person("Alice", new Physic(12)),
            new Person("Bob", new Physic(10)),
            new Person("Charlie", new Physic(15))
        };

        // Triez le tableau de personnes par âge en utilisant un Comparator
        // Person.sort(pss, new String[]{"physic"},new String []{"physic","weight"});

    
    }


}

