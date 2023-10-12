package HW_12_2;

public class ThreadB extends Thread {
    @Override
    public void run() {

    }

    public boolean buzz(int number) {
        return number % 5 == 0;
    }
}
