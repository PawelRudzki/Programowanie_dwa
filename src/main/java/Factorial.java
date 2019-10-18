import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Factorial {
    public static void main(String[] args) {

        int anyIntYouWant = 8;


        returnSumOfDigitsInNumber("65");

    }

    static int factorial(int a) {
        if (a == 0) {
            return 1;
        } else {
            return factorial(a - 1) * a;
        }
    }

    static int returnSumOfDigitsInNumber(int number) {

        int sum = 0;
        do {
            if (number < 10) {
                sum += number;
                return sum;
            }

            sum += number % 10;
            number = number / 10;

        } while (true);
    }

    static int returnSumOfDigitsInNumber(String number) {

        List<Character> listOfChars = number
                .chars()
                .mapToObj(a -> (char) a)
                .collect(Collectors.toList());

//        ALTERNATYWNE ROZWIĄZANIE
//        int result = 0;
//        for (char digit : listOfChars) {
//            result += Character.getNumericValue(digit);
//        }
        
        return number
                .chars()
                .reduce(0, (subtotal, element)->
                        subtotal + Character.getNumericValue(element));

    }
}
