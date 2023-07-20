package test;

import java.util.Date;

import generic.util.Generic;


public class Person extends Generic<Person>{
    
    String name ;
    int age ;
    Date dateDeNaissance;
    boolean isDispo =false ;
    Physic physic ;


    public Person(String name,Physic physic) {
        this.name = name;
        this.physic = physic;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public Person(int age) {
        this.age = age;
    }

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

    public Object getPhysic() {
        return null;
    }


}
