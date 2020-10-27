package pl.coderslab;

import java.util.Random;
import java.util.Scanner;

public class Zgadywanie_liczb {


    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("Komputer wybrał liczbę od 0 do 100. Zgadnij jaka to liczba!");
        //Komputer losuje liczbę
        int liczbaKomputer = random.nextInt(101);
        System.out.print("Wpisz liczbę: ");
        Scanner scanner = new Scanner(System.in);
        int liczba = -1;
        int count = 0;
        //wprowadzam mój strzał
        while (liczba!=liczbaKomputer) {
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.print("Nieprawidłowe dane. Podaj jeszcze raz: ");
            }
            liczba = scanner.nextInt();
            count++;
            //sprawdzam czy liczba jest wieksza od liczby komputera
            if(liczba > liczbaKomputer){
                System.out.print("Wprowadź mniejszą liczbę: ");
                //sprawdzam czy jest mniejsza od liczby komputera
            }else if (liczba < liczbaKomputer){
                System.out.print("Wprowadź większą liczbę: ");
            }
        }
        System.out.println("GRATULACJE! Liczba wylosowana przez komputer to: " + liczba);
        System.out.println("Zgadłeś w " + count + " ruchach!");

    }
}
