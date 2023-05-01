package TaskThree;

import java.util.ArrayList;
import java.util.List;

class PostOffice implements Subscriber {
    private List<String> publications = new ArrayList<>();

    public void update(String publication) {
        publications.add(publication);
        System.out.println("Почтовое отделение: получено издание - " + publication);
    }

    public void sendPublicationsToSubscribers() {
        System.out.println("Почтовое отделение: отправка изданий подписчикам");
        for (String publication : publications) {
            System.out.println("Почтовое отделение: отправлено издание - " + publication);
        }
        publications.clear();
    }
}