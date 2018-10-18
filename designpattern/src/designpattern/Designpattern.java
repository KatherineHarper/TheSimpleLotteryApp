/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpattern;

/**
 *
 * @author 92018448
 */
public class Designpattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("**** Welcome to the Simple Lotto **** ");
        
        //Creating obervable and observer objects
        NumberCallout observable = new NumberCallout();
        Person observer1 = new Person("Tama");
        Person observer2 = new Person("Bob");
        Person observer3 = new Person("Caesar");
        
        //subscribing observers to the observable object that will call out the numbers
        observable.registerObserver(observer1);
        observable.registerObserver(observer2);
        observable.registerObserver(observer3);
        //the object will call out the numbers until the vicrtory condition is achieved by one of the subscribed objects
        while(observable.checkVictoryCondition() == false){
            observable.generateRandomNumber();        
        }
        //the program terminates when a winner is announced
        System.exit(0);
    }
    
}
