
package Model;

import Controller.Datacontrol;

public class Datainput {
    Datacontrol dt = new Datacontrol();
    public void Date(){     
        dt.getDateFromInput();
        System.out.println("Checking success! Format is valid");
    }
    
    public void Email(){
        dt.getValidEmail("Email: ");
        System.out.println("Checking success! Format is valid");
    }
    
    public void Phone(){
        dt.getValidPhoneNumber("Phone: ");
        System.out.println("Checking success! Format is valid");
    }
}
