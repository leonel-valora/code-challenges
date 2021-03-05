package ConstanteKaprekar;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero");
        String input = sc.nextLine();
        try {
            isInputValid(input);
            kaprekarRoutine(input);
        } catch(Exception e) {
            System.out.println(e);
        }
        sc.close();
    }
    private static void kaprekarRoutine(String input) {
        for(int i = 1; i <= 7; i++) {
            int dNumber = Integer.parseInt(descendOrder(input));
            int aNumber = Integer.parseInt(ascendOrder(input));
            int rNumber = dNumber - aNumber;
            System.out.println(descendOrder(input) + " - " + ascendOrder(input) + " = " + rNumber);
            input = String.valueOf(rNumber);
            if(rNumber == 6174) {
                break;
            }
        }
    }

    private static String ascendOrder(String input) {
        input = fourDigitsLength(input);
        String result = "";
        String[] numbers = input.split("");
        int[] array = new int[4];
        for(int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }
        Arrays.sort(array);
        for(int n : array) {
            result += n;
        }
        return result;
    }

    private static String descendOrder(String input) {
        input = fourDigitsLength(input);
        String result = "";
        String[] numbers = input.split("");
        Integer[] array = new Integer[4];
        for(int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }
        Arrays.sort(array, Collections.reverseOrder());
        for(Integer n : array) {
            result += n;
        }
        return result;
    }

    private static String fourDigitsLength(String input) {
        while(input.length() < 4) {
			input = 0 + input;
		}
        return input;
    }

    private static void isInputValid(String input) {
        try {
            Integer.parseInt(input);
        } catch(Exception e) {
            throw new IllegalArgumentException("La entrada debe ser un numero decimal");
        }
        if(input.length() > 4 || input.length() < 2) {
            throw new IllegalArgumentException("La entrada debe tener de dos a cuatro numeros");
        }
        char n = input.charAt(0);
        for(int i = 1; i < input.length(); i++) {
            if(n != input.charAt(i)) {
                break;
            } 
            if(n == input.charAt(i) && input.length() - 1 == i ) {
                throw new IllegalArgumentException("La entrada debe contener al menos dos numeros distintos");
            } 
        }
    }
}