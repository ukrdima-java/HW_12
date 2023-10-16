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

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть кількість чисел(n): ");
        FizzBuzz fizzBuzz = new FizzBuzz(scanner.nextInt());

        Thread fizzThread = new Thread(fizzBuzz::fizz);
        Thread buzzThread = new Thread(fizzBuzz::buzz);
        Thread fizzbuzzThread = new Thread(fizzBuzz::fizzbuzz);
        Thread numberThread = new Thread(fizzBuzz::number);

        numberThread.start();
        fizzThread.start();
        buzzThread.start();
        fizzbuzzThread.start();

        try {
            numberThread.join();
            fizzThread.join();
            buzzThread.join();
            fizzbuzzThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

