package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;

    /**
    * Enum class for pizza types
    * @author [Adam Trabelsi, Sean Thomas]
    */
public enum PizzaType {
    DELUXE,
    SUPREME,
    MEATZZA,
    SEAFOOD,
    PEPPERONI,
        SEAN_ADAM,
        SHRIMP,
VEGGIE,
        ITALIANO,
        FIRE,
    BYO;

    /**
     * Generates an ArrayList of specialty pizza names
     *
     * @return ArrayList of specialty pizza names.
     */
    public static ArrayList<String> specialtyPizzaNames() {
        PizzaType[] pizzaTypes = values();
        String[] names = new String[pizzaTypes.length];

        for (int i = 0; i < pizzaTypes.length; i++) {
            if (pizzaTypes[i].equals(PizzaType.BYO)){
                continue;
            }
            String name = pizzaTypes[i].name().toLowerCase();
            names[i] = name.substring(0, 1).toUpperCase() + name.substring(1);
        }

        return new ArrayList<>(Arrays.asList(names));
    }
}
