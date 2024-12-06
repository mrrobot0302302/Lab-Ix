package ConnectHub;

import java.util.HashSet;
import java.util.Set;

public class FriendshipService {

    private Set<Friendship> friendships;

    public FriendshipService() {
        this.friendships = new HashSet<>();
    }

    // Method to create a friendship between two users
    public void createFriendship(User user1, User user2) {
        Friendship friendship = new Friendship(user1, user2);
        friendships.add(friendship);
    }

    // Method to check if two users are friends
    public boolean isFriend(String userId1, String userId2) {
        for (Friendship friendship : friendships) {
            if (friendship.isBetween(userId1, userId2)) {
                return true;
            }
        }
        return false;
    }

    // Method to remove a friendship between two users
    public boolean removeFriendship(String userId1, String userId2) {
        for (Friendship friendship : friendships) {
            if (friendship.isBetween(userId1, userId2)) {
                friendships.remove(friendship);
                return true;
            }
        }
        return false;
    }
}
