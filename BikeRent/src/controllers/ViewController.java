
package controllers;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.BikeModel;
import models.ViewModel;
import views.BikeForm;


public class ViewController {
    
    private BikeForm bikeFrm;
    private ViewModel viewMdl;
    private BikeModel bikeMdl;
    private Vector<Vector<Object>> tableData;
    private DataBaseController dbCtr;
    
    public ViewController(DataBaseController dbCtr) {
        
        this.dbCtr = dbCtr;
        bikeFrm = new BikeForm();
        viewMdl = new ViewModel();
        initComponents();
        initListeners();
        start();
    }
            
    private void initComponents() {
        if(dbCtr.setDatabase()){
            bikeFrm.setStatusLbl("Kapcsolat: OK");
        }else{
            bikeFrm.setStatusLbl("Kapcsolat: NINCS!");
        }
    }
    
    private void initListeners() {
        bikeFrm.getExitBtn().addActionListener( event -> { exit(); });
        bikeFrm.getDeleteBtn().addActionListener(event -> { delete(); });
        bikeFrm.getEditBtn().addActionListener(event -> { edit(); });
        bikeFrm.getSaveBtn().addActionListener(event -> { save(); });
        bikeFrm.getSearchBtn().addActionListener(event -> { search(); }); 
        bikeFrm.getTableTb().addChangeListener(event -> { initTables(); });
    }

    private void start(){
        initTables();
        bikeFrm.setVisible( true );
    }
    
    private void initTables(){
        
        Vector<String> columnNames = new Vector<>();
        tableData = new Vector<>();
        
        switch (bikeFrm.getTableTb().getSelectedIndex()) {
            case 0 ->   {
                tableData = dbCtr.getMembers();
                tableData.add(null);
                columnNames = viewMdl.getMemberColumnNames();
                TableModel tableMdl = new DefaultTableModel(tableData, columnNames);
                bikeFrm.getMemberTbl().setModel(tableMdl);
            }
            case 1 ->   {
                tableData = dbCtr.getBikes();
                tableData.add(null);
                columnNames = viewMdl.getBikeColumnNames();
                TableModel tableMdl = new DefaultTableModel(tableData, columnNames);
                bikeFrm.getBikeTbl().setModel(tableMdl);
            }
            case 2 ->   {
                tableData = dbCtr.getRents();
                tableData.add(null);
                columnNames = viewMdl.getRentColumnNames();
                TableModel tableMdl = new DefaultTableModel(tableData, columnNames);
                bikeFrm.getRentTbl().setModel(tableMdl);
            }
        }
    }
    
    private void setTablesColumns(){
        
    }
    
    private void exit() {
        System.exit( 0 );
    }
    private void delete() {
        
    }
    private void edit() {
        
    }
    private void save() {
        
    }
    private void search() {
    }
}
