package test;

import generic.util.Generic;

public class PersonM extends Generic<PersonM>{
    
    private int v ;
    private String name;



    public PersonM(int v,  String name) {
        this.v = v;
        this.name = name;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public static void main(String[] args) {
        PersonM[] ps = new PersonM[]
        {
            new PersonM(4 ,"COCO"),
            new PersonM(6,"SEBON"),
            new PersonM(3,"adfsfd")
        };

        PersonM.sortUsingMethod(ps, new String[]{"getV"});

    }
}
