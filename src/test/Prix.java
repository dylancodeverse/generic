package test;

import generic.util.Generic;

public class Prix extends Generic<Prix> {
    String id;
    Double prixCoca;
    Double prixChoco;

    public Prix() {
    }

    public Prix(Double prixCoca, Double prixChoco) 
    {
        this.prixCoca = prixCoca;
        this.prixChoco = prixChoco;
    }
}
