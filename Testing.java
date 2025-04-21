
import java.util.*;
public class Testing {

    public static void main(String[] args) {
        int n = 3;
        int[][] menPrefs = {{0,1,2},{1,0,2},{0,2,1}};
        int[][] invWomenPrefs = {
            {0,2,1},
            {1,0,2},
            {0,2,1}
        };
        int[] wife = match(n, menPrefs, invWomenPrefs);
        for (int m=0; m<n; m++){
            System.out.printf("Man %d -> Women %d%n", m, wife[m]);
        }
    }

    private static int[] match(int n, int[][] menPrefs, int[][] invWomenPrefs){
        int[] wife = new int[n];
        int[] husband = new int[n];
        int[] nextProposal = new int[n];
        Arrays.fill(wife, -1);
        Arrays.fill(husband, -1);

        Queue<Integer> freeMen = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            freeMen.add(i);
        while (!freeMen.isEmpty()){
            int m = freeMen.poll();
            int w = menPrefs[m][nextProposal[m]++];
            if (husband[w] < 0){
                wife[m] = w;
                husband[w] = m;
            }
            else if (invWomenPrefs[w][m] < invWomenPrefs[w][husband[w]]){
                freeMen.add(husband[w]);
                wife[husband[w]] = -1;
                wife[m] = w;
                husband[w] = m;
            }
            else{
                freeMen.add(m);
            }
        }
        return wife;
    }

}
