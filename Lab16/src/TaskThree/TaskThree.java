package TaskThree;

public class TaskThree {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        PostOffice postOffice = new PostOffice();
        publisher.addSubscriber(postOffice);

        publisher.receivePublication("Газета №1");
        publisher.receivePublication("Журнал №1");

        postOffice.sendPublicationsToSubscribers();
    }
}
