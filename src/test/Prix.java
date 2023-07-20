package test;

import generic.util.Generic;

public class Prix extends Generic<Prix> {
    String id;
    Double prixCoca;
    Double prixChoco;

    public Prix()
    {
        super();
    }
    public Prix(Double prixCoca, Double prixChoco) 
    {
        super();

        this.prixCoca = prixCoca;
        this.prixChoco = prixChoco;
    }
}
