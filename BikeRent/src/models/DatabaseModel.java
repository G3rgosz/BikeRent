
package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DatabaseModel {
    
    private String host;
    private String db;
    private String port;
    private String user;
    private String pass;
    private Connection conn;
    
    public DatabaseModel() {
        host = "localhost";
        db = "tanar_bikerent";
        port = "3306";
        user = "root";
        pass = "";
        conn = null;
        getConnection();
    }
    
    private void getConnection(){
        try {
            //jdbc://localhost:3306/tanar_bikerent
            String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean isConnected(){
        if(conn == null){
            return false;
        }else{
            return true;
        }
    }
    public ResultSet getMember(){
        
        String sql = "SELECT name, email, phone, address, identity FROM renters";
                     
        
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rs;
    }
}
