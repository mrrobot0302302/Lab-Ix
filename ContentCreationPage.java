package ConnectHub;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContentCreationPage extends JFrame {
    private String userEmail; // To hold the user's email passed from the previous page

    // Constructor that accepts a String (user's email)
    public ContentCreationPage(String email) {
        // Initialize user email
        this.userEmail = email;

        // Set up the frame
        setTitle("Content Creation");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Layout and components
        setLayout(null);

        // Display welcome message with the user's email
        JLabel welcomeLabel = new JLabel("Welcome, " + email);
        welcomeLabel.setBounds(50, 20, 400, 30);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(welcomeLabel);

        // Create label for the post input
        JLabel postLabel = new JLabel("Create Post:");
        postLabel.setBounds(50, 70, 100, 30);
        add(postLabel);

        // Create text area for the post content
        JTextArea postArea = new JTextArea();
        postArea.setBounds(50, 110, 400, 100);
        postArea.setLineWrap(true);
        postArea.setWrapStyleWord(true);
        postArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(postArea);

        // Add a button to create the post
        JButton createPostButton = new JButton("Create Post");
        createPostButton.setBounds(150, 250, 200, 30);
        createPostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String postContent = postArea.getText();
                if (!postContent.isEmpty()) {
                    // Handle content creation (save to the database or memory)
                    JOptionPane.showMessageDialog(ContentCreationPage.this, "Post Created Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    postArea.setText(""); // Clear the text area after submission
                } else {
                    JOptionPane.showMessageDialog(ContentCreationPage.this, "Post content cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(createPostButton);

        // Optionally add a button to create a story
        JButton createStoryButton = new JButton("Create Story");
        createStoryButton.setBounds(150, 290, 200, 30);
        createStoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String storyContent = postArea.getText();
                if (!storyContent.isEmpty()) {
                    // Handle story creation (save to the database or memory)
                    JOptionPane.showMessageDialog(ContentCreationPage.this, "Story Created Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    postArea.setText(""); // Clear the text area after submission
                } else {
                    JOptionPane.showMessageDialog(ContentCreationPage.this, "Story content cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(createStoryButton);
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
        // Launch the ContentCreationPage, passing an example email for testing
        SwingUtilities.invokeLater(() -> new ContentCreationPage("user@example.com").setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
