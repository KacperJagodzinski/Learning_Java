package pl.coderslab;

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Kostka {

//    xDy+z
//
//    gdzie:
//
//    y – rodzaj kostek, których należy użyć (np. D6, D10),
//    x – liczba rzutów kośćmi (jeśli rzucamy raz, ten parametr jest pomijalny),
//    z – (opcjonalnie) liczba, którą należy dodać (lub odjąć) do wyniku rzutów.

    static int instrukcja() {
        Scanner scan = new Scanner(System.in);
        String kostka = scan.nextLine();
        StringTokenizer tokenizer = new StringTokenizer(kostka, "D+-");
        int y = 0;
        int x = 1;
        int z = 0;
        if (kostka.startsWith("D")) {
            y = Integer.valueOf(tokenizer.nextToken());
            if (tokenizer.hasMoreTokens()) {
                z = Integer.valueOf(tokenizer.nextToken());
                if (kostka.contains("-")) ;
                {
                    z = -z;
                }
            }
            System.out.println("Rodzaj kostki" + y);
            System.out.println("Dodajesz: " + z);
        } else {
            x = Integer.valueOf(tokenizer.nextToken());
            y = Integer.valueOf(tokenizer.nextToken());
            z = Integer.valueOf(tokenizer.nextToken());
            System.out.println("Rzucasz razy: " + x);
            System.out.println("Rodzaj kostki" + y);
            System.out.println("Dodajesz: " + z);

        }
        Random rand = new Random();
        int sum=0;
        for (int i = 0; i < x; i++) {
            int los=rand.nextInt(y)+1;
            System.out.println("Wyrzuciłeś: " + los);
            sum += los;
            System.out.println();
        }
        return sum+z;
    }

    public static void main(String[] args) {
        System.out.println("suma= "+  instrukcja());

    }
}
