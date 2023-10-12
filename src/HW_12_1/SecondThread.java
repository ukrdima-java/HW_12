package HW_12_1;

public class SecondThread extends Thread {
    long startTime = System.currentTimeMillis();
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Час роботи програми: " + (System.currentTimeMillis() - startTime));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
