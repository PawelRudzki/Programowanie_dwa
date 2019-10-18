import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class factorialTest {

    @Test
    public void factorialTestI() {

        //given
        int a = 0;
        int b = 1;
        int c = 10;

        //when
        int factorialFromA = Factorial.factorial(a);
        int factorialFromB = Factorial.factorial(b);
        int factorialFromC = Factorial.factorial(c);

        //then
        assertEquals(1, factorialFromA);
        assertEquals(1, factorialFromB);
        assertEquals(3628800, factorialFromC);
    }

    @Test
    public void sumDigitsTestFromInt() {
        //given
        int a = 65;
        int b = 0;
        int c = 101;

        //when
        int resultA = Factorial.returnSumOfDigitsInNumber(a);
        int resultB = Factorial.returnSumOfDigitsInNumber(b);
        int resultC = Factorial.returnSumOfDigitsInNumber(c);

        //then
        assertEquals(11, resultA);
        assertEquals(0, resultB);
        assertEquals(2, resultC);
    }

    @Test
    public void sumDigitsTestFromString() {
        //given
        String a = "65";
        String b = "0";
        String c = "101";

        //when
        int resultA = Factorial.returnSumOfDigitsInNumber(a);
        int resultB = Factorial.returnSumOfDigitsInNumber(b);
        int resultC = Factorial.returnSumOfDigitsInNumber(c);

        //then
        assertEquals(11, resultA);
        assertEquals(0, resultB);
        assertEquals(2, resultC);
    }
}
