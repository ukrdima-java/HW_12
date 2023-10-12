package HW_12_2;

public class ThreadC extends Thread {
    @Override
    public void run() {

    }

    public boolean fizzbuzz(int number) {
        return number % 3 == 0 && number % 5 == 0;
    }
}
