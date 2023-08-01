/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import entities.Dog;
import java.util.Comparator;

/**
 *
 * @author nohyv
 */
public class Comparators {
    public static Comparator<Dog> sortListOfDogsAlphabetically= (Dog o1, Dog o2) -> o1.getBreed().compareTo(o2.getBreed());
    
    public static Comparator<Dog> sortListOfDogsAlphabeticallyDesc= (Dog o1, Dog o2) -> o2.getBreed().compareTo(o1.getBreed());
}
