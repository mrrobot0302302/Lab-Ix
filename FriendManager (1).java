package connecthub;
import java.util.*;
public class FriendManager {
    private Map<String, Set<String>> friendsList = new HashMap<>();
    private Map<String, Map<String, String>> friendRequests = new HashMap<>();
    private Map<String, Boolean> userStatus = new HashMap<>();
    private Map<String, Set<String>> blockedUsers = new HashMap<>();
    // Send a friend request
    public void sendFriendRequest(String fromUser, String toUser) {
        friendRequests.putIfAbsent(toUser, new HashMap<>());
        friendRequests.get(toUser).put(fromUser, "Pending");
    }

    // Respond to a friend request
    public void respondToFriendRequest(String toUser, String fromUser, boolean accept) {
        if (!friendRequests.containsKey(toUser)) return;
        Map<String, String> requests = friendRequests.get(toUser);
        if (requests.containsKey(fromUser)) {
            if (accept) {
                friendsList.putIfAbsent(toUser, new HashSet<>());
                friendsList.putIfAbsent(fromUser, new HashSet<>());
                friendsList.get(toUser).add(fromUser);
                friendsList.get(fromUser).add(toUser);
            }
            requests.remove(fromUser);
        }
    }

    // Suggest friends
    public List<String> suggestFriends(String userId) {
        Set<String> currentFriends = friendsList.getOrDefault(userId, new HashSet<>());
        List<String> suggestions = new ArrayList<>();
        for (String user : friendsList.keySet()) {
            if (!user.equals(userId) && !currentFriends.contains(user)) {
                suggestions.add(user);
            }
        }
        return suggestions;
    }

    // Block a friend
    public void blockFriend(String userId, String friendId) {
        blockedUsers.putIfAbsent(userId, new HashSet<>());
        blockedUsers.get(userId).add(friendId);
        friendsList.getOrDefault(userId, new HashSet<>()).remove(friendId);
        friendsList.getOrDefault(friendId, new HashSet<>()).remove(userId);
    }

    // Remove a friend
    public void removeFriend(String userId, String friendId) {
        friendsList.getOrDefault(userId, new HashSet<>()).remove(friendId);
        friendsList.getOrDefault(friendId, new HashSet<>()).remove(userId);
    }

    // Get online/offline status of friends
    public Map<String, Boolean> getFriendStatuses(String userId) {
        Map<String, Boolean> statuses = new HashMap<>();
        Set<String> userFriends = friendsList.getOrDefault(userId, new HashSet<>());
        for (String friend : userFriends) {
            statuses.put(friend, userStatus.getOrDefault(friend, false));
        }
        return statuses;
    }

    // Set user status
    public void setUserStatus(String userId, boolean isOnline) {
        userStatus.put(userId, isOnline);
    }

    // Get friend requests
    public Map<String, String> getFriendRequests(String userId) {
        return friendRequests.getOrDefault(userId, new HashMap<>());
    }

    // Get friend list
    public Set<String> getFriendList(String userId) {
        return friendsList.getOrDefault(userId, new HashSet<>());
    }
}