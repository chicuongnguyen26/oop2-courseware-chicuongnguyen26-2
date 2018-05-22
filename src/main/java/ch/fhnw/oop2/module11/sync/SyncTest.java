package ch.fhnw.oop2.module11.sync;

/**
 * @author Dieter Holz
 */
public class SyncTest {
    private int count;

    public void increase() {
        int temp = count;
        count = temp + 1;
        System.out.println(count);
    }

    public void decrease() {
        int temp = count;
        count = temp - 1;
        System.out.println(count);
    }

    public static void main(String[] args) {
        SyncTest st = new SyncTest();

        Thread increaseThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                st.increase();
                sleep();
            }
        });

        Thread decreaseThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                st.decrease();
                sleep();
            }
        });


        //Thread zum Start freigeben
        increaseThread.start();
        decreaseThread.start();
    }

    private static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            //nothing to do
        }
    }
}
