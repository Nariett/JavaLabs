package TaskThree;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String publication) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(publication);
        }
    }

    public void receivePublication(String publication) {
        notifySubscribers(publication);
    }
}
