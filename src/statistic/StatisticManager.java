package statistic;


import statistic.event.EventDataRow;

//будет регистрировать события в хранилище
public class StatisticManager {
    private static StatisticManager instance;

    private StatisticManager(){
    }

    public static StatisticManager getInstance() {
        if(instance == null) instance = new StatisticManager();
        return instance;
    }

    public void register(EventDataRow data){

    }

}
