package HW_12_1;

//        Напишіть програму, яка кожну секунду виводить на екрані дані про час, що минув від моменту запуску програми.
//        Другий потік цієї ж програми кожні 5 секунд виводить повідомлення Минуло 5 секунд.

public class Main {
    public static void main(String[] args) {
        FirstThread first = new FirstThread();
        SecondThread second = new SecondThread();
        first.start();
        second.start();
    }
}