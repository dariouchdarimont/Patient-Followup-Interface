/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.patient.followup.project;

/**
 *
 * @author dardar2000
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

    public static void main(String[] args) {

        try {
            String url = "jdbc:mysql://localhost:3306/projet_patient_follow_up";
            String username = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database.");
            
            String sql = "SELECT * FROM person";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                // process each row of the result set
            }

        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());

        }

    }
}
        
