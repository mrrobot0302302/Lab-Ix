package ConnectHub;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;

    public LoginForm() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 50, 100, 30);
        add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(150, 50, 200, 30);
        add(emailField);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 30);
        add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 30);
        add(passwordField);
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 30);
        loginButton.addActionListener(this::handleLogin);
        add(loginButton);
        JButton signupButton = new JButton("Signup");
        signupButton.setBounds(250, 150, 100, 30);
        signupButton.addActionListener(e -> {
            new SignupForm().setVisible(true);
            dispose();
        });
        add(signupButton);
    }
    private void handleLogin(ActionEvent e) {
        try {
            UserService userService = new UserService();
            boolean isLoggedIn = userService.login(emailField.getText(), new String(passwordField.getPassword()));
            if (isLoggedIn) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                new NewsfeedPage(emailField.getText()).setVisible(true);  // Pass email to NewsfeedPage
                dispose(); // Close LoginForm
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
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

    /**
     * @param args the command line arguments
     */
       public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
