package test;

import generic.util.Generic;

public class Prix extends Generic<Prix> {
    String id;
    int prixCoca;
    int prixChoco;

    public Prix()
    {
        super();
    }
    public Prix(int prixCoca, int prixChoco) 
    {
        super();

        this.prixCoca = prixCoca;
        this.prixChoco = prixChoco;
    }
}
