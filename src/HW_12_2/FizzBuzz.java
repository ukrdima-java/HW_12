package HW_12_2;

public class FizzBuzz {
    private final int n;
    private int current;
    private final Object lock;

    public FizzBuzz(int n) {
        this.n = n;
        this.current = 1;
        this.lock = new Object();
    }
    public void fizz() {
        while (current <= n) {
            synchronized (lock) {
                if (current % 3 == 0 && current % 5 != 0) {
                    System.out.print("fizz ");
                    current++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void buzz() {
        while (current <= n) {
            synchronized (lock) {
                if (current % 3 != 0 && current % 5 == 0) {
                    System.out.print("buzz ");
                    current++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void fizzbuzz() {
        while (current <= n) {
            synchronized (lock) {
                if (current % 15 == 0) {
                    System.out.print("fizzbuzz ");
                    current++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void number() {
        while (current <= n) {
            synchronized (lock) {
                if (current % 3 != 0 && current % 5 != 0) {
                    System.out.print(current + " ");
                    current++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
