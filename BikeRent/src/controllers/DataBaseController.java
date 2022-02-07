
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
        setDatabase();
    }
    protected boolean setDatabase(){
        dbModel = new DatabaseModel();
        if(dbModel.isConnected()){
            return true;
        }else{
            return false;
        }
    }
    public Vector<Vector<Object>> getMembers(){
        Vector<Vector<Object>> members = new Vector<>();
        ResultSet rs = dbModel.getMember();
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
    
}
