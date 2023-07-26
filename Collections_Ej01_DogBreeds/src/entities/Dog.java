/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author nohyv
 */
public class Dog {
    private String breed;
    
    //Constructors
    public Dog() {
    }

    public Dog(String breed) {
        this.breed = breed;
    }
    
    //Getters&Setters

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
    
    //toString
    @Override
    public String toString() {
        return "Dog{" + "breed=" + breed + '}';
    }
    
}
