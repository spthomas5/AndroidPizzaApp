package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents an abstract Pizza with toppings, size, sauce, and additional options.
 * Subclasses, such as Deluxe, Meatzza, and Pepperoni, extend this class to define specific pizza types.
 * 
 * The Pizza class includes methods to calculate the price, manage toppings, and provide a string representation.
 * 
 * @author [Adam Trabelsi, Sean Thomas]
 */
public abstract class Pizza {
    protected ArrayList<Topping> toppings; //Topping is a enum class
    protected Size size; //Size is a enum class
    protected Sauce sauce; //Sauce is a enum class
    protected boolean extraSauce;
    protected boolean extraCheese;

    private static final double TAX_RATE = 0.06625;

    /**
     * Abstract method to calculate the price of the pizza.
     * Subclasses must implement this method.
     * 
     * @return the total price of the pizza.
     */
    public abstract double price(); //polymorphism

    /**
     * Abstract method to get the name of a pizza
     *
     * @return the name of a pizza
     */
    public abstract String name(); //polymorphism
     /**
     * Sets the extra cheese option for the pizza.
     * 
     * @param extraCheese true if extra cheese is selected, false otherwise.
     */
    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    /**
     * Retrieves the list of toppings on the pizza.
     * 
     * @return the list of toppings.
     */
    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    /**
     * Sets the toppings for the pizza.
     * 
     * @param toppings the list of toppings to be set.
     */
    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    /**
     * Adds a topping to the pizza.
     * 
     * @param topping the topping to be added.
     */
    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    /**
     * Removes a topping from the pizza.
     * 
     * @param topping the topping to be removed.
     * @return true if the topping is successfully removed, false otherwise.
     */
    public boolean removeTopping(Topping topping) {
        return this.toppings.remove(topping);
    }

    /**
     * Checks if extra cheese is selected for the pizza.
     * 
     * @return true if extra cheese is selected, false otherwise.
     */
    public boolean isExtraCheese() {
        return extraCheese;
    }

    /**
     * Checks if extra sauce is selected for the pizza.
     * 
     * @return true if extra sauce is selected, false otherwise.
     */
    public boolean isExtraSauce() {
        return extraSauce;
    }

    /**
     * Sets the extra sauce option for the pizza.
     * 
     * @param extraSauce true if extra sauce is selected, false otherwise.
     */
    public void setExtraSauce(boolean extraSauce) {
        this.extraSauce = extraSauce;
    }

     /**
     * Sets the sauce for the pizza.
     * 
     * @param sauce the sauce to be set.
     */
    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    /**
     * Retrieves the sauce of the pizza.
     * 
     * @return the sauce of the pizza.
     */
    public Sauce getSauce() {
        return sauce;
    }

     /**
     * Sets the size of the pizza.
     * 
     * @param size the size to be set.
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Retrieves the size of the pizza.
     * 
     * @return the size of the pizza.
     */
    public Size getSize() {
        return size;
    }

    /**
     * Calculates additional fees for the pizza based on size and extra options.
     * 
     * @return the total additional fees for the pizza.
     */
    public double calculateFees(){
        double sizeFee;
        if (this.size == null) {
            sizeFee = 0.0;
        }else {
            sizeFee = switch (this.size) {
                case SMALL -> 0.0;
                case MEDIUM -> 2.0;
                case LARGE -> 4.0;
            };
        }
        double extraFees = (this.extraCheese ? 1 : 0) + (this.extraSauce ? 1 : 0);
        return extraFees + sizeFee;
    }


     /**
     * Generates a string representation of the pizza including price, toppings, sauce, and additional options.
     * 
     * @return a string representation of the pizza.
     */
    @Override
    public String toString() {
        String toppingsString = "";
        for (int i = 0; i < toppings.size(); i++) {
            toppingsString += toppings.get(i);
            if (i < toppings.size() - 1) {
                toppingsString += ",";
            }
        }


        return "Price: $" + String.format("%,.2f", this.price() ) + " Price with Tax: $"
                + String.format("%,.2f", this.price() * (1+ TAX_RATE) )
                + " Toppings: " + toppingsString + " | " + "Sauce: "
                + this.sauce.toString() + " | "  + "Extra sauce: "
                + (this.extraSauce ? "Yes" : "No") + " | "
                + "Extra cheese: " + (this.extraCheese ? "Yes" : "No");
    }
}