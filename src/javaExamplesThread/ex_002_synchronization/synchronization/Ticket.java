package javaExamplesThread.ex_002_synchronization.synchronization;

public class Ticket {
    boolean isBought;
    int place;

    Ticket(int place) {
        this.place = place;
    }

    // Билет будет покупатся покупаться кассиром
    synchronized void buy(Cashier c) {
        if (!isBought) {
            try {
                // Если билет не куплен, на 1 сек засыпаем
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            // Билет куплен
            isBought = true;
            System.out.println("Cashier " + c.id + " ticket " + this.place);
        }
    }
}
