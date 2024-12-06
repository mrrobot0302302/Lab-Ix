package ConnectHub;

import java.util.ArrayList;
import java.util.List;

public class ContentManager {
    
    private List<Post> posts; // List to store posts
    private String postId;
    
    public ContentManager() {
        this.posts = new ArrayList<>(); // Initialize the list of posts
    }

    // Method to create a new post and add it to the list
    public void createPost(String content, String authorId) {
        Post newPost = new Post(postId, content, authorId);
// Create a new post with the content and authorId
        posts.add(newPost); // Add the post to the list
    }

    // Method to retrieve all posts
    public List<Post> getPosts() {
        return posts; // Return the list of posts
    }

    // Method to get posts for a specific user (by authorId)
    public List<Post> getPostsForUser(String authorId) {
        List<Post> userPosts = new ArrayList<>();
        for (Post post : posts) {
            if (post.getAuthorId().equals(authorId)) {
                userPosts.add(post); // Add posts by this author
            }
        }
        return userPosts; // Return the filtered list of posts by the user
    }

    // Method to remove expired stories (for example, older than a certain date)
    public void removeExpiredStories() {
        // Assuming a condition for expiry (this is just an example)
        posts.removeIf(post -> post.isExpired());
    }
}
