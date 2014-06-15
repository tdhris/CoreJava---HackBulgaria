package exam1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExamUtils {
    public static List<Integer> sort(List<Integer> original) {
        List<Integer> sorted = new ArrayList<Integer>(original);
        Collections.sort(sorted);
        return sorted;
    }
    
    public static List<Integer> reverse(List<Integer> original) {
        List<Integer> reversed = new ArrayList<>(original);
        Collections.reverse(reversed);
        return reversed;
    }
    
    public static boolean isMonotonous(List<Integer> original) {
        return isDecreasing(original) || isIncreasing(original);
    }

    private static boolean isIncreasing(List<Integer> original) {
        for (int i = 0; i < original.size() - 1; i++) {
            if (original.get(i) > original.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDecreasing(List<Integer> original) {
        for (int i = 0; i < original.size() - 1; i++) {
            if (original.get(i) < original.get(i+1)) {
                return false;
            }
        }
        return true;
    }
}
