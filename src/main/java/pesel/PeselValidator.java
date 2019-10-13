package pesel;

import java.lang.reflect.Array;

public class PeselValidator {

    //Rozważmy PESEL osoby urodzonej 8 lipca 1902 roku, płci żeńskiej (parzysta końcówka numeru z serii – 0362). Czyli mamy wówczas 0207080362. Teraz kolejne cyfry należy przemnożyć przez odpowiednie wagi i dodać do siebie.
    //0*1 + 2*3 + 0*7 + 7*9 + 0*1 + 8*3 + 0*7 + 3*9 + 6*1 + 2*3 = 0 + 6 + 0 + 63 + 0 + 24 + 0 + 27 + 6 + 6 = 132
    //Wynik dzielimy modulo przez 10.
    //132 mod 10 = 2
    //A następnie odejmujemy od 10
    //10 - 2 = 8.
    //I wynik dzielimy znów modulo 10
    //8 mod 10 = 8
    //Cyfra kontrolna to 8, zatem nasz prawidłowy numer PESEL to: 02070803628

    public boolean validate(String pesel) {

        if (pesel.length() != 11 || pesel == null) return false;

        int array[] = new int[]{1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        char peselArray[] = pesel.toCharArray();
        System.out.println(peselArray);


        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue((peselArray[i])) * array[i];


        }

        sum = (10 - (sum % 10)) % 10;

        if (sum == Character.getNumericValue(peselArray[10])) {
            return true;
        } else {

            return false;
        }
    }

}
