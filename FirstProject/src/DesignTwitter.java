import java.util.*;
import java.util.stream.Collectors;

public class DesignTwitter {

    Map<Integer, Set<Integer>> followers;

    Map<Integer, PriorityQueue<Tweet>> posts;

    public static int timestamp = 999999;

    public DesignTwitter() {
        followers = new HashMap<>();
        posts = new HashMap<>();
    }

    public static class Tweet {
        int id;
        int timestamp;
        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
        public int getTimestamp() {
            return timestamp;
        }

        public int getId() {
            return id;
        }
    }

    public void postTweet(int userId, int tweetId) {
        if(posts.containsKey(userId)) {
            posts.get(userId).add(new Tweet(tweetId, timestamp));
        } else {
            Tweet postedTweet = new Tweet(tweetId, timestamp);
            PriorityQueue<Tweet> pq = new PriorityQueue<>(10, Comparator.comparingInt(Tweet::getTimestamp));
            pq.add(postedTweet);
            posts.put(userId, pq);
        }
        Set<Integer> followerList = followers.get(userId);
        if(followerList != null) {
            for(Integer i : followerList) {
                Queue<Tweet> pq = posts.get(i);
                pq.add(new Tweet(tweetId, timestamp));
            }
        }
        timestamp--;
    }

    public List<Integer> getNewsFeed(int userId) {
        Queue<Tweet> q = posts.get(userId);
        if(q != null) {
            return q.stream().map(Tweet::getId).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public void follow(int followerId, int followeeId) {
        if(followers.containsKey(followeeId)) {
            Set<Integer> followerList = followers.get(followeeId);
            followerList.add(followerId);
            followers.replace(followeeId, followerList);
            return;
        } else {
            Set<Integer> followerList = new HashSet<>();
            followerList.add(followerId);
            followers.put(followeeId, followerList);
        }
        PriorityQueue<Tweet> followerPosts = posts.get(followerId);
        PriorityQueue<Tweet> followeePosts = posts.get(followeeId);
        if(followerPosts == null) {
            followerPosts = new PriorityQueue<>(10, Comparator.comparingInt(Tweet::getTimestamp));
        }
        if(followeePosts == null) {
            return;
        }
        followerPosts.addAll(followeePosts);

        posts.put(followerId, followerPosts);

    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followeeId)) {
            followers.get(followeeId).remove(followerId);
            PriorityQueue<Tweet> followerPosts = posts.get(followerId);
            PriorityQueue<Tweet> followeePosts = posts.get(followeeId);
            if (followerPosts != null && followeePosts != null) {
                for(Tweet i : followerPosts) {
                    for(Tweet j : followeePosts) {
                        if(i.id == j.id) {
                            followerPosts.remove(i);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] Args) {
        DesignTwitter twitter = new DesignTwitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(1, 505);
        twitter.postTweet(1, 333);
        twitter.getNewsFeed(1);
    }
}
