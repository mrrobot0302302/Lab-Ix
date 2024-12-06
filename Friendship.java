package ConnectHub;

public class Friendship {

    private String user1Id;
    private String user2Id;
    private String status;
      private User user1;
    private User user2;
    // Constructor
      public Friendship(String user1Id, String user2Id, String status) {
        this.user1Id = user1Id;
        this.user2Id = user2Id;
        this.status = status;
    }

   public String getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(String user1Id) {
        this.user1Id = user1Id;
    }

    public String getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(String user2Id) {
        this.user2Id = user2Id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Constructor accepting User objects
    public Friendship(User user1, User user2, String status) {
        this.user1 = user1;
        this.user2 = user2;
        this.status = status;
    }

    // Getter and Setter methods
    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

  

 

    // Implementing the isBetween method
    public boolean isBetween(String userId1, String userId2) {
        // Check if this friendship involves the two given users (user1Id and user2Id)
        return (user1Id.equals(userId1) && user2Id.equals(userId2)) || (user1Id.equals(userId2) && user2Id.equals(userId1));
    }
}
