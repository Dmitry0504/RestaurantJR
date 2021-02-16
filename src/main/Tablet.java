package main;

import kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private Observer observer;

    public Tablet(int number) {
        this.number = number;
    }

    //создает заказ из тех блюд, которые выберет пользователь
    public Order createOrder(){
        Order order;
        try {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            if(order.isEmpty()) return null;
            setChanged();
            notifyObservers(order);
            return order;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        return null;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
