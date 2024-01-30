import java.util.*;

public class TestingPurposes {
    public static void main(String[] args) {
        
    }
    static int[] merge(int[] sorted1, int[] sorted2){
        int[] result = new int[sorted1.length + sorted2.length];
        int nextRead1 = 0;
        int nextRead2 = 0;
        int nextWrite = 0;
        
        while(nextRead1<sorted1.length && nextRead2 < sorted2.length){
            if (sorted1[nextRead1] < sorted2[nextRead2])
                result[nextWrite++] = sorted1[nextRead1++];
            else
                result[nextWrite++] = sorted2[nextRead2++];
        }

        // Check for remaining elements
        if (nextRead1 < sorted1.length){
            // Copy rest of sorted1 into result
        }
        // Repeat for sorted2.

        return result;
    }
}
