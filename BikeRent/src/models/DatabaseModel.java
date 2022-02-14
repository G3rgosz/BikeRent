
package models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
    }
    private String[] getSql(String fileName){
        String filePath = "sql/" + fileName + ".sql";
        String[] sql = null;
        try {
            Path path = Path.of(filePath);
            String content = Files.readString(path);
            sql = content.split(";");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sql;
    }
    public void getConnection(){
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
    public ResultSet getMember(String fileName){
        
        String[] sql = getSql(fileName);
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql[0]);    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rs;
    }
    public ResultSet getBike(String fileName){
        
        String[] sql = getSql(fileName);
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql[0]);    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rs;
    }
    public ResultSet getRent(String fileName){
        
        String[] sql = getSql(fileName);
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql[0]);    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rs;
    }
}
