package utils;

import com.google.common.collect.Ordering;

import java.util.List;

public class SortingUtils {
    public static boolean isSortedBy(List<Double> list, String sortingBy){
        if(sortingBy.equals("Desc")){
            return Ordering.natural().reverse().isOrdered(list);
        }
        else return Ordering.natural().isOrdered(list);
    }
}
