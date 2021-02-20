package ad;

import main.ConsoleHelper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 у каждого планшета будет свой объект менеджера, который будет
 подбирать оптимальный набор роликов и их последовательность для каждого заказа.
 Он также будет взаимодействовать с плеером и отображать ролики.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }

        //сортируем лист по стоимости видео за один показ
        //вторичная сортировка по стоимости одной секунды показа
        storage.list().sort(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement a1, Advertisement a2) {
                int result = Long.compare(a2.getAmountPerOneDisplaying(), a1.getAmountPerOneDisplaying());
                if (result != 0) return result;

                long oneSecondCost1 = a1.getAmountPerOneDisplaying() * 1000 / a1.getDuration();
                long oneSecondCost2 = a2.getAmountPerOneDisplaying() * 1000 / a2.getDuration();

                return Long.compare(oneSecondCost1, oneSecondCost2);
            }
        });


        int duration = timeSeconds;
        //результирующий список рекламных роликов
        //отбираем в него самые выгодные по цене ролики
        List<Advertisement> resList = new ArrayList<>();
        while (duration > 0){
            for(Advertisement advertisement: storage.list()){
                if(duration < advertisement.getDuration()) continue;

                if(!resList.contains(advertisement) && advertisement.getHits() > 0){
                    duration -= advertisement.getDuration();
                    resList.add(advertisement);
                }
            }
            duration = 0;
        }
        //выводим рекламу в консоль
        //точнее какие ролики будут показаны
        for(Advertisement a: resList){
            ConsoleHelper.writeMessage(a.getName() + " is displaying... "
                    + a.getAmountPerOneDisplaying() + ", "
                    + a.getAmountPerOneDisplaying() * 1000 / a.getDuration());

            a.revalidate();
        }

    }

}
