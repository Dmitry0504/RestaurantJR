package main;

import kitchen.Cook;
import kitchen.Waiter;

import java.util.Observer;

public class Restaurant {

    public static void main(String[] args) {
        Tablet tablet1 = new Tablet(1);
        Cook cook = new Cook("Amigo");
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        tablet1.addObserver(cook);
        tablet1.createOrder();
        tablet1.createOrder();

    }
}
