package database;

import java.sql.*;
import models.*;

public class CharityDatabase {
    public void insertDonor(Donor donor) throws SQLException {
        String query = "INSERT INTO donors (id, name, email) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, donor.getId());
            stmt.setString(2, donor.getName());
            stmt.setString(3, donor.getEmail());
            stmt.executeUpdate();
        }
    }

    public void updateDonorEmail(int id, String newEmail) throws SQLException {
        String query = "UPDATE donors SET email = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newEmail);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    public void deleteDonor(int id) throws SQLException {
        String query = "DELETE FROM donors WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public void listDonors() throws SQLException {
        String query = "SELECT * FROM donors";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("Donor{id=" + rs.getInt("id") + ", name='" + rs.getString("name") + "', email='" + rs.getString("email") + "'}");
            }
        }
    }
}
