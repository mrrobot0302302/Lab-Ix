package ConnectHub;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class NewsfeedPage extends JFrame {
    private String currentUserEmail;
    private JPanel contentPanel;
    private JButton createPostButton;
    private JButton refreshButton;
    private JList<String> postsList;
    private DefaultListModel<String> postsListModel;
    private UserService userService;
    private ContentManager contentManager;

    // Constructor to initialize the NewsfeedPage with the current user's email
    public NewsfeedPage(String email) {
        this.currentUserEmail = email;
        this.userService = new UserService();
        this.contentManager = new ContentManager();

        setTitle("Newsfeed");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Top Panel with User Info and Refresh Button
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel userLabel = new JLabel("Logged in as: " + currentUserEmail);
        topPanel.add(userLabel);

        refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(this::handleRefresh);
        topPanel.add(refreshButton);
        add(topPanel, BorderLayout.NORTH);

        // Content Panel for Posts and Stories
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(contentPanel), BorderLayout.CENTER);

        // List of posts
        postsListModel = new DefaultListModel<>();
        postsList = new JList<>(postsListModel);
        JScrollPane postScroll = new JScrollPane(postsList);
        contentPanel.add(postScroll);

        // Create New Post Button
        createPostButton = new JButton("Create New Post");
        createPostButton.addActionListener(this::handleCreatePost);
        contentPanel.add(createPostButton);

        // Load user's posts and friends (to be extended)
        loadUserPostsAndFriends();
    }

    // Load posts and friends data
    private void loadUserPostsAndFriends() {
        List<Post> posts = contentManager.getPostsForUser(currentUserEmail);
        for (Post post : posts) {
            postsListModel.addElement(post.getContent() + " - " + post.getTimestamp());
        }
    }

    // Refresh button action listener
    private void handleRefresh(ActionEvent e) {
        // Refresh the list of posts
        postsListModel.clear();
        loadUserPostsAndFriends();
    }

    // Handle creation of a new post
    private void handleCreatePost(ActionEvent e) {
        String postContent = JOptionPane.showInputDialog(this, "Enter Post Content:");
        if (postContent != null && !postContent.trim().isEmpty()) {
            // Create the post (with no image for simplicity)
            contentManager.createPost(currentUserEmail, postContent);
            // Refresh after creating the post
            handleRefresh(e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NewsfeedPage("test@example.com").setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
