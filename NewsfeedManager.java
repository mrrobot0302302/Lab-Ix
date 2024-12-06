package ConnectHub;

import java.util.ArrayList;
import java.util.List;


public class NewsfeedManager {

    private ContentManager contentManager;  // Assuming ContentManager contains posts
    private UserService userService;        // Assuming UserService is for user management

    public NewsfeedManager() {
        this.contentManager = new ContentManager();
        this.userService = new UserService();
    }

    // Method to get a list of posts for the user's newsfeed
    public List<Post> getUserNewsfeed(String userId) {
        List<Post> newsfeed = new ArrayList<>();

        // Step 1: Get the user and their friends
        List<String> friendIds = userService.getFriendIds(userId);  // Get the list of friend IDs
        friendIds.add(userId);  // Add the user themselves to the newsfeed (if desired)

        // Step 2: Retrieve posts from the ContentManager
        for (String friendId : friendIds) {
            List<Post> postsForFriend = contentManager.getPostsForUser(friendId);  // Get posts for each friend
            newsfeed.addAll(postsForFriend);  // Add all posts to the newsfeed
        }

        // Return the combined list of posts
        return newsfeed;
    }

    // Method to generate the newsfeed as a list of Content (if required)
    public List<Content> toList() {
        List<Content> contentList = new ArrayList<>();

        // Convert List<Post> to List<Content> (assuming Post extends Content)
        for (Post post : contentManager.getPosts()) {
            contentList.add(post);  // Add each post to the content list
        }

        return contentList;  // Return the list of Content (which includes Post)
    }

    // Other methods can be added to filter, sort, etc., if needed
}
