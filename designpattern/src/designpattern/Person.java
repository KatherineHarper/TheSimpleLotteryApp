/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpattern;



import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
/**
 *
 * @author 92018448
 */
public class Person implements Observer{
    
    private String personName;
    //bingo numbers for each player
    private List<Integer> bingoSet = new ArrayList<Integer>(); 
    //to control how many numbers left to match, when = 0, BINGO!
    private int matchesLeft = 3;
    private NumberCallout numberCallout;
 
    // constructor
    public Person(String pName) {            
            
            personName = pName;
            bingoSet = createBingoSet();           
            System.out.print(personName + "  ");
            //displays numbers in Person's bingo set
            for (int i:bingoSet){
                System.out.print(i + ", ");
            }
            System.out.println();
            
    }
 
  //  holds lotto numbers
    @SuppressWarnings("empty-statement")
    private ArrayList<Integer> createBingoSet(){
        ArrayList<Integer> newBingoSet = new ArrayList<Integer>();
     Collections.addAll(newBingoSet, 10, 20, 30, 40, 500, 3);
    
    return newBingoSet;
    
    }
    
    
    // mandatory method because implements Observer
    @Override
    public void update(Observable o, Object numberCallout) {
        this.numberCallout = (NumberCallout)numberCallout;        
        //checks through the person't bingo set. If number matched the one called out, the amount of numbers to match is reduced
        for (int num:bingoSet){
            if (num == this.numberCallout.getCalloutNumber()){
                matchesLeft--;
            }
        }  
        // Person matched all the numbers, print out victory message and set victory condition to be true
        if (matchesLeft == 0){
            System.out.println("****** WINNER ****** \n Congratulations " + personName + " \nYou have won " );
            this.numberCallout.victory = true;            
        }
    }
}