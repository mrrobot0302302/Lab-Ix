public class Main {
    public static void main(String[] args) {
        ContentManager contentManager = new ContentManager();
        
        // Add some Post objects (which extend Content)
        contentManager.addContent(new Post("Post 1", "user1"));
        contentManager.addContent(new Post("Post 2", "user2"));

        // Now retrieve a list of Posts (type-safe)
        List<Post> posts = contentManager.toList(Post.class);
        
        // Print out the posts
        for (Post post : posts) {
            System.out.println(post.getContent());
        }
    }
}