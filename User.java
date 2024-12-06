package ConnectHub;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private String email;
    private String phone;
     private List<String> friendIds = new ArrayList<>();
     private String status;

    // Constructor
    public User(String userId, String name, String email, String phone) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
     public User(String id, String name, String email, String phone, String status) {
        this.userId = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
       public List<String> getFriendIds() {
        return friendIds;
    }
           public void addFriend(String friendId) {
        this.friendIds.add(friendId);
    }
    public String getStatus() {
        return status;
    }
}
