package HW_12_2;

public class ThreadD extends Thread {
    @Override
    public void run() {

    }

    public void number(String result, boolean hasNext) {
        System.out.print(result + (hasNext ? ", " : "."));
    }
}
