
import java.sql.*;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 987132
 */
public class DbConnection {
    private static Connection connection = null;
    
    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/entries","root","12345678");               
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
            return connection;
        }
    }
    
    public static ArrayList<Word> getDefinition(String word) {
        connection = DbConnection.getConnection();
        ArrayList<Word> definition = new ArrayList<Word>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT wordtype, definition FROM entries where word = ?");
            statement.setString(1, word);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Word def = new Word();
                def.setWordtype(rs.getString("wordtype"));
                def.setDefinition(rs.getString("definition"));
                definition.add(def);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }       
        return definition;
    }
    
}
