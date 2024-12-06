package ConnectHub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainWindow extends JFrame {
    private String currentUserEmail;
    public MainWindow(String email) {
        // Store the current user's email (or ID)
        this.currentUserEmail = email;
        // Initialize the main window settings
        setTitle("ConnectHub - Main Window");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        // Layout configuration
        setLayout(new BorderLayout());
        // Create a top panel for welcome message and logout button
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel welcomeLabel = new JLabel("Welcome, " + email);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle logout (update status to offline and close window)
                JOptionPane.showMessageDialog(MainWindow.this, "You have logged out.", "Logout", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Close the window (You can add more logout logic here)
            }
        });
        topPanel.add(welcomeLabel);
        topPanel.add(logoutButton);
        add(topPanel, BorderLayout.NORTH);
        // Create a content area with buttons for different sections
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2, 2, 10, 10));

        JButton newsFeedButton = new JButton("Go to NewsFeed");
        newsFeedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewsfeedPage(currentUserEmail).setVisible(true);
                dispose(); // Close the main window
            }
        });
        JButton contentCreationButton = new JButton("Create Content");
        contentCreationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContentCreationPage(currentUserEmail).setVisible(true);
                dispose(); // Close the main window
            }
        });
        JButton profileButton = new JButton("Manage Profile");
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call ProfileManagementPage (assuming it's already implemented)
                // new ProfileManagementPage(currentUserEmail).setVisible(true);
                JOptionPane.showMessageDialog(MainWindow.this, "Profile Management section (not implemented yet).", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JButton friendRequestsButton = new JButton("Friend Requests");
        friendRequestsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Assuming friend requests are handled in a separate class
                // new FriendRequestsPage(currentUserEmail).setVisible(true);
                JOptionPane.showMessageDialog(MainWindow.this, "Friend Requests section (not implemented yet).", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        // Add the buttons to the content panel
        contentPanel.add(newsFeedButton);
        contentPanel.add(contentCreationButton);
        contentPanel.add(profileButton);
        contentPanel.add(friendRequestsButton);
        
        // Add content panel to the main window
        add(contentPanel, BorderLayout.CENTER);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static void main(String[] args) {
        // Launch the MainWindow with an example user email
        SwingUtilities.invokeLater(() -> new MainWindow("user@example.com").setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
