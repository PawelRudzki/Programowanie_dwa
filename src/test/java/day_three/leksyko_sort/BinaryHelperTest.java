package day_three.leksyko_sort;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BinaryHelperTest {

    @Test
    public void binaryTest() {

        //given

        BinaryHelper binaryHelper = new BinaryHelper();
        int start = 1;
        int end = 10;

        //when

        List<String> resultList = binaryHelper.binaryArrayWithoutDoubleOnes(start, end);

        //then
        assertEquals(7, resultList.size());

        assertEquals("1", resultList.get(0));
        assertEquals("10", resultList.get(1));
        assertEquals("100", resultList.get(2));
        assertEquals("101", resultList.get(3));
        assertEquals("1000", resultList.get(4));
        assertEquals("1001", resultList.get(5));
        assertEquals("1010", resultList.get(6));

    }

    @Test
    public void binaryTestII() {


        //given

        BinaryHelper binaryHelper = new BinaryHelper();
        int start = 1;
        int end = 100000;

        //when

        List<String> resultList = binaryHelper.binaryArrayWithoutDoubleOnes(start, end);

        //then

        assertEquals(4180, resultList.size());

        assertEquals("1", resultList.get(0));
        assertEquals("10", resultList.get(1));
        assertEquals("100", resultList.get(2));
        assertEquals("101", resultList.get(3));
        assertEquals("1000", resultList.get(4));
        assertEquals("1001", resultList.get(5));
        assertEquals("1010", resultList.get(6));

    }
}

