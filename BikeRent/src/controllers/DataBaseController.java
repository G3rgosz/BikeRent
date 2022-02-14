
package controllers;

import java.util.Vector;
import models.DatabaseModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseController {
    
    private DatabaseModel dbModel;
    
    public DataBaseController() {
    }
    protected boolean setDatabase(){
        dbModel = new DatabaseModel();
        dbModel.getConnection();
        if(dbModel.isConnected()){
            return true;
        }else{
            return false;
        }
    }
    public Vector<Vector<Object>> getMembers(){
        Vector<Vector<Object>> members = new Vector<>();
        ResultSet rs = dbModel.getMember("getMembers");
        try {
            while(rs.next()){
                Vector<Object> member = new Vector<>();
                member.add(rs.getString("name"));
                member.add(rs.getString("email"));
                member.add(rs.getString("phone"));
                member.add(rs.getString("address"));
                member.add(rs.getString("identity"));
                members.add(member);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return members;
    }
    public Vector<Vector<Object>> getBikes(){
        Vector<Vector<Object>> bikes = new Vector<>();
        ResultSet rs = dbModel.getBike("getBikes");
        try {
            while(rs.next()){
                Vector<Object> bike = new Vector<>();
                bike.add(rs.getString("type"));
                bike.add(rs.getString("design"));
                bike.add(rs.getString("size"));
                bike.add(rs.getString("brake"));
                bike.add(rs.getString("speed"));
                bike.add(rs.getString("brand"));
                bike.add(rs.getString("code"));
                bikes.add(bike);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bikes;
    }
    public Vector<Vector<Object>> getRents(){
        Vector<Vector<Object>> rents = new Vector<>();
        ResultSet rs = dbModel.getRent("getRents");
        try {
            while(rs.next()){
                Vector<Object> rent = new Vector<>();
                rent.add(rs.getString("name"));
                rent.add(rs.getString("code"));
                rent.add(rs.getString("startdate"));
                rent.add(rs.getString("enddate"));
                rent.add(rs.getString("deposit"));
                rents.add(rent);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rents;
    }
    
}
