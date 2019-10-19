package day_three.leksyko_sort;

import java.util.ArrayList;
import java.util.List;

class BinaryHelper {

    List<String> binaryArrayWithoutDoubleOnes(int start, int end) {
        List<String> resultList = new ArrayList<>();

        String tmp;

        for (int i = start; i <= end; i++) {
            tmp = Integer.toBinaryString(i);
            if (!tmp.contains("11")) resultList.add(tmp);
        }
        return resultList;
    }


//        OPCJA NA STREAMACH
//        public List<String> converToBinary(int start, int end) {
//            List<Long> longList = new ArrayList<>();
//            for (int i = start; i <= end; i++) {
//                longList.add((long) i);
//            }
//​
//            List<String> resultList = longList.stream()
//                    .map(a -> Long.toBinaryString(a))
//                    .filter(a -> !a.contains("11"))
//                    .collect(Collectors.toList());
//​
//            return resultList;
//        }


}
