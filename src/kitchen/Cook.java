package kitchen;

import main.ConsoleHelper;
import main.Tablet;
import statistic.StatisticManager;
import statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private String name;
    private Observer observer;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Order order = (Order) arg;
        Tablet tablet = (Tablet) o;
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(
                tablet.toString(), name, order.getTotalCookingTime(), order.getDishes()));
        ConsoleHelper.writeMessage("Start cooking - " + arg);
        setChanged();
        notifyObservers(arg);
    }
}
