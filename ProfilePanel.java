package connecthub;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfilePanel extends JPanel {
    private ProfileManager profileManager;

    // Constructor
    public ProfilePanel(ProfileManager manager) {
        this.profileManager = manager;
        setLayout(new BorderLayout());

        // Components for profile update
        JPanel profilePanel = new JPanel(new GridLayout(5, 2, 5, 5));
        profilePanel.setBorder(BorderFactory.createTitledBorder("Update Profile"));

        JLabel userIdLabel = new JLabel("User ID:");
        JTextField userIdField = new JTextField();
        JLabel bioLabel = new JLabel("Bio:");
        JTextField bioField = new JTextField();
        JLabel profilePhotoLabel = new JLabel("Profile Photo Path:");
        JTextField profilePhotoField = new JTextField();
        JLabel coverPhotoLabel = new JLabel("Cover Photo Path:");
        JTextField coverPhotoField = new JTextField();
        JButton updateProfileButton = new JButton("Update Profile");

        profilePanel.add(userIdLabel);
        profilePanel.add(userIdField);
        profilePanel.add(bioLabel);
        profilePanel.add(bioField);
        profilePanel.add(profilePhotoLabel);
        profilePanel.add(profilePhotoField);
        profilePanel.add(coverPhotoLabel);
        profilePanel.add(coverPhotoField);
        profilePanel.add(new JLabel()); // Spacer
        profilePanel.add(updateProfileButton);

        // Components for password update
        JPanel passwordPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        passwordPanel.setBorder(BorderFactory.createTitledBorder("Change Password"));

        JLabel userIdPasswordLabel = new JLabel("User ID:");
        JTextField userIdPasswordField = new JTextField();
        JLabel newPasswordLabel = new JLabel("New Password:");
        JPasswordField newPasswordField = new JPasswordField();
        JButton updatePasswordButton = new JButton("Update Password");

        passwordPanel.add(userIdPasswordLabel);
        passwordPanel.add(userIdPasswordField);
        passwordPanel.add(newPasswordLabel);
        passwordPanel.add(newPasswordField);
        passwordPanel.add(new JLabel()); // Spacer
        passwordPanel.add(updatePasswordButton);

        // Add action listeners
        updateProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = userIdField.getText().trim();
                String bio = bioField.getText().trim();
                String profilePhoto = profilePhotoField.getText().trim();
                String coverPhoto = coverPhotoField.getText().trim();

                if (userId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "User ID cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                profileManager.updateProfile(userId, bio, profilePhoto, coverPhoto);
                JOptionPane.showMessageDialog(null, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        updatePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = userIdPasswordField.getText().trim();
                String newPassword = new String(newPasswordField.getPassword()).trim();

                if (userId.isEmpty() || newPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "User ID and Password cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                boolean success = profileManager.updatePassword(userId, newPassword);
                if (success) {
                    JOptionPane.showMessageDialog(null, "Password updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update password. User not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add panels to the main panel
        add(profilePanel, BorderLayout.NORTH);
        add(passwordPanel, BorderLayout.SOUTH);
    }

    // Main method to run the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Profile Manager");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.add(new ProfilePanel(new ProfileManager()));
            frame.setVisible(true);
        });
    }
}
