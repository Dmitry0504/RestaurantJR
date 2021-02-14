package main;

import kitchen.Cook;

import java.util.Observer;

public class Restaurant {

    public static void main(String[] args) {
        Tablet tablet1 = new Tablet(1);
        Observer observer = new Cook("Amigo");
        tablet1.addObserver(observer);
        tablet1.createOrder();
        tablet1.createOrder();

    }
}
