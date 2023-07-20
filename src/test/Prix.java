package test;

import generic.util.Generic;

public class Prix extends Generic<Prix> {
    public Prix() {
    }



    String id;
    Double prixCoca;
    Double prixChoco;



    public Prix(Double prixCoca, Double prixChoco) 
    {
        this.prixCoca = prixCoca;
        this.prixChoco = prixChoco;
    }
}
