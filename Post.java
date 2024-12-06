package ConnectHub;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
public class Post extends Content {
    private String authorId;
    private String timestamp;

    // Constructor that takes content, authorId, and timestamp
    public Post(String content, String authorId, String timestamp) {
        super(content); // Call the constructor of the Content class
        this.authorId = authorId;
        this.timestamp = timestamp;
    }

    // Getter methods for authorId and timestamp
    public String getAuthorId() {
        return authorId;
    }

    public String getTimestamp() {
        return timestamp;
    }
      public boolean isExpired() {
        // Define the expiration threshold (e.g., 24 hours)
        long expirationHours = 24;

        // Parse the timestamp into a LocalDateTime object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime postTime = LocalDateTime.parse(timestamp, formatter);

        // Get the current time
        LocalDateTime currentTime = LocalDateTime.now();

        // Calculate the difference in hours between the current time and the post's timestamp
        long hoursDifference = ChronoUnit.HOURS.between(postTime, currentTime);

        // If the difference is greater than the expiration threshold, the post is expired
        return hoursDifference > expirationHours;
    }
   
}
