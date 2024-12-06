package ConnectHub;
import javax.swing.*;

public class SignupForm extends javax.swing.JFrame {

    // Declare an instance of UserService
    private UserService userService;

    // Declare the GUI components (fields, buttons)
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JTextField phoneField;
    private JButton signupButton;

    // Constructor to initialize the form
    public SignupForm() {
        // Calling the existing initComponents method
        initComponents();
        
        // Initialize the UserService instance
        userService = new UserService();
        
        // Add ActionListener to the signup button (assuming the button exists in initComponents)
        signupButton.addActionListener(evt -> signupButtonActionPerformed(evt));
    }

    // Action performed when the signup button is clicked
    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // Get input values from the form fields
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText();
        String phone = phoneField.getText();

        // Call the non-static signup method on the UserService instance
        userService.signup(username, password, email, phone);

        // Optionally, show a success message or transition to another screen
        JOptionPane.showMessageDialog(this, "Signup successful!");
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

   public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
