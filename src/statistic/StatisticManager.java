package statistic;


import statistic.event.EventDataRow;
import statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//будет регистрировать события в хранилище
public class StatisticManager {
    private static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager(){
    }

    public static StatisticManager getInstance() {
        if(instance == null) instance = new StatisticManager();
        return instance;
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }

    private class StatisticStorage{
        private Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage() {
            storage = new HashMap<>();
            for(EventType event: EventType.values()){
                storage.put(event, new ArrayList<>());
            }
        }

        private void put(EventDataRow data){
            storage.get(data.getType()).add(data);
        }
    }

}
