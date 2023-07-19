package test;

import java.util.Date;

import generic.Generic;

public class Person extends Generic{
    
    String name = "Dylan" ;
    int age ;
    Date dateDeNaissance;


    public Person(String name, int age, Date dateDeNaissance) {
     
        super();
        this.name = name;
        this.age = age;
        this.dateDeNaissance = dateDeNaissance;

    }

    public Person(){

        super();

    }
    

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }
    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }


}
