package st10085622_prog5121_poe_p1;
import javax.swing.*;

public class St10085622_prog5121_poe_p1 {
        
    public static void main(String[] args) {
        
        login lg = new login();
        int choice, choice2;
       
       
        Object[] options = {"Register", "Login"}; //using option dialogue so I can manipulate the button text
        choice = JOptionPane.showOptionDialog(null,"Welcome to Kanban \n If you're a new user please register or log-in if you've signed up already", 
                "Kanban", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            
       if (choice == JOptionPane.YES_OPTION){ //if user wants to register
           lg.registerUser();
           choice2 = JOptionPane.showConfirmDialog(null, "Would you like to Login? ", 
                   "Kanban", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
           if (choice2 == JOptionPane.YES_OPTION) {
               lg.loginUser();
           }
           else if (choice2 == JOptionPane.NO_OPTION){
               JOptionPane.showMessageDialog(null, "Thank you for using Kanban, we hope to see you soon");
               System.exit(0);
           }
       }
       else if (choice == JOptionPane.NO_OPTION){ //if user wants to login
           lg.loginUser();
           JOptionPane.showMessageDialog(null, "Thank you for using Kanban, we hope to see you soon");
               System.exit(0);
       }
   
    }
    
}
