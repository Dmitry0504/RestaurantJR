package ad;


//Рекламное объявление
public class Advertisement {
    //видео
    private Object content;
    //имя/название
    private String name;
    //начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    private long initialAmount;
    //количество оплаченных показов
    private int hits;
    //продолжительность в секундах
    private int duration;
    //стоимость одного показа
    private long amountPerOneDisplaying = 0;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        if(hits > 0) amountPerOneDisplaying = initialAmount/hits;
    }

    public int getHits() {
        return hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate(){
        if(hits <= 0) throw new UnsupportedOperationException();
        hits--;
    }
}