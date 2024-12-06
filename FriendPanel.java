package connecthub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Set;

public class FriendPanel extends JPanel {
    private FriendManager friendManager;
    private String currentUserId = "user1"; // For demo purposes

    public FriendPanel(FriendManager manager) {
        this.friendManager = manager;
        setLayout(new BorderLayout());

        // Friend Requests Panel
        JPanel requestsPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        requestsPanel.setBorder(BorderFactory.createTitledBorder("Friend Requests"));

        Map<String, String> friendRequests = friendManager.getFriendRequests(currentUserId);
        for (String fromUser : friendRequests.keySet()) {
            JPanel request = new JPanel(new FlowLayout());
            JLabel label = new JLabel("Request from: " + fromUser);
            JButton acceptButton = new JButton("Accept");
            JButton declineButton = new JButton("Decline");

            acceptButton.addActionListener(e -> {
                friendManager.respondToFriendRequest(currentUserId, fromUser, true);
                refresh();
            });

            declineButton.addActionListener(e -> {
                friendManager.respondToFriendRequest(currentUserId, fromUser, false);
                refresh();
            });

            request.add(label);
            request.add(acceptButton);
            request.add(declineButton);
            requestsPanel.add(request);
        }

        // Friend List Panel
        JPanel friendListPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        friendListPanel.setBorder(BorderFactory.createTitledBorder("Friend List"));

        Set<String> friends = friendManager.getFriendList(currentUserId);
        for (String friend : friends) {
            JPanel friendEntry = new JPanel(new FlowLayout());
            JLabel label = new JLabel(friend + " ("
                    + (friendManager.getFriendStatuses(currentUserId).getOrDefault(friend, false) ? "Online" : "Offline") + ")");
            JButton removeButton = new JButton("Remove");
            JButton blockButton = new JButton("Block");

            removeButton.addActionListener(e -> {
                friendManager.removeFriend(currentUserId, friend);
                refresh();
            });

            blockButton.addActionListener(e -> {
                friendManager.blockFriend(currentUserId, friend);
                refresh();
            });

            friendEntry.add(label);
            friendEntry.add(removeButton);
            friendEntry.add(blockButton);
            friendListPanel.add(friendEntry);
        }

        // Suggestions Panel
        JPanel suggestionsPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        suggestionsPanel.setBorder(BorderFactory.createTitledBorder("Friend Suggestions"));

        for (String suggestion : friendManager.suggestFriends(currentUserId)) {
            JPanel suggestionEntry = new JPanel(new FlowLayout());
            JLabel label = new JLabel("Suggested: " + suggestion);
            JButton sendRequestButton = new JButton("Send Request");

            sendRequestButton.addActionListener(e -> {
                friendManager.sendFriendRequest(currentUserId, suggestion);
                refresh();
            });

            suggestionEntry.add(label);
            suggestionEntry.add(sendRequestButton);
            suggestionsPanel.add(suggestionEntry);
        }

        // Add panels to the main panel
        add(requestsPanel, BorderLayout.NORTH);
        add(friendListPanel, BorderLayout.CENTER);
        add(suggestionsPanel, BorderLayout.SOUTH);
    }

    // Refresh the UI
    private void refresh() {
        removeAll();
        revalidate();
        repaint();
        add(new FriendPanel(friendManager));
    }

    // Main method to run the GUI
    public static void main(String[] args) {
        FriendManager manager = new FriendManager();
        manager.setUserStatus("user2", true); // Simulate online status
        manager.setUserStatus("user3", false); // Simulate offline status

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Friend Management");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.add(new FriendPanel(manager));
            frame.setVisible(true);
        });
    }
}
