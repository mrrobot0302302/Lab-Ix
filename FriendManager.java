package ConnectHub;

import java.util.List;

public class FriendManager {

    private UserService userService;
    private FriendshipService friendshipService;

    // Constructor to initialize services
    public FriendManager(UserService userService, FriendshipService friendshipService) {
        this.userService = userService;
        this.friendshipService = friendshipService;
    }

    // Method to display user's status using getStatus()
    public void displayUserStatus(String userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            System.out.println("User: " + user.getName() + " - Status: " + user.getStatus());
        } else {
            System.out.println("User not found.");
        }
    }

    // Method to display user's friends list
    public void displayUserFriends(String userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            List<String> friends = userService.getFriendIds(userId);
            System.out.println("Friends of " + user.getName() + ": ");
            for (String friendId : friends) {
                User friend = userService.getUserById(friendId);
                if (friend != null) {
                    System.out.println("- " + friend.getName());
                }
            }
        } else {
            System.out.println("User not found.");
        }
    }

    // Method to create a friendship between two users
    public void createFriendship(String userId1, String userId2) {
        User user1 = userService.getUserById(userId1);
        User user2 = userService.getUserById(userId2);

        if (user1 != null && user2 != null) {
            friendshipService.createFriendship(user1, user2);
            System.out.println("Friendship created between " + user1.getName() + " and " + user2.getName());
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Method to get the user's posts
    public void displayUserPosts(String userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            List<Post> posts = userService.getPostsForUser(userId);
            System.out.println("Posts from " + user.getName() + ":");
            for (Post post : posts) {
                System.out.println("- " + post.getContent() + " (Timestamp: " + post.getTimestamp() + ")");
            }
        } else {
            System.out.println("User not found.");
        }
    }

    // Method to get the user's friend status
    public void displayFriendStatus(String userId1, String userId2) {
        if (friendshipService.isFriend(userId1, userId2)) {
            System.out.println(userId1 + " and " + userId2 + " are friends.");
        } else {
            System.out.println(userId1 + " and " + userId2 + " are not friends.");
        }
    }

    // Method to remove friendship between two users
    public void removeFriendship(String userId1, String userId2) {
        if (friendshipService.removeFriendship(userId1, userId2)) {
            System.out.println("Friendship removed between " + userId1 + " and " + userId2);
        } else {
            System.out.println("No friendship exists between " + userId1 + " and " + userId2);
        }
    }
}
