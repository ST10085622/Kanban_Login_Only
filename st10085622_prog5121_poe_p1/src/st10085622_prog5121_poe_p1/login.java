package st10085622_prog5121_poe_p1;

import java.util.function.IntBinaryOperator;
import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class login {
    
    //declaring all the variables I'll be using below
    int usernameUnderscore = 0; //used to check for underscore  
    int passDigit;
    boolean containsLetter, containsDigit, containsSpecial, containsEight; //used to check for password 
    userData ud = new userData();
    String name, surname, username, password; 
    private boolean success = false;
    
    
    public String registerUser(){
       //using try and catch incase user inputs an interger instead of a string, will be configured and added to p2. used to handle runtime errors
        name = JOptionPane.showInputDialog(null,"Welcome new user. \n Please enter your name",
                                           "Kanban | Registering New User", JOptionPane.INFORMATION_MESSAGE);
        ud.setName(name);
        JOptionPane.showMessageDialog(null, "Thank you " +ud.getName()+ ", \n You've succefully entered your name.");
        
        //capturing the surname
        surname = JOptionPane.showInputDialog(null,"Please enter your last name",
                                           "Kanban | Registering New User", JOptionPane.INFORMATION_MESSAGE);
        ud.setSurname(surname);
        JOptionPane.showMessageDialog(null, "You've succefully entered your last name.");
        
        enterUsername();
        JOptionPane.showMessageDialog(null, "Username successfully captured."); 
        
        enterPassword();
        JOptionPane.showMessageDialog(null, "Password successfully captured!.");
        
        JOptionPane.showMessageDialog(null, "Thank you "+ud.getUsername()+ ", you've successfully registered!");
        
       return "USER HAS BEEN SUCCEFULLY REGISTERED";
    } 
    
    public void enterUsername(){
        int x = 0;
        do {
            username = JOptionPane.showInputDialog(null,"""
                                                        Please enter your user name. 
                                                        * Include an underscore in your username 
                                                        * It should be no longer that 5 characters""",
                                               "Kanban | Enter Username", JOptionPane.INFORMATION_MESSAGE);
                if(username != null){
                    checkUserName(username);
                    x = 1;
                }
                 else{
                    x = 1;
                   
                }
        } while(x == 0);
    } 
    
    public boolean checkUserName(String nameCheck){
    //This method ensures that any username contains an underscore (_) and is no more than 5 characters in length
     //capturing the username
            if(nameCheck.contains("_") && nameCheck.length()<= 5){ //checks username to see if it meets the requirements of username contains an underscore (_) and is no more than 5 characters
                ud.setUsername(nameCheck);
                success = true;
                return true;
            }
            else if(nameCheck == null ){
                JOptionPane.showMessageDialog(null, """
                                                    Please retry entering your username.
                                                    Dont forget to include the underscore & Keep username length at 5 characters.""",
                                            "Error - Username", JOptionPane.ERROR_MESSAGE);  
                return false;
            }
    return false;
    } 
    
    public void enterPassword(){
        password = JOptionPane.showInputDialog(null, """
                                                     Please create a new login password 
                                                     REQUIREMENTS:-
                                                     * Contains a capital letter 
                                                     * Contains a number 
                                                     * Contains a special character 
                                                     * Contains at least eight characters""", "Kanban | Enter Password", JOptionPane.INFORMATION_MESSAGE);
        if(password !=null){
            checkPasswordComplexity(password);
        }
    }  
    
    
    public boolean checkPasswordComplexity(String passCheck){    
                //i'll be using the regular expressions to check the subsequents of the passsword for all the requirements mentioned in the question
                Pattern letter = Pattern.compile("[A-z]"); // setting the pattern to contain uppercase and lowercase letters
                Pattern digit = Pattern.compile("[0-9]"); //setting the patterns to contain digits from 0 - 9
                Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]"); // setting pattern to contain special character, defined in this statement
                Pattern eight = Pattern.compile (".{8}"); //setting pattern to notice that string input ftom user should be more that 8
                
                //matching the patterns, set above,to the user input
                Matcher hasLetter = letter.matcher(passCheck); 
                Matcher hasDigit = digit.matcher(passCheck); 
                Matcher hasSpecial = special.matcher(passCheck); 
                Matcher hasEight = eight.matcher(passCheck); 
               
                //since the regular expression api can't be used in an if-else statements, we convert it into booleans before using it below
                containsLetter = hasLetter.find(); 
                containsDigit = hasDigit.find();
                containsSpecial = hasSpecial.find();
                containsEight = hasEight.find();
        
           if(containsLetter && containsDigit && containsSpecial && containsEight){
                ud.setPassword(passCheck);
                success = true;
                return true;
                  }
           else{
             JOptionPane.showMessageDialog(null, """
                                                 Password is not correctrly formatted, retry entering your password. 
                                                 Password Requirements:- 
                                                 * Contain a capital letter 
                                                 * Contain a number 
                                                 * Contain a special character 
                                                 * Contains at least eight characters""", "Error - Password Incorrect ", JOptionPane.ERROR_MESSAGE);      
           }
       
        return false;
    }
 
    public boolean loginUser(){
        do {
            JOptionPane.showMessageDialog(null, "KANBAN \nWelcome User","Kanban", JOptionPane.INFORMATION_MESSAGE);
            enterUsername();
            if (username.equals(ud.getUsername())){
                enterPassword();
                if(password.equals(ud.getPassword())){
                   success = true ;
                   returnLoginStatus("true");
                   return true;
                }
                else if(password != ud.getPassword()){ 
                    login lg = new login();
                    var resp = JOptionPane.showInputDialog(null, """
                                                             Username incorrect, or doesn't exist. Please try again. 
                                                             Would you like to register or try again? 
                                                             Press 
                                                             (0) to Retry or 
                                                             (1) to Register as New User or 
                                                             (2) To exit application""",
                "KANBAN | Password Invalid", JOptionPane.ERROR_MESSAGE);
                switch(resp){
                    case "0" -> {
                        lg.loginUser();
                    }
                    case "1" -> { 
                        lg.registerUser();
                        lg.loginUser();
                        return true;
                    }
                    case "2" -> { 
                        returnLoginStatus("false");
                    }
                }
               }
            }
            else if(username != ud.getUsername()){
                login lg = new login();
                var resp = JOptionPane.showInputDialog(null, """
                                                             Username incorrect, or doesn't exist. Please try again. 
                                                             Would you like to register or try again? 
                                                             Press 
                                                             (0) To Retry or 
                                                             (1) To Register as New User or 
                                                             (2) To exit application""",
                "KANBAN | Username Invalid", JOptionPane.ERROR_MESSAGE);
                switch(resp){
                    case "0" -> {
                        lg.loginUser();
                    }
                    case "1" -> { 
                        lg.registerUser();
                        lg.loginUser();
                        return true;
                    }
                    case "2" -> { 
                        returnLoginStatus("false");
                    }
                }
              success = true;
            }

        } while(success = false);
    return false; 
    }
    
    public String returnLoginStatus(String check){
       if(check == "true"){
         JOptionPane.showMessageDialog(null,"A succecessful login");
         JOptionPane.showMessageDialog(null, "Welcome back "+ud.getName()+ ", "+ud.getSurname()+" it's great to see you.",
                "KANBAN | "+ud.getName(), JOptionPane.INFORMATION_MESSAGE);
         
         
       }
       else if(check == "false"){
         JOptionPane.showMessageDialog(null,"A failed login");
       }
       return check;
    }
    
}
