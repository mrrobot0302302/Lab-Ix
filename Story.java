package ConnectHub;

public class Story extends Content {
    private String title;
    private String authorId;
    private String content;

    // Constructor accepting arguments for Story, calling the Content constructor
    public Story(String id, String title, String authorId, String content) {
        super(id);  // Pass 'id' to the parent class (Content) constructor
        this.title = title;
        this.authorId = authorId;
        this.content = content;
    }

    // Getters for Story class fields
    public String getTitle() {
        return title;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getContent() {
        return content;
    }
}
