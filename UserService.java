package ConnectHub;

import java.util.List;
import java.util.ArrayList;

public class UserService {

    // List to store users
    private List<Post> posts;
    private List<User> users;

    // Constructor
    public UserService() {
        users = new ArrayList<>();
        posts = new ArrayList<>();
    }
     public List<String> getFriendIds(String userId) {
        List<String> friendIds = new ArrayList<>();
                // Find the user by ID
        User user = getUserById(userId);
        if (user != null) {
            // Assuming the User class has a method to get their friends by ID
            friendIds = user.getFriendIds();  // You need to implement this method in User class
        }
        return friendIds;

     }
    // Method to add a user
    public void addUser(User user) {
        users.add(user);
    }

    // Method to get a user by their userId
    public User getUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;  // Return null if user not found
    }

    // Method to sign up a user
    public boolean signup(String userId, String name, String email, String phone) {
        // Check if user already exists
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return false; // User already exists
            }
        }
        
        // Create and add new user
        User newUser = new User(userId, name, email, phone);
        users.add(newUser);
        return true;
    }

    // Method to get a list of all users
    public List<User> getAllUsers() {
        return users;
    }

    // Method to update user details (if needed)
    public boolean updateUser(String userId, String name, String email, String phone) {
        User user = getUserById(userId);
        if (user != null) {
            user.setName(name);
            user.setEmail(email);
            user.setPhone(phone);
            return true;  // Update successful
        }
        return false;  // User not found
    }

    // Method to delete a user by userId
    public boolean deleteUser(String userId) {
        User user = getUserById(userId);
        if (user != null) {
            users.remove(user);
            return true;  // Deletion successful
        }
        return false;  // User not found
    }
     public List<Post> getPostsForUser(String userId) {
        List<Post> userPosts = new ArrayList<>();
        for (Post post : posts) {
            if (post.getAuthorId().equals(userId)) {
                userPosts.add(post);
            }
        }
        return userPosts;
    }
    // Other methods for user service if required...
}
