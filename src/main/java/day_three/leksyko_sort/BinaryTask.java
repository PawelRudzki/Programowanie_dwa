package day_three.leksyko_sort;

import java.util.List;
import java.util.stream.Collectors;

public class BinaryTask {

    public static void main(String[] args) {
        BinaryTask binaryTask = new BinaryTask();
        binaryTask.resultTask(3, 3, 2);

    }

    void resultTask(int d, int n, int k) {

        BinaryHelper binaryHelper = new BinaryHelper();

        List<String> list = binaryHelper.binaryArrayWithoutDoubleOnes(0, d);

        list = list
                .stream()
                .filter(a -> a.length() == n)
                .collect(Collectors.toList());


        if (list.size() >= k) {
            System.out.println(list.get(k));
        } else {
            System.out.println("-1");
        }


    }


}
