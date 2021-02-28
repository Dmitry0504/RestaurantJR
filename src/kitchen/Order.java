package kitchen;

import main.ConsoleHelper;
import main.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime(){
        int time = 0;
        if(!dishes.isEmpty()){
            for(Dish dish: dishes){
                time += dish.getDuration();
            }
        }
        return time;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    @Override
    public String toString() {
        return "Your order: " + dishes + " of " + tablet + ", cooking time " + getTotalCookingTime() + "min";
    }

}
