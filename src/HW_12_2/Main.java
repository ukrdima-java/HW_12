package HW_12_2;

//Напишіть програму, що виводить в консоль рядок, що складається з чисел від 1 до n, але з заміною деяких значень:
//
//        якщо число ділиться на 3 - вивести fizz
//        якщо число ділиться на 5 - вивести buzz
//        якщо число ділиться на 3 і на 5 одночасно - вивести fizzbuzz
//        Наприклад, для n = 15, очікується такий результат: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.
//
//        Програма повинна бути багатопотоковою, і працювати з 4 потоками:
//
//        Потік A викликає fizz(), щоб перевірити, чи ділиться число на 3, і якщо так - додати в чергу на виведення для потоку D рядок fizz.
//        Потік B викликає buzz(), щоб перевірити, чи ділиться число на 5, і якщо так - додати в чергу на виведення для потоку D рядок buzz.
//        Потік C викликає fizzbuzz(), щоб перевірити, чи ділиться число на 3 та 5 одночасно, і якщо так - додати в чергу на виведення для потоку D рядок fizzbuzz.
//        Потік D викликає метод number(), щоб вивести наступне число з черги, якщо є таке число для виведення.

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть кількість чисел(n): ");
        int n = scanner.nextInt();
        ArrayList<Integer> numbers = new ArrayList<>();
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        ThreadC threadC = new ThreadC();
        ThreadD threadD = new ThreadD();
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        for(int i = 1; i <= n; i++)
            numbers.add(i);
        for(int i = 0; i < numbers.size(); i++) {
            boolean hasNext = i < numbers.size() - 1;
            if(threadC.fizzbuzz(numbers.get(i)))
                threadD.number("fizzbuzz", hasNext);
            else if(threadB.buzz(numbers.get(i)))
                threadD.number("buzz", hasNext);
            else if(threadA.fizz(numbers.get(i)))
                threadD.number("fizz", hasNext);
            else if(true)
                threadD.number("" + numbers.get(i), hasNext);
        }
    }
}
