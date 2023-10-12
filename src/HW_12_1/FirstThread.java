package HW_12_1;

public class FirstThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Минуло 5 секунд");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
