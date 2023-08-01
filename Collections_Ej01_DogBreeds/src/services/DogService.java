/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Utilities.Comparators;
import entities.Dog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author nohyv
 */
public class DogService {
    private final ArrayList<Dog> dogsList;
    
    public DogService(){
        dogsList= new ArrayList<>();
    }
    
    public Dog createDog(String breed) {
        if (breedExist(breed)) {
            System.out.println(breed + " is already in the list");
            return null;
        } else {
            System.out.println("Adding " + breed + " to the list");
            Dog d = new Dog(breed);
            return d;
        }
    }
    
    public boolean breedExist(String breed){
        return dogsList.stream().anyMatch((dog) -> (dog.getBreed().equalsIgnoreCase(breed)));
    }
    
    public void addDog(Dog dog){
        dogsList.add(dog);
    }
    
    public void showListOfDogs(){
        dogsList.forEach((dog) -> {
            System.out.println(dog.getBreed());
        });
    }
    
    public void showSortedListOfDogs(){
        System.out.println("List of dogs alphabetically sorted");
        Collections.sort(dogsList, Comparators.sortListOfDogsAlphabetically);
        showListOfDogs();
    }
    
    public int showNumbListOfDogs(){
        int index= 1;
        
        for(Dog dog: dogsList) {
            System.out.println(index+". "+dog.getBreed());
            index++;
        }
        
        return dogsList.size();
    }
    
    public void readDogBreeds(){
        Scanner input= new Scanner(System.in);
        String choice;
        
        do{
            System.out.println("Enter the breed of the dog:");
            String breed= input.nextLine();
            
            if(breedExist(breed)){
                System.out.println(breed+" is already in the list");
            }else{
                Dog addedDog= createDog(breed);
                addDog(addedDog);
                System.out.println(breed+" sucesfully added");
            }
            
            System.out.print("Do you want to add another dog? (y/n): ");
            choice = input.nextLine();
            
        }while(choice.equalsIgnoreCase("y"));
    }
    
    public void updateDogBreed(int index, String breed){
//        Dog dog= dogsList.get(index);
//          
//        dog.setBreed(breed);
        Dog dog= createDog(breed);
        
        dogsList.set(index, dog);
          
    }
    
    public void eliminateDogBreed(String breed){
        boolean eliminated= false;
        Iterator<Dog> iterator= dogsList.iterator();
        
        while(iterator.hasNext()){
            if(iterator.next().getBreed().equalsIgnoreCase(breed)){
                iterator.remove();
                eliminated= true;
            }
        }
        
        if(eliminated){
            System.out.println("Sucesfully eliminated");
        }else{
            System.out.println(breed+" not found");
        }
    }
}
