package day_three;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeksykoSort {

    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "ala",
                "1",
                "2",
                "12",
                "22",
                "200",
                "1000",
                "kot"
        );

        Collections.sort(list);

        //sortujemy według długości binarnej

        System.out.println(Arrays.toString(list.toArray()));
    }

//    public static List<String> removeElementsContainingDoubleOnes(List<String> list){
//
//    }


}
