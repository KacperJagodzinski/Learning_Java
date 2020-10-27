package pl.coderslab;

import java.util.Scanner;

public class Zgadywanie_odwrotne {
    public static void main(String[] args) {
        //wypisuje polecenie
        System.out.println("Wymyśl liczbę od 1 do 1000 i zapamietaj ją. \nKomputer będzie próbował odganąć Twoją liczbę!");
        System.out.println("Jeżeli Twoja liczba jest większa od podanej przez komputer napisz \"więcej\"");
        System.out.println("Jeżeli Twoja liczba jest mniejsza od podanej przez komputer napisz \"mniej\"");
        System.out.println("Jeżeli komputer odgadł Twoją liczbę napisz \"zgadles\"");
        //deklaruje wartosc minimalna i maksymalna
        int min = 1;
        int max = 1000;
        int count = 0;
        //wprowadzam pierwszy strzał w połowie zakresu liczb
        int guess = ((max - min) / 2) + min;
        //System.out.println("Twoja liczba to: " + guess);
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        while (!(answer.equals("zgadles"))) {
            guess = guess = ((max - min) / 2) + min;
            System.out.println("Twoja liczba to: " + guess);
            answer = scanner.nextLine();
            if (answer.equals("mniej")) {
                if(guess == min){
                    System.out.println("Nie oszukuj!");

                }
                max = guess;
                count++;
            } else if (answer.equals("wiecej")){
                min=guess;
                count++;
            }
        }
        System.out.println("WYGRAŁEM!" + "Zgadłem w ruchach: " + count);


    }
}
