package test;

import java.util.HashMap;

import generic.util.DeepField;

public class App {
    public static void main(String[] args) throws Exception {

        // System.out.println(new Person().getFormHTMLSpecified("treatment", "get" , 
        // new String[] { "Nom","Age" , "Is free" } ,"birthday" ));

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
            new Person("PBob", new Physic(10)),
            new Person("Charlie", new Physic(15)),
            new Person("Patrick",new Physic(10))
        };


        HashMap <String ,DeepField > map = new HashMap<String ,DeepField>();
        map.put("physic", new DeepField(new String[]{"physic","weight"}));
        Person.sort(pss, new String[]{"physic","name"},map);

    
        Prix[] prixList = new Prix[] {
            new Prix(10., 15.),
            new Prix(5., 8.),
            new Prix(12., 20.)
        };

        Prix p = new Prix().sum(prixList, new String[]{"prixCoca","prixChoco"});

        Prix p1= new Prix().average(prixList, new String[]{"prixCoca","prixChoco"});

    }


}

