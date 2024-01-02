package test;

import java.util.HashMap;

import generic.util.DeepField;

public class PersonChild extends Person{

    int valeur;


    public PersonChild(String name, Physic physic, int valeur) {
        super(name, physic);
        setValeur(valeur);
    }

    public PersonChild(int valeur) {
        this.valeur = valeur;
    }

    public PersonChild(){
        super();
    }
    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }


    public static void main(String[] args) {
        PersonChild[] pss = new PersonChild[]{
            new PersonChild("Alice", new Physic(12),1),
            new PersonChild("PBob", new Physic(10),3),
            new PersonChild("Charlie", new Physic(15),1),
            new PersonChild("Patrick",new Physic(10),4)
        };


        HashMap <String ,DeepField > map = new HashMap<String ,DeepField>();
        map.put("physic", new DeepField(new String[]{"physic","weight"}));
        PersonChild.sortDESC(pss, new String[]{"physic","name"},map);
    }
}
