package connecthub;

import java.util.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfileManager {

    private static final String DATABASE_FILE = "database.csv";

    // Update user profile
    public void updateProfile(String userId, String bio, String profilePhoto, String coverPhoto) {
        List<Map<String, String>> database = loadDatabase();
        for (Map<String, String> user : database) {
            if (user.get("userId").equals(userId)) {
                user.put("bio", bio);
                user.put("profilePhoto", profilePhoto);
                user.put("coverPhoto", coverPhoto);
                saveDatabase(database);
                return;
            }
        }
    }

    // Update password
    public boolean updatePassword(String userId, String newPassword)  {
        if (newPassword.isEmpty()) {
            return false;
        }
        String hashedPassword = hashPassword(newPassword);
        List<Map<String, String>> database = loadDatabase();
        for (Map<String, String> user : database) {
            if (user.get("userId").equals(userId)) {
                user.put("password", hashedPassword);
                saveDatabase(database);
                return true;
            }
        }
        return false;
    }

    // Load database from CSV file
    public List<Map<String, String>> loadDatabase() {
        List<Map<String, String>> database = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE))) {
            String headerLine = reader.readLine(); // Read header
            if (headerLine == null) return database; // Empty file

            String[] headers = headerLine.split(",");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",", -1); // Include empty values
                Map<String, String> user = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    user.put(headers[i], values[i]);
                }
                database.add(user);
            }
        } catch (IOException e) {
            System.out.println("Error loading database: " + e.getMessage());
        }
        return database;
    }

    // Save database to CSV file
    public void saveDatabase(List<Map<String, String>> database) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_FILE))) {
            if (database.isEmpty()) return;

            // Write header
            Set<String> headers = database.get(0).keySet();
            writer.write(String.join(",", headers));
            writer.newLine();

            // Write user data
            for (Map<String, String> user : database) {
                List<String> values = new ArrayList<>();
                for (String header : headers) {
                    values.add(user.getOrDefault(header, ""));
                }
                writer.write(String.join(",", values));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving database: " + e.getMessage());
        }
    }

    // Password hashing (placeholder, implement hashing as needed)
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for(byte b : hashBytes){
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ProfileManager.class.getName()).log(Level.SEVERE, null, ex);
            return password;
        }
    }
}
