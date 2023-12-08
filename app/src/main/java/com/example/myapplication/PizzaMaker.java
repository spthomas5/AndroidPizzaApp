package com.example.myapplication;

/**
 * Factory for creating instances of various pizza types.
 * It uses the PizzaType enum to determine the type of pizza to instantiate.
 * 
 * @author [Adam Trabelsi, Sean Thomas]
 */
public class PizzaMaker {
    /**
     * Creates a new Pizza instance based on the specified pizza type.
     *
     * @param pizzaType A String representing the type of pizza to create.
     * @return The created Pizza instance corresponding to the specified type.
     */
    public static Pizza createPizza(String pizzaType) {
        Pizza pizza = switch (PizzaType.valueOf(pizzaType)){
            case DELUXE -> new Deluxe();
            case SUPREME -> new Supreme();
            case MEATZZA -> new Meatzza();
            case SEAFOOD -> new Seafood();
            case PEPPERONI -> new Pepperoni();
            case BYO -> new BuildYourOwn();
        };
        return pizza;
    }
}
