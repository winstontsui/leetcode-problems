/*
 * Leetcode 355: Design Twitter. Java. Medium.
 * O(klogk) runtime and O(n) space complexity.
 * Nasty problem. Use a max-heap to merge the latest tweets from the user 
 * and their followed accounts by iteratively extracting the most recent tweets
 * 6/14/2024 Winston Tsui
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


class Twitter {
    HashMap<Integer, HashSet<Integer>> isFollowing = new HashMap<>();

    // TweetList maps each user to a list of their tweet's [chronological order, tweetId].
    HashMap<Integer, List<int[]>> tweetList = new HashMap<>();
    int order = 0;
    
    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        if (tweetList.containsKey(userId)) {
        } else {
            tweetList.put(userId, new ArrayList<>());
        }

        // Newer tweets have larger values.
        tweetList.get(userId).add(new int[]{order++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        Queue<int[]> heap = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]); // Max heap based on tweet's chronological order
        HashSet<Integer> followedAccounts = isFollowing.get(userId);
        if (followedAccounts == null) 
            followedAccounts = new HashSet<>();
        followedAccounts.add(userId);

        for (Integer user: followedAccounts){
            if (tweetList.get(user) != null && !tweetList.get(user).isEmpty()){
                List<int[]> userTweetList = tweetList.get(user);
                // Add to heap [tweetOrder, tweetId, user, next most recent tweet position for user]
                heap.add(new int[]{userTweetList.get(userTweetList.size()-1)[0], 
                userTweetList.get(userTweetList.size()-1)[1], user, userTweetList.size()-2});
            }

        }

        for (int i = 0; i < 10; i++){
            if (!heap.isEmpty()){
                int[] curr = heap.remove();
                newsFeed.add(curr[1]);
                if (curr[3] > -1)
                    heap.add(new int[]{tweetList.get(curr[2]).get(curr[3])[0], 
                    tweetList.get(curr[2]).get(curr[3])[1], curr[2], curr[3]- 1});
            }
        }
        return newsFeed;

    }

    public void follow(int followerId, int followeeId) {
        if (!isFollowing.containsKey(followerId))
            isFollowing.put(followerId, new HashSet<>());
        isFollowing.get(followerId).add(followeeId);
        
    }

    public void unfollow(int followerId, int followeeId) {
        if (isFollowing.get(followerId) != null)
            isFollowing.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
