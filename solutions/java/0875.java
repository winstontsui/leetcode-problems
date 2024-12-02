

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = piles[0];

        // Binary search range: [1, max(piles)]
        for (int pile : piles)
            right = Math.max(right, pile);
            
        while (left < right){
            int mid = left + (right - left) / 2;

            // Check if Koko can finish with speed `mid`
            if (canFinish(mid, h, piles))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
    private boolean canFinish(int k, int h, int[] piles){
        int count = 0;

        for (int pile : piles)
            count += Math.ceil((double) pile / k);

        return count <= h;
    }
}
