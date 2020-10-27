package pl.coderslab;

import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LOTTO {
    static int[] wprowadzanieLiczb(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj 6 liczb! ");
        int[] array = new int[6];
        for (int i = 0; i < array.length ; i++) {

            try {
                System.out.println("Liczba " + (i +1));
                array[i] = scanner.nextInt();
                if(array[i] < 49) {
                    for (int j = 0; j < i; j++) {
                        if (array[i] == array[j]) {
                            System.out.println("Liczba już była. Wybierz inną.");
                            i--;
                        }
                    }
                }else{
                    System.out.println("Liczba musi być mniejsza niż 49. ");
                    i--;
                }

            }catch(InputMismatchException e) {
                System.out.println("Podaj liczbę.");
                i--;
                scanner.next();
            }
        }
        return array;
    }

    static int[] losowanieLICZB(){

        System.out.println("Zwolnienie blokady i rozpoczynamy losowanie: ");
        Integer[] liczby = new Integer[49];
        for (int i = 0; i < liczby.length; i++) {
            liczby[i] = i +1 ;
        }
        //System.out.println(Arrays.toString(liczby));
        Collections.shuffle(Arrays.asList(liczby));
        //System.out.println(Arrays.toString(liczby));
        System.out.println("Wylosowane liczby to");
        int[] wylosowane = new int[6];
        for (int i = 0; i < 6 ; i++) {
            wylosowane[i] = liczby[i];
        }
        return wylosowane;
    }

    static String wygrana(int[] podane, int[] wylosowane){
        int count =0;
        for (int i = 0; i < podane.length ; i++) {
            for (int j = 0; j < wylosowane.length ; j++) {
                if(podane[i] == wylosowane[j]){
                    count++;
                }

            }

        }
        String wygrana = "";
        switch(count) {
            case 0:
                wygrana = "Nic nie trafiłeś. Spróbuj jeszcze raz!";
                break;
            case 1:
                wygrana = "Trafiłeś 1 liczbę. Spróbuj jeszcze raz!";
                break;
            case 2:
                wygrana = "Trafłeś 2 liczby. Spróbuj jeszcze raz!";
                break;
            case 3:
                wygrana = "Trafiłeś \"trójkę\"! Gratulacje!";
                break;
            case 4:
                wygrana = "Trafiłeś \"czwórkę\"! Gratulacje!";
                break;
            case 5:
                wygrana = "Trafiłeś 5 liczb! Super!";
                break;
            case 6:
                wygrana = "Jaki kolor Lambo pan sobie życzy? GRATULACJE TRAFIŁEŚ WSZYSTKIE LICZBY";
                break;
            default:
                wygrana = "coś nie wyszło";// code block
        }

        return wygrana;
    }




    public static void main(String[] args) {
        int[] arr = wprowadzanieLiczb();
        System.out.println(Arrays.toString(arr));
        int[] wylosowane = losowanieLICZB();
        System.out.println(Arrays.toString(wylosowane));
        System.out.println(wygrana(arr,wylosowane));

    }




}
