package HW_12_2;

public class ThreadA extends Thread {
    @Override
    public void run() {

    }

    public boolean fizz(int number) {
        return number % 3 == 0;
    }
}
