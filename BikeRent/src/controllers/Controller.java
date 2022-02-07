
package controllers;


public class Controller {

    public Controller() {
        
        DataBaseController dbCtr = new DataBaseController();
        new ViewController(dbCtr);
        
    }
    
    
}
